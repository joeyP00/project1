import mayflower.*;
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lava extends Actor
{
   
    public Lava()
    {
        setImage("img/BG/lava.jpg");
    }

    public void act() {        
        if(this.isTouching(Cat.class)) 
        {
            Object a = this.getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            int prevX = c.getX();
            int prevY = c.getY();
            c.loseLife(1);
            c.setLocation(prevX - 100, prevY - 20);

        }
    }
}
