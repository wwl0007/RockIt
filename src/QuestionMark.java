import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class to provide an image for users to understand the game if they hover over a QuestionMark object.
 * This understanding is provided by a pop-up guide.
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class QuestionMark extends Actor
{
    // Field for the QuestionMark class.
    public GreenfootImage image = new GreenfootImage("question.png");
    /**
     * Constructor for the QuestionMark class.
     */
    public QuestionMark() {
        setImage(image);
    }
    /**
     * Act method for the QuestionMark class.
     * Display an interactive guide to help players if the mouse hovers over a QuestionMark object.
     */
    public void act() 
    {
        if (Greenfoot.mouseMoved(this)) {
            MyWorld.help.helpImage.setTransparency(255);
            MyWorld.player.stopped = true;
            MyWorld.enemy.stopped = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            MyWorld.help.helpImage.setTransparency(0);
            MyWorld.player.stopped = false;
            MyWorld.enemy.stopped = false;
        }
    }    
}
