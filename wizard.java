import java.util.Scanner;

/* Wizard version 1.3 */
public class wizard 
{
    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        n = sc.nextInt(); /* n: number of players */

        // Number of Match
        int matchNum = 60/n;
        if (60 % n == 0)
        {
             // Create an array in the memory of length n to input the name of players
            String[] arrayName = new String[n];
            System.out.println("Enter the name of player: ");
            for(int i = 0; i < n; i++)
            {
                //reading arrayName from the user
                arrayName[i] = sc.next(); 
            }

            // Match Performance
            int[] guessNum = new int[n];
            int[] result = new int[n];
            int[] check = new int[n];
            int[] score = new int[n];
            int[] point = new int[n];
            for(int i = 0; i < matchNum; i++)
            {
                int p; /* p: players */
                /* Insert Guess Number */
                for(p = 0; p < n; p++)
                {
                    System.out.print("\nThe Guess Number of " + arrayName[p] +": ");
                    guessNum[p] = sc.nextInt();
                }

                /* Change Guess Number */
                int agree;
                int changeGuess;
                for(i = 0; i < 2*n; i++)
                {
                    System.out.println("\nDo you want to change any guess number?: 1 means Yes, 0 means No.");
                    agree = sc.nextInt();
                    if(agree == 1)
                    {
                        System.out.print("\nEnter the index of the player wants to change: "); 
                        changeGuess = sc.nextInt();
                        System.out.print("\nEnter the number that " + arrayName[changeGuess - 1] + " wants to change: ");
                        guessNum[changeGuess - 1] = sc.nextInt();
                    }
                
                    else if(agree == 0)
                    {
                        break;
                    }
                    
                    else
                    {
                        System.out.println("Error!");
                    }
                }
                
                /* Insert Result Number */
                System.out.println("\n");
                for(p = 0; p < n; p++)
                {
                    System.out.print("\nThe Result of " + arrayName[p] +": ");
                    result[p] = sc.nextInt();
                }

                System.out.println("\n----------------MATCH "+ (i+1) +"------------------");
                /* Calculate point of each player */
                for(p = 0;p < n; p++)
                {
                    check[p] = guessNum[p] - result[p];
                    if(check[p] == 0)
                    {
                        point[p] = score[p] + 20 + guessNum[p] * 10;
                        System.out.println(arrayName[p] + "'s point: " + point[p]);
                        score[p] = point[p];
                    }
                    else
                    {
                        point[p] = score[p] - Math.abs(check[p])*10;
                        System.out.println(arrayName[p] + "'s point: " + point[p]);
                        score[p] = point[p];
                    }
                }
                System.out.println("-----------------------------------------");
            }
        }
        else
        {
            System.out.println("\n ERROR!! ERROR!! MEINE FRESSE! \n");
        }
    }
}
