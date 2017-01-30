import java.util.Random;
public class dice {
    int value;
    int sides;
    Random r = new Random();
    public dice(int s) {
        sides = s;
        value = r.nextInt(6+1) % sides + 1;
    }
    public int getSides() {
        return sides;
    }
    public int getValue() {
        return value;
    }
    public void setSides(int s) {
        sides = s;
    }
    public void setValue(int v) {
        value = v;
    }
    
}