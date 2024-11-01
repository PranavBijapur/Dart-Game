/**
 * The Validation class contains methods for validating various types of input.
 * */

public class Validation
{
    /**
     * Constructs a new Validation object.
     * */
    public Validation ()
    {

    }

    /**
     * Checks if the input is blank or not.
     * @param input the input string to be validated.
     * @return true if the input is not blank, false otherwise.
     * */
    public boolean isBlank(String input)
    {
        boolean flag = true;
        if(input.trim().length() == 0)
            flag = false;
        return flag;
    }

    /***
     *
     * Checks if the input string contains only alphabetic characters.
     * @param input the input string to be validated.
     * @return true if the input string contains only alphabetic characters, false otherwise.
     */
    public boolean stringIsAlphabetic(String input)
    {
        boolean flag = true;
        int len = input.trim().length();
        for(int i = 0 ; i < len ; i++)
        {
            if(Character.isDigit(input.charAt(i)))
            {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * Checks if the length of the input string is within a specified range.
     * @param input the input string to be validated.
     * @param min the minimum length of the input string.
     * @param max the maximum length of the input string.
     * @return true if the length of the input string is within the specified range, false otherwise.
     * */
    public boolean stringLengthInRange(String input , int min , int max)
    {
        boolean flag = false;
        int len = input.trim().length();
        if(len <= max && len >= min)
            flag = true;
        return flag;

    }

    /**
     * Checks if the input string is a valid integer between 1 and 5.
     *
     * @param input the input string to be validated.
     *
     * @return true if the input string is a valid integer between 1 and 5, false otherwise.
     * */
    public boolean stringValidInput(String input)
    {
        boolean flag = false;
        int i = Integer.parseInt(input);
        if (i >= 1 && i <= 5)
            flag = true;

        return flag;

    }
}
