package immersive_paintings;

import immersive_paintings.cobalt.network.NetworkHandler;
import immersive_paintings.network.s2c.PaintingListMessage;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashSet;
import java.util.Set;

public class ServerDataManager {
    public static Set<Integer> sent = new HashSet<>();

    public static void playerLoggedOff(ServerPlayerEntity player) {
        sent.remove(player.getId());
    }

    public static void playerRequestedImages(ServerPlayerEntity player) {
        if (!sent.contains(player.getId())) {
            NetworkHandler.sendToPlayer(new PaintingListMessage(), player);
            sent.add(player.getId());
        }
    }
}
