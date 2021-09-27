import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idle;
    private Animation fallLeft;
    private Animation fallRight;
    private Animation jumpRight;
    private Animation jumpLeft;
    private Animation climbLeft;
    private Animation climbRight;
    private Animation idleL;
    private String currentAction;
    private String lastCurrentAction;
    private String direction;
    private boolean isJumping = false;
    private boolean isFalling;
    private int maxJumpHeight;
    private Timer jumpTime;

    public MovableAnimatedActor()
    {
        walkRight = null;
        idle = null;
        currentAction = null;
        lastCurrentAction = "";
        direction = "right";
        maxJumpHeight = 20;
        jumpTime = new Timer(20);
    }

    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }

    public void setFallRightAnimation(Animation ani)
    {
        fallRight = ani;
    }

    public void setidleLeftAnimation(Animation ani)
    {
        idleL=ani;
    }

    public void setFallLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }

    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
    }

    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft = ani;
    }

    public void setIdleAnimation(Animation ani)
    {
        idle = ani;
    }

    public void setJumpLeftAnimation(Animation ani)
    {
        jumpLeft = ani;
    }

    public void setJumpRightAnimation(Animation ani)
    {
        jumpRight = ani;
    }

    public void setClimbLeftAnimation(Animation ani)
    {
        climbLeft = ani;
    }

    public void setClimbRightAnimation(Animation ani)
    {
        climbRight = ani;
    }

    public String getCurrentAction()
    {
        return currentAction;
    }

    public boolean isCurrentAction(String action)
    {
        if(action.equals(currentAction))
        {
            return true;
        } else {
            return false;
        }
    }

    public boolean wasCurrentAction(String action)
    {
        if(action.equals(lastCurrentAction))
        {
            return true;
        }
        return false;
    }

    public void act()
    {
        lastCurrentAction = currentAction;

        String newAction = null;
        if(currentAction == null) {
            newAction = "idle";
        }

        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        int top = y+(h/2);
        int bottom = y-(h/2);
        int left = x+(w/2);
        int right = x-(w/2);
        int worldX = 800;
        int worldY = 600;

        if(isTouching(Vine.class))
        {
            if( Mayflower.isKeyDown(Keyboard.KEY_UP))
            {
                setLocation(getX(), getY()+1);
            }
            if( Mayflower.isKeyDown(Keyboard.KEY_DOWN))
            {
                setLocation(getX(), getY()-1);
            }
            if(direction.equals("left"))
            {
                newAction = "climbLeft";
            }
            else
            {
                newAction = "climbRight";
            }
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x < 800 - h) {
            direction = "right";
            setLocation(x + 1, y);
            newAction = "walkRight";
            if(isBlocked()) {
                setLocation(x-1, y);
            }
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            direction = "left";
            setLocation(x - 1,y);
            newAction = "walkLeft";
            if(isBlocked()) {
                setLocation(x+1, y);
            }
        } else if (Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0 && !isJumping) {
            isJumping = true;
            if(getY() - 25 > maxJumpHeight) {
                setLocation(getX(), getY() - 25);
            }
            

        }
        else
        {
            newAction = "idle";
            if(direction.equals("left"))
            {
                newAction = "idleLeft";
            }
        }

        if(isCurrentAction("walkLeft") && !wasCurrentAction("walkLeft"))
        {
            setLocation(x-1, y);
        }

        if(!isCurrentAction("walkLeft") && wasCurrentAction("walkLeft"))
        {
            setLocation(x+1, y);
        }

        if(this.isFalling()) {
            newAction = "fallRight";
            if(direction.equals("left")) {
                newAction = "fallLeft";
            }
        }

        if(newAction!=null && !newAction.equals(currentAction))
        {
            if(newAction.equals("idle"))
            {
                setAnimation(idle);
            }
            else if(newAction.equals("idleLeft"))
            {
                setAnimation(idleL);
            }
            else if(newAction.equals("walkLeft"))
            {
                setAnimation(walkLeft);
            }
            else if(newAction.equals("walkRight"))
            {
                setAnimation(walkRight);
            }
            else if(newAction.equals("fallRight"))
            {
                setAnimation(fallRight);
            }
            else if(newAction.equals("fallLeft"))
            {
                setAnimation(fallLeft);
            }
            else if(newAction.equals("climbLeft"))
            {
                setAnimation(climbLeft);
            }
            else if(newAction.equals("climbRight"))
            {
                setAnimation(climbRight);
            }
            currentAction = newAction;
        }

        super.act();
    }
}

