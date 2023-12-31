package pyxel00.shuffler.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ShufflerClient implements ClientModInitializer {
    private static KeyBinding shufflerKey;


    @Override
    public void onInitializeClient() {
        shufflerKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.shuffler.shuffle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "category.shuffler.shuffle"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while(shufflerKey.wasPressed()) {
                ShufflerMechanic.addToTempList();
                ShufflerMechanic.shuffleSecondToFirst();
                ShufflerMechanic.shuffleThirdToSecond();
                ShufflerMechanic.shuffleFourthToThird();
                ShufflerMechanic.readFromTempList();
            }
        });
    }
}
