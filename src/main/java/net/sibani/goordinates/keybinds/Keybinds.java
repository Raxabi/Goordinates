package net.sibani.goordinates.keybinds;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.util.InputUtil;
import net.minecraft.client.option.KeyBinding;

/**
 * Define the KeyBindings to run while shifting and print the actual coords in the screen
 */
public class Keybinds {
  public static KeyBinding runAndShift_LSHIFT = new KeyBinding(
    "key.goordinates.primary_run_and_shift",
    InputUtil.Type.KEYSYM,
    GLFW.GLFW_KEY_LEFT_SHIFT,
    "Goordinates"
  );

  public static KeyBinding runAndShift_LALT = new KeyBinding(
    "key.goordinates.secondary_run_and_shift",
    InputUtil.Type.KEYSYM,
    GLFW.GLFW_KEY_LEFT_ALT,
    "Goordinates"
  );

  public static KeyBinding texteableCoords = new KeyBinding(
    "key.goordinates.texteable_coords",
    InputUtil.Type.KEYSYM,
    GLFW.GLFW_KEY_F4,
    "Goordinates"
  );
}
