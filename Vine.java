import mayflower.*;

public class Vine extends Actor
{
    private MayflowerImage image;
    public Vine() 
    {
        image = new MayflowerImage("img/Tiles/vine.png");
        image.scale(100,100);
        setImage(image);
        
    }

    public void act()
    {
       if(this.isTouching(Cat.class)) {
            Object a = this.getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            int prevX = c.getX();
            int prevY = c.getY();
            c.setLocation(prevX, prevY - 5);

        }
    }
}
