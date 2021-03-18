import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class to created buttons for the menu pages.
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class Button extends Actor
{
    // Fields for the Button class.
    public GreenfootImage image;
    public boolean clicked = false;
    /**
     * Constructor method for the Button class.
     * @param imageName - image input for the button class.
     */
    public Button(String imageName) {
        image = new GreenfootImage(imageName);
        setImage(image);
    }
    /**
     * Act method for the Button class.
     * Sets the value of clicked to true if the mouse is clicked.
     */
    public void act() 
    {
        clicked = Greenfoot.mouseClicked(this);
    }
}
