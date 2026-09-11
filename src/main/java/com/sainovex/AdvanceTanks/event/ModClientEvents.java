package com.sainovex.AdvanceTanks.event;

import com.sainovex.AdvanceTanks.SNVX;
import com.sainovex.AdvanceTanks.client.renderer.T90MSRenderer;
import com.sainovex.AdvanceTanks.init.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SNVX.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Binds your entity to your T90MSRenderer class
        event.registerEntityRenderer(ModEntities.T90_MSA.get(), T90MSRenderer::new);
    }
}