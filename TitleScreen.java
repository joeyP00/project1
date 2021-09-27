import mayflower.*;

public class TitleScreen extends World
{
    public TitleScreen()
    {
        setBackground("img/BG/image.png");
        showText("Press the spacebar to start!", 50, 50, 50);
    }

    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE))
        {
            Mayflower.setWorld(new MyWorld());
        }
    }
}

