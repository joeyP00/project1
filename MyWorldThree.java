import mayflower.*;

public class MyWorldThree extends World {
    private Cat cat;
    private Sign sign;
    private String[][] tiles;

    public MyWorldThree() 
    {
        //Mayflower.showBounds(true);
        setBackground("img/BG/BG.png");
        tiles = new String[6][8];
        addRandomObjects();

        buildWorld(tiles);
        showText("Score: " + cat.getScore() + " Health: " + cat.getHealth(), 10, 30, Color.BLACK);
    }

    public void addRandomObjects() {
        for(int r = 0; r < tiles.length - 1; r++) {
            for(int c = 0; c < tiles[0].length; c++) {
                int random = (int)(Math.random() * tiles.length);
                if(tiles[r][c].equals("")) {
                if(random < 1) {
                    Yarn yarn = new Yarn();
                    addObject(yarn, (c *100), (r*100));
                    tiles[r][c] = "yarn";
                }
            }
            }
        }
    }
    
    public void buildWorld(String[][] tiles)
    {
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[i].length; j++)
            {
                tiles[i][j] = "";
            }
        }

        for(int x = 0; x < tiles[0].length; x++)
        {
            tiles[5][x] = "lava";
        }

        tiles[4][1] = "ground";
        tiles[3][3] = "ground";
        tiles[2][5] = "ground";
        tiles[4][0] = "vine";
        tiles[3][2] = "vine";
        tiles[2][4] = "vine";
        tiles[1][6] = "sign";

        for(int a = 0; a < tiles.length; a++)
        {
            for(int b = 0; b < tiles[a].length; b++)
            {
                if(tiles[a][b].equals("ground"))
                {
                    addObject(new Block(), b*100, a*100);
                }
                if(tiles[a][b].equals("sign"))
                {
                    addObject(new Sign(), (b*100)-80, (a*100)+30);
                }
                if(tiles[a][b].equals("lava"))
                {
                    addObject(new Lava(), (b*100), (a*100));
                }
                if(tiles[a][b].equals("vine"))
                {
                    addObject(new Vine(), (b*100), (a*100));
                }
            }
        }
        cat = new Cat();
        addObject(cat, 50, 100);
    }

    public void act()
    {
        if(cat.getLevelThree())
        {
            if(cat.getScore() > 15)
            {
                Mayflower.setWorld(new GameOverScreen());
            }
            else
            {
                Mayflower.setWorld(new GameOverLoserScreen());
            }
        }
    }

}