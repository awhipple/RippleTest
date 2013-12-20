/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rippletest;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Image;

/**
 *
 * @author Aaron
 */
public class Dot {
    
    private VisualState state, drawState;
    private int x, y, drawX, drawY;
    private Image img;
    
    public Dot(int x, int y, int radius, int red, int green, int blue) {
        state = new VisualState(radius, red, green, blue);
        drawState = state;
        img = PremadeDots.getDot(state.getRadius());
        this.x = x;
        this.y = y;
    }
    
    public void update(List<Ripple> ripples) {
        List<TransitionElement> teList = new LinkedList<>();
        for(Ripple ripple : ripples) {
            int dist = ripple.distFromPerimeter(x,y);
            float alpha = dist < 200 ? (ripple.getAlpha() * (1 - (float)dist/200)) : 0;
            teList.add(new TransitionElement(ripple.getState(), alpha));
        }
        if(teList.size()>=1)drawState = state.transitionTo(teList);
        
        int radius = drawState.getRadius();
        drawX = x - radius;
        drawY = y - radius;
        img = PremadeDots.getDot(radius);
    }
    
    public void draw() {
        img.draw(drawX, drawY, 1, drawState.getColor());
    }
}
