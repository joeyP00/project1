import mayflower.*;

public class MyWorldTwo extends World {
    private Cat cat;
    private String[][] tiles;
    
    public MyWorldTwo() 
    {
        //Mayflower.showBounds(true);
        setBackground("img/BG/BG.png");
        tiles = new String[6][8];
        
        cat = new Cat();


        buildWorld(tiles);
        addRandomObjects();
        addObject(cat, 10, 10);
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

        for(int x = 1; x < 8; x++)
        {
            tiles[1][x] = "ground";
        }
        tiles[5][0] = "lava";
        tiles[5][1] = "ground";
        tiles[5][2] = "lava";
        tiles[5][3] = "ground";
        tiles[5][4] = "lava";
        tiles[5][5] = "ground";
        tiles[5][6] = "ground";
        tiles[4][6] = "sign";
        
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
                    addObject(new Sign(), (b*100)+30, (a*100)+30);
                }
                if(tiles[a][b].equals("lava"))
                {
                    addObject(new Lava(), b*100, a*100);
                }
            }
        }
    }
    
    public void act()
    {
        if(cat.getLevelTwo())
        {
            Mayflower.setWorld(new MyWorldThree());
        }
    }

}