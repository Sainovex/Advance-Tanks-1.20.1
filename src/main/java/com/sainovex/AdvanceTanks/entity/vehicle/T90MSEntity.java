package com.sainovex.AdvanceTanks.entity.vehicle;

import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import com.atsuishio.superbwarfare.tools.ParticleTool;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.UUID;

import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class T90MSEntity extends VehicleEntity implements GeoAnimatable {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public T90MSEntity(EntityType<? extends T90MSEntity> type, Level world) {
        super(type, world);
        this.setTurretXRot(-3f);
        this.setTurretXRotO(-3f);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // Controlled by Superb Warfare
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object object) {
        return (double) this.tickCount;
    }

    @Override
    public void vehicleShoot(LivingEntity living, UUID uuid, Vec3 targetPos) {
        if (living != null) {
            Level level = living.level();
            if (level instanceof ServerLevel serverLevel && living == this.getFirstPassenger() && this.getWeaponIndex(0) == 0) {
                ParticleTool.spawnBigCannonMuzzleParticles(
                    this.getShootVec(living, 1f), 
                    this.getShootPos(living, 1f), 
                    serverLevel, 
                    this
                );
            }
        }
        super.vehicleShoot(living, uuid, targetPos);
    }
}