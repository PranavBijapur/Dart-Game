import java.util.Scanner;
/**
 * The Input class provides methods to accept input from the user.
 * It includes methods to accept doubles, integers, and strings from the console.
 * */
public class Input
{
    /**
     * Constructs a new instance of the Input class.
     * */
    public Input()
    {

    }

    Scanner console = new Scanner(System.in);

    /**
     * Accepts a double from the console.
     *
     * @param displayMessage a message to display to the user.
     * @return a double entered by the user.
     * */
    public double acceptDouble(String displayMessage)
    {
        System.out.println(displayMessage);
        double input = console.nextDouble();
        return input;
    }


    /**
     * Accepts an integer from the console.
     *
     * @param displayMessage a message to display to the user.
     * @return an integer entered by the user.
     * */
    public int acceptInteger(String displayMessage)
    {
        System.out.println(displayMessage);
        int input = console.nextInt();
        return input;
    }


    /**
     * Accepts a string from the console.
     *
     *@param displayMessage a message to display to the user.
     *@return a string entered by the user.
     * */
    public String accpetString(String displayMessage)
    {
        System.out.println(displayMessage);
        String input = console.nextLine();
        return input;
    }

}
