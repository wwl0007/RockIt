import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class that can be used to instantiate objects of a "Manbearpig", the main enemy in the game.
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class Manbearpig extends Actor
{
    // Fields for the Manbearpig class.
    public int x;
    public int y;
    public int tick = 0;
    public int realX = 475;
    public int realY = 475;
    public int tileWorldX = 0;
    public int tileWorldY = 0;
    public static int moveSpeed = 200;
    public GreenfootImage image = new GreenfootImage("manbearpig.png");
    public boolean inChunk;
    public int catchedTick;
    public boolean stopped = false;
    /**
     * Constructor method for the Manbearpig class.
     */
    public Manbearpig() {
        setImage(image);
        x = 9;
        y = 9;
    }
    /**
     * Act method for the Manbearpig class.
     * Follows the player object based on its location.
     * Ends the game if it contacts the player object.
     */
    public void act() 
    {
        inChunk = tileWorldX == MyWorld.player.tileWorldX && tileWorldY == MyWorld.player.tileWorldY;
        if(inChunk) {
            image.setTransparency(255);
        } else {
            image.setTransparency(0);
        }
        if(moveSpeed < 12) {
            moveSpeed = 12;
        }
        tick++;
        if(!stopped) {
            if(tick % moveSpeed == 0) {
                move();
            }
            /*if(tick % 1500 == 0) {
                if(moveSpeed > 10) {
                    moveSpeed -= 10;
                }
            }
            */
            if(MyWorld.player.tileWorldX == tileWorldX && MyWorld.player.tileWorldY == tileWorldY && MyWorld.player.x == x && MyWorld.player.y == y) {
                MyWorld.livesCounter.score -= 3;
                if(MyWorld.livesCounter.score <= 0) {
                    MyWorld.livesCounter.score = 0;
                    MyWorld.reset();
                    new GreenfootSound("Loser.wav").play();
                    MyWorld.livesCounter.update();
                    Greenfoot.setWorld(new MainMenu());
                } else {
                    catchedTick = tick;
                    moveSpeed = 100;
                    stopped = true;
                    MyWorld.livesCounter.update();
                }
            }
        } else {
            if(tick - catchedTick >= 5000) {
                stopped = false;
            }
        }
    }
    /**
     * Method to move the Manbearpig object.
     */
    public void move() {
        if(!inChunk) { // 0,1
            if(MyWorld.player.tileWorldX < tileWorldX) {
                left();
            } else if(MyWorld.player.tileWorldX > tileWorldX) {
                right();
            } else if(MyWorld.player.tileWorldY < tileWorldY) {
                down();
            } else if(MyWorld.player.tileWorldY > tileWorldY) {
                up();
            }
        } else {
            if(MyWorld.player.x < x) {
                left();
            } else if(MyWorld.player.x > x) {
                right();
            } else if(MyWorld.player.y < y) {
                up();
            } else if(MyWorld.player.y > y) {
                down();
            }
        }
    }
    /**
     * Method to move the Manbearpig object up.
     */
    public void up() {
        if(y != 0) {
            realY -= 50;
            y -= 1;
        } else {
            //((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord + 1);
            y = 9;
            realY = 475;
            tileWorldY++;
        }
        setLocation(realX, realY);
    }
    /**
     * Method to move the Manbearpig object down.
     */
    public void down() {
        if(y != 9) {
            realY += 50;
            y += 1;
        } else {
            //((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord - 1);
            y = 0;
            realY = 25;
            tileWorldY--;
        }
        setLocation(realX, realY);
    }
    /**
     * Method to move the Manbearpig object to the left.
     */
    public void left() {
        if(x != 0) {
            realX -= 50;
            x -= 1;
        } else {
            //((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord - 1, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord);
            x = 9;
            realX = 475;
            tileWorldX--;
        }
        setLocation(realX, realY);
    }
    /**
     * Method to move the Manbearpig object to the right.
     */
    public void right() {
        if(x != 9) {
            realX += 50;
            x += 1;
        } else {
            //((MyWorld)getWorld()).genChunk(MyWorld.chunkWorld.get(MyWorld.loadedChunk).xCoord + 1, MyWorld.chunkWorld.get(MyWorld.loadedChunk).yCoord);
            x = 0;
            realX = 25;
            tileWorldX++;
        }
        setLocation(realX, realY);
    }  
}
