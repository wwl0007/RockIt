import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class to create a guide to help users understand the game when they hover over an object..
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class PlayerHelp extends Actor
{
    // Field for the PlayerHelp class.
    public GreenfootImage helpImage = new GreenfootImage("help.png");
    /**
     * Constructor method for the PlayerHelp class.
     */
    public PlayerHelp() {
        setImage(helpImage);
        helpImage.setTransparency(0);
    }
    /**
     * Act method for the PlayerHelp class.
     */
    public void act() 
    {    
    }    
}
