/**
 *The Player class represents a player in the dart game.
 *It contains the name and cumulative score of the player.
 */
public class Player
{
    private String name;
    private int cumScore;

    /**
     * Constructs a new Player object with default values for name and cumulative score.
     * */
    public Player()
    {
        name = "unknown";
        cumScore = 0;
    }
    /**
     * Constructs a new Player object with the specified name and cumulative score.
     * @param name the name of the player.
     * @param cumScore the cumulative score of the player.*/
    public Player(String name, int cumScore)
    {
        this.name = name;
        this.cumScore = cumScore;
    }

    /***
     * Returns the name of the player.
     * @return the name of the player.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns the cumulative score of the player.
     * @return the cumulative score of the player.
     * */

    public int getScore()
    {
        return this.cumScore;
    }

    /**
     * Sets the name of the player.
     * @param name the new name of the player.
     * */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets the cumulative score of the player.
     * @param cumScore the new cumulative score of the player.
     * */
    public void setScore(int cumScore)
    {
        this.cumScore = cumScore;
    }

    /**
     * Returns a string representation of the Player object.
     * @return a string representation of the Player object.
     * */
    public String toString()
    {
        return "Player:\n" + "Name:" + name + "\nCumulative Score:" + cumScore;
    }


}
