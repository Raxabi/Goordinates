package net.sibani.goordinates;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import net.sibani.goordinates.keybinds.Keybinds;
import net.sibani.goordinates.client.GoordinatesGUI;

import net.minecraft.text.Text;

/**
 * Class invoked when the client starts
 */
@Environment(EnvType.CLIENT)
public class GoordinatesModClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    KeyBindingHelper.registerKeyBinding(Keybinds.runAndShift_LSHIFT);
    KeyBindingHelper.registerKeyBinding(Keybinds.runAndShift_LALT);

    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      while (Keybinds.texteableCoords.wasPressed()) {
        client.player.sendMessage(Text.literal(
          String.format(
            "%s: X: %d  Y: %d  Z: %d",
            Text.translatable("debug.goordinates.coords_info").getString(), Math.round(client.player.capeX), Math.round(client.player.capeY), Math.round(client.player.capeZ)
          )), false
        );
      }
    });

    HudRenderCallback.EVENT.register(new GoordinatesGUI());
  }
}