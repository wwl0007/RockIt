import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class to create an actor object that gives the player an increase in lives when touched..
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class FirstAidKit extends Actor
{
    /**
     * Act - do whatever the FirstAidKit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Fields for the FirstAidKit class.
    public int x;
    public int y;
    public int tileWorldX;
    public int tileWorldY;
    public int healAmount = 1;
    public boolean inChunk;
    public GreenfootImage image = new GreenfootImage("firstaid.png");
    /**
     * Constructor method for the FirstAidKit class.
     * @param xCoord - x coordinate location where the first aid kit will be inserted.
     * @param yCoord - y coordinate location where the first aid kit will be inserted.
     * @param tileX - integer value of the x coordinate where tile is located.
     * @param tileY - integer value of the y coordinate where tile is located.
     */
    public FirstAidKit(int xCoord, int yCoord, int tileX, int tileY) {
        x = xCoord;
        y = yCoord;
        tileWorldX = tileX;
        tileWorldY = tileY;
        setImage(image);
    }
    /**
     * Act method for the FirstAidKit class.
     * Makes first aid kit visibile if it is located on a tile.
     * Heals player if the player touches the first aid kit.
     * Removes itself from the world when a player touches it.
     */
    public void act() 
    {
        inChunk = tileWorldX == MyWorld.player.tileWorldX && tileWorldY == MyWorld.player.tileWorldY;
        if(inChunk) {
            image.setTransparency(255);
        } else {
            image.setTransparency(0);
        }
        if(MyWorld.player.tileWorldX == tileWorldX && MyWorld.player.tileWorldY == tileWorldY && MyWorld.player.x == x && MyWorld.player.y == y) {
            MyWorld.lives += healAmount;
            MyWorld.livesCounter.score += healAmount;
            MyWorld.livesCounter.update();
            ((MyWorld)getWorld()).removeObject(this);
        }
    }    
}
