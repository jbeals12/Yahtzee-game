import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Yahtzee {
   
   public static void main(String[] args) {
      
      int[] dice = new int[5];
      Random r = new Random();
      Scanner in = new Scanner (System.in);
      
      //generate the dice rolls
      for (int i = 0; i < 5; i++) {
      dice[i] = r.nextInt(6) + 1;
      }
      
      //display the dice rolls
      for (int i = 0; i < 5; i++) {
         System.out.print(dice[i] + " ");
      }
      
      System.out.println();
      
      //set two reroll rounds
      for (int j = 0; j < 3; j++) { 
         if (j < 2) { 
         
         //get user response for each dice
         for (int i = 0; i < dice.length; i++) { 
            System.out.println("Re-roll " + dice[i] + "? (Y/N)"); 
            String userResponse = in.nextLine(); 
            //rerolls selected dice
            if (userResponse.equalsIgnoreCase ("Y")) { 
            dice[i] = r.nextInt(6)+ 1; 
            } 
         }
         //displays new dice values
         for (int i = 0; i < dice.length; i++){ 
            System.out.print(dice[i] + " "); 
            } 
            System.out.println(""); 
            }
         else { 
            System.out.println ("Cheater mode"); //This is the cheater mode for manually testing each dice number
         for (int i = 0; i < dice.length; i++){ 
            System.out.println ("Manually set dice # " + (i+1)+ " to?"); 
            dice[i] = in.nextInt(); 
         } 
         
         //displays new dice values
         for (int i = 0; i < dice.length; i++){ 
            System.out.print(dice[i] + " ");
         }
         }//end of cheater mode
       }//end of reroll rounds
       
      //Create a counts array, set all values to zero.
      int[] counts = new int[6];
      for (int i = 0; i < 6; i++){
         counts[i] = 0;
      }
      
      //count up the values
      for (int i = 0; i < 5; i++) {
         /* diceIndex will hold the value of the dice location
         minus one. This is so it can be placed in the 0th
         based array, in the correct location.*/
         int diceIndex = dice[i] - 1;
         /* This will go to the location reserved for the dice and increment its value by 1.
         For example, if the value of the die was 4, the diceIndex value would be 3. 
         This would increment counts[3] by one. 
         Now it’s easy to tell how many 4s there are, because each time there is a 4, 
         it will increment the count[3] location by one again.*/
         counts[diceIndex]++;
         }
         /* This prints out how many of each number there is. 
         COMMENT IT OUT WHEN YOU ARE DONE WITH IT. */
         System.out.println();
         
         for (int i = 0; i < 6; i++){
            System.out.println("The number of " + (i+1) + "s is : " + counts[i]);
         }
         
         //Prints out the result of the final roll by using the counts array
         for (int i = 0; i < 6; i++) {
            if (counts[i] == 5){
            System.out.println("Yahtzee!");
            break;
            }
            if ((counts[0] == 1) && (counts[1] == 1) && (counts[2] == 1) && (counts[3] == 1) && (counts[4] == 1) || (counts[1] == 1) && (counts[2] == 1) && (counts[3] == 1) && (counts[4] == 1) && (counts[5] == 1)) {
            System.out.print("Large Straight!");
            break;
            }
            if ((counts[0] >= 1) && (counts[1] >= 1) && (counts[2] >= 1) && (counts[3] >= 1) || (counts[1] >= 1) && (counts[2] >= 1) && (counts[3] >= 1) && (counts[4] >= 1) || (counts[2] >= 1) && (counts[3] >= 1) && (counts[4] >= 1) && (counts[5] >= 1)) {
            System.out.print("Small Straight!");
            break;
            }
            if (counts[i] == 4) {
            System.out.println("Four of a kind!");
            break;
            }
            if ((counts[0] == 3) && (counts[i] == 2) || (counts[1] == 3) && (counts[i] == 2) || (counts[2] == 3) && (counts[i] == 2) || (counts[3] == 3) && (counts[i] == 2) || (counts[4] == 3) && (counts[i] == 2) || (counts[5] == 3) && (counts[i] == 2)) {
            System.out.println("Full House!");
            return;
            }
         }
         //To seperate Three of a Kind and a Full House so only the correct result displays
         for (int i = 0; i < 6; i++) {
            if (counts[i] == 3) {
            System.out.println("Three of a Kind!");
            break;
            }
         }
   }//end main
}//end class