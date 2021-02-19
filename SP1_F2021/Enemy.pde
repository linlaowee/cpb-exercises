class Enemy
{
    int x; 
    int y; 
    int type = 1; 
    Player player;

    Enemy(int x, int y, Player player)
    {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    void moveTowardsPlayer()
    {
        int xDistance = Math.abs(player.x - x);
        int yDistance = Math.abs(player.y - y);

        // 25% chance (~25% chance) for the food to move a random space
        int count = int(random(0,99));
        
        if (count < 25) 
        {
          x += random(-1,1);
          y += random(-1,1);
        }
        
        // moving towards the player
        if (xDistance > yDistance && count >= 25)
        {
            moveXtowards();
        } 
        else
        {
            moveYtowards();
        }
    }
    
    // Updates x so it moves towards from the player
    void moveXtowards()
    {
        if (player.x > x)
        {
            x++;
            
            if (x >= grid.length)
            {
               x = grid.length -1;
            }
         } 
         else
         {
            x--;
            
            if (x < 0)
            {
               x = 0;
            }
         }
    }   
    
   
    // Updates y so it moves towards from the player
    void moveYtowards()
    {
        if (player.y > y)
        {
            y++;
            
            if (y >= grid[0].length)
            {
               y = grid[0].length -1;
            }
         } 
         else
         {
            y--;
            
            if (y < 0)
            {
               y = 0;
            }
         }
    }  
}
