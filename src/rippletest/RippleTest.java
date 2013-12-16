package rippletest;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Aaron
 */

public class RippleTest extends BasicGame {
    
    private static final int SCREEN_X = 1600, SCREEN_Y = 900;
    private static final boolean FULLSCREEN_FLAG = false;

    private static final int DOT_SPACING = 20, DOT_SIZE = 2;
    
    private List<Dot> dots = new LinkedList<>();
    private List<Ripple> ripples = new LinkedList<>();
    
    @Override
    public void init(GameContainer gc) throws SlickException {
        int offsetX = 4, offsetY = 4;
        for(int y = DOT_SIZE + offsetY; y < SCREEN_Y - DOT_SIZE; y += DOT_SPACING) {
            for(int x = DOT_SIZE + offsetX; x < SCREEN_X - DOT_SIZE; x += DOT_SPACING) {
                dots.add(new Dot(x, y, DOT_SIZE));
            }
        }
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        Input input = gc.getInput();
        
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            int mouseX = input.getMouseX(), mouseY = input.getMouseY();
            ripples.add(new Ripple(mouseX, mouseY, (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        }
        
        for(Ripple ripple : ripples) ripple.update();
        for(Dot dot : dots) dot.update(ripples);
        
        if(input.isKeyDown(Input.KEY_ESCAPE)) gc.exit();
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        for(Dot dot : dots) dot.draw();
        //for(Ripple ripple : ripples) ripple.draw();
    }
        
    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new RippleTest());
            app.setTargetFrameRate(60);
            app.setShowFPS(false);
            app.setDisplayMode(SCREEN_X, SCREEN_Y, FULLSCREEN_FLAG);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
    public RippleTest() {
        super("RippleTest");
    }
}
