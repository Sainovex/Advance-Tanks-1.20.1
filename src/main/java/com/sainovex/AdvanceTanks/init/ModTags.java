package com.sainovex.AdvanceTanks.init;

import com.sainovex.AdvanceTanks.SNVX;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public final class ModTags {
    private ModTags() {
    }

    private static TagKey<EntityType<?>> modEntityTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(SNVX.MODID, name));
    }

    private static TagKey<Item> modItemTag(String name) {
        return ItemTags.create(new ResourceLocation(SNVX.MODID, name));
    }

    public static final class EntityTypes {
        public static final TagKey<EntityType<?>> TANKS = modEntityTag("tanks");
    }

    public static final class Items {
        public static final TagKey<Item> LEGENDARY_BLUEPRINT = modItemTag("blueprint/legendary");
    }
}