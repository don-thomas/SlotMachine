/*
 Authors:  Thomas, Don & Molla, Youseuf
 Date: Fri, April 8th 2016
 Filename: SlotMachine
 Description: This program simulates a slot machine in which three 
 numbers between 0 and 9 are randomly generated and printed side by side.
 If the numbers are the same, coins are added to the total. If none of the
 numbers are the same, the coins waged are taken away from the total amount.
 */

class SlotMachine
{
  public static void main (String[] args)
  {
    /* totalCoins repersents the coins that the player starts with, and is the total number of coins 
     remaining after each play (starting value is 1000) 
     */
    int totalCoins=1000;    
    /* wager repersents the amount of coins that the player wants to bid, this amount is then added or 
     deducted depending on the numbers  generated
     */
    int wager; 
    // The name of this program is printed 
    System.out.println("Slot Machine");
    // The amount of coins the player has in the beginning is displayed
    System.out.println("You have 1000 coins.");
    
    /*This is the main loop of the program, it checks if the total number of coins is equal to 
     0, and if the wager is equal to 0. If one of those expressions is not true, then the program will exit the main
     loop and end 
     */
    do
    {
      /* generatedNumbers stores the all three of the randomly generated numbers (from 0-9)
       these numbers determine whether coins are added or taken away from the total amount of coins.
       The values for the generated numbers gets reset after each play
       */
      String generatedNumbers="";
      // This print statement tells the player that by pressing 0 they could exit the play and pressing other numbers 
      //determines the amount of biding coins
      System.out.println("Press 0 to exit, any other number to play that many coins per spin.");
      
      /*This loop checks if the wager is less than 0 and if the wager is greater than the total number of coins. 
       The program will exit the loop if the wager is equal to 0, if the wager is below or equal to the total 
       number of coins and if the wager is not a negative number 
       */
      do
      {
        //This line of code takes the value the player inputed and stores it in the variable "wager"
        wager = In.getInt();
        
        //If the wager is greater than the total number of coins than the following if statement will be executed 
        if (wager>totalCoins)
    
          /* This print statement tells the player that their wager is higher than the total number of coins and that they 
           need to enter a amount that is lower than the total number of coins
           */
          System.out.println("Your Wager is greater than the number of coins you have");
      }
      // This expresion checks if the wager is higher than the total number of coins 
      while (wager>totalCoins);
      
      // If the wager is in between 0 and total number of coins than this "if" statement will be excueted  
      if (wager<=totalCoins && wager!=0)
      {
        
        // The variable generatedNumber stores 3 random numbers (from 0-9), which are than collected as String variable.      
        for (int i =0;i<3; ++i)
        {
          
          /* The random numbers are generated from 0-9, which is stores in the variable generatedNumber.
           Three numbers are randomly generated and stored in the string.
          */
             generatedNumbers+=(int)(Math.random()*10)+" ";          
        }
        
        //This statement prints the three generated numbers
        System.out.println(generatedNumbers);
        
        /* By using the .charAt the generated numbers are placed at specific positions on the same line.
         If all three of the numbers are the same than the following if statement will be true and the wager 
         will be multpilied by 100 and than added to the total number of coins the player has.
         */
        if (generatedNumbers.charAt(0)==generatedNumbers.charAt(2) && generatedNumbers.charAt(0)==generatedNumbers.charAt(4))
        {   
          // This mathematical expression calculates the new total number of coins
          totalCoins+=wager*100;
          
          /*If three of the generated numbers are the same then the following statement will print, declaring the
           amount won and the new total number of coins 
           */
          System.out.println("You won "+(wager*100)+"! "+"You now have "+totalCoins+" coins.");
          
        }
        /*If 2 of the numbers are the same than the following else if statement will be true and the wager 
         will be multpilied by 10 and than added to the total number of coins the player has.
         */
        else if (generatedNumbers.charAt(0)==generatedNumbers.charAt(2) || generatedNumbers.charAt(0)==generatedNumbers.charAt(4) 
                   || generatedNumbers.charAt(2)==generatedNumbers.charAt(4))
        {
          // This mathematical expression calculates the new total number of coins
          totalCoins+=wager*10;
          
          // This statement declares the amount won and the new total number of coins 
             System.out.println("You won "+(wager*10)+"! "+"You now have "+totalCoins+" coins.");
          
        }
        /*If none of the numbers are the same than the following else statement will excute and total amount of coins 
         the player has will be deducted by the amount bid. 
         */
        else
        {
          // This mathematical expression calculates the new total number of coins
          totalCoins-=wager;
          
          // This statement declares the amount lost and the new total number of coins 
          System.out.println("You lost "+(wager)+"! "+"You now have "+totalCoins+" coins.");
          
        }
        
      }
      
    }
    // If the wager or total number of coins is equal to zero than the program will exit the main loop.
    while(wager!=0 && totalCoins!=0);
  }
}