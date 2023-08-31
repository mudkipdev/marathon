package dev.emortal.minestom.marathon;

import dev.emortal.minestom.gamesdk.MinestomGameServer;
import dev.emortal.minestom.gamesdk.config.GameSdkConfig;
import net.minestom.server.MinecraftServer;
import net.minestom.server.utils.NamespaceID;
import net.minestom.server.world.DimensionType;

public class Main {

    public static void main(String[] args) {
        MinestomGameServer.create(() -> {
            DimensionType fullbright = DimensionType.builder(NamespaceID.from("fullbright")).ambientLight(1f).build();
            MinecraftServer.getDimensionTypeManager().addDimension(fullbright);

            return GameSdkConfig.builder()
                    .minPlayers(1)
                    .maxGames(30)
                    .gameCreator(MarathonGame::new)
                    .build();
        });
    }

}