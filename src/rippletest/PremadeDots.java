/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rippletest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Aaron
 */
public class PremadeDots {
    private static final int MAX_RADIUS = 100;
    
    private static Image[] dots = new Image[MAX_RADIUS+1];
    
    static {
        for(Image img : dots) img = null;
    }
    
    public static Image getDot(int radius) {
        if(radius > MAX_RADIUS) radius = MAX_RADIUS;
        if(dots[radius] == null) {
            int length = 2*radius + 1;
            try {
                dots[radius] = new Image(length,length);
                Graphics dotGraph = dots[radius].getGraphics();
                dotGraph.setColor(Color.white);
                dotGraph.fillRect(0, 0, length, length);
                dotGraph.flush();
            } catch (SlickException ex) {
                Logger.getLogger(Dot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dots[radius];
    }
}
