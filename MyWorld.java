import mayflower.*;

public class MyWorld extends World {
    private Cat cat;
    private String[][] tiles;
    
    public MyWorld() 
    {
        Mayflower.showBounds(true);
        setBackground("img/BG/BG.png");
        tiles = new String[6][8];
        
        buildWorld(tiles);
        addRandomObjects();
        
        cat = new Cat();
        addObject(cat, 100, 10);
        
        showText("Score: " + cat.getScore() + " Health: " + cat.getHealth(), 10, 30, Color.BLACK);

        
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

        for(int x = 0; x < tiles.length; x++)
        {
            tiles[x][5] = "ground";
        }
        
        tiles[2][4] = "vine";
        tiles[3][4] = "vine";
        tiles[4][4] = "vine";
        tiles[1][4] = "vine";
        
        tiles[5][2] = "lava";
        tiles[5][0] = "lava";
        tiles[5][1] = "lava";

        for(int x = 1; x < tiles.length; x++)
        {
            if(x==2)
            {
                continue;
            }
            tiles[5][x] = "ground";
        }
        tiles[0][5] = "sign";
        for(int a = 0; a < tiles.length; a++)
        {
            for(int b = 0; b < tiles[a].length; b++)
            {
                if(tiles[a][b].equals("ground"))
                {
                    addObject(new Block(), (b*100), (a*100));
                }
                if(tiles[a][b].equals("sign"))
                {
                    addObject(new Sign(), (b*100)+30, (a*100)+30);
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
        
        
    }
    
    public void addRandomObjects() {
        for(int r = 0; r < tiles.length - 1; r++) {
            for(int c = 0; c < tiles[0].length; c++) {
                int random = (int)(Math.random() * tiles.length);
                if(tiles[r][c].equals("")) {
                if(random < 2) {
                    Yarn yarn = new Yarn();
                    addObject(yarn, (c *100), (r*100));
                    tiles[r][c] = "yarn";
                }
            }
            }
        }
    }
    
    public void act()
    {
        if(cat.getLevelOne())
        {
            Mayflower.setWorld(new MyWorldTwo());
        }
    }

}