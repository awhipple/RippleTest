/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rippletest;

import java.util.List;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return new Color(red, green, blue);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void setColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public VisualState transitionTo(List<TransitionElement> teList) {
        /*TransitionElement te = teList.remove(0);
        int radius = transInt(this.radius, te.state.getRadius(), te.alpha),
            red = transInt(this.red, te.state.getRed(), te.alpha),
            green = transInt(this.green, te.state.getGreen(), te.alpha),
            blue = transInt(this.blue, te.state.getBlue(), te.alpha);
        return new VisualState(radius, red, green, blue);*/
        
        float alphaTotal = 0, orig = 0;
        for(TransitionElement te : teList) alphaTotal += te.alpha;
        if(alphaTotal >= 1) {
            for(TransitionElement te : teList) te.alpha /= alphaTotal;
        } else {
            orig = 1-alphaTotal;
        }
        
        float radius = (float)this.radius*orig,
              red = (float)this.red*orig,
              green = (float)this.green*orig,
              blue = (float)this.blue*orig;
        
        for(TransitionElement te : teList) {
            radius += (float)te.state.radius*te.alpha;
            red += (float)te.state.red*te.alpha;
            green += (float)te.state.green*te.alpha;
            blue += (float)te.state.blue*te.alpha;
        }
        
        return new VisualState((int)radius, (int)red, (int)green, (int)blue);
    }

    public static int transInt(int first, int second, float alpha) {
        int diff = second - first;
        return first + (int) (diff * alpha);
    }
}
