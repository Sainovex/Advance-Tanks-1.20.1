package com.sainovex.AdvanceTanks.event;

import com.atsuishio.superbwarfare.api.event.RegisterContainersEvent;
import com.sainovex.AdvanceTanks.SNVX;
import com.sainovex.AdvanceTanks.init.ModEntities;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SNVX.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModContainerEvents {

    @SubscribeEvent
    public static void onRegisterContainers(RegisterContainersEvent event) {
        // Registers your T-90 MSA entity as a vehicle container item
        event.add(ModEntities.T90_MSA);
    }
}