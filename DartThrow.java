import java.util.*;
/**
 * The DartThrow class represents a dart throw in a game of darts. It contains a method to generate a random number representing where the dart lands on the dartboard.
 * */
public class DartThrow
{

    /**
     * Constructs a new instance of the DartThrow class.
     * */
    public DartThrow()
    {

    }

    /**
     *  Generates a random number representing where the dart lands on the dartboard.
     *
     * @param max the maximum value of the range of possible numbers.
     * @param min the minimum value of the range of possible numbers.
     * @return a double representing the random number where the dart lands on the dartboard.
     * */
    public double dartLandsOnBoard(int max ,int min)
    {
        double randomNum = Math.floor(Math.random() * (max - min + 1) + min);
        return randomNum;
    }


}
