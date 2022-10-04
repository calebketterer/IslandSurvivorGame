public interface ItemList {
    int ItemCount = 6;

    Item item0 = new Item.ItemBuilder("nothing", 0)
            .Ability("Not a thing.")
            .Flavortext("I'm not hopeless, you are.")
            .build();

    Item item1 = new Item.ItemBuilder("a stick", 5)
            .Ability("Gain 5 detached melee combat strength.")
            .Flavortext("Might be pointy, might not be.")
            .build();

    Item item2 = new Item.ItemBuilder("a few stones", 5)
            .Ability("Gain 3 ranged combat strength.")
            .Flavortext("Pretty much just harassment.")
            .build();

    Item item3 = new Item.ItemBuilder("a heavy rock", 5)
            .Ability("Gain 10 melee combat strength.")
            .Flavortext("It's a fucking rock.")
            .build();

    Item item4 = new Item.ItemBuilder("some metal scraps", 15)
            .Ability("Might be worth something.")
            .Flavortext("Harder than rock.")
            .build();

    Item item5 = new Item.ItemBuilder("a rusty blade", 10)
            .Ability("Gain 15 melee combat strength.")
            .Flavortext("Might give tetanus too.")
            .build();
}
