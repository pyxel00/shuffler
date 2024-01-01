package pyxel00.shuffler.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ShufflerMechanic {
    private static final Inventory inventory = MinecraftClient.getInstance().player.getInventory();
    private static List<ItemStack> temp = new ArrayList<>();
    public static void addToTempList() {
        for(int i = 0; i < 9; i++) {
            ItemStack itemStack = inventory.getStack(i);
            temp.add(itemStack);
            inventory.setStack(i, ItemStack.EMPTY);
        }
    }
    public static void readFromTempList() {
        for (int i = 0; i < 9; i++) {
            inventory.setStack(i + 9, temp.get(i));
        }
        temp.clear();
    }
    public static void shuffle() {
        for(int i = 27; i < 36; i++) {
            ItemStack itemStack = inventory.getStack(i);
            inventory.setStack(i - 27, itemStack);
            inventory.setStack(i, ItemStack.EMPTY);
        }
        for(int i = 18; i < 27; i++) {
            ItemStack itemStack = inventory.getStack(i);
            inventory.setStack(i + 9, itemStack);
            inventory.setStack(i, ItemStack.EMPTY);
        }
        for(int i = 9; i < 18; i++) {
            ItemStack itemStack = inventory.getStack(i);
            inventory.setStack(i + 9, itemStack);
            inventory.setStack(i, ItemStack.EMPTY);
        }
    }
}
