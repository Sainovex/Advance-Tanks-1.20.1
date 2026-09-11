package com.sainovex.AdvanceTanks;

import com.atsuishio.superbwarfare.api.event.RegisterContainersEvent;
import com.mojang.logging.LogUtils;
import com.sainovex.AdvanceTanks.init.ModEntities;
import com.sainovex.AdvanceTanks.init.ModItems;
import com.sainovex.AdvanceTanks.init.ModTabs;
import com.sainovex.AdvanceTanks.network.ADVANCETANKSNetwork;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;

@Mod(SNVX.MODID)
public class SNVX {
    public static final String MODID = "snvx";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SNVX() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModTabs.TABS.register(modEventBus);

        modEventBus.addListener(this::setup);

        modEventBus.register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ADVANCETANKSNetwork.register();
        });
    }

    @SubscribeEvent
    public void onRegisterContainers(RegisterContainersEvent event) {
        // Superb Warfare uses add(RegistryObject<EntityType<T>>)
        event.add(ModEntities.T90_MSA);
    }

    public static SimpleChannel getPacketHandler() {
        return ADVANCETANKSNetwork.ADVANCETANKS_HANDLER;
    }

    public static ResourceLocation loc(String path) {
        return new ResourceLocation(MODID, path);
    }
}