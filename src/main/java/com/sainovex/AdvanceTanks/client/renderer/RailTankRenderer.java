package com.sainovex.AdvanceTanks.client.renderer;

import com.atsuishio.superbwarfare.client.renderer.entity.BasicVehicleRenderer;
import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.sainovex.AdvanceTanks.entity.vehicle.RailTankEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

import java.util.Optional;

@SuppressWarnings({"rawtypes", "unchecked"})
public class RailTankRenderer extends BasicVehicleRenderer {

    public RailTankRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(
            VehicleEntity entity,
            float entityYaw,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight
    ) {
        if (entity instanceof RailTankEntity railTank) {
            GeoModel model = null;
            if (this instanceof GeoRenderer geoRenderer) {
                model = geoRenderer.getGeoModel();
            }

            if (model != null) {
                // Fan Rotations
                float rot = (System.currentTimeMillis() % 36000000L) / 75f;
                getBone(model, "move_fanL").ifPresent(bone -> bone.setRotY(rot));
                getBone(model, "move_fanR").ifPresent(bone -> bone.setRotY(rot));

                // Track Animations
                float t = (railTank.tickCount + partialTick) % 100f;
                float rotX = getBoneRotX(t);
                float moveY = getBoneMoveY(t);
                float moveZ = getBoneMoveZ(t);

                getBone(model, "track_left").ifPresent(bone -> {
                    bone.setRotX(rotX * Mth.DEG_TO_RAD);
                    bone.setPosY(moveY);
                    bone.setPosZ(moveZ);
                });

                getBone(model, "track_right").ifPresent(bone -> {
                    bone.setRotX(rotX * Mth.DEG_TO_RAD);
                    bone.setPosY(moveY);
                    bone.setPosZ(moveZ);
                });

                // Laser Scaling
                getBone(model, "laser").ifPresent(laser -> {
                    laser.setHidden(false);

                    float scale = Mth.lerp(
                            partialTick,
                            railTank.getLaserScaleO(),
                            railTank.getLaserScale()
                    );
                    if (scale > 1.2f) {
                        scale = 1.2f;
                    }

                    laser.setScaleX(scale);
                    laser.setScaleY(2.8f * scale);
                    laser.setScaleZ(10.0f * railTank.getLaserLength());
                });
            }
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    private Optional<GeoBone> getBone(GeoModel model, String boneName) {
        if (model == null || model.getAnimationProcessor() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable((GeoBone) model.getAnimationProcessor().getBone(boneName));
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