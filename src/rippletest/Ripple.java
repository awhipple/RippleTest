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
    private int x, y, radius, speed;
    private float rad;
    private Image img;
    
    public Ripple() {
        x = 100;
        y = 100;
        rad = 1;
        radius = 1;
        img = PremadeDots.getDot(radius);
    }
    
    public Ripple(int x, int y) {
        this.x = x;
        this.y = y;
        rad = 1;
        radius = 1;
        speed = 100;
        img = PremadeDots.getDot(radius);
    }
    
    public void update() {
        rad += speed * (1f/60f);
        radius = (int)rad;
        img = PremadeDots.getDot(radius);
    }
    
    public void draw() {
        img.draw(x-radius,y-radius);
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
    public int getRadius(){return (int)rad;}
}
