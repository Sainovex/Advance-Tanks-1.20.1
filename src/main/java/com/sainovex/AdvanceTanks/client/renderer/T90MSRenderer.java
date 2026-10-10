package com.sainovex.AdvanceTanks.client.renderer;

import com.atsuishio.superbwarfare.client.renderer.entity.BasicVehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

public class T90MSRenderer extends BasicVehicleRenderer {

    // Standard Blockbench to Minecraft model scaling factor

    public T90MSRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public float getTrackDistance() {
        return 1.15f;
    }

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }

    /**
     * Pitch rotation around the tracks (X-axis in degrees)
     */

    @Override
public float getBoneRotX(float t) {
    t = (100.0f - (t % 100.0f)) % 100.0f;
    if (t <= 1.15f) return Mth.lerp(t / 1.15f, 2.0f, 1.5f);
    if (t <= 2.30f) return Mth.lerp((t - 1.15f) / 1.15f, 1.5f, 2.0f);
    if (t <= 3.45f) return Mth.lerp((t - 2.30f) / 1.15f, 2.0f, 1.5f);
    if (t <= 4.60f) return Mth.lerp((t - 3.45f) / 1.15f, 1.5f, 1.0f);
    if (t <= 5.75f) return Mth.lerp((t - 4.60f) / 1.15f, 1.0f, 3.0f);
    if (t <= 6.90f) return Mth.lerp((t - 5.75f) / 1.15f, 3.0f, 2.0f);
    if (t <= 8.05f) return Mth.lerp((t - 6.90f) / 1.15f, 2.0f, 1.0f);
    if (t <= 9.20f) return Mth.lerp((t - 8.05f) / 1.15f, 1.0f, 2.0f);
    if (t <= 10.34f) return Mth.lerp((t - 9.20f) / 1.15f, 2.0f, 2.0f);
    if (t <= 11.49f) return Mth.lerp((t - 10.34f) / 1.15f, 2.0f, 1.0f);
    if (t <= 12.64f) return Mth.lerp((t - 11.49f) / 1.15f, 1.0f, 3.0f);
    if (t <= 13.79f) return Mth.lerp((t - 12.64f) / 1.15f, 3.0f, 2.0f);
    if (t <= 14.94f) return Mth.lerp((t - 13.79f) / 1.15f, 2.0f, 1.0f);
    if (t <= 16.09f) return Mth.lerp((t - 14.94f) / 1.15f, 1.0f, 2.0f);
    if (t <= 17.24f) return Mth.lerp((t - 16.09f) / 1.15f, 2.0f, 2.0f);
    if (t <= 18.39f) return Mth.lerp((t - 17.24f) / 1.15f, 2.0f, 1.0f);
    if (t <= 19.54f) return Mth.lerp((t - 18.39f) / 1.15f, 1.0f, 1.0f);
    if (t <= 20.69f) return Mth.lerp((t - 19.54f) / 1.15f, 1.0f, 0.0f);
    if (t <= 21.84f) return Mth.lerp((t - 20.69f) / 1.15f, 0.0f, 1.0f);
    if (t <= 22.99f) return Mth.lerp((t - 21.84f) / 1.15f, 1.0f, 1.0f);
    if (t <= 24.14f) return Mth.lerp((t - 22.99f) / 1.15f, 1.0f, 2.0f);
    if (t <= 25.29f) return Mth.lerp((t - 24.14f) / 1.15f, 2.0f, 1.0f);
    if (t <= 26.44f) return Mth.lerp((t - 25.29f) / 1.15f, 1.0f, 1.0f);
    if (t <= 27.59f) return Mth.lerp((t - 26.44f) / 1.15f, 1.0f, 1.5f);
    if (t <= 28.74f) return Mth.lerp((t - 27.59f) / 1.15f, 1.5f, 1.0f);
    if (t <= 29.89f) return Mth.lerp((t - 28.74f) / 1.15f, 1.0f, 1.0f);
    if (t <= 31.03f) return Mth.lerp((t - 29.89f) / 1.15f, 1.0f, 1.5f);
    if (t <= 32.18f) return Mth.lerp((t - 31.03f) / 1.15f, 1.5f, 1.0f);
    if (t <= 33.33f) return Mth.lerp((t - 32.18f) / 1.15f, 1.0f, 0.0f);
    if (t <= 34.48f) return Mth.lerp((t - 33.33f) / 1.15f, 0.0f, 1.0f);
    if (t <= 35.63f) return Mth.lerp((t - 34.48f) / 1.15f, 1.0f, 1.0f);
    if (t <= 36.78f) return Mth.lerp((t - 35.63f) / 1.15f, 1.0f, 1.0f);
    if (t <= 37.93f) return Mth.lerp((t - 36.78f) / 1.15f, 1.0f, 3.0f);
    if (t <= 39.08f) return Mth.lerp((t - 37.93f) / 1.15f, 3.0f, 0.0f);
    if (t <= 40.23f) return Mth.lerp((t - 39.08f) / 1.15f, 0.0f, -39.0f);
    if (t <= 41.38f) return Mth.lerp((t - 40.23f) / 1.15f, -39.0f, -72.5f);
    if (t <= 42.53f) return Mth.lerp((t - 41.38f) / 1.15f, -72.5f, -95.0f);
    if (t <= 43.68f) return Mth.lerp((t - 42.53f) / 1.15f, -95.0f, -127.5f);
    if (t <= 44.83f) return Mth.lerp((t - 43.68f) / 1.15f, -127.5f, -139.5f);
    if (t <= 45.98f) return Mth.lerp((t - 44.83f) / 1.15f, -139.5f, -142.0f);
    if (t <= 47.13f) return Mth.lerp((t - 45.98f) / 1.15f, -142.0f, -143.0f);
    if (t <= 48.28f) return Mth.lerp((t - 47.13f) / 1.15f, -143.0f, -145.0f);
    if (t <= 49.43f) return Mth.lerp((t - 48.28f) / 1.15f, -145.0f, -148.5f);
    if (t <= 50.57f) return Mth.lerp((t - 49.43f) / 1.15f, -148.5f, -157.5f);
    if (t <= 51.72f) return Mth.lerp((t - 50.57f) / 1.15f, -157.5f, -180.0f);
    if (t <= 83.91f) return -180.0f; // Bottom flat section (L46 - L73)
    if (t <= 85.06f) return Mth.lerp((t - 83.91f) / 1.15f, -180.0f, -192.5f);
    if (t <= 86.21f) return Mth.lerp((t - 85.06f) / 1.15f, -192.5f, -203.0f);
    if (t <= 87.36f) return Mth.lerp((t - 86.21f) / 1.15f, -203.0f, -203.5f);
    if (t <= 88.51f) return Mth.lerp((t - 87.36f) / 1.15f, -203.5f, -205.0f);
    if (t <= 89.66f) return Mth.lerp((t - 88.51f) / 1.15f, -205.0f, -207.5f);
    if (t <= 90.80f) return Mth.lerp((t - 89.66f) / 1.15f, -207.5f, -209.0f);
    if (t <= 91.95f) return Mth.lerp((t - 90.80f) / 1.15f, -209.0f, -232.0f);
    if (t <= 93.10f) return Mth.lerp((t - 91.95f) / 1.15f, -232.0f, -240.5f);
    if (t <= 94.25f) return Mth.lerp((t - 93.10f) / 1.15f, -240.5f, -272.5f);
    if (t <= 95.40f) return Mth.lerp((t - 94.25f) / 1.15f, -272.5f, -312.5f);
    if (t <= 96.55f) return Mth.lerp((t - 95.40f) / 1.15f, -312.5f, -337.5f);
    if (t <= 97.70f) return Mth.lerp((t - 96.55f) / 1.15f, -337.5f, -360.5f);

    // Smoothly wrap from -360.5 deg back to 0 deg
    return Mth.lerp((t - 97.70f) / 2.30f, -360.5f, -358.5f);
}

    /**
     * Vertical movement along the track loop (Y-axis)
     */
    @Override
    public float getBoneMoveY(float t) {
        t = (100.0f - (t % 100.0f)) % 100.0f;
        if (t <= 40.23f) return Mth.lerp(t / 40.23f, 0.0f, 2.3f);
        if (t <= 41.38f) return Mth.lerp((t - 40.23f) / (41.38f - 40.23f), 2.3f, 2.2f);
        if (t <= 42.53f) return Mth.lerp((t - 41.38f) / (42.53f - 41.38f), 2.2f, 0.4f);
        if (t <= 43.68f) return Mth.lerp((t - 42.53f) / (43.68f - 42.53f), 0.4f, -2.3f);
        if (t <= 44.83f) return Mth.lerp((t - 43.68f) / (44.83f - 43.68f), -2.3f, -5.4f);
        if (t <= 45.98f) return Mth.lerp((t - 44.83f) / (45.98f - 44.83f), -5.4f, -7.6f);
        if (t <= 47.13f) return Mth.lerp((t - 45.98f) / (47.13f - 45.98f), -7.6f, -9.5f);
        if (t <= 48.28f) return Mth.lerp((t - 47.13f) / (48.28f - 47.13f), -9.5f, -11.3f);
        if (t <= 49.43f) return Mth.lerp((t - 48.28f) / (49.43f - 48.28f), -11.3f, -13.1f);
        if (t <= 50.57f) return Mth.lerp((t - 49.43f) / (50.57f - 49.43f), -13.1f, -14.8f);
        if (t <= 51.72f) return Mth.lerp((t - 50.57f) / (51.72f - 50.57f), -14.8f, -16.3f);
        if (t <= 83.91f) return -17.3f;
        if (t <= 85.06f) return Mth.lerp((t - 83.91f) / (85.06f - 83.91f), -17.3f, -16.6f);
        if (t <= 86.21f) return Mth.lerp((t - 85.06f) / (86.21f - 85.06f), -16.6f, -15.5f);
        if (t <= 87.36f) return Mth.lerp((t - 86.21f) / (87.36f - 86.21f), -15.5f, -14.3f);
        if (t <= 88.51f) return Mth.lerp((t - 87.36f) / (88.51f - 87.36f), -14.3f, -13.3f);
        if (t <= 89.66f) return Mth.lerp((t - 88.51f) / (89.66f - 88.51f), -13.3f, -12.1f);
        if (t <= 90.80f) return Mth.lerp((t - 89.66f) / (90.80f - 89.66f), -12.1f, -10.7f);
        if (t <= 91.95f) return Mth.lerp((t - 90.80f) / (91.95f - 90.80f), -10.7f, -8.5f);
        if (t <= 93.10f) return Mth.lerp((t - 91.95f) / (93.10f - 91.95f), -8.5f, -5.95f);
        if (t <= 94.25f) return Mth.lerp((t - 93.10f) / (94.25f - 93.10f), -5.95f, -3.05f);
        if (t <= 95.40f) return Mth.lerp((t - 94.25f) / (95.40f - 94.25f), -3.05f, -0.95f);
        if (t <= 96.55f) return Mth.lerp((t - 95.40f) / (96.55f - 95.40f), -0.95f, 0.05f);

        return Mth.lerp((t - 96.55f) / (100.0f - 96.55f), 0.05f, 0.0f);
    }

    /**
     * Horizontal translation along the length of the vehicle (Z-axis)
     */
    @Override
