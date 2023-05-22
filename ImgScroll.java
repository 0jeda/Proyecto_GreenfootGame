import greenfoot.*;
/**
 * Write a description of class ImgScroller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImgScroll
{
    private World scrollWorld; // the world the background image scrolls in
    private GreenfootImage[][] scrollImages; // the drawing panels (background image broken down)
    private int scrollWidth, scrollHeight; // the dimensions of the scrolling area
    private int worldWidth, worldHeight; // the dimensions of the world window
    private int xScrAmt, yScrAmt; // the overall horizontal and vertical scrolled amounts
    
    /**
     * calls the main constructor of the class using the dimensions of the given image for
     * the dimensions of the scrolling area
     * 
     * @param scrWorld the world the given background image is to scroll in
     * @param scrImage the scrolling background image to be used in the given world
     */
    public ImgScroll(World scrWorld, GreenfootImage scrImage)
    {
        this(scrWorld, scrImage, scrImage.getWidth(), scrImage.getHeight());
    }
    
    /**
     * this main constructor sets field values and initial world background image
     * 
     * @param scrWorld the world the given background image is to scroll in
     * @param repImage the image that is tiled to create the scrolling background image of the given world
     * @param wide the horizontal dimension of the scrolling area
     * @param high the vertical dimension of the scrolling area
     */
    public ImgScroll(World scrWorld, GreenfootImage repImage, int wide, int high)
    {
        // the field values
        scrollWorld = scrWorld;
        worldWidth = scrWorld.getWidth();
        worldHeight = scrWorld.getHeight();
        scrollWidth = wide;
        scrollHeight = high;
        // the scrolling image
        if (repImage == null) repImage = scrWorld.getBackground();
        GreenfootImage scrImage = new GreenfootImage(wide, high);
        scrImage.setColor(Color.WHITE);
        scrImage.fill(); // ensures no transparent pixels in background
        for (int i=0; i<wide; i+=repImage.getWidth())
            for (int j=0; j<high; j+=repImage.getHeight())
                scrImage.drawImage(repImage, i, j);
        // the drawing panels (to help reduce lag by reducing the number of pixels drawn when scrolling)
        int x = 1+scrollWidth/worldWidth; // number of panels across
        int y = 1+scrollHeight/worldHeight; // number of panels down
        scrollImages = new GreenfootImage[y][x]; // creates the array
        for (int j=0; j<y; j++) for (int i=0; i<x; i++) // fills the array
        {
            scrollImages[j][i] = new GreenfootImage(worldWidth, worldHeight);
            scrollImages[j][i].drawImage(scrImage, -i*worldWidth, -j*worldHeight);
        }
        scrollBackground(); // sets initial world background image
    }
    
    /** sets the world background image determined by the current scroll values */
    private void scrollBackground()
    {
        int x = (-xScrAmt)/worldWidth; // panel x index
        int y = (-yScrAmt)/worldHeight; // panel y index
        int dx = -((-xScrAmt)%worldWidth); // drawing x offset
        int dy = -((-yScrAmt)%worldHeight); // drawing y offset
        GreenfootImage bg = scrollWorld.getBackground(); // gets local reference to world background
        bg.drawImage(scrollImages[y][x], dx, dy); // draw top-left image
        if (dx != 0) // draw top-right image if needed
            bg.drawImage(scrollImages[y][x+1], dx+worldWidth, dy);
        if (dy != 0) // draw bottom-left image if needed
            bg.drawImage(scrollImages[y+1][x], dx, dy+worldHeight);
        if (dx != 0 && dy != 0) // draw bottom-right image if needed
            bg.drawImage(scrollImages[y+1][x+1], dx+worldWidth, dy+worldHeight);
    }
    
    /** 
     * performs limited scrolling using the given changes in scroll values
     * 
     * @param dx the amount to scroll horizontally (positive values scroll left moving view toward the right)
     * @param dy the amount to scroll vertically (positive values scroll up moving view toward the bottom)
     */
    public void scroll(int dx, int dy)
    {
        // limit change values
        if (dx > 0 && xScrAmt+dx > 0) dx = -xScrAmt;
        if (dx < 0 && xScrAmt+dx <= worldWidth-scrollWidth)
            dx = (worldWidth-scrollWidth)-xScrAmt;
        if (dy > 0 && yScrAmt+dy > 0) dy = -yScrAmt;
        if (dy < 0 && yScrAmt+dy <= worldHeight-scrollHeight)
            dy = (worldHeight-scrollHeight)-yScrAmt;
        // change scrolling values
        xScrAmt += dx;
        yScrAmt += dy;
        // update world background
        scrollBackground();
        // keep actors in place with relation to background image
        for (Object obj : scrollWorld.getObjects(null))
        {
            Actor actor = (Actor) obj;
            actor.setLocation(actor.getX()+dx, actor.getY()+dy);
        }
    }
    
    /** returns the overall amount scrolled horizontally */
    public int getScrolledX()
    {
        return xScrAmt;
    }
    
    /** returns the overall amount scrolled vertically */
    public int getScrolledY()
    {
        return yScrAmt;
    }
    
    /** returns the width of the scrolling area */
    public int getScrollWidth()
    {
        return scrollWidth;
    }
    
    /** returns the height of the scrolling area */
    public int getScrollHeight()
    {
        return scrollHeight;
    }
}
