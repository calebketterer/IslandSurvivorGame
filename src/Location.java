import java.util.Random;
import java.util.Scanner;

public class Location {

    public static void main(String[] args) {

        Random rand = new Random();

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an x boundary: ");
        int xbound = input.nextInt();

        System.out.println("Please enter a y boundary:  ");
        int ybound = input.nextInt();

        System.out.println("Please enter an x location between 0 and " + xbound + ".");
        int startingx = input.nextInt();
        if (startingx<=1||startingx>=xbound){
            startingx = rand.nextInt(1,xbound-1);
            System.out.println(startingx+ " has been chosen for you.");
        }

        System.out.println("Please enter a y location between 0 and " + ybound + ".");
        int startingy = input.nextInt();
        if (startingy<=1||startingy>=ybound){
            startingy = rand.nextInt(1,ybound-1);
            System.out.println(startingy+ " has been chosen for you.");
        }

        /*
        int xbound = rand.nextInt(5,20);
        int startingx = rand.nextInt(1,xbound-1);
        int ybound = rand.nextInt(5,20);
        int startingy = rand.nextInt(1,ybound-1);*/ //For automatic, random inputs

        for (int j = ybound; j >= 1; j--) {
            if(j<10) {System.out.print(" " + j);}
            else {System.out.print(j);}
            for (int i = 1; i <= xbound; i++) {
                if (i == startingx && j == startingy) {
                    System.out.print(" ●");//◯●
                } else {
                    System.out.print(" ■");//⬜■
                }
            }

            System.out.print("\n");
        }
        for (int k = 0;k<xbound+1;k++) {
            switch (k) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 -> System.out.print(" " + k);
                default -> System.out.print(k);
            }
        }

        System.out.println("\n\nGrid size: "+xbound+" by "+ ybound+". ");
        System.out.println("Starting Location: (" + startingx+", "+startingy+").");
    }

}
