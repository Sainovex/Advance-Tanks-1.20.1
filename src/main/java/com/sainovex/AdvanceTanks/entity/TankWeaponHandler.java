package com.sainovex.AdvanceTanks.entity;

import com.sainovex.AdvanceTanks.data.gun.DefaultGunData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.TickTask;

public class TankWeaponHandler {

    /**
     * Call this method when the player attempts to fire the tank gun.
     */
    public void handleFiring(ServerLevel serverLevel, DefaultGunData gunData) {
        
        // Check if there is a shoot delay configured
        if (gunData.getShootDelay() > 0) {
            
            // Calculate the exact tick when the shot should execute
            long targetTick = serverLevel.getServer().getTickCount() + gunData.getShootDelay();

            // Schedule the shot to execute after the delay
            serverLevel.getServer().tell(new TickTask(
                (int) targetTick, 
                this::executeActualShot
            ));

        } else {
            // No delay set, shoot immediately
            executeActualShot();
        }
    }

    /**
     * Performs the actual shooting actions (spawning projectiles, sound, recoil).
     */
    private void executeActualShot() {
        // Place your weapon firing, projectile spawning, and sound logic here
    }
}