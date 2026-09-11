package com.sainovex.AdvanceTanks.data.gun;

import com.google.gson.annotations.SerializedName;

public class DefaultGunData {

    @SerializedName("ShootDelay")
    public int shootDelay = 0; // Delay in ticks before firing (20 ticks = 1 second)

    // Getters and Setters
    public int getShootDelay() {
        return shootDelay;
    }

    public void setShootDelay(int shootDelay) {
        this.shootDelay = shootDelay;
    }
}