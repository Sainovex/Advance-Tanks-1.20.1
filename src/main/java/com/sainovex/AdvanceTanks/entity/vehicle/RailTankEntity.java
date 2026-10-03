package com.sainovex.AdvanceTanks.entity.vehicle;

import com.atsuishio.superbwarfare.data.gun.GunData;
import com.atsuishio.superbwarfare.data.gun.GunProp;
import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import com.atsuishio.superbwarfare.init.ModDamageTypes;
import com.atsuishio.superbwarfare.init.ModSounds;
import com.atsuishio.superbwarfare.tools.ParticleTool;
import com.atsuishio.superbwarfare.tools.SeekTool;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class RailTankEntity extends VehicleEntity {

    private float laserScale = 1.0f;
    private float laserScaleO = 1.0f;
    private float laserLength = 1.0f;

    public RailTankEntity(EntityType<? extends RailTankEntity> type, Level world) {
        super(type, world);
        this.noCulling = true;
    }

    // Laser scaling getters used by RailTankRenderer
    public float getLaserScale() {
        return this.laserScale;
    }

    public float getLaserScaleO() {
        return this.laserScaleO;
    }

    public float getLaserLength() {
        return this.laserLength;
    }

    public void setLaserScale(float scale) {
        this.laserScaleO = this.laserScale;
        this.laserScale = scale;
    }

    public void setLaserLength(float length) {
        this.laserLength = length;
    }

    public void hitBlock(Vec3 pos, GunData gunData, @Nullable Entity shooter) {
        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        if (gunData.get(GunProp.EXPLOSION_RADIUS) > 0) {
            findNearEntity(pos, gunData, shooter);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 24, 0.0, 0.0, 0.0, 0.2, true);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, pos.x, pos.y, pos.z, 8, 0.0, 0.0, 0.0, 0.4, true);
        } else {
            ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 4, 0.0, 0.0, 0.0, 0.05, true);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, pos.x, pos.y, pos.z, 2, 0.0, 0.0, 0.0, 0.15, true);
        }
    }

    public void hitEntity(Vec3 pos, GunData gunData, @Nullable Entity shooter) {
        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        if (gunData.get(GunProp.EXPLOSION_RADIUS) > 0) {
            findNearEntity(pos, gunData, shooter);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 24, 0.0, 0.0, 0.0, 0.2, true);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, pos.x, pos.y, pos.z, 8, 0.0, 0.0, 0.0, 0.4, true);
        } else {
            ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 4, 0.0, 0.0, 0.0, 0.05, true);
            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, pos.x, pos.y, pos.z, 2, 0.0, 0.0, 0.0, 0.15, true);
        }
    }

    public void findNearEntity(Vec3 vec, GunData gunData, @Nullable Entity shooter) {
        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        double aoeDamage = gunData.get(GunProp.EXPLOSION_DAMAGE);
        double range = gunData.get(GunProp.EXPLOSION_RADIUS);

        List<Entity> entities = new SeekTool.Builder(this)
                .withinRange(vec, range)
                .notItsVehicle()
                .baseFilter()
                .noVehicle()
                .notFriendly()
                .isNotMyOwner()
                .build();

        for (Entity e : entities) {
            double dis = vec.distanceTo(e.getEyePosition());

            for (float i = 0.0f; i < dis; i += 0.5f) {
                Vec3 toVec = vec.vectorTo(e.getEyePosition()).normalize();
                Vec3 pos = vec.add(toVec.scale(i));
                ParticleTool.sendParticle(serverLevel, ParticleTypes.END_ROD, pos.x, pos.y, pos.z, 1, 0.0, 0.0, 0.0, 0.0, true);
            }

            ParticleTool.sendParticle(serverLevel, ParticleTypes.LAVA, e.getX(), e.getEyeY(), e.getZ(), 4, 0.0, 0.0, 0.0, 0.15, true);

            double ratio = range > 0 ? dis / range : 1.0;
            float calculatedDamage = (float) (aoeDamage - Mth.clamp(ratio, 0.0, 0.75) * aoeDamage);

            e.hurt(ModDamageTypes.causeLaserDamage(this.level().registryAccess(), this, shooter), calculatedDamage);

            if (shooter instanceof ServerPlayer serverPlayer) {
                Holder<net.minecraft.sounds.SoundEvent> holder = Holder.direct(ModSounds.INDICATION.get());
                serverPlayer.connection.send(new ClientboundSoundPacket(
                        holder,
                        SoundSource.PLAYERS,
                        serverPlayer.getX(),
                        serverPlayer.getY(),
                        serverPlayer.getZ(),
                        1.0f,
                        1.0f,
                        serverPlayer.level().getRandom().nextLong()
                ));
            }
        }
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