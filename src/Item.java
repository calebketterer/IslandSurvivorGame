public class Item {
    private final String ItemName;
    private final int Worth;

    private String Ability;
    private String FlavorText;

    private Item(ItemBuilder builder) {
        this.ItemName = builder.ItemName;
        this.Worth = builder.Worth;
        this.Ability = builder.Ability;
        this.FlavorText = builder.FlavorText;
    }

    public String getItemName() {
        return ItemName;
    }
    public int getWorth() {
        return Worth;
    }
    public String getAbility() {
        return Ability;
    }
    public String getFlavorText() {
        return FlavorText;
    }

    @Override
    public String toString() {
        return "Item: " + this.ItemName + " is worth " + this.Worth + " coin. " + this.Ability + "\n\n"+ this.FlavorText;}

    public static class ItemBuilder{
        private final String ItemName;
        private final int Worth;
        private String Ability;
        private String FlavorText;

        public ItemBuilder(String ItemName, int Worth){
            this.ItemName = ItemName;
            this.Worth = Worth;
        }

        public ItemBuilder Ability(String Ability){this.Ability = Ability;return this;}
        public ItemBuilder Flavortext(String FlavorText){this.FlavorText = FlavorText; return this;}

        public Item build(){
            Item item = new Item(this);
            validateItemsObject(item);
            return item;
        }

        private void validateItemsObject(Item item){}
    }
}
