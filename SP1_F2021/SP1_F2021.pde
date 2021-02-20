import java.util.*;
int size = 40;
int[][] grid = new int[25][25];

PImage img;

Player player;

Enemy enemy1;
Enemy enemy2;
Enemy enemy3;
Enemy enemy4;

Food food1;
Food food2;
Food food3;
Food food4;

List<Enemy> enemies = new ArrayList<Enemy>();
List<Food> allFood = new ArrayList<Food>();

// Gives a NullPointerException
//Enemy[] enemies = { 
//  new Enemy(20, 19, player),
//  new Enemy(18, 19, player),
//  new Enemy(18, 17, player),
//  new Enemy(20, 17, player),
//};

void setup()
{
    size(1001, 1001);
    player = new Player(3, 4);
    enemy1 = new Enemy(20, 19, player);
    enemy2 = new Enemy(18, 19, player);
    enemy3 = new Enemy(18, 17, player);
    enemy4 = new Enemy(20, 17, player);
    
    food1 = new Food(3, 19, player);
    food2 = new Food(int(random(5, grid.length - 4)), int(random(3, grid[0].length - 4)), player); 
    food3 = new Food(int(random(5, grid.length - 4)), int(random(12, grid[0].length - 4)), player); 
    food4 = new Food(int(random(5, grid.length - 4)), int(random(15, grid[0].length - 4)), player); 
    
    lastTime = millis();
    
    enemies.add(enemy1);
    enemies.add(enemy2);
    enemies.add(enemy3);
    enemies.add(enemy4);
    
    allFood.add(food1);
    allFood.add(food2);
    allFood.add(food3);
    allFood.add(food4);
    
    img = loadImage("gameover.png");
      
}

void draw()
{
    clearBoard();
    if (!isGameOver(player)){
        updateEntities();
        //clearBoard();
        //drawBoard(); 
        
    }
    drawBoard(); 
    
    if (isGameOver(player)){
        image(img,0,0);
    }
    
    
    // Debug
    println(player.health);
    //println(player.score);
    
}

void clearBoard()
{
    for (int x = 0; x < grid.length; x++)
    {
        for (int y = 0; y < grid[0].length; y++)
        {
            grid[x][y] = 0;
        }
    }
}


void drawBoard()
{
    for (int x = 0; x < grid.length; x++)
    {
        for (int y = 0; y < grid[0].length; y++)
        {
            fill(getColorFromType(grid[x][y]));
            
            rect(x * size, y * size, size, size);
        }
    }
}

float lastTime = 0.0;
float lastTime2 = 0.0;

void updateEntities()
{
    grid[player.x][player.y] = player.type; //displays player
    
    for (Enemy e : enemies)                 
    {
        grid[e.x][e.y] = e.type;            //displays all enemies
        resolveCollisionEnemy(e);           //detects collision with player and enemy and gives damages
    }  
    
    for (Food f : allFood)
    {
        grid[f.x][f.y] = f.type;            //displays food
        resolveCollisionFood(f);            //detects collision with player and food and increases score
    }
    
    
    if ( millis() - lastTime > 300 )        //delaying enemy movement
    {
       for (Enemy e : enemies)              //all enemy movement
       {
           e.moveTowardsPlayer();
           lastTime = millis();
        }
    }
    
    
    if (millis() - lastTime2 > 300 )        //delaying food movement
    {
        for (Food f : allFood)              //all food movement
        {
            f.moveAwayPlayer();
            lastTime2 = millis();
        }
    }
    
}

void resolveCollisionEnemy(Enemy tempEnemy)
{
    if (grid[tempEnemy.x][tempEnemy.y] == grid[player.x][player.y])
    {
        player.takeDamage();
    }
}


boolean eaten = false;

void resolveCollisionFood(Food tempFood)
{
    if (grid[tempFood.x][tempFood.y] == grid[player.x][player.y] && eaten == false)
    {
        if (grid[tempFood.x][tempFood.y] == grid[player.x][player.y] && tempFood.type != 0)
        {
            player.increaseScore();
        }
        eaten = true;
        tempFood.type = 0;
        
    }
    if (tempFood.type != 0)
    {
        eaten = false;
    }
    
}


boolean isGameOver(Player tempPlayer)
{
    if (tempPlayer.health <= 0)
    {
        return true;
    }
    else 
    {
        return false;
    }
}





//Here are the color values for the fields and enteties
color getColorFromType(int type) 
{
    color c = color(255);
    
    switch(type)
    {
        case 0: 
            c = color(150);         //grey
            break;
        case 1: 
            c = color(230,70,70);   //red
            break;
        case 2: 
            c = color(0, 255, 0);   //green
            break;
        case 3: 
            c = color(0,0,255);     //blue
            break;
        case 4: 
            c = color (0,255,255);  //cyan
            break;
    }    
    
    return c; 
}

void printIntArray(int[][] arr) 
{
    System.out.println("");
    System.out.println("");
    System.out.println("");
    for (int x = 0; x < arr.length; x++)
    {
        for (int y = 0; y < arr[0].length; y++) 
        {

            System.out.print(arr[x][y] + ", ");
            
        }
        println();
    }
}

void keyPressed()
{
    if(key == 'w') //up
    {
      player.y--; 
      if (player.y < 0) 
      {
        player.y = 0;
      }
    }
    if(key == 'a') //left
    {
      player.x--;   
      if (player.x < 0)
      {
        player.x = 0;
      }
    }
    if(key == 's') //down
    {
      player.y++;   
      if (player.y >= grid[0].length) 
      {
        player.y = grid[0].length-1;
      }
    }
    if(key == 'd') //right
    {
      player.x++;   
      if (player.x >= grid.length)
      {
        player.x = grid.length-1;
      }
    }
}
