import greenfoot.*;
import greenfoot.graphics.*;

public class ImageScroller extends GreenfootImage {

    private GreenfootImage image;
    private int scrollX;
    private int scrollY;

    public ImageScroller(String imagePath) {
        super(imagePath);
        image = new GreenfootImage(imagePath);
        scrollX = 0;
        scrollY = 0;
    }

    public void scroll(int x, int y) {
        scrollX += x;
        scrollY += y;
    }

    public void draw(GreenfootGraphics g) {
        g.drawImage(image, scrollX, scrollY);
    }
}

