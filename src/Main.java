import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main implements ItemList, DiscoveryList {
    public static int Nourishment = 25, DistanceFromCoast = 0, Lifetime = 0, PocketChange = 0, Experience = 0, TotalWorth, n;
    public static String s;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static Item Card1, Card2, Card3;

    //GameRules
    public static boolean Inventory = false;
    public static boolean Randomize = false;

    public static void genInventory(){
        Inventory = true;
        Card1 = ItemGen.GenRandomItem();
        Card2 = ItemGen.GenRandomItem();
        Card3 = ItemGen.GenRandomItem();
    }
    public static void initializePlayerStats(){
        if(Randomize){randomizePlayerStats();}
        else {
            Nourishment = 100;  //If it reaches 0, the player dies.
            PocketChange = 20;
            DistanceFromCoast = 0; //Temporary player location tool. Negatives will be in ocean.
            Lifetime = 0; // How many turns you survived
            if (Inventory) {
                TotalWorth = Card1.getWorth() + Card2.getWorth() + Card3.getWorth() + PocketChange;
            } else {
                TotalWorth = PocketChange;
            }
        }
        if(Inventory){genInventory();}
    }
    public static void randomizePlayerStats(){
        Random rand = new Random();
        n = rand.nextInt(21, 101);
        Nourishment = n;  //If it reaches 0, the player dies.
        PocketChange = rand.nextInt(10, 25);
        DistanceFromCoast = 0; //Temporary player location tool. Negatives will be in ocean.
        /*
         Coast has higher chance of treasure, no chance of food.
         Beach has high chance of treasure, slim chance for food.
         The farther inland you go, the more difficult it gets,
         but there might be food and drinkable water.
        */
        Lifetime = 0; // How many turns you survived
        int Experience = 0; // Experienced gained by scenario completion
        if (Inventory) {TotalWorth=Card1.getWorth() + Card2.getWorth() + Card3.getWorth()+PocketChange;}
        else {TotalWorth=PocketChange;}
    }

    public static void promptControls(){
        System.out.print("""
                                                                
                            This game is entirely type-based.
                            If the text has something like (Yes/No),
                            Your obvious options are Yes or No.
                                                                
                            These cannot have a space before or after them
                            and must start with a capital letter.
                            
                            Alternatively, you can simply input
                            the first lowercase letter of a word.
                            (This only works after the game starts.)
                                                                
                            During the game, you will always have access to (Stats)
                            and will not be penalized for mis-inputs.
                            """);
    }
    public static void promptObjective(){
        System.out.print("""
                                                                
                            The goal of this game is to live the longest possible life you can
                            while acquiring as much wealth as possible.
                            """);
    }
    public static void promptTips(){

        n = rand.nextInt(5);
        switch (n) {
            case 0 -> System.out.print("""

                                Your wealth can be spent on food to keep your character from going hungry
                                as long as you can find the local village with funds to spare.
                                """); // Spending wealth
            case 1 -> System.out.print("""

                                This game's values are almost entirely RNG based,
                                so it's best to play it safe if you're worried about dying!
                                """); // Play it safe!
            case 2 -> System.out.print("""

                                Due to the shipwrecks along the shore,
                                you are more likely to find valuable items washed up at the coast!
                                """); // More likely for valuables
            case 3 -> System.out.print("""

                                You are less likely to find valuables close to the village.
                                """); // Less likely for valuables
            case 4 -> System.out.print("""

                                You are more likely to find food closer to the inland than at the coast!
                                """); // Food rarity
            default -> System.out.print("""

                                Well this wasn't supposed to happen...
                                """); // Catch
        } // Tip list
    }
    public static void promptConsent(){
        do{
            System.out.println("\nReady?(Yes/No/Controls/Objective/Tips)");
            s = sc.nextLine();
            switch (s) {
                case "Controls" -> promptControls();
                case "Objective" -> promptObjective();
                case "ReRoll" -> {
                    randomizePlayerStats();
                    if (Inventory) {
                        genInventory();
                        System.out.print("\nAll your stats have officially been rerolled.");
                        promptStats();
                    }
                    else {
                        System.out.print("\nAll your stats have officially been rerolled.");
                        promptStats();
                        System.out.print("This is a reminder that you still have no inventory.\n");
                    }


                }
                case "ReRollInv" -> {
                    if (Inventory) {
                        genInventory();
                        System.out.print("\nYour items have officially been rerolled.");
                        System.out.println("They are now " + Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + ".");
                    }
                    else {
                        System.out.print("\nYou have no inventory.\n");
                    }
                }
                case "Stats" -> promptStats(); //Add get fucked statement if ItemWorth <= 5 coin.
                case "Tips" -> promptTips();
            }
        } //Ready?(Yes/No/Controls/Objectives/Tips)
        while(!Objects.equals(s, "Yes")); // Consent prompt
    }
    public static void promptIntro(){
        System.out.println("""
                
                Hello survivor!

                You are washed up onto the banks of a shore you’ve never seen before.
                From what you can tell, no one else has found it either.""");
        if (Inventory) {
            System.out.println("Immediately surrounding you are\040" +
                    Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + ". " +
                    "\nThese seem to be the only remains from the shipwreck.");
        }
        System.out.println("You are the sole survivor.");
    }
    public static void promptSarcasticPostIntro(){

        do{
            System.out.println("\nWill you get up or just lay there and die? (Live/Die)");
            s = sc.nextLine();
            switch (s) {
                case "Die" -> {System.out.println("\nWell... Congrats, you died... \n\nGame over."); System.exit(0);}
                case "Controls" -> promptControls();
                case "Stats" -> promptStats();
            }
        } //Ready?(Yes/No/Controls/Objectives/Tips)
        while(!Objects.equals(s, "Live"));
        //(Live/Die)
        System.out.println("\nWell... Alright. If you insist... \n");
        // Sarcastic intro prompt  Make it pop up 20% of the time ?
    }
    public static void promptStats(){
        if (Inventory){
            System.out.print("\nYou're carrying " + Card1.getItemName() + ", " + Card2.getItemName() + ", and " + Card3.getItemName() + "."+
                    "\nYour current worth is " + TotalWorth + " coin. " + PocketChange + " of that is pocket change. ");
        }
        else {System.out.print("\nYou got " + PocketChange + " coin in your pockets.");}
        if (Lifetime!=0){System.out.print("\nYou're on turn " + Lifetime + ".");}
        System.out.print(
                "\nYour Nourishment remains at " + Nourishment + " percent." +
                "\n"
        );
    }
    public static void prompt0(){
        System.out.println("""
                                            
                            You now have to choose if you'll wander along the coast
                            or across the beach towards the inland.
                                            
                            Which shall it be? (Coast/Beach)""");
    } //(Coast/Beach)
    public static void prompt1(){
        System.out.println("""
                                            
                            You now have have to choose if you'll return to the coast,
                            remain on the beach, or approach the inland.
                                            
                            Which shall it be? (Coast/Beach/Inland)""");
    } //(Coast/Beach/Inland)
    public static void prompt2(){
        System.out.println("""
                                            
                            You now have have to choose if you'll return to the beach,
                            remain on the inland, or approach the forest.
                                            
                            Which shall it be? (Beach/Inland/Forest)""");
    } //(Beach/Inland/Forest)
    public static void prompt3(){
        System.out.println("""
                                            
                            You now have have to choose if you'll return to the inland,
                            remain in the forest, or approach the village.
                                            
                            Which shall it be? (Inland/Forest/Village)""");
    } //(Inland/Forest/Village)
    public static void prompt4(){
        System.out.println("\nCongrats, you've found the local village!\nYour final stats:" +
                "\nLifetime: " + Lifetime + " turns." +
                "\nWorth: " + TotalWorth + " coin." +
                "\nNourishment: " + Nourishment + " percent.");
    } //Current Endgame

    public static void checkNourishment(){

        if (Nourishment <= 0 && s.equals("Village")) {
            System.out.println("\nYou were so close, but a small miscalculation resulted in the worst. \nYou starved to death. Or died from dehydration. Either way, you didn't survive.\n" +
                    "\nYour final stats:" +
                    "\nLifetime: " + Lifetime + " turns." +
                    "\nWorth: " + TotalWorth + " coin." +
                    "\nNourishment: " + Nourishment + " percent.");
            System.exit(0);
        }

        if (Nourishment <= 0) {
            System.out.println("\nWell.. You starved to death. Or died from dehydration. Either way, you didn't survive." +
                    "\nYour final stats:" +
                    "\nLifetime: " + Lifetime + " turns." +
                    "\nWorth: " + TotalWorth + " coin." +
                    "\nNourishment: " + Nourishment + " percent.");
            System.exit(0);
        }
    }
    public static boolean validInput(){
        return Objects.equals(s, "Coast") || Objects.equals(s, "c")||
                Objects.equals(s, "Beach") || Objects.equals(s, "b")||
                Objects.equals(s, "Inland") || Objects.equals(s, "i")||
                Objects.equals(s, "Forest") || Objects.equals(s, "f")||
                Objects.equals(s, "Village")|| Objects.equals(s, "v");
    }

    public static void selectCoast(){
        Nourishment = Nourishment - 5;
        DistanceFromCoast = 0;
        int n = rand.nextInt(discovery1.getRarity() + 1);
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
    }
    public static void selectBeach(){
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
        }}
    public static void selectInland(){

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
    }
    public static void selectForest(){

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
    }
    public static void selectVillage(){
            Nourishment = Nourishment - 5;
            DistanceFromCoast = 4;
    }

    public static void doTheThing(){
        do {
            switch (DistanceFromCoast) {
                case 0 -> {
                    prompt0();
                    s = sc.nextLine();
                    switch (s) {
                        case "Stats", "s" -> promptStats();
                        case "Coast", "c" -> selectCoast();
                        case "Beach", "b" -> selectBeach();
                        default -> {
                            if (!s.equals("Exit")) {
                                System.out.println("Invalid input: " + s);
                            }
                        }
                    }
                    checkNourishment();
                } // Coast
                case 1 -> {
                    prompt1();
                    s = sc.nextLine();
                    switch (s) {
                        case "Stats", "s" -> promptStats();
                        case "Coast", "c" -> selectCoast();
                        case "Beach", "b" -> selectBeach();
                        case "Inland", "i" -> selectInland();
                        default -> {
                            if (!s.equals("Exit")) {
                                System.out.println("Invalid input: " + s);
                            }
                        }
                    }
                    checkNourishment();
                } // Beach
                case 2 -> {
                    prompt2();
                    s = sc.nextLine();
                    switch (s) {
                        case "Stats", "s" -> promptStats();
                        case "Beach", "b" -> selectBeach();
                        case "Inland", "i" -> selectInland();
                        case "Forest", "f" -> selectForest();
                        default -> {
                            if (!s.equals("Exit")) {
                                System.out.println("Invalid input: " + s);
                            }
                        }
                    }
                    checkNourishment();
                } // Inland
                case 3 -> {
                    prompt3();
                    s = sc.nextLine();
                    switch (s) {
                        case "Stats", "s" -> promptStats();
                        case "Inland", "i" -> selectInland();
                        case "Forest", "f" -> selectForest();
                        case "Village", "v" -> selectVillage();
                        default -> {
                            if (!s.equals("Exit")) {
                                System.out.println("Invalid input: " + s);
                            }
                        }
                    }
                    checkNourishment();
                } // Forest
                case 4 -> {
                    prompt4();
                    System.exit(0);
                } // Village
            }
            if (validInput()){ Lifetime ++;}
        }//switch cases

        while(!Objects.equals(s, "Exit"));
    }

    public static void main(String[] args) {
        initializePlayerStats();
        promptConsent();
        promptSarcasticPostIntro();
        promptIntro();
        doTheThing();

        System.out.println("\nThe game has been exited.");
    }
}