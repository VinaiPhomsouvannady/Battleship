
import java.util.*;

public class BattleShip {
  public static int numRows = 10;
  public static int numCols = 10;
  public static int playerShips;
  public static String Player1;
  public static String Player2;
  public static int player2Ships;
  public static String[][] grid = new String[numRows][numCols];
  public static String[][] grid2 = new String[numRows][numCols];
  
  public static void createOcean1()
  {
    System.out.print("  ");
    for(int i = 0; i < numCols; i++)
    {
      System.out.print(i);
    }
    System.out.println();
    
    for(int i = 0; i < grid.length; i++) 
    {
      for (int j = 0; j < grid[i].length; j++) 
      {
        grid[i][j] = " ";
        if (j == 0)
          System.out.print(i + "]" + grid[i][j]);
        else if (j == grid[i].length - 1)
        {
          System.out.print(grid[i][j] + "[");
        }
        else
        {
          System.out.print(grid[i][j]);
        }
      }
      System.out.println();
    }
  }
  public static void createOcean2()
  {
    System.out.print("  ");
    for(int i = 0; i < numCols; i++)
    {
      System.out.print(i);
    }
    System.out.println();
    
    for(int i = 0; i < grid2.length; i++) 
    {
      for (int j = 0; j < grid2[i].length; j++) 
      {
        grid2[i][j] = " ";
        if (j == 0)
        {
          System.out.print(i + "]" + grid2[i][j]);
        }
        else if (j == grid2[i].length - 1)
        {
          System.out.print(grid2[i][j] + "[");
        }
        else
        {
          System.out.print(grid2[i][j]);
        }
      }
      System.out.println();
    }
  }
  public static void deployPlayer1Ships()
  {
    Scanner input = new Scanner(System.in);
    BattleShip.playerShips = 3;                                                                //Amount of Ships.............You Can Change this
    for (int i = 1; i <= BattleShip.playerShips; ) {
      System.out.print("Enter X coordinate for ship "+i+":");
      int x = input.nextInt();
      System.out.print("Enter Y coordinate for ship "+i+":");
      int y = input.nextInt();
      if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " "))
      {
        grid[x][y] =   "S";
        i++;
      }
      else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "S")
        System.out.println("Ship already placed here");
      else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
        System.out.println("Must be within the grid");
    }
    printOcean1();
  }
  public static void deployPlayer2Ships()
  {
    Scanner input = new Scanner(System.in);
    BattleShip.player2Ships = 3;                                                              //Amount of Ships.............You Can Change this
    for (int i = 1; i <= BattleShip.playerShips; ) {
      System.out.print("Enter X coordinate for ship "+i+":");
      int x = input.nextInt();
      System.out.print("Enter Y coordinate for ship "+i+":");
      int y = input.nextInt();    
      if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid2[x][y] == " "))
      {
        grid2[x][y] =   "S";
        i++;
      }
      else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid2[x][y] == "S")
        System.out.println("Ship already placed here");
      else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
        System.out.println("Must be within the grid");
    }
    printOcean2();
  }
  public static void Battle(){
    playerTurn();
    player2Turn();
    printguess1();
    printguess2();
    System.out.println("\n\n"+Player1+" ships:" + BattleShip.playerShips + " | "+Player2+" ships: " + BattleShip.player2Ships+"\n\n");
  }
  public static void playerTurn(){
    System.out.println("\n"+Player1+"'s turn");
    int x = 0;
    int y = 0;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter X coordinate: ");
    x = input.nextInt();
    System.out.print("Enter Y coordinate: ");
    y = input.nextInt();
    while((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
    {
      System.out.print("Invalid guess");
      System.out.print("Enter X coordinate: ");
      x = input.nextInt();
      System.out.print("Enter Y coordinate: ");
      y = input.nextInt();
    }
    if (grid2[x][y] == "S") 
    {       for(int i = 0;i<4;i++)
      {
      System.out.println("-__+--__+--__+-");
    }
    System.out.println("YOU SUNK MY BATTLESHIP!!!");       for(int i = 0;i<4;i++)
    {
      System.out.println("-__+--__+--__+-");
    }
    grid2[x][y] = "!"; 
    --BattleShip.player2Ships;
    }
    else  
    {
      for(int i = 0;i<4;i++)
      {
        System.out.println("-__+--__+--__+-");
      }
      System.out.println("Try again sucka!!!");
      for(int i = 0;i<4;i++)
      {
        System.out.println("-__+--__+--__+-");
      }
      if(grid2[x][y]==" ")
      {
        grid2[x][y] = "o";
      }
    }
  }
  public static void player2Turn()
  {
    System.out.println("\n"+Player2+"'s turn");
    int x = 0;
    int y = 0;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter X coordinate: ");
    x = input.nextInt();
    System.out.print("Enter Y coordinate: ");
    y = input.nextInt();
    while((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
    {
      System.out.print("Invalid guess");
      System.out.print("Enter X coordinate: ");
      x = input.nextInt();
      System.out.print("Enter Y coordinate: ");
      y = input.nextInt();
    }
    if (grid[x][y] == "S") 
    {       for(int i = 0;i<4;i++)
      {
      System.out.println("-__+--__+--__+-");
    }
    System.out.println("YOU SUNK MY BATTLESHIP!!!");       for(int i = 0;i<4;i++)
    {
      System.out.println("-__+--__+--__+-");
    }
    grid[x][y] = "!"; 
    --BattleShip.playerShips;
    }
    else  
    {
      for(int i = 0;i<4;i++)
      {
        System.out.println("-__+--__+--__+-");
      }
      System.out.println("Try again sucka!!!");
      for(int i = 0;i<4;i++)
      {
        System.out.println("-__+--__+--__+-");
      }
      if(grid2[x][y]==" ")
      {
        grid2[x][y] = "o";
      }
    }
  }
  
  public static void printOcean1()
  {
    System.out.println();
    System.out.print("  ");
    for(int i = 0; i < numCols; i++)
    {
      System.out.print(i);
    }
    System.out.println();
    for(int x = 0; x < grid.length; x++)
    {
      System.out.print(x + "]");
      
      for (int y = 0; y < grid[x].length; y++)
      {
        System.out.print(grid[x][y]);
      }
      System.out.println();
    }
  }
  public static void printOcean2()
  {
    System.out.println();
    System.out.print("  ");
    for(int i = 0; i < numCols; i++)
    {
      System.out.print(i);
    }
    System.out.println();
    for(int x = 0; x < grid2.length; x++) 
    {
      System.out.print(x + "]");
      
      for (int y = 0; y < grid2[x].length; y++)
      {
        System.out.print(grid2[x][y]);
      }
      System.out.println();
    }
  }
  public static void printguess1()
  {      System.out.println(Player1+"'s Ocean");
    System.out.println();
    System.out.print("  ");
    for(int i = 0; i < numCols; i++)
    {
      System.out.print(i);
    }
    System.out.println();
    for(int x = 0; x < grid.length; x++) 
    {
      System.out.print(x + "]");
      
      for (int y = 0; y < grid[x].length; y++)
      {
        if(grid[x][y]=="S")
        {
          System.out.print(" ");
        }
        else
        {
          System.out.print(grid[x][y]);
        }
      }
      System.out.println();
    }
  }
  public static void printguess2()
  {      System.out.println(Player2+"'s Ocean");
    System.out.println();
    System.out.print("  ");
    for(int i = 0; i < numCols; i++)
    {
      System.out.print(i);
    }
    System.out.println();
    for(int x = 0; x < grid2.length; x++) 
    {
      System.out.print(x + "]");
      
      for (int y = 0; y < grid2[x].length; y++)
      {
        if(grid2[x][y]=="S")
        {
          System.out.print(" ");
        }
        else
        {
          System.out.print(grid2[x][y]);
        }
      }
      System.out.println();
    }
  }
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    {
      System.out.println("Welcome to BattleShip");
      System.out.println("Name your players");
      System.out.println("Player 1 enter your name below:");
      BattleShip.Player1 = input.next();
      System.out.println("Player 2 enter your name below:");
      BattleShip.Player2 = input.next();
      System.out.println(Player1+"'s Ocean");
      createOcean1();
      System.out.println("\n\n\n"+Player2+"'s Ocean");
      createOcean2();
      System.out.println(Player1+" is deploying ships:");
      deployPlayer1Ships();
      System.out.println("Press ENTER to proceed to "+Player2+"'s turn to deploy");
      input.nextLine();
      input.nextLine();
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+Player2+" is deploying ships:");
      deployPlayer2Ships();
      System.out.println("Press ENTER to proceed to battle");
      input.nextLine();
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      for(int i = 0;i<20;i++)
      {
        System.out.println("^w^^w^^w^^w^^w^^w^^w^^w^^w^^w^^w^^w^");
      }
      System.out.println("         PREPARE FOR BATTLE!!");
      for(int i = 0;i<20;i++)
      {
        System.out.println("^w^^w^^w^^w^^w^^w^^w^^w^^w^^w^^w^^w^");
      }
      while(BattleShip.playerShips != 0 && BattleShip.player2Ships != 0)
      {
        Battle();
      }
      
      System.out.println(Player1+" ships:" + BattleShip.playerShips + " | "+Player2+" ships: " + BattleShip.player2Ships);
      if(BattleShip.playerShips > BattleShip.player2Ships)
      {
        for(int i = 0;i<4;i++)
        {
          System.out.println("[<><><><><><><><><><><><><><><>]");
        }
        System.out.println("         "+Player1+" WON!!!!");
        for(int i = 0;i<4;i++)
        {
          System.out.println("[<><><><><><><><><><><><><><><>]");
        }
      }
      else  if(BattleShip.playerShips < BattleShip.player2Ships)
      {
        for(int i = 0;i<4;i++)
        {
          System.out.println("[<><><><><><><><><><><><><><><>]");
        }
        System.out.println("         "+Player2+" WON!!!!");
        for(int i = 0;i<4;i++)
        {
          System.out.println("[<><><><><><><><><><><><><><><>]");
        }
      }
      else 
      {
        for(int i = 0;i<4;i++)
        {
          System.out.println("[<><><><><><><><><><><><><><><>]");
        }
        System.out.println("              DRAW"); 
        for(int i = 0;i<4;i++)
        {
          System.out.println("[<><><><><><><><><><><><><><><>]");
        }
      }
      printOcean1();
      printOcean2();
    }
    
  }
}