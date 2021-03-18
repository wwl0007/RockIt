import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Class to create tiles that are used in the game.
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class Tile extends Actor
{
    // Fields for the tile class.
    public int x;
    public int y;
    public int realX;
    public int realY;
    public int index;
    public String type;
    /**
     * Constructor method for the Tile class.
     * @param img - image of tile being created.
     * @param tileType - type of tile being created.
     */
    public Tile(String img, String tileType) {
        setImage(new GreenfootImage(img));
        type = tileType;
    }
    /**
     * Act method for the Tile class.
     */
    public void act() 
    {
        
    }
    /**
     * Method to change the image of a tile.
     * @param img - new image to be used for the tile.
     */
    public void changeImage(String img) {
        setImage(new GreenfootImage(img));
    }
}
