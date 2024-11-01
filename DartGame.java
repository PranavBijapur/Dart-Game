import java.util.*;

 /**
 *The DartGame class is responsible for creating a game of darts and managing gameplay between the player and the computer opponent, DartVader.
 *@author Pranav Bijapur
 *version 1.2.7
 */
public class DartGame
{
    private Player player;
    private Player dartVader;
    private int score;
    private int dartThrows;

    /**
     * Default constructor for the DartGame class.
     * Initializes the player, DartVader, score, and dartThrows instance variables.
     */
    public DartGame()
    {
        player = new Player();
        dartVader = new Player();
        score = -1;
        dartThrows = -1;
    }

    /**
     * Constructor for the DartGame class.
     * Initializes the player, DartVader, score, and dartThrows instance variables to the given parameters.
     *
     * @param player The player to use in the game.
     * @param dartVader The DartVader opponent to use in the game.
     * @param score The starting score for the game.
     * @param dartThrows The number of dart throws for the game.
     */
    public DartGame(Player player, Player dartVader, int score, int dartThrows)
    {
        this.dartVader = dartVader;
        this.player = player;
        this.score = score;
        this.dartThrows = dartThrows;
    }

    /**
     * Calculates the score for a single dart throw based on where it lands on the board.
     * Uses a random number generator to simulate the throw and determines the score based on the position.
     *
     * @return The score for the dart throw.
     */
    public int calcScore()
    {
        int score = 0;
        DartThrow dT = new DartThrow();
        int rand = (int)dT.dartLandsOnBoard(100,1);
        double range = Math.PI / 4 * 100;
        if (rand<=range)
        {
            int random = (int)dT.dartLandsOnBoard(100,1);
            if(random<=4)
            {
                score = 5;
            }
            else if(random >4 && random<17)
            {
                score = 2;
            }
            else
            {
                score = 1;

            }
        }
        else
            score = 0;
        return score;


    }

    /**
     * Simulates a dart throw for DartVader.
     * Calls calcScore to determine the score for the throw and updates DartVader's score accordingly.
     */
    public void dartVaderDartThrow()
    {
        DartThrow darty = new DartThrow();
        int rand = (int)(darty.dartLandsOnBoard(100,0));
        if(rand>5)
        {
            System.out.println(dartVader.getName() + "Turn");
            int dartSc = calcScore();
            System.out.println(dartVader.getName() + "Score:" + dartSc);
            int dpcs = dartVader.getScore();
            dpcs = dpcs + dartSc;
            dartVader.setScore(dpcs);
        }
        else
        {
            System.out.println(dartVader.getName() + "has chosen to abandon Turn");
        }
    }
    /**
     * Displays the game end result, including the scores of the player and DartVader.
     * Also prompts the user to play another game or exit the program.
     */
    public void displayGameEnd()
    {
        System.out.println("***Game Over***\n=======================================\n***Result***\n");
        System.out.println(player.getName()+"Score:" + player.getScore());
        System.out.println(dartVader.getName()+"Score:"+dartVader.getScore());
        if (dartVader.getScore() > player.getScore())
        {
            System.out.println("***DART VADER WINS**+");
        }
        else
        {
            System.out.println("*** "+player.getName()+" WINS***");
        }

        Scanner console = new Scanner(System.in);
        System.out.println("Would you like to play another game? \n*** YES(y)/NO(n) ***");
        String answer = console.nextLine();
        if (answer.equalsIgnoreCase("Y"))
        {
            int fresh_score = 0;
            player.setScore(fresh_score);
            dartVader.setScore(fresh_score);
            toStart();
        }
        else
            System.out.println("***GOOD BYE***\nThank You! For Playing with Dart Vader!");


    }

    /**
     * Displays a welcome message before the beginning of the game.
     */
    public void displayWelcome()
    {
        System.out.println("***Welcome!***\n***To***\n***DART GAME***\n-A game of darts!\n-Against our very own computer player\n***DARTVADER***!!!\n=======================================\n");
    }

