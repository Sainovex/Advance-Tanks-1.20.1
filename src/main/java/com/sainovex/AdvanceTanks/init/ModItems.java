package com.sainovex.AdvanceTanks.init;

import com.sainovex.AdvanceTanks.SNVX;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, SNVX.MODID);

    // Vehicles
    public static final RegistryObject<Item> T90_MSA = ITEMS.register("t90_msa",
        () -> new Item(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1)));

    public static final RegistryObject<Item> ABRAMS_X = ITEMS.register("abrams_x",
        () -> new Item(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1)));


    // Helper method called in SNVX.java
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}