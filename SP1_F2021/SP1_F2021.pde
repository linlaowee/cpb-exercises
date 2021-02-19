
int size = 40;
int[][] grid = new int[25][25];

Player player;
Enemy enemy;
Food food;

void setup()
{
    size(1001, 1001);
    player = new Player(3, 4);
    enemy = new Enemy(20, 19, player);
    food = new Food(3, 19, player);
    
    lastTime = millis();
    
}

void draw()
{
    clearBoard();
    updateEntities();
    drawBoard(); 
    //println(player.health);
    println(player.score);
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

float lastTime = 0;

void updateEntities()
{
    grid[player.x][player.y] = player.type; //displays player
    grid[enemy.x][enemy.y] = enemy.type;    //displays enemy
    grid[food.x][food.y] = food.type;       //displays food
    resolveCollisionEnemy(enemy);
    resolveCollisionFood();
    
    if ( millis() - lastTime > 200 )        // delaying enemy movement
    {
      enemy.MoveTowardsPlayer();
      lastTime = millis();
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

void resolveCollisionFood()
{
    if (grid[food.x][food.y] == grid[player.x][player.y] && eaten == false)
    {
        player.increaseScore();
        eaten = true;
        food.type = 0;
    }
}




//Here are the color values for the fields
color getColorFromType(int type) 
{
    color c = color(255);
    
    switch(type)
    {
        case 0: 
            c = color(150); //grey
            break;
        case 1: 
            c = color(230,70,70); //red
            break;
        case 2: 
            c = color(0, 255, 0); //green
            break;
        case 3: 
            c = color(0,0,255);
            break;
        case 4: 
            c = color (0,255,255);
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
