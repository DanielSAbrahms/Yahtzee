import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jason on 4/22/2017.
 */
public class SpecialDice {
    private int numRolls = 3;
    private int range = 6;
    private boolean isKept;
    private int sideUp;
    private int[] specialDiceArray = {2, 2, 4, 4, 5, 6};


    /*
    (sideUp = 0 signifies that there is no side up. When reading outputs, should set (if ... == 0), do nothing.
     */
    public specialDice(){
        isKept = false;
        int sideUp = 0;
    }

    /*
    2's = use letter twice
    4's = double word score
    5 = replace letter
    6 = force other player (?) //can work on later if need be//

    only allow roll if all 3 rolls have not been used.
     */
    void roll(){
        if(numRolls > 0) {
            int sideUp = specialDiceArray[ThreadLocalRandom.current().nextInt(1, 7)];
            numRolls--;
        }
    }

    int getSideUp() { return sideUp; }

    int getRange() {return range; }

    int setRange(int newRange) {range = newRange; }

    void setIsKept(boolean newKept) { isKept = newKept; }

    boolean getIsKept() { return isKept; }


}
