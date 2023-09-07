package net.sibani.goordinates.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.font.TextRenderer;

/**
 * Renders in the screen the actual player coordinates implementing HudRenderCallback (when the client has loaded all)
 */
public class GoordinatesGUI implements HudRenderCallback {

  //TODO: Allow move the rendered text in other screen corners
  private void renderCoordsInScreenCorner(
    DrawContext drawContext, TextRenderer textRenderer, 
    MinecraftClient mClient
  ) {
    String formattedCoords = String.format(
      "X: %d  Y: %d  Z: %d",
      Math.round(mClient.player.capeX), Math.round(mClient.player.capeY), Math.round(mClient.player.capeZ)
    );

    drawContext.drawText(
      textRenderer, Text.literal(formattedCoords),
      20, 20,
      Colors.WHITE, true
    );
  }

  /**
   * Implements the method of the implemented interface
   */
  @Override
  public void onHudRender(DrawContext drawContext, float tickDelta) {
    var mClient = MinecraftClient.getInstance();
    var textRenderer = mClient.textRenderer;

    if (!mClient.options.debugEnabled) {
      this.renderCoordsInScreenCorner(drawContext, textRenderer, mClient);
    }
    
  }
}
