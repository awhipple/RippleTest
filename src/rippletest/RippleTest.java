package rippletest;

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
    
    private static final int SCREEN_X = 1024, SCREEN_Y = 768;
    private static final boolean FULLSCREEN_FLAG = false;
            
    @Override
    public void init(GameContainer gc) throws SlickException {
       
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        Input input = gc.getInput();
                                
        if(input.isKeyDown(Input.KEY_ESCAPE)) gc.exit();
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        
    }
        
    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new RippleTest());
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
