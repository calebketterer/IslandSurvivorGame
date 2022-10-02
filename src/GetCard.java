import java.util.Objects;
import java.util.Random;

public Item GetCard()
        {
        Random rand = new Random();
        int n = rand.nextInt(ItemCount);

        switch (n) {
        case 0 -> return item0;//nothing
        case 1 -> return item1;//a stick
        case 2 -> return item2;//a few stones
        case 3 -> return item3;//a heavy rock
        case 4 -> return item4;//some metal scraps
        case 5 -> return item5;//a rusty blade
        default -> throw new IllegalStateException("Unexpected value: " + n);
            /*if (n == 0){Card1 = item0;} //nothing
            if (n == 1){Card1 = item1;} //a stick
            if (n == 2){Card1 = item2;} //a few stones
            if (n == 3){Card1 = item3;} //a heavy rock
            if (n == 4){Card1 = item4;} //some metal scraps*/ //Old if-else structure
        }
        }