import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Class to display a label on the screen while the program is running.
 *
 * @author War Eagle Studios 
 * @version 11/19/2020
 */
public class Label extends Actor
{
    // Fields for the Label class.
    private String value;
    private int fontSize;
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private static final Color transparent = new Color(0,0,0,0);
    /**
     * Constructor method to create a label and initialize it based on input values.
     * @param value - integer value input for label.
     * @param fontSize - font size input for label.
     */
    public Label(int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
    }
    /**
     * Additional Constructor Method for the Label class.
     * @param value - value input for String being used in label.
     * @param fontSize - font size input for the label.
     */
    public Label(String value, int fontSize)
    {
        this.value = value;
        this.fontSize = fontSize;
        updateImage();
    }
    /**
     * Method to set the value of the String object used for a label.
     * @param value - text input for the string displayed by a label.
     */
    public void setValue(String value)
    {
        this.value = value;
        updateImage();
    }
    /**
     * Method to set int value used in a label.
     * @param value - input for the integer used in a label string.
     */
    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();
    }
    /**
     * Method to set the color of the text used in a label.
     * @param lineColor - color input for the text.
     */
    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();
    }
    /**
     * Method to set the fill color of the text used in a label.
     * @param fillColor - color input for the fill color used in the text.
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();
    }
    /**
     * Method to update the label image based on new parameter input from other methods.
     */
    private void updateImage()
    {
        setImage(new GreenfootImage(value, fontSize, fillColor, transparent, lineColor));
    }
}