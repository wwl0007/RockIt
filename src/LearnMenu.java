import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of the world class designed to help users learn about three main types of rocks.
 * 
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class LearnMenu extends World
{
    // Fields for the LearnMenu class.
    public Button metamorphic = new Button("metamorphic.png");
    public Button sedimentary = new Button("sedimentary.png");
    public Button igneous = new Button("igneous.png");
    public Button exit = new Button("exit.png");
    public Label name = new Label("", 24);
    public Label desc = new Label("", 18);
    public Label learnLabel = new Label("Learn", 64);
    public String metamorphicDesc = "A metamorphic rock is a rock that\n is formed under the influence of \nheat, pressure, or fluids without undergoing a \nliquid phase. These rocks start out as a different\n type of rock, but geological processes \ncause them to become metamorphic rocks.";
    public String sedimentaryDesc = "A sedimentary rock is a rock that\n formed through the deposition and \nsolidification of sediment. This is especially \nthe case when sediment is transported by water,\n ice, and when during erosion. These rocks \nare often deposited in layers, often \ncontaining fossils.";
    public String igneousDesc = "An igneous rock is a rock formed \nby the cooling and solidifying of molten \nmaterials. Igneous rocks can form beneath \nthe Earth’s surface. They can also form at \nEarth’s surface when lava cools rapidly.";
    /**
     * Constructor method for the LearnMenu class.
     * 
     */
    public LearnMenu()
    {    
        super(500, 550, 1); 
        addObject(metamorphic, 60, 160);
        addObject(sedimentary, 60, 240);
        addObject(igneous, 60, 320);
        learnLabel.setFillColor(Color.GREEN);
        addObject(learnLabel, 250, 50);
        addObject(exit, 440, 60);
        name.setFillColor(Color.BLACK);
        name.setLineColor(null);
        desc.setFillColor(Color.BLACK);
        desc.setLineColor(null);
        addObject(name, 300, 150);
        addObject(desc, 300, 225);
    }
    /**
     * Act method for the LearnMenu class.
     * Text on screen will change based on which image is clicked.
     */
    public void act() {
        if(metamorphic.clicked) {
            name.setValue("Metamorphic");
            desc.setValue(metamorphicDesc);
        }
        if(sedimentary.clicked) {
            name.setValue("Sedimentary");
            desc.setValue(sedimentaryDesc);
        }
        if(igneous.clicked) {
            name.setValue("Igneous");
            desc.setValue(igneousDesc);
        }
        if(exit.clicked) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
