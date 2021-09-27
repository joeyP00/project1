import mayflower.*;

public class Cat extends MovableAnimatedActor
{
    private Animation walk;
    private Animation idle;
    private Animation idleLeft;
    private Animation walkLeft;
    private Animation fallLeft;
    private Animation fallRight;
    private Animation jumpLeft;
    private Animation jumpRight;
    
    private boolean levelOneComplete;
    private boolean levelTwoComplete;
    private boolean levelThreeComplete;
    
    private int score;
    private int health;

    public Cat() 
    {
        levelOneComplete = false;
        levelTwoComplete = false;
        levelThreeComplete = false;
        score = 0;
        health = 3;
        
        String[] images = new String[10];
        for(int i=0; i<10; i++)
        {
            images[i] = "img/cat/Walk ("+(i+1)+").png";
        }
        walk = new Animation(50, images);
        walk.scale(100,87);
        walk.setBounds(18, 5, 54, 80);
        setWalkRightAnimation(walk);

        walkLeft = new Animation(50, images);
        walkLeft.mirrorHorizontally();
        walkLeft.scale(100,87);
        walkLeft.setBounds(28, 5, 54, 80); 
        setWalkLeftAnimation(walkLeft);

        String[] idleImages = new String[10];
        for(int j = 0; j < 10; j++)
        {
            idleImages[j] = "img/cat/Idle ("+(j+1)+").png";
        }

        idle = new Animation(50, idleImages);
        idle.scale(100,87);
        setIdleAnimation(idle);
        idle.setBounds(18, 5, 54, 80);
        setIdleAnimation(idle);

        idleLeft = new Animation(50, idleImages);
        idleLeft.mirrorHorizontally();
        idleLeft.scale(100,87);
        idleLeft.setBounds(28, 5, 54, 80);
        setidleLeftAnimation(idleLeft);

        String[] fallImages = new String[8];
        for(int x = 0; x < 8; x++)
        {
            fallImages[x] = "img/cat/Fall ("+(x+1)+").png";
        }
        fallRight = new Animation(50, fallImages);
        setFallRightAnimation(fallRight);
        fallRight.scale(100,87);
        fallRight.setBounds(18,5,54,80);

        fallLeft = new Animation(50, fallImages);
        fallLeft.mirrorHorizontally();
        fallLeft.scale(100,87);
        fallLeft.setBounds(30, 5, 54, 80);
        setFallLeftAnimation(fallLeft);
        
        setClimbLeftAnimation(fallLeft);
        setClimbRightAnimation(fallRight);
        

        String[] jumpImages = new String[8];
        for(int y = 0; y < 8; y++)
        {
            jumpImages[y] = "img/cat/Jump ("+(y+1)+").png";
        }
        jumpRight = new Animation(50, jumpImages);
        setJumpRightAnimation(jumpRight);
        jumpRight.scale(100,87);
        jumpRight.setBounds(18,5,54,80);

        jumpLeft = new Animation(50, jumpImages);
        jumpLeft.mirrorHorizontally();
        jumpLeft.scale(100,87);
        jumpLeft.setBounds(30, 5, 54, 80);
        setJumpLeftAnimation(jumpLeft);
    }
    
    public boolean getLevelOne()
    {
        return levelOneComplete;
    }
    
    public void checkLevelOne()
    {
        if(this.isTouching(Sign.class))
        {
            levelOneComplete=true;
        }
    }
    
    public boolean getLevelTwo()
    {
        return levelTwoComplete;
    }
    
    public void checkLevelTwo()
    {
        if(this.isTouching(Sign.class))
        {
            levelTwoComplete=true;
        }
    }
    
    public boolean getLevelThree()
    {
        return levelThreeComplete;
    }
    
    public void checkLevelThree()
    {
        if(this.isTouching(Sign.class))
        {
            levelThreeComplete=true;
        }
    }
    
    public void increaseScore(int amount) {
        score += amount;
        updateText();
    }
    
    public void loseLife(int amount) {
        health -= amount;
        updateText();
        
        if (health == 0) {
            World w = getWorld();
            w.removeObject(this);
            Mayflower.setWorld(new GameOverLoserScreen());
        }
    }
    
    public int getScore() {
        return score;
    }
    
    public int getHealth() {
        return health;
    }
    
    private void updateText() {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Health: " + health, 10, 30, Color.BLACK);
    }
    
    public void act()
    {
        checkLevelOne();
        checkLevelTwo();
        checkLevelThree();
        super.act();
    }
 
}
