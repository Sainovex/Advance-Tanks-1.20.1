package com.sainovex.AdvanceTanks.entity.vehicle;

import com.atsuishio.superbwarfare.data.gun.GunData;
import com.atsuishio.superbwarfare.data.gun.GunProp;
import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import com.atsuishio.superbwarfare.tools.ParticleTool;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class RailTankEntity extends VehicleEntity {

    public RailTankEntity(EntityType<? extends RailTankEntity> type, Level world) {
        super(type, world);
        this.noCulling = true;
    }

    @Override
    public void vehicleShoot(LivingEntity living, java.util.UUID uuid, Vec3 targetPos) {
        GunData gunData = living == null ? null : getGunData(living);
        boolean explosiveRay = living != null && canShoot(living) && isExplosiveRay(gunData);

        if (living != null && canShoot(living)) {
            if (gunData != null && "ray".equals(gunData.get(GunProp.PROJECTILE).getId())) {
                setLaserLength((float) gunData.get(GunProp.RANGE));
                setLaserScale((float) gunData.get(GunProp.SHOOT_ANIMATION_TIME));
            }
        }

        super.vehicleShoot(living, uuid, targetPos);

        if (explosiveRay && living != null && this.level() instanceof ServerLevel) {
            explodeRayAtImpact(living, gunData);
        }
    }

    private boolean isExplosiveRay(@Nullable GunData gunData) {
        return gunData != null
                && "ray".equals(gunData.get(GunProp.PROJECTILE).getId())
                && "HE".equalsIgnoreCase(gunData.get(GunProp.SHELL_TYPE));
    }

    private void explodeRayAtImpact(LivingEntity shooter, GunData gunData) {
        Vec3 start = getShootPos(shooter, 1.0f);
        Vec3 direction = getShootVec(shooter, 1.0f);
        double range = gunData.get(GunProp.RANGE);
        Vec3 end = start.add(direction.scale(range));

        BlockHitResult blockHit = this.level().clip(new ClipContext(
                start,
                end,
                ClipContext.Block.VISUAL,
                ClipContext.Fluid.NONE,
                shooter
        ));
        Vec3 blockImpact = this.level().getBlockState(blockHit.getBlockPos()).canOcclude()
                ? blockHit.getLocation()
                : null;

        AABB searchBox = shooter.getBoundingBox().expandTowards(direction.scale(range)).inflate(1.0);
        EntityHitResult entityHit = ProjectileUtil.getEntityHitResult(
                shooter,
                start,
                end,
                searchBox,
                entity -> !entity.isSpectator() && entity.isAlive() && entity != shooter && entity != this,
                range * range
        );

        if (entityHit != null && (blockImpact == null
                || start.distanceToSqr(entityHit.getLocation()) < start.distanceToSqr(blockImpact))) {
            Vec3 impact = entityHit.getLocation();
            setLaserLength((float) start.distanceTo(impact));
            hitEntity(impact, gunData, shooter);
        } else if (blockImpact != null) {
            setLaserLength((float) start.distanceTo(blockImpact));
            hitBlock(blockImpact, gunData, shooter);
        }
    }

    public void hitBlock(Vec3 pos, GunData gunData, @Nullable Entity shooter) {
        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        explodeAt(pos, gunData, shooter);

        if (gunData.get(GunProp.EXPLOSION_RADIUS) > 0) {
            ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 24, 0.0, 0.0, 0.0, 0.2, true);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, pos.x, pos.y, pos.z, 8, 0.0, 0.0, 0.0, 0.4, true);
        } else {
            ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 4, 0.0, 0.0, 0.0, 0.05, true);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, pos.x, pos.y, pos.z, 2, 0.0, 0.0, 0.0, 0.15, true);
        }
    }

    public void hitEntity(Vec3 pos, GunData gunData, @Nullable Entity shooter) {
        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        explodeAt(pos, gunData, shooter);

        if (gunData.get(GunProp.EXPLOSION_RADIUS) > 0) {
            ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 24, 0.0, 0.0, 0.0, 0.2, true);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, pos.x, pos.y, pos.z, 8, 0.0, 0.0, 0.0, 0.4, true);
        } else {
            ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 4, 0.0, 0.0, 0.0, 0.05, true);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, pos.x, pos.y, pos.z, 2, 0.0, 0.0, 0.0, 0.15, true);
        }
    }

    private void explodeAt(Vec3 pos, GunData gunData, @Nullable Entity shooter) {
        float radius = gunData.get(GunProp.EXPLOSION_RADIUS).floatValue();
        if (radius <= 0.0f) return;

        createCustomExplosion()
                .attacker(shooter)
                .position(pos)
                .damage(gunData.get(GunProp.EXPLOSION_DAMAGE).floatValue())
                .radius(radius)
                .explode();
    }

    @Override
    public float getWheelMaxHealth() {
        return 100.0f;
    }

    @Override
    public float getEngineMaxHealth() {
        return 150.0f;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public Component firstPersonAmmoComponent(GunData data, @Nullable Player player) {
        String name = data.get(GunProp.NAME);
        if (name == null || name.isBlank()) {
            return Component.empty();
        }

        int tempC = (int) (25 + data.heat.get());
        return Component.translatable(name, tempC + " °C");
    }
}