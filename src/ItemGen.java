import java.util.Random;

public class ItemGen {
    public static Item GenRandomItem() {
        Random rand = new Random();
        int n = rand.nextInt(ItemList.ItemCount);
        switch (n) {
            case 0 -> {
                return ItemList.item0;
            }//nothing
            case 1 -> {
                return ItemList.item1;
            }//a stick
            case 2 -> {
                return ItemList.item2;
            }//a few stones
            case 3 -> {
                return ItemList.item3;
            }//a heavy rock
            case 4 -> {
                return ItemList.item4;
            }//some metal scraps
            case 5 -> {
                return ItemList.item5;
            }//a rusty blade
            default -> throw new IllegalStateException("Unexpected value: " + n);
        }
    }
}