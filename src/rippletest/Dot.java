/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rippletest;

import java.util.List;
import org.newdawn.slick.Image;

/**
 *
 * @author Aaron
 */
public class Dot {
    
    private VisualState state;
    private int x, y, drawX, drawY;
    private Image img;
    
    public Dot() {
        state = new VisualState(10,255,255,255);
        img = PremadeDots.getDot(state.getRadius());
        x = 100;
        y = 100;
    }
    
    public Dot(int x, int y, int radius) {
        state = new VisualState(radius, 255, 0, 0);
        img = PremadeDots.getDot(state.getRadius());
        this.x = x;
        this.y = y;
    }
    
    public void update(List<Ripple> ripples) {
        int radius = state.getRadius();
        drawX = x - radius;
        drawY = y - radius;
        
        for(Ripple ripple : ripples) {
            int distX = x - ripple.getX(),
                distY = y - ripple.getY(),
                ripRad = ripple.getRadius();
            if(distX * distX + distY * distY < ripRad*ripRad)
                state.setColor(0, 255, 0);
        }
    }
    
    public void draw() {
        img.draw(drawX, drawY, 1, state.getColor());
    }
}
