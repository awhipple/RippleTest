/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rippletest;

import org.newdawn.slick.Image;

/**
 *
 * @author Aaron
 */
public class Ripple {
    private VisualState state;
    private int x, y, radius, speed;
    private float rad;
    private Image img;
   
    public Ripple(int x, int y) {
        state = new VisualState(20, 0, 0, 255);
        this.x = x;
        this.y = y;
        rad = 1;
        radius = (int)rad;
        speed = 250;
    }
    
    public Ripple(int x, int y, int r, int g, int b) {
        state = new VisualState(20, r, g, b);
        this.x = x;
        this.y = y;
        rad = 1;
        radius = (int)rad;
        speed = 250;
    }
    
    public void update() {
        rad += speed * (1f/60f);
        radius = (int)rad;
    }
    
    public void draw() {
        img = PremadeDots.getDot(radius);
        img.draw(x-radius,y-radius);
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
    public int getRadius(){return radius;}
    public VisualState getState() {return state;}
    
    public int distFromPerimeter(int x, int y) {
        int distX = this.x - x,
            distY = this.y - y,
            distCenter = (int)Math.sqrt(distX*distX + distY*distY),
            distPerimeter = Math.abs(distCenter - radius);
        return distPerimeter;
    }
}
