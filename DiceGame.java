import javax.swing.JOptionPane;

/**
 * This is the dice game! The player will start the game with 100 tokens,
 * and it costs 10 tokens to start each match. The player will play by rolling
 * two dice. If the sum of the face - up values of the two dice are 7 or 11, 
 * the player is rewarded with 20 tokens. If the dice values are 2, 3, or 12, 
 * the player looses. If any value other than 2, 3, 7, 11, or 12 is rolled
 * this value will be called the point. The player will roll the dice until 
 * the point is matched, in which the player will be rewarded with 20 tokens,
 * or until a 7 is rolled in which the match will be over.
 * @author jeffrowell
 */
public class DiceGame {

    static Token bank;
    static Dice die1;
    static Dice die2;
    static private UserInterface ui;
    static final String TITLE = "Dice Game";
    
    /**
     * The main method runs the dice game.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        DiceGame dice = new DiceGame(args[0]);
        play(dice);
        
    } // main
    
    /**
     * Constructs the dice game giving each player two dice and an initial
     * token bank of 100 tokens.
     */
    public DiceGame(String mode)
    {
        bank = new Token();
        die1 = new Dice();
        die2 = new Dice();
        if (mode.toLowerCase().equals("c")) 
        {
            ui = new ConsoleUserInterface("Dice Game\n"
                + "----------");
        }
        else 
        {
            ui = new DialogUserInterface("Dice Game\n"
                + "----------");
        }
    } // default constructor
    
    /**
     * Prints a welcome message to the players of the game. Returns a 1 if the
     * user selects 'No' and returns 0 if the user selects 'Yes', returns -1 if
     * the user closes the frame.
     * @return result   The result of the user's answer.
     */
    public static boolean welcomeMessage()
    {
        String welcomeMessage = "Welcome to the Dice Game.\nIt costs 10"
                + " tokens to play a round.\nYou have " + bank.getTotal()
                + " tokens.\n\nWould you like to play?";
        boolean result = ui.askYesNoQuestion(welcomeMessage);
        return result;
    } // welcomeMessage()
    
    /**
     * Prompts the player when they have won a match that 20 tokens will be
     * added to their bank.
     */
    public static void winnerMessage()
    {
        String message = "WINNER!\nYou have " + bank.getTotal() + " tokens.\n"
                       + "Would you like to play again?";
        boolean result = ui.askYesNoQuestion(message);
        if (!result)
        {
            goodbyeMessage();
            System.exit(0);
        }
        else
        {
           playAgain(); 
        }
    } //winnerMessage()
    
    /**
     * Prompts the player that they have lost the match, telling them their
     * running total of tokens and asking if another match wants to be played.
     */
    public static void looserMessage()
    {
        String message = "Looser.\nYou have " + bank.getTotal() + " tokens.\n"
                       + "Would you like to play again?";
        boolean result = ui.askYesNoQuestion(message);
        if (!result)
        {
            goodbyeMessage();
            System.exit(0);
        }
        else
        {
           playAgain(); 
        }
    }// looserMessage()
    
    /**
     * Displays a message to the user thanking them for playing dice. Prompts
     * the user with the amount of their token bank when exiting the game.
     */
    public static void goodbyeMessage()
    {
        String message = "You retired from the game with " + bank.getTotal() 
                       + " tokens.\nThank you for playing.";
        ui.showMessage(message);
    }// goodbyeMessage()
    
    /**
     * The bet method takes 10 tokens from the player's bank if it is 
     * available, otherwise outputs an error message.
     */
    public static void bet()
    {
        if (bank.getTotal() >= 10)
        {
            bank.remove(10);
        }
        else
        {
            String message = "ERROR: Not enough tokens to play!";
            ui.showMessage(message);
        }
    } // bet()
    
    /**
     * Plays the dice game.
     */
    public static void play(DiceGame dice)
    {
        boolean result = welcomeMessage();
        if (!result)   //If user selects no or closes frame
        {
            goodbyeMessage();
            System.exit(0);
        }
        else
        {
            bet();    // Take the starting fee
            String message = "New round starting!\nComeout roll...\n"
                           + "Start rolling the dice!";
            ui.showMessage(message);
            
            int die1Val = die1.roll();
            int die2Val = die2.roll();
            int comeoutRoll = die1Val + die2Val;
            
            message = "Dice are rolling... ... " + die1Val + " + " + die2Val
                    + " => " + comeoutRoll;
            ui.showMessage(message);
            
            if (comeoutRoll == 7 || comeoutRoll == 11)
            {
                bank.add(20);       // Winner gets 10 tokens
                winnerMessage();
            }
            else if (comeoutRoll == 2 || comeoutRoll == 3 || comeoutRoll == 12)
            {
                looserMessage();
            }
            else
            {
                int point = comeoutRoll;    // Match the point to win
                die1Val = die1.roll();
                die2Val = die2.roll();
                comeoutRoll = die1Val + die2Val;
                
                message = "Your point is " + point + ".\nDice are rolling... "
                        + "... " + die1Val + " + " + die2Val + " => " 
                        + comeoutRoll;
                ui.showMessage(message);
                
                while (comeoutRoll != point && comeoutRoll != 7)
                {
                    die1Val = die1.roll();
                    die2Val = die2.roll();
                    comeoutRoll = die1Val + die2Val;
                    message = "Your point is " + point + ".\nDice are rolling... "
                            + "... " + die1Val + " + " + die2Val + " => " 
                            + comeoutRoll;
                    ui.showMessage(message);
                    
                }
                if (comeoutRoll == 7)
                {
                    looserMessage();
                }
                if (comeoutRoll == point)
                {
                    bank.add(20);
                    winnerMessage();
                }
            }
        }
    } // play()
        
    public static void playAgain() {
        
        bet();    // Take the starting fee
        String message = "New round starting!\nComeout roll...\n"
                + "Start rolling the dice!";
        ui.showMessage(message);

        int die1Val = die1.roll();
        int die2Val = die2.roll();
        int comeoutRoll = die1Val + die2Val;

        message = "Dice are rolling... ... " + die1Val + " + " + die2Val
                + " => " + comeoutRoll;
        ui.showMessage(message);

        if (comeoutRoll == 7 || comeoutRoll == 11) 
        {
            bank.add(20);       // Winner gets 10 tokens
            winnerMessage();
        } 
        else if (comeoutRoll == 2 || comeoutRoll == 3 || comeoutRoll == 12) 
        {
            looserMessage();
        } 
        else 
        {
            int point = comeoutRoll;    // Match the point to win
            die1Val = die1.roll();
            die2Val = die2.roll();
            comeoutRoll = die1Val + die2Val;
                
            message = "Your point is " + point + ".\nDice are rolling... "
                    + "... " + die1Val + " + " + die2Val + " => " 
                    + comeoutRoll;
            ui.showMessage(message);

            while (comeoutRoll != point && comeoutRoll != 7) 
            {
                die1Val = die1.roll();
                die2Val = die2.roll();
                comeoutRoll = die1Val + die2Val;
                message = "Your point is " + point + ".\nDice are rolling... "
                        + "... " + die1Val + " + " + die2Val + " => " 
                        + comeoutRoll;
                ui.showMessage(message);
            }
            if (comeoutRoll == 7) 
            {
                looserMessage();
            }
            if (comeoutRoll == point) 
            {
                bank.add(20);
                winnerMessage();
            }
        }
    }  // playAgain()
}   
