import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Class for the player character that is controlled by the user.
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class Player extends Actor
{
    // Fields for the player class.
    public int x;
    public int y;
    public int realX;
    public int realY;
    public int tileWorldX;
    public int tileWorldY;
    public String key;
    public Boolean isSetting = false;
    public Boolean inMenu = false;
    public Boolean stopped = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /**
     * Act method for the player class.
     * Calls the checkMove method if a key is pressed.
     */
    public void act() 
    {
        // attempted input lag optimization
        key = Greenfoot.getKey();
        if(key != null && !stopped) {
            checkMove();
        }
    }    
    /**
     * Constructor method for the Player class.
     */
    public Player() {
        setImage(new GreenfootImage("player.png"));
    }
    /**
     * Method that allows user to control movement of a Player object.
     * Pressing the 'w' key moves the player up.
     * Pressing the 'a' key moves the player to the left.
     * Pressing the 'd' key moves the player to the right.
     * Pressing the 's' key moves the player down.
     * Pressing the 'e' key collects an object and affects the score/lives count as appropriate.
     * If a Player object contacts the teleporter tile, the Player object is transported back to the location with coordinates (0,0).
     */
    public void checkMove() {
      //check for singular movements from keyboard
        if(!isSetting && !inMenu) {
            if("w".equals(key)) {
                if(y != 0) {
                    realY -= 50;
                    y -= 1;
                } else {
                    ((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord + 1);
                    y = 9;
                    realY = 475;
                    tileWorldY++;
                }
                setLocation(realX, realY);
            } else if("a".equals(key)) {
                if(x != 0) {
                    realX -= 50;
                    x -= 1;
                } else {
                    ((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord - 1, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord);
                    x = 9;
                    realX = 475;
                    tileWorldX--;
                }
                setLocation(realX, realY);
            } else if("s".equals(key)) {
                if(y != 9) {
                    realY += 50;
                    y += 1;
                } else {
                    ((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord - 1);
                    y = 0;
                    realY = 25;
                    tileWorldY--;
                }
                setLocation(realX, realY);
            } else if("d".equals(key)) {
                if(x != 9) {
                    realX += 50;
                    x += 1;
                } else {
                    ((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord + 1, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord);
                    x = 0;
                    realX = 25;
                    tileWorldX++;
                }
                setLocation(realX, realY);
            } else if("e".equals(key)) {
                Tile currTile = getCurrentTile();
                if(currTile.type == "metamorphic") {
                    currTile.setImage("grass" + Greenfoot.getRandomNumber(5) + ".png");
                    currTile.type = "grass";
                    if (MyWorld.desiredType == 0){
                        MyWorld.scoreBoard.score++;
                        //Manbearpig.moveSpeed = (int)((double)Manbearpig.moveSpeed * 0.90);
                        MyWorld.scoreBoard.update();
                    } else if (MyWorld.desiredType != 0){
                        MyWorld.scoreBoard.score--;
                        MyWorld.scoreBoard.update();
                    }
                } else if(currTile.type == "sedimentary") {
                    currTile.setImage("grass" + Greenfoot.getRandomNumber(5) + ".png");
                    currTile.type = "grass";
                    if (MyWorld.desiredType == 1){
                        MyWorld.scoreBoard.score++;
                        //Manbearpig.moveSpeed = (int)((double)Manbearpig.moveSpeed * 0.90);
                        MyWorld.scoreBoard.update();
                    } else if (MyWorld.desiredType != 1){
                        MyWorld.scoreBoard.score--;
                        MyWorld.scoreBoard.update();
                    }
                } else if(currTile.type == "igneous") {
                    currTile.setImage("grass" + Greenfoot.getRandomNumber(5) + ".png");
                    currTile.type = "grass";
                    if (MyWorld.desiredType == 2){
                        MyWorld.scoreBoard.score++;
                        //Manbearpig.moveSpeed = (int)((double)Manbearpig.moveSpeed * 0.90);
                        MyWorld.scoreBoard.update();
                    } else if (MyWorld.desiredType != 2){
                        MyWorld.scoreBoard.score--;
                        MyWorld.scoreBoard.update();
                    }
                }
                if (currTile.type == "poisonous") {
                    currTile.setImage("grass" + Greenfoot.getRandomNumber(5) + ".png");
                    currTile.type = "grass";
                    Manbearpig.moveSpeed = 100;
                    MyWorld.livesCounter.score -= 2;
                    MyWorld.scoreBoard.score /= 2;
                    MyWorld.livesCounter.update();
                    MyWorld.scoreBoard.update();
                }
                if(currTile.type == "teleporter") {
                    x = 0;
                    y = 0;
                    tileWorldX = 0;
                    tileWorldY = 0;
                    realX = 25;
                    realY = 25;
                    setLocation(25, 25);
                }
            } 
        }
    }
    /**
     * Method that returns the current tile the player is standing on.
     */
    public Tile getCurrentTile() {
        return MyWorld.chunkWorld.get(MyWorld.loadedChunk).chunk.get(MyWorld.getTile(x, y));
    }
}
