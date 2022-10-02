import java.util.Random;

public class Location {

    public static void main(String[] args) {

        Random rand = new Random();
        //Scanner input = new Scanner(System.in);

        //System.out.println("Please enter an X co-ordinate from 1-5: ");
        //int x = input.nextInt();
        int xbound = rand.nextInt(5,10);
        int startingx = rand.nextInt(1,xbound-1);
        //System.out.println("Please enter a y co-ordinate from 1-5:  ");
        //int y = input.nextInt();
        int ybound = rand.nextInt(5,10);
        int startingy = rand.nextInt(1,ybound-1);

        //System.out.println("");

        for (int i = ybound; i >= 1; i--) {
            System.out.print(i);

            for (int j = 1; j <= xbound; j++) {
                if (i == startingx && j == startingy) {
                    System.out.print(" X");
                } else {
                    System.out.print(" █");
                }
            }

            System.out.print("\n");
        }
        for (int k = 0;k<=9;k++) {
            if (k<xbound+1){System.out.print(k + " ");}
        }

        System.out.println("\n\n"+ xbound);
        System.out.println(ybound);
        System.out.println(startingx);
        System.out.println(startingy);

        /*for (int k = 10;k<ybound;k++) {
            if (k<ybound){System.out.print(k + "");}
        }*/
    }

}
