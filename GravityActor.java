import mayflower.*;

public class GravityActor extends Actor
{
    
    public GravityActor()
    {

    }
    
    public boolean isFalling()
    {
        boolean ret;
        setLocation(getX(), getY() + 1);
        ret = isTouching(Block.class);
        setLocation(getX(), getY() - 1);
        return !ret;
    }

    public boolean isBlocked()
    {
        if(isTouching(Block.class))
        {
            return true;
        }
        return false;
    }
    
    public void act()
    {
        setLocation(getX(), getY()+1);
        boolean landed = this.isBlocked();
        if(landed)
        {
            setLocation(getX(), getY()-1);
            landed = false;
        }
       
        
        // if ( Mayflower.isKeyDown(Keyboard.KEY_UP) && getY() > 0) {
          
            // /*jumpTime = new Timer(8);
            // while(!jumpTime.isDone()) {
                // setLocation(x, y+10);
            // }
            // */
            
            // // do {
                // // setLocation(x, y - 1);
                // // seconds++;
            // // } while(seconds > 100);
            

            // // int currentVertical = this.getX();
            // // while(this.getX() <= currentVertical + maxJumpHeight)
            // // {
                // // setLocation(x, y + 1);
            // // }
            // // while(this.getX() > currentVertical)
            // // {
                // // setLocation(x, y - 1);
            // // }

            // if(isBlocked()) {
                // setLocation(getX(), getY() + 1);
            // }
        // }
        // else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && getY()<600 - getWidth()) {
            
            // setLocation(getX(), getY() + 1);
            // if(isBlocked()) {
                // setLocation(getX(), getY() - 1);
            // }
        // }
    }
}
