import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * A 10x10 grid of tiles designed for this game.
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class TileWorld
{
    // Fields for the TileWorld class.
    public ArrayList<Tile> chunk = new ArrayList<Tile>();
    public int xCoord;
    public int yCoord;
    public int id;
    public static String[] weightString = {"grass", "metamorphic", "sedimentary", "igneous", "poisonous", "teleporter"};
    public static int[] weights = {4000, Greenfoot.getRandomNumber(50) + 21, Greenfoot.getRandomNumber(50) + 21, Greenfoot.getRandomNumber(50) + 21, Greenfoot.getRandomNumber(5) + 6, Greenfoot.getRandomNumber(3) + 1};
    /**
     * Constructor for the TileWorld class.
     * @param x - x coordinate of tile.
     * @param y - y coordinate of tile.
     */
    public TileWorld(int x, int y) {
        xCoord = x;
        yCoord = y;
    }
    /**
     * Act method for the TileWorld class.
     */
    public void act() 
    {
        
    }
    /**
     * Method to set the weights for tiles.
     * @param arr - array input for an integer array holding tile weights.
     */
    public void setWeights(int[] arr) {
        weights = arr;
    }
    /**
     * Method to generate a world made of tiles using iteration.
     */
    public void genWorld() {
        int index = 0;
        int roll = 0;
        for(int i = 25; i <= 500; i += 50) {
            for(int j = 25; j <= 500; j += 50) {
                roll = getRoll();
                if(roll == 0) {
                    chunk.add(new Tile("grass" + Greenfoot.getRandomNumber(5) + ".png", "grass"));
                } else {
                    chunk.add(new Tile(weightString[roll] + ".png", weightString[roll]));
                }
                chunk.get(index).realX = i;
                chunk.get(index).realY = j;
                chunk.get(index).x = (i-25)/50;
                chunk.get(index).y = (j-25)/50;
                chunk.get(index).index = i;
                index++;
            }
        }
    }
    /**
     * Method to change the tile at a certain location.
     * @param x - x coordinate of tile being changed.
     * @param y - y coordinate of tile being changed.
     * @param newTile - new tile object being inserted.
     */
    public void changeTile(int x, int y, Tile newTile) {
        chunk.set(y + x * 10, newTile);
    }
    /**
     * Method to get the roll of a tile based on weights.
     */
    public int getRoll() {
        /*
        int total = 0;
        for(int i : weights) {
            total += i;
        }
        int roll = Greenfoot.getRandomNumber(total);
        if(roll < weights[0]) {
            return 0;
        } else if(roll < weights[0] + weights[1]) {
            return 1;
        } else if(roll < weights[0] + weights[1] + weights[2]){
            return 2;
        } else if(roll < weights[0] + weights[1] + weights[2] + weights[3]){
            return 3;
        } else {
            return 4;
        }
        */
        int total = 0;
        ArrayList<Integer> minMax = new ArrayList<Integer>();
        minMax.add(0);
        for(int i : weights) {
            total += i;
        }
        for (int i = 1, j = 0; j < weights.length; i++) {
            if (i % 2 == 1)
            {
                minMax.add(weights[j] + minMax.get(i - 1) - 1);
                j++;
            } else {
                minMax.add(minMax.get(i - 1) + 1);
            }
        }
        int roll = Greenfoot.getRandomNumber(minMax.get(minMax.size() - 1) + 2);
        for(int i = 0; i < minMax.size(); i++) {
            if(i == minMax.size() - 1) {
                return weights.length - 1;
            }
            if(roll >= minMax.get(i) && roll <= minMax.get(i + 1)) {
                return i/2;
            }
        }
        return -1;
      }
}
