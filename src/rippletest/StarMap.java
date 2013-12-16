/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rippletest;

import java.util.LinkedList;
import java.util.Queue;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Aaron
 */
public class StarMap implements Actor{

    private Queue<Integer> starLoc;
    private Image starMap;
    private Graphics starMapGraphics;
    private Color backColor, starColor;
    private int mapWidth, mapHeight;
    private int scrollSpeed, curDelta;
    
    StarMap(int screenWidth, int screenHeight) throws SlickException {
        scrollSpeed = 30;
        curDelta = 0;
        
        mapWidth = screenWidth;
        mapHeight = screenHeight;
        
        starLoc = new LinkedList<>();
        
        for(int y = 0; y < screenHeight; y++) {
            starLoc.add(new Integer((int)(Math.random() * mapWidth)));
        }
        
        backColor = Color.black;
        starColor = Color.white;
        
        starMap = new Image(screenWidth, screenHeight);
                
        starMapGraphics = starMap.getGraphics();
        starMapGraphics.setColor(backColor);
        starMapGraphics.fillRect(0, 0, starMap.getWidth(), starMap.getWidth());
        starMapGraphics.flush();
        
        generateStars(starColor);
        starMapGraphics.flush();
    }
    
    @Override
    public void draw() {
        starMap.draw(0,0);
    }

    @Override
    public void update(Input input, int delta) {
        curDelta += delta;
        while (curDelta > scrollSpeed) {
            curDelta -= scrollSpeed;
            
            generateStars(backColor);
            starLoc.poll();
            starLoc.add(new Integer((int) (Math.random() * mapWidth)));
            generateStars(starColor);
            starMapGraphics.flush();
        }
    }

    private void generateStars(Color color) {
        starMapGraphics.setColor(color);
        int y = mapHeight;
        for (Integer nextLoc : starLoc) {
            starMapGraphics.fillRect(nextLoc, y, 1, 1);
            y--;
        }
    }
}
