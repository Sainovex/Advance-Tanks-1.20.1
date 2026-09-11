package com.sainovex.AdvanceTanks.init;

import com.sainovex.AdvanceTanks.SNVX;
import com.atsuishio.superbwarfare.item.container.ContainerBlockItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SNVX.MODID);

    public static final RegistryObject<CreativeModeTab> ADVANCE_TANKS_TAB = TABS.register("advance_tanks_tab",
            () -> CreativeModeTab.builder()
                    // Use Superb Warfare's generated container item stack directly for the icon!
                    .icon(() -> ContainerBlockItem.createInstance(ModEntities.T90_MSA.get()))
                    .title(Component.literal("Advance Vehicle"))
                    .displayItems((parameters, output) -> {
                        output.accept(ContainerBlockItem.createInstance(ModEntities.T90_MSA.get()));
                    })
                    .build());

    private ModTabs() {
    }

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}