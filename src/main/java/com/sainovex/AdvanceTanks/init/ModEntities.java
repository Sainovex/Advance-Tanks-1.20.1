package com.sainovex.AdvanceTanks.init;

import com.sainovex.AdvanceTanks.SNVX;
import com.sainovex.AdvanceTanks.entity.vehicle.T90MSEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SNVX.MODID);

    public static final RegistryObject<EntityType<T90MSEntity>> T90_MSA =
            ENTITY_TYPES.register("t90_msa", () -> EntityType.Builder
                    .<T90MSEntity>of(T90MSEntity::new, MobCategory.MISC)
                    .setTrackingRange(512)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.9F, 3.5F)
                    .build("t90_msa"));

    private ModEntities() {
    }

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}