import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main implements ItemList, DiscoveryList {

    public static void main(String[] args) {

        //This is where the ItemsList was
        //This is where the ScenarioList likely would have been

        Item Card1 = ItemGen.GenRandomItem();
        Item Card2 = ItemGen.GenRandomItem();
        Item Card3 = ItemGen.GenRandomItem();

        /*Item Card1 = null;
        int n = rand.nextInt(5);
        switch (n) {
            case 0 -> Card1 = item0;//nothing
            case 1 -> Card1 = item1;//a stick
            case 2 -> Card1 = item2;//a few stones
            case 3 -> Card1 = item3;//a heavy rock
            case 4 -> Card1 = item4;//some metal scraps
            default -> throw new IllegalStateException("Unexpected value: " + n);

        }

        Item Card2 = null;
        n = rand.nextInt(5);
        switch (n) {
            case 0 -> Card2 = item0;//nothing
            case 1 -> Card2 = item1;//a stick
            case 2 -> Card2 = item2;//a few stones
            case 3 -> Card2 = item3;//a heavy rock
            case 4 -> Card2 = item4;//some metal scraps
            default -> throw new IllegalStateException("Unexpected value: " + n);
        }

        Item Card3 = null;
        n = rand.nextInt(5);
        switch (n) {
            case 0 -> Card3 = item0;//nothing
            case 1 -> Card3 = item1;//a stick
            case 2 -> Card3 = item2;//a few stones
            case 3 -> Card3 = item3;//a heavy rock
            case 4 -> Card3 = item4;//some metal scraps
            default -> throw new IllegalStateException("Unexpected value: " + n);
        }*/
        Random rand = new Random();
        int n = rand.nextInt(21, 101);
        int Nourishment = n;  //Food and Hydration out of 100. If it reaches 0, the player dies.
        int DistanceFromCoast = 0; //Distance from coast. Negatives will be in ocean.
        /*
         Coast has higher chance of treasure, no chance of food.
         Beach has high chance of treasure, slim chance for food.
         The farther inland you go, the more difficult it gets,
         but there might be food and drinkable water.
        */
        int Lifetime = 0; // How many turns you survived
        //int Experience = 0; // Experienced gained by scenario completion
        int TotalWorth = Card1.getWorth() + Card2.getWorth() + Card3.getWorth();

        String s = null;
        Scanner sc = new Scanner(System.in);

        /*do{System.out.println("\nReady?(Yes/No/Controls/Objective/Tips)");
            s = sc.nextLine();
            switch (s) {
                case "Controls": {
                    System.out.print("""
                                    
                                    This game is entirely type-based.
                                    If the text has something like (Yes/No),
                                    Your obvious options are Yes or No.
                                    
                                    These cannot have a space before or after them
                                    and must start with a capital letter.
                                    
                                    During the game, you will always have access to (Stats)
                                    and will not be penalized for mis-inputs.
                                    """);
                    break;
                }
                case "Objective": {
                    System.out.print("""
                                    
                                    The goal of this game is to live the longest possible life you can
                                    while acquiring as much wealth as possible.
                                    """);
                    break;
                }
                case "Reroll": {
                    Card1 = GetItem.GenRandomItem();
                    Card2 = GetItem.GenRandomItem();
                    Card3 = GetItem.GenRandomItem();
                    System.out.print("Your items have officially been rerolled.");
                    break;
                }
                case "Stats": {
                    System.out.print("\nYou're currently carrying " + Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + "." +
                            "\nYou're on turn " + Lifetime + "." +
                            "\nYou're currently worth " + TotalWorth + " coin." +
                            "\nYour Nourishment is at " + Nourishment + " percent." +
                            "\nYou're " + DistanceFromCoast + " quarter-kilometers from the coast.\n"
                    );
                    break;
                } //Add get fucked statement if ItemWorth <= 5 coin.
                case "Tips": {
                    n = rand.nextInt(5);
                    switch (n) {
                        case 0 -> {
                            System.out.print("""

                                    Your wealth can be spent on food to keep your character from going hungry
                                    as long as you can find the local village with funds to spare.
                                    """);
                        } // Spending wealth
                        case 1 -> {
                            System.out.print("""

                                    This game's values are almost entirely RNG based,
                                    so it's best to play it safe if you're worried about dying!
                                    """);
                        } // Play it safe!
                        case 2 -> {
                            System.out.print("""

                                    Due to the shipwrecks along the shore,
                                    you are more likely to find valuable items washed up at the coast!
                                    """);
                        } // More likely for valuables
                        case 3 -> {
                            System.out.print("""

                                    You are less likely to find valuables close to the village.
                                    """);
                        } // Less likely for valuables
                        case 4 -> {
                            System.out.print("""

                                    You are more likely to find food closer to the inland than at the coast!
                                    """);
                        } // Food rarity
                        default -> {
                            System.out.print("""

                                    Well this wasn't supposed to happen...
                                    """);
                        } // Catch
                    } // Tip list
                    break;
                }

            }
        } //Ready?(Yes/No/Controls/Objectives/Tips)
        while(!Objects.equals(s, "Yes"));*/ // Consent prompt
        /*System.out.println("""
                
                Hello survivor!

                You are washed up onto the banks of a shore you’ve never seen before.
                From what you can tell, no one else has found it either.
                Immediately surrounding you are\040""" + Card1.getItemName()+ ", " + Card2.getItemName() + ", and " + Card3.getItemName() + ". " + """
                
                These seem to be the only remains from the shipwreck.
                
                You are the sole survivor.""");*/ // Intro info
        /*do {System.out.println("\nWill you get up or just lay there and die? (Live/Die)");
            s = sc.nextLine();
            if (Objects.equals(s, "Die")){System.out.println("\nWell... Congrats. You never got up and you died. \n\nGame over.");
                System.exit(0);}
            if (Objects.equals(s, "Controls")){System.out.print("""
                Input the following to display the following:
                
                Stats       :   Displays your character stats.
                Controls    :   Pulls up this menu again.
                """);}
            if (Objects.equals(s, "Stats")){System.out.print("\nYou're currently carrying " + Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + "." +
                    "\nYou're currently worth " + TotalWorth + " coin." +
                    "\nYour Nourishment is at " + Nourishment + " percent." +
                    "\nYour Hydration is at " + Hydration + " percent." +
                    "\nYou're " + DistanceFromCoast + " quarter-kilometers from the coast.\n"
            );}
        }//(Live/Die)
        while(!Objects.equals(s, "Live"));
        System.out.println("\nWell... Congrats, you didn't die... \n\nYet.");
*/ // Sarcastic intro prompt  Make it pop up 20% of the time ?
        do {
            switch (DistanceFromCoast) {
                case 0 -> {
                    System.out.println("""
                                            
                            You now have to choose if you'll wander along the coast
                            or across the beach towards the inland.
                                            
                            Which shall it be? (Coast/Beach)""");
                    s = sc.nextLine();
                    switch (s) {
                        case "Stats": {
                            System.out.print("\nYou're currently carrying " + Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + "." +
                                    "\nYou're on turn " + Lifetime + "." +
                                    "\nYou're currently worth " + TotalWorth + " coin." +
                                    "\nYour Nourishment is at " + Nourishment + " percent." +
                                    "\nYou're " + DistanceFromCoast + " quarter-kilometers from the coast.\n"
                            );
                            break;
                        } //Add get fucked statement if ItemWorth <= 5 coin.
                        case "Coast": {
                            Nourishment = Nourishment - 5;
                            //DistanceFromCoast = 0;
                            n = rand.nextInt(discovery1.getRarity() + 1);
                            if (n == 1 || n == 2) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery1;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            } //Temp scenario gen. Doesn't work in the long run.
                            n = rand.nextInt(discovery2.getRarity() + 1);
                            if (n == 1 || n == 2) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery2;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        case "Beach": {
                            Nourishment = Nourishment - 5;
                            DistanceFromCoast = 1;
                            n = rand.nextInt(discovery1.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery1;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            } //Temp scenario gen. Doesn't work in the long run.
                            n = rand.nextInt(discovery2.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery2;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        default: {
                            if (!s.equals("Exit")) {
                                System.out.println("Invalid input: " + s);
                            }
                            break;
                        }
                    }
                    if (Nourishment <= 0) {
                        System.out.println("\nWell.. You starved to death. Or died from dehydration. Either way, you didn't survive." +
                                "\nYour final stats:" +
                                "\nLifetime: " + Lifetime + " turns." +
                                "\nWorth: " + TotalWorth + " coin." +
                                "\nNourishment: " + Nourishment + " percent.");
                        System.exit(0);
                    }
                    break;
                } // Coast
                case 1 -> {
                    System.out.println("""
                                            
                            You now have have to choose if you'll return to the coast,
                            remain on the beach, or approach the inland.
                                            
                            Which shall it be? (Coast/Beach/Inland)""");
                    s = sc.nextLine();
                    switch (s) {
                        case "Stats": {
                            System.out.print("\nYou're currently carrying " + Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + "." +
                                    "\nYou're on turn " + Lifetime + "." +
                                    "\nYou're currently worth " + TotalWorth + " coin." +
                                    "\nYour Nourishment is at " + Nourishment + " percent." +
                                    "\nYou're " + DistanceFromCoast + " quarter-kilometers from the coast.\n"
                            );
                            break;
                        }
                        case "Coast": {
                            Nourishment = Nourishment - 5;
                            DistanceFromCoast = 0;
                            n = rand.nextInt(discovery1.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery1;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            } //Temp scenario gen. Doesn't work in the long run with a lot of discoveries.
                            n = rand.nextInt(discovery2.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery2;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        case "Beach": {
                            Nourishment = Nourishment - 5;
                            //DistanceFromCoast = 1;
                            n = rand.nextInt(discovery1.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery1;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            } //Temp scenario gen. Doesn't work in the long run.
                            n = rand.nextInt(discovery2.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery2;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        case "Inland": {
                            Nourishment = Nourishment - 5;
                            DistanceFromCoast = 2;
                            n = rand.nextInt(discovery3.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery3;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery4.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery4;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery5.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery5;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        default: {
                            if (!s.equals("Exit")) {
                                System.out.println("Invalid input: " + s);
                            }
                            break;
                        }
                    }
                    if (Nourishment <= 0) {
                        System.out.println("\nWell.. You starved to death. Or died from dehydration. Either way, you didn't survive.\n" +
                                "\nYour final stats:" +
                                "\nLifetime: " + Lifetime + " turns." +
                                "\nWorth: " + TotalWorth + " coin." +
                                "\nNourishment: " + Nourishment + " percent.");
                        System.exit(0);
                    }
                    break;
                } // Beach
                case 2 -> {
                    System.out.println("""
                                            
                            You now have have to choose if you'll return to the beach,
                            remain on the inland, or approach the forest.
                                            
                            Which shall it be? (Beach/Inland/Forest)""");
                    s = sc.nextLine();
                    switch (s) {
                        case "Stats": {
                            System.out.print("\nYou're currently carrying " + Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + "." +
                                    "\nYou're on turn " + Lifetime + "." +
                                    "\nYou're currently worth " + TotalWorth + " coin." +
                                    "\nYour Nourishment is at " + Nourishment + " percent." +
                                    "\nYou're " + DistanceFromCoast + " quarter-kilometers from the coast.\n"
                            );
                            break;
                        }
                        case "Beach": {
                            Nourishment = Nourishment - 5;
                            DistanceFromCoast = 1;
                            n = rand.nextInt(discovery1.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery1;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            } //Temp scenario gen. Doesn't work in the long run.
                            n = rand.nextInt(discovery2.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery2;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        case "Inland": {
                            Nourishment = Nourishment - 5;
                            //DistanceFromCoast = 2;
                            n = rand.nextInt(discovery3.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery3;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery4.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery4;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery5.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery5;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        case "Forest": {
                            Nourishment = Nourishment - 5;
                            DistanceFromCoast = 3;
                            n = rand.nextInt(discovery3.getRarity() + 1);
                            if (n == 1 || n == 2) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery3;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery4.getRarity() + 1);
                            if (n == 1 || n == 2) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery4;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery5.getRarity() + 1);
                            if (n == 1 || n == 2) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery5;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        default: {
                            if (!s.equals("Exit")) {
                                System.out.println("Invalid input: " + s);
                            }
                            break;
                        }
                    }
                    if (Nourishment <= 0) {
                        System.out.println("\nWell.. You starved to death. Or died from dehydration. Either way, you didn't survive.\n" +
                                "\nYour final stats:" +
                                "\nLifetime: " + Lifetime + " turns." +
                                "\nWorth: " + TotalWorth + " coin." +
                                "\nNourishment: " + Nourishment + " percent.");
                        System.exit(0);
                    }
                    break;
                } // Inland
                case 3 -> {
                    System.out.println("""
                                            
                            You now have have to choose if you'll return to the inland,
                            remain in the forest, or approach the village.
                                            
                            Which shall it be? (Inland/Forest/Village)""");
                    s = sc.nextLine();
                    switch (s) {
                        case "Stats": {
                            System.out.print("\nYou're currently carrying " + Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + "." +
                                    "\nYou're on turn " + Lifetime + "." +
                                    "\nYou're currently worth " + TotalWorth + " coin." +
                                    "\nYour Nourishment is at " + Nourishment + " percent." +
                                    "\nYou're " + DistanceFromCoast + " quarter-kilometers from the coast.\n"
                            );
                            break;
                        }
                        case "Inland": {
                            Nourishment = Nourishment - 5;
                            DistanceFromCoast = 2;
                            n = rand.nextInt(discovery3.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery3;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery4.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery4;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery5.getRarity() + 1);
                            if (n == 1) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery5;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        case "Forest": {
                            Nourishment = Nourishment - 5;
                            //DistanceFromCoast = 3;
                            n = rand.nextInt(discovery3.getRarity() + 1);
                            if (n == 1 || n == 2) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery3;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery4.getRarity() + 1);
                            if (n == 1 || n == 2) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery4;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            n = rand.nextInt(discovery5.getRarity() + 1);
                            if (n == 1 || n == 2) {
                                Discovery DiscoveryX;
                                DiscoveryX = discovery5;
                                TotalWorth = TotalWorth + DiscoveryX.getWorth();
                                if (Nourishment + DiscoveryX.getNourishment() < 100) {
                                    Nourishment = Nourishment + DiscoveryX.getNourishment();
                                }
                                System.out.println("\n" + DiscoveryX.getNarrative());
                            }
                            break;
                        }
                        case "Village": {
                            Nourishment = Nourishment - 5;
                            DistanceFromCoast = 4;
                            break;
                        }
                        default: {
                            if (!s.equals("Exit")) {
                                System.out.println("Invalid input: " + s);
                            }
                            break;
                        }
                    }
                    if (Nourishment <= 0 && s.equals("Village")) {
                        System.out.println("\nYou were so close, but a small miscalculation resulted in the worst. \nYou starved to death. Or died from dehydration. Either way, you didn't survive.\n" +
                                "\nYour final stats:" +
                                "\nLifetime: " + Lifetime + " turns." +
                                "\nWorth: " + TotalWorth + " coin." +
                                "\nNourishment: " + Nourishment + " percent.");
                        System.exit(0);
                    }
                    if (Nourishment <= 0) {
                        System.out.println("\nWell.. You starved to death. Or died from dehydration. Either way, you didn't survive.\n" +
                                "\nYour final stats:" +
                                "\nLifetime: " + Lifetime + " turns." +
                                "\nWorth: " + TotalWorth + " coin." +
                                "\nNourishment: " + Nourishment + " percent.");
                        System.exit(0);
                    }

                    break;
                } // Forest
                case 4 -> {
                    System.out.println("\nCongrats, you've found the local village!\nYour final stats:" +
                            "\nLifetime: " + Lifetime + " turns." +
                            "\nWorth: " + TotalWorth + " coin." +
                            "\nNourishment: " + Nourishment + " percent.");
                    System.exit(0);
                } // Village
            }
            if (Objects.equals(s, "Coast") || Objects.equals(s, "Beach") || Objects.equals(s, "Inland") || Objects.equals(s, "Forest") || Objects.equals(s, "Village")){ Lifetime ++;}
        }//switch cases

        while(!Objects.equals(s, "Exit"));

            System.out.println("\nThe game has been exited.");
    }
}