import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Class to create an interactive scoreboard for users.
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class Score extends Actor
{
    // Fields for the Score class.
    public String text;
    public int score;
    public String displayText;
    /**
     * Act method for the Score class.
     */
    public void act() 
    {
        
    } 
    /**
     * Constructor method for the Score class.
     * @param display - text to be displayed on scoreboard.
     * @param scoreNum - score number to be displayed on scoreboard.
     */
    public Score(String display, int scoreNum) {
        displayText = display;
        score = scoreNum;
        GreenfootImage textDisp = new GreenfootImage(displayText + scoreNum, 20, greenfoot.Color.BLACK, new Color(0, 0, 0, 0));
        setImage(textDisp);
        text = displayText + score;
    }
    /**
     * Method to update scoreboard.
     * Scoreboard updates based on rocks that are collected.
     * Scoreboard can change based on the score displayed and the amount of lives a user has left.
     */
    public void update() {
        text =  displayText + score;
        if(displayText == "Rocks: ") {
            text += "/20";
        }
        GreenfootImage textDisp = new GreenfootImage(text, 20, null, null);
        setImage(textDisp);
        if (score == 20 && displayText == "Rocks: ") {
            new GreenfootSound("Winner.wav").play();
            MyWorld.reset();
            Greenfoot.setWorld(new MainMenu());
            Greenfoot.stop();
        }
        if (score < 0) {
            score = 0;
        }
        if(score <= 0 && displayText == "Lives: ") {
            MyWorld.reset();
            new GreenfootSound("Loser.wav").play();
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
