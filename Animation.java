import mayflower.*;
/**
 * Write a description of class Animation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animation
{
    private MayflowerImage[] frames;
    private int currentFrame;
    private int frameRate;
    public Animation(int rate, String[] images)
    {
        frames = new MayflowerImage[images.length];
        for(int i=0; i<images.length; i++)
        {
            frames[i] = new MayflowerImage(images[i]);
        }
        currentFrame = 0;
        frameRate = rate;
    }

    public int getFrameRate()
    {
        return frameRate;
    }

    public void scale(int w, int h)
    {
        for(int i = 0; i<frames.length; i++)
        {
            frames[i].scale(w,h);
        }
    }

    public void setTransparency(int percent)
    {
        for(int i = 0; i<frames.length; i++)
        {
            frames[i].setTransparency(percent);
        }
    }

    public void setBounds(int x, int y, int w, int h)
    {
        for(int i = 0; i<frames.length; i++)
        {
            frames[i].crop(x, y, w, h);
        }
    }

    public MayflowerImage getNextFrame()
    {
        if(currentFrame==frames.length)
        {
            currentFrame = 0;
        }
        MayflowerImage frame = frames[currentFrame];
        currentFrame++;
        return frame;
    }

    public void mirrorHorizontally()
    {
        for(int i = 0; i<frames.length; i++)
        {
            frames[i].mirrorHorizontally();
        }
    }
}
