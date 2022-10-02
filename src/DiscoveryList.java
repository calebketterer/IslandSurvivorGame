public interface DiscoveryList {

    Discovery discovery0 = new Discovery.DiscoveryBuilder("Nothing", 0)
            .FlavorText("I'm not hopeless, you are.")
            .Narrative("You wander on for a while longer and find nothing. You just get a bit hungrier and thirstier.")
            .build();

    Discovery discovery1 = new Discovery.DiscoveryBuilder("Small Treasure", 10)
            .FlavorText("A little less hopeless, you are.")
            .Narrative("You find a small pouch of jewelry that washed up.")
            .Rarity(20) // There is a 1/Rarity chance of finding this item.
            .Worth(25)
            .build();

    Discovery discovery2 = new Discovery.DiscoveryBuilder("Large Treasure", 20)
            .FlavorText("Lucky, all things considered.")
            .Narrative("You find a small chest that cracked upon washing up. Probably more remains from the wreck.")
            .Rarity(50)
            .Worth(75)
            .build();

    Discovery discovery3 = new Discovery.DiscoveryBuilder("Wild Berries", 5)
            .FlavorText("A little less hungry, I hope.")
            .Narrative("After wandering amongst the brush, you find some wild berries to eat.")
            .Nourishment(20)
            .Rarity(15)
            .build();

    Discovery discovery4 = new Discovery.DiscoveryBuilder("Edible Weeds", 5)
            .Narrative("These edible weeds might make me less hungry...")
            .FlavorText("A little less hungry, I hope.")
            .Nourishment(5)
            .Rarity(15)
            .build();

    Discovery discovery5 = new Discovery.DiscoveryBuilder("Tasty Tree Bark", 5)
            .Narrative("You take notice of how tasty the trees around you look and take a bite.")
            .FlavorText("A little less hungry, I hope.")
            .Nourishment(5)
            .Rarity(15)
            .build();
}