public float getBoneMoveZ(float t) {
    t = (100.0f - (t % 100.0f)) % 100.0f;
    if (t <= 1.15f) return Mth.lerp(t / 1.15f, 0.0f, 3.0f);
    if (t <= 2.30f) return Mth.lerp((t - 1.15f) / 1.15f, 3.0f, 6.0f);
    if (t <= 3.45f) return Mth.lerp((t - 2.30f) / 1.15f, 6.0f, 9.0f);
    if (t <= 4.60f) return Mth.lerp((t - 3.45f) / 1.15f, 9.0f, 12.0f);
    if (t <= 5.75f) return Mth.lerp((t - 4.60f) / 1.15f, 12.0f, 15.0f);
    if (t <= 6.90f) return Mth.lerp((t - 5.75f) / 1.15f, 15.0f, 18.0f);
    if (t <= 8.05f) return Mth.lerp((t - 6.90f) / 1.15f, 18.0f, 21.0f);
    if (t <= 9.20f) return Mth.lerp((t - 8.05f) / 1.15f, 21.0f, 24.0f);
    if (t <= 10.34f) return Mth.lerp((t - 9.20f) / 1.15f, 24.0f, 27.0f);
    if (t <= 11.49f) return Mth.lerp((t - 10.34f) / 1.15f, 27.0f, 30.0f);
    if (t <= 12.64f) return Mth.lerp((t - 11.49f) / 1.15f, 30.0f, 33.0f);
    if (t <= 13.79f) return Mth.lerp((t - 12.64f) / 1.15f, 33.0f, 36.0f);
    if (t <= 14.94f) return Mth.lerp((t - 13.79f) / 1.15f, 36.0f, 39.0f);
    if (t <= 16.09f) return Mth.lerp((t - 14.94f) / 1.15f, 39.0f, 42.0f);
    if (t <= 17.24f) return Mth.lerp((t - 16.09f) / 1.15f, 42.0f, 45.0f);
    if (t <= 18.39f) return Mth.lerp((t - 17.24f) / 1.15f, 45.0f, 48.0f);
    if (t <= 19.54f) return Mth.lerp((t - 18.39f) / 1.15f, 48.0f, 51.0f);
    if (t <= 20.69f) return Mth.lerp((t - 19.54f) / 1.15f, 51.0f, 54.0f);
    if (t <= 21.84f) return Mth.lerp((t - 20.69f) / 1.15f, 54.0f, 57.0f);
    if (t <= 22.99f) return Mth.lerp((t - 21.84f) / 1.15f, 57.0f, 60.0f);
    if (t <= 24.14f) return Mth.lerp((t - 22.99f) / 1.15f, 60.0f, 63.0f);
    if (t <= 25.29f) return Mth.lerp((t - 24.14f) / 1.15f, 63.0f, 66.0f);
    if (t <= 26.44f) return Mth.lerp((t - 25.29f) / 1.15f, 66.0f, 69.0f);
    if (t <= 27.59f) return Mth.lerp((t - 26.44f) / 1.15f, 69.0f, 72.0f);
    if (t <= 28.74f) return Mth.lerp((t - 27.59f) / 1.15f, 72.0f, 75.0f);
    if (t <= 29.89f) return Mth.lerp((t - 28.74f) / 1.15f, 75.0f, 78.0f);
    if (t <= 31.03f) return Mth.lerp((t - 29.89f) / 1.14f, 78.0f, 81.0f);
    if (t <= 32.18f) return Mth.lerp((t - 31.03f) / 1.15f, 81.0f, 84.0f);
    if (t <= 33.33f) return Mth.lerp((t - 32.18f) / 1.15f, 84.0f, 87.0f);
    if (t <= 34.48f) return Mth.lerp((t - 33.33f) / 1.15f, 87.0f, 90.0f);
    if (t <= 35.63f) return Mth.lerp((t - 34.48f) / 1.15f, 90.0f, 93.0f);
    if (t <= 36.78f) return Mth.lerp((t - 35.63f) / 1.15f, 93.0f, 96.0f);
    if (t <= 37.93f) return Mth.lerp((t - 36.78f) / 1.15f, 96.0f, 99.0f);
    if (t <= 39.08f) return Mth.lerp((t - 37.93f) / 1.15f, 99.0f, 102.0f);
    if (t <= 40.23f) return Mth.lerp((t - 39.08f) / 1.15f, 102.0f, 105.0f);
    if (t <= 41.38f) return Mth.lerp((t - 40.23f) / 1.15f, 105.0f, 107.85f);
    if (t <= 42.53f) return Mth.lerp((t - 41.38f) / 1.15f, 107.85f, 110.0f);
    if (t <= 43.68f) return Mth.lerp((t - 42.53f) / 1.15f, 110.0f, 110.8f);
    if (t <= 44.83f) return Mth.lerp((t - 43.68f) / 1.15f, 110.8f, 110.65f);
    if (t <= 45.98f) return Mth.lerp((t - 44.83f) / 1.15f, 110.65f, 108.8f);
    if (t <= 47.13f) return Mth.lerp((t - 45.98f) / 1.15f, 108.8f, 106.55f);
    if (t <= 48.28f) return Mth.lerp((t - 47.13f) / 1.15f, 106.55f, 104.25f);
    if (t <= 49.43f) return Mth.lerp((t - 48.28f) / 1.15f, 104.25f, 101.9f);
    if (t <= 50.57f) return Mth.lerp((t - 49.43f) / 1.15f, 101.9f, 99.5f);
    if (t <= 51.72f) return Mth.lerp((t - 50.57f) / 1.15f, 99.5f, 96.9f);
    if (t <= 52.87f) return Mth.lerp((t - 51.72f) / 1.15f, 96.9f, 94.3f);
    if (t <= 83.91f) return Mth.lerp((t - 52.87f) / 31.04f, 94.3f, 13.5f);
    if (t <= 85.06f) return Mth.lerp((t - 83.91f) / 1.15f, 13.5f, 10.5f);
    if (t <= 86.21f) return Mth.lerp((t - 85.06f) / 1.15f, 10.5f, 7.7f);
    if (t <= 87.36f) return Mth.lerp((t - 86.21f) / 1.15f, 7.7f, 5.0f);
    if (t <= 88.51f) return Mth.lerp((t - 87.36f) / 1.15f, 5.0f, 2.3f);
    if (t <= 89.66f) return Mth.lerp((t - 88.51f) / 1.15f, 2.3f, 0.1f);
    if (t <= 90.80f) return Mth.lerp((t - 89.66f) / 1.15f, 0.1f, -2.3f);
    if (t <= 91.95f) return Mth.lerp((t - 90.80f) / 1.15f, -2.3f, -4.9f);
    if (t <= 93.10f) return Mth.lerp((t - 91.95f) / 1.15f, -4.9f, -6.6f);
    if (t <= 94.25f) return Mth.lerp((t - 93.10f) / 1.15f, -6.6f, -7.95f);
    if (t <= 95.40f) return Mth.lerp((t - 94.25f) / 1.15f, -7.95f, -7.85f);
    if (t <= 96.55f) return Mth.lerp((t - 95.40f) / 1.15f, -7.85f, -5.95f);
    if (t <= 97.70f) return Mth.lerp((t - 96.55f) / 1.15f, -5.95f, -3.15f);

    return Mth.lerp((t - 97.70f) / 2.30f, -3.15f, 0.0f);
}
}