    /**Static funciton of the class and begining point of the execution of the program.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        DartGame dart = new DartGame();
        dart.displayWelcome();
        dart.setPlayerName();
        dart.toStart();
    }

    /**
     * Simulates a dart throw for DartVader.
     * Calls calcScore to determine the score for the throw and updates DartVader's score accordingly.
     * */
    public void playerDartThrow()
    {

        System.out.println(player.getName()+"Turn");
        int sc = calcScore();
        int pcs = player.getScore();
        pcs = pcs +sc;
        player.setScore(pcs);
        System.out.println(player.getName()+"Score:"+sc);

    }
    /**Sets the number of throws to the desired value that the player chooses between the range:1-5
     * @return number of dart throws for the game.
     * */
    public int setDartThrow()
    {

        System.out.println("\nEnter the number of dart throws you would like to play:\n**Please enter a numeric value between 1-5 \n=======================================\n");
        Scanner console = new Scanner(System.in);
        String dartThrow = console.nextLine();
        Validation vali = new Validation();
        boolean flag = vali.stringIsAlphabetic(dartThrow);
        boolean flag1 = vali.isBlank(dartThrow);

        if (!flag && flag1 )
        {
            boolean flag3 = vali.stringValidInput(dartThrow);
            if(flag3)
                this.dartThrows = Integer.parseInt(dartThrow);
            else
            {
                System.out.println("!!!ERROR!!!\n**Please enter a valid numeric value between the range 1-5.\n=======================================\n");
                setDartThrow();
            }
        }
        else
        {
            System.out.println("!!!ERROR!!!\n**Please enter a valid numeric value between the range 1-5.\n=======================================\n");
            setDartThrow();
        }
        int dts = this.dartThrows;
        return dts;
    }

    /**
     *Prompts the user to enter a player name, validates the input and sets the player name.
     *If the input is invalid, prompts the user again until a valid input is given.
     *The player name should follow the format:
     *Lowercase only
     *Alphabetic only
     *Up to 8 characters.
     */
    public void setPlayerName()
    {
        System.out.println("\nEnter a player name:\n=======================================\n");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        Validation vali = new Validation();
        boolean flag = vali.stringLengthInRange(name,0,7);
        boolean flag1 = vali.stringIsAlphabetic(name);
        boolean flag2 = vali.isBlank(name);
        if (flag2 && flag1)
        {
            if(flag )
                this.player.setName(name);
            else
            {
                System.out.println("!!!ERROR!!!\nPlease enter a valid player name that follows the instructions displayed below .\n**The name should be:\n-Lowercase only\n-Alphabetic only\n-Only upto 8 characters.\n=======================================\n");
                setPlayerName();
            }

        }

        else
        {
            System.out.println("!!!ERROR!!!\nPlease enter a valid player name that follows the instructions displayed below .\n**The name should be:\n-Lowercase only\n-Alphabetic only\n-Only upto 8 characters.\n=======================================\n");
            setPlayerName();
        }
        this.dartVader.setName("DartVader");
    }

    /**
     *Asks the player if they want to continue or abandon the game.
     @return a char representing the player's decision ('Y' to continue, 'X' to abandon)
     */
    public char toPlay()
    {

        Scanner console = new Scanner(System.in);
        System.out.println("***"+ player.getName()+" Turn***\nEnter any 'Y' to continue or enter 'X' to abandon this game");
        String choice = console.nextLine();
        if(!choice.equalsIgnoreCase("Y")&&!choice.equalsIgnoreCase("X"))
        {
            System.out.println("\n!!!ERROR!!!\n**Invalid input detected\n**Please follow instructions and enter a valid response.");
            toPlay();
        }
        char decision = choice.charAt(0);
        return decision;
    }

    /**
     *This method prompts the user to enter the number of dart throws they would like to play,
     *calls the setDartThrow() method to validate the input, and sets the number of throws.
     *Then, it loops through the number of throws
     *calls the toPlay()
     *calls playerDartThrow() methods
     *to get input from the player and simulate their dart throw.
     *calls the dartVaderDartThrow() method
     *to simulate Dart Vader's dart throw.
     *calls the displayGameEnd() method to display the results
     *of the game.
     */
    public void toStart()
    {

        int dt = setDartThrow();
        for(int i = 1; i <= dt; i++)
        {
            System.out.println("\n=======================================\nThrow: "+i+"\n=======================================\n");
            char choice = toPlay();
            if (Character.toUpperCase(choice) == 'Y')
            {
                playerDartThrow();
                dartVaderDartThrow();
            }
            else
            {
                System.out.println(("You have chosen to abandon "));
                i = dt+1;
            }

        }
        displayGameEnd();
    }

}
