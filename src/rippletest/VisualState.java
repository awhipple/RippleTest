/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rippletest;

import org.newdawn.slick.Color;

/**
 *
 * @author Aaron
 */
public class VisualState {
    private int radius, red, green, blue;
    
    public VisualState(int radius, int red, int green, int blue) {
        this.radius = radius;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    public int getRadius() { return radius;}
    public void setRadius(int radius) {this.radius = radius;}
    
    public Color getColor() {return new Color(red, green, blue);}
    public void setColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
