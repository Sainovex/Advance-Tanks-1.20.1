package com.sainovex.AdvanceTanks.client.renderer;

import com.atsuishio.superbwarfare.client.renderer.entity.BasicVehicleRenderer;
import com.atsuishio.superbwarfare.client.model.entity.VehicleModelInstance;
import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import com.github.mcmodderanchor.simplebedrockmodel.v2.common.model.runtime.BoneState;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

import java.util.List;

public class RailTankRenderer extends BasicVehicleRenderer {

    public RailTankRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void transformCustomModelPart(VehicleEntity entity, VehicleModelInstance instance, PoseStack poseStack, float entityYaw, float partialTicks) {
        super.transformCustomModelPart(entity, instance, poseStack, entityYaw, partialTicks);

        float rotation = (System.currentTimeMillis() % 36000000L) / 75.0f;
        BoneState fanLeft = instance.getBone("move_fanL");
        BoneState fanRight = instance.getBone("move_fanR");
        BoneState fanRight2 = instance.getBone("move_fanR2");

        if (fanLeft != null) fanLeft.rotation.rotationY(rotation);
        if (fanRight != null) fanRight.rotation.rotationY(rotation);
        if (fanRight2 != null) fanRight2.rotation.rotationY(rotation);
    }

    @Override
    public void customLaserLength(List<? extends BoneState> laserBones, VehicleEntity entity, float partialTicks) {
        for (BoneState laser : laserBones) {
            laser.visible = false;
            laser.zScale = 10.0f * entity.getLaserLength();

            float scale = Math.min(Mth.lerp(partialTicks, entity.getLaserScaleO(), entity.getLaserScale()), 1.2f);
            laser.xScale = scale;
            laser.yScale = 2.8f * scale;
        }
    }

    // Track Animation Math Helpers
    public float getBoneRotX(float t) {
        if (t <= 37.6667f) return 0f;
        if (t <= 38.5833f) return Mth.lerp((t - 37.6667f) / (38.5833f - 37.6667f), 0f, -45f);
        if (t <= 39.75f) return -45f;
        if (t <= 40.6667f) return Mth.lerp((t - 39.75f) / (40.6667f - 39.75f), -45f, -90f);
        if (t <= 41.6667f) return -90f;
        if (t <= 42.5f) return -90f;
        if (t <= 43.5f) return Mth.lerp(t - 42.5f, -90f, -135f);
        if (t <= 44.5833f) return -135f;
        if (t <= 45.0833f) return Mth.lerp((t - 44.5833f) / (45.0833f - 44.5833f), -135f, -150f);
        if (t <= 52.25f) return -150f;
        if (t <= 52.75f) return Mth.lerp((t - 52.25f) / (52.75f - 52.25f), -150f, -180f);
        if (t <= 84.3333f) return -180f;
        if (t <= 84.9167f) return Mth.lerp((t - 84.3333f) / (84.9167f - 84.3333f), -180f, -210f);
        if (t <= 92.5833f) return Mth.lerp((t - 92.5833f) / (93.4167f - 92.5833f), -210f, -220f);
        if (t <= 94.25f) return -220f;
        if (t <= 94.9167f) return Mth.lerp((t - 94.25f) / (95.75f - 94.9167f), -220f, -243.33f);
        if (t <= 95.75f) return Mth.lerp((t - 94.9167f) / (95.75f - 94.9167f), -243.33f, -270f);
        if (t <= 96.8333f) return -270f;
        if (t <= 97.5833f) return Mth.lerp((t - 96.8333f) / (97.5833f - 96.8333f), -270f, -315f);
        if (t <= 98.8333f) return -315f;
        if (t <= 99.5833f) return Mth.lerp((t - 98.8333f) / (99.5833f - 98.8333f), -315f, -360f);

        return 0f;
    }

    public float getBoneMoveY(float t) {
        if (t <= 37.6667f) return 0f;
        if (t <= 38.5833f) return Mth.lerp((t - 37.6667f) / (38.5833f - 37.6667f), 0f, -1.8f);
        if (t <= 40.3333f) return Mth.lerp((t - 38.5833f) / (40.3333f - 38.5833f), -1.8f, -4.1f);
        if (t <= 42.9167f) return Mth.lerp((t - 40.3333f) / (42.9167f - 40.3333f), -4.1f, -10.3f);
        if (t <= 44.25f) return Mth.lerp((t - 42.9167f) / (44.25f - 44.25f), -10.3f, -12.9f);
        if (t <= 52.4167f) return Mth.lerp((t - 44.25f) / (52.4167f - 44.25f), -12.9f, -23.96f);
        if (t <= 84.5833f) return -23.96f;
        if (t <= 93f) return Mth.lerp((t - 84.5833f) / (93f - 84.5833f), -23.96f, -12.93f);
        if (t <= 95.25f) return Mth.lerp((t - 93f) / (95.25f - 93f), -12.93f, -10.085f);
        if (t <= 97.5f) return Mth.lerp((t - 95.25f) / (97.5f - 95.25f), -10.085f, -4.585f);
        if (t <= 98.8333f) return Mth.lerp((t - 97.5f) / (98.8333f - 97.5f), -4.585f, -1.165f);
        if (t <= 99.25f) return Mth.lerp((t - 98.8333f) / (99.25f - 98.8333f), -1.165f, -0.25f);

        return Mth.lerp((t - 99.25f) / (100f - 99.25f), -0.25f, 0f);
    }

    public float getBoneMoveZ(float t) {
        if (t <= 37.6667f) return Mth.lerp(t / 37.6667f, 0f, 111.6f);
        if (t <= 38.5833f) return Mth.lerp((t - 37.6667f) / (38.5833f - 37.6667f), 111.6f, 113.25f);
        if (t <= 40.3333f) return Mth.lerp((t - 38.5833f) / (40.3333f - 38.5833f), 113.25f, 116f);
        if (t <= 42.9167f) return 116f;
        if (t <= 44.25f) return Mth.lerp((t - 42.9167f) / (44.25f - 44.25f), 116f, 113.5f);
        if (t <= 52.4167f) return Mth.lerp((t - 44.25f) / (52.4167f - 44.25f), 113.5f, 96.25f);
        if (t <= 84.5833f) return Mth.lerp((t - 52.4167f) / (84.5833f - 52.4167f), 96.25f, 14.095f);
        if (t <= 93f) return Mth.lerp((t - 84.5833f) / (93f - 84.5833f), 14.095f, -3.565f);
        if (t <= 95.25f) return Mth.lerp((t - 93f) / (95.25f - 93f), -3.565f, -6.35f);
        if (t <= 97.5f) return Mth.lerp((t - 95.25f) / (97.5f - 95.25f), -6.35f, -6.39f);
        if (t <= 98.8333f) return Mth.lerp((t - 97.5f) / (98.8333f - 97.5f), -6.39f, -3.03f);
        if (t <= 99.25f) return Mth.lerp((t - 98.8333f) / (99.25f - 98.8333f), -3.03f, -1.95f);

        return Mth.lerp((t - 99.25f) / (100f - 99.25f), -1.95f, 0f);
    }
}