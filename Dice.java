import java.util.Random;
/**
 * The dice class represents a 6 - sided die. Each side of the die has a 
 * different number ranging from 1 to 6, inclusive. When the die is rolled,
 * the face - up side will be counted.
 * @author jeffrowell
 */
public class Dice {
    
    static Random rand;        // Access to random number generator 
    static int comeoutRoll;    // The value of dice once rolled
    
    /**
     * This constructs a 6 - sided die with values ranging from 1 to 6,
     * inclusive.
     */
    public Dice()
    {
        rand = new Random();
    }
    
    /**
     * The roll method gets the face - up value after the die has been rolled.
     * 
     * @return comeoutRoll  The face - up value of the die.
     */
    public static int roll()
    {
      comeoutRoll = rand.nextInt(6) + 1;
      return comeoutRoll;  
    }
    
}
