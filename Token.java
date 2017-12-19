/**
 * The token class keeps track of the player's token bank.
 * @author jeffrowell
 */
public class Token {
    
    private final static int INITIAL_STAKE = 100; //Each player starts with 100
    private static int currentStake;
    
    /**
     *  Constructor starts the player off with 100 tokens.
     */
    public Token()
    {
        currentStake = INITIAL_STAKE;
    }
    
    /**
     * Adds tokens to the player's bank
     * @param amount    The amount to add to the token bank
     */
    public static void add(int amount)
    {
        currentStake += amount;
    }
    
    /**
     * Removes tokens from the player's bank
     * @param amount    The amount to remove from the token bank
     */
    public static void remove(int amount)
    {
        currentStake -= amount;
    }
    
    /**
     * Gets the total amount of tokens in the player's bank.
     * @return currentStake     The running total of tokens
     */
    public static int getTotal()
    {
        return currentStake;
    }
}
