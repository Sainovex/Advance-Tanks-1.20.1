package com.sainovex.AdvanceTanks.network;

import com.sainovex.AdvanceTanks.SNVX;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ADVANCETANKSNetwork {
    public static final String MOD_ID = SNVX.MODID;
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel ADVANCETANKS_HANDLER = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MOD_ID, "network"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int messageID = 0;

    private ADVANCETANKSNetwork() {
    }

    public static <T> void addNetworkMessage(Class<T> messageType,
                                            BiConsumer<T, FriendlyByteBuf> encoder,
                                            Function<FriendlyByteBuf, T> decoder,
                                            BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        ADVANCETANKS_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    public static <T> void addNetworkMessage(Class<T> messageType,
                                            BiConsumer<T, FriendlyByteBuf> encoder,
                                            Function<FriendlyByteBuf, T> decoder,
                                            BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer,
                                            Optional<NetworkDirection> direction) {
        ADVANCETANKS_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer, direction);
        messageID++;
    }

    public static void register() {

    }
}
