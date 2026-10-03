package com.sainovex.AdvanceTanks.client.renderer;

import com.atsuishio.superbwarfare.client.renderer.entity.BasicVehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

public class AbramsXRenderer extends BasicVehicleRenderer {

    public AbramsXRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }

    @Override
    public float getBoneRotX(float t) {
        if (t <= 41.25f) return 0f;
        if (t <= 47.25f) return Mth.lerp((t - 41.25f) / (47.25f - 41.25f), 0f, -147.5f);
        if (t <= 53.9167f) return -147.5f;
        if (t <= 54.5833f) return Mth.lerp((t - 53.9167f) / (54.5833f - 53.9167f), -147.5f, -180f);
        if (t <= 85.5f) return -180f;
        if (t <= 85.9167f) return -180f;
        if (t <= 86.4167f) return Mth.lerp((t - 85.9167f) / (86.4167f - 85.9167f), -180f, -205f);
        if (t <= 93.6667f) return -205f;
        if (t <= 100f) return Mth.lerp((t - 93.6667f) / (99.5f - 93.6667f), -205f, -360f);

        return 0f;
    }

    @Override
    public float getBoneMoveY(float t) {
        if (t <= 41.75f) return 0f;
        if (t <= 42.5833f) return Mth.lerp((t - 41.75f) / (42.5833f - 41.75f), 0f, -0.72f);
        if (t <= 43.5f) return Mth.lerp((t - 42.5833f) / (43.5f - 42.5833f), -0.72f, -2.175f);
        if (t <= 44.3333f) return Mth.lerp((t - 43.5f) / (44.3333f - 43.5f), -2.175f, -5.01f);
        if (t <= 45.25f) return Mth.lerp((t - 44.3333f) / (45.25f - 44.3333f), -5.01f, -7.8f);
        if (t <= 46.0833f) return Mth.lerp((t - 45.25f) / (46.0833f - 45.25f), -7.8f, -10.6f);
        if (t <= 46.9167f) return Mth.lerp((t - 46.0833f) / (46.9167f - 46.0833f), -10.6f, -13.245f);
        if (t <= 47.8333f) return Mth.lerp((t - 46.9167f) / (47.8333f - 46.9167f), -13.245f, -14.81f);
        if (t <= 53.5833f) return Mth.lerp((t - 47.8333f) / (53.5833f - 47.8333f), -14.81f, -24.64f);
        if (t <= 54.25f) return Mth.lerp((t - 53.5833f) / (54.25f - 53.5833f), -24.64f, -25.39f);
        if (t <= 54.9167f) return Mth.lerp((t - 54.25f) / (54.9167f - 54.25f), -25.39f, -25.74f);
        if (t <= 84.9167f) return Mth.lerp((t - 54.9167f) / (84.9167f - 54.9167f), -25.74f, -25.73f);
        if (t <= 85.6667f) return Mth.lerp((t - 84.9167f) / (85.6667f - 84.9167F), -25.73f, -25.33f);
        if (t <= 86.4167f) return Mth.lerp((t - 85.6667f) / (86.4167f - 85.6667f), -25.33f, -24.72f);
        if (t <= 93.1667f) return Mth.lerp((t - 86.4167f) / (93.1667f - 86.4167f), -24.72f, -15.75f);
        if (t <= 93.9167f) return Mth.lerp((t - 93.1667f) / (93.9167f - 93.1667f), -15.75f, -14.53f);
        if (t <= 94.5833f) return Mth.lerp((t - 93.9167f) / (94.5833f - 93.9167f), -14.53f, -12.57f);
        if (t <= 95.25f) return Mth.lerp((t - 94.5833f) / (95.25f - 94.5833f), -12.57f, -10.62f);
        if (t <= 95.9167f) return Mth.lerp((t - 95.25f) / (95.9167f - 95.25f), -10.62f, -8.48f);
        if (t <= 96.6667f) return Mth.lerp((t - 95.9167f) / (96.6667f - 95.9167f), -8.48f, -6.2f);
        if (t <= 97.25f) return Mth.lerp((t - 96.6667f) / (97.25f - 96.6667f), -6.2f, -4.35f);
        if (t <= 97.8333f) return Mth.lerp((t - 97.25f) / (97.8333f - 97.25f), -4.35f, -2.68f);
        if (t <= 98.5f) return Mth.lerp((t - 97.8333f) / (98.5f - 97.8333f), -2.68f, -1.26f);
        if (t <= 98.8333f) return Mth.lerp((t - 98.5f) / (98.8333f - 98.5f), -1.26f, -0.68f);
        if (t <= 99.25f) return Mth.lerp((t - 98.8333f) / (99.25f - 98.8333f), -0.68f, -0.3f);
        if (t <= 99.5833f) return Mth.lerp((t - 99.25f) / (99.5833f - 99.25f), -0.3f, 0f);

        return 0f;
    }

    @Override
    public float getBoneMoveZ(float t) {
        if (t <= 41.75f) return Mth.lerp(t / (41.75f - 0f), 0f, 126.5f);
        if (t <= 42.5833f) return Mth.lerp((t - 41.75f) / (42.5833f - 41.75f), 126.5f, 129.37f);
        if (t <= 43.5f) return Mth.lerp((t - 42.5833f) / (43.5f - 42.5833f), 129.37f, 131.74f);
        if (t <= 44.3333f) return Mth.lerp((t - 43.5f) / (44.3333f - 43.5f), 131.74f, 133.605f);
        if (t <= 45.25f) return Mth.lerp((t - 44.3333f) / (45.25f - 44.3333f), 133.605f, 134.085f);
        if (t <= 46.0833f) return Mth.lerp((t - 45.25f) / (46.0833f - 45.25f), 134.085f, 133.565f);
        if (t <= 46.9167f) return Mth.lerp((t - 46.0833f) / (46.9167f - 46.0833f), 133.565f, 131.6f);
        if (t <= 47.8333f) return Mth.lerp((t - 46.9167f) / (47.8333f - 46.9167f), 131.6f, 129.55f);
        if (t <= 53.5833f) return Mth.lerp((t - 47.8333f) / (53.5833f - 47.8333f), 129.55f, 114.11f);
        if (t <= 54.25f) return Mth.lerp((t - 53.5833f) / (54.25f - 53.5833f), 114.11f, 112.38f);
        if (t <= 54.9167f) return Mth.lerp((t - 54.25f) / (54.9167f - 54.25f), 112.38f, 110.33f);
        if (t <= 84.9167f) return Mth.lerp((t - 54.9167f) / (84.9167f - 54.9167f), 110.33f, 16.99f);
        if (t <= 85.6667f) return Mth.lerp((t - 84.9167f) / (85.6667f - 84.9167f), 16.99f, 14.71f);
        if (t <= 86.4167f) return Mth.lerp((t - 85.6667f) / (86.4167f - 85.6667f), 14.71f, 12.51f);
        if (t <= 93.1667f) return Mth.lerp((t - 86.4167f) / (93.1667f - 86.4167f), 12.51f, -6.97f);
        if (t <= 93.9167f) return Mth.lerp((t - 93.1667f) / (93.9167f - 93.1667f), -6.97f, -8.64f);
        if (t <= 94.5833f) return Mth.lerp((t - 93.9167f) / (94.5833f - 93.9167f), -8.64f, -10.07f);
        if (t <= 95.25f) return Mth.lerp((t - 94.5833f) / (95.25f - 94.5833f), -10.07f, -10.86f);
        if (t <= 95.9167f) return Mth.lerp((t - 95.25f) / (95.9167f - 95.25f), -10.86f, -11.18f);
        if (t <= 96.6667f) return Mth.lerp((t - 95.9167f) / (96.6667f - 95.9167f), -11.18f, -10.8f);
        if (t <= 97.25f) return Mth.lerp((t - 96.6667f) / (97.25f - 96.6667f), -10.8f, -10.05f);
        if (t <= 97.8333f) return Mth.lerp((t - 97.25f) / (97.8333f - 97.25f), -10.05f, -8.695f);
        if (t <= 98.5f) return Mth.lerp((t - 97.8333f) / (98.5f - 97.8333f), -8.695f, -6.38f);
        if (t <= 98.8333f) return Mth.lerp((t - 98.5f) / (98.8333f - 98.5f), -1.26f, -0.68f);
        if (t <= 99.25f) return Mth.lerp((t - 98.8333f) / (99.25f - 98.8333f), -0.68f, -0.3f);
        if (t <= 99.5833f) return Mth.lerp((t - 99.25f) / (99.5833f - 99.25f), -0.3f, 0f);

        return Mth.lerp((t - 99.5833f) / (100f - 99.5833f), -1.69f, 0f);
    }

    @Override
    public float getTrackDistance() {
        return 2.27f;
    }
}