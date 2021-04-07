import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class secretNumbers {

    static String[] congratulations = {"Did you expect a gift ?","I hope you are happy with yourself","I'm so proud of you","gg ez","Was it too easy ?","Congratulations","That was awesome right ? (Maybe not)"};

    int secretNumberArray [];

   /*
    *  Return true if int key is found inside int[] arr and false if not
    */
    public static boolean contains(final int[] arr,final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

   /*
    *  Return true if secretNumber is a factor of number false if not
    */
    public static boolean isFactor(int number,int secretNumber){
        return (number > 0 && secretNumber > 0 && number % secretNumber == 0 );
    }
    
   /*
    *  Return a random integer between floor and ceil both included
    */
    public static int randomInt(int floor,int ceil){
        if (floor >= ceil) {
            throw new IllegalArgumentException("ceil must be greater than floor");
        }
        Random r = new Random();
        return r.nextInt((ceil - floor) + 1) + floor;
    }

    secretNumbers(int secretNumbers_count, int floor, int ceil){

        //If we want more distinct secret numbers than whats possible
        if ((ceil - floor + 1) < secretNumbers_count) {
            throw new IllegalArgumentException("Can't select enough distinct secret numbers in the range selected");
        }

        this.secretNumberArray = new int[secretNumbers_count];
        this.secretNumberArray[0] = randomInt(floor, ceil);
        int random;
        for(int i = 1; i < secretNumbers_count;i++) {

            // We loop until we have a secret number not already present
            do {
                random = randomInt(floor, ceil);
            } while(contains(this.secretNumberArray,random));

            //Add it to the secret numbers array
            this.secretNumberArray[i] = random;
        }
    }

   /*
    *  Return the number of secret numbers being factor of numberEntered
    */
    public int tryNumbers(int numberEntered){

        int count = 0;

        for(int i=0; i < this.secretNumberArray.length;i++){
            count = (isFactor(numberEntered, this.secretNumberArray[i])) ? count + 1 : count;
        }

        return count;
    }

    public static void main(String [] args) {

        //Default param
        int numCount = 3;
        int secretFloor = 1;
        int secretCeil = 10;

        if (args.length == 3) {
            //All arguments were given
            numCount = Integer.parseInt(args[0]);
            secretFloor = Integer.parseInt(args[1]);
            secretCeil = Integer.parseInt(args[2]);
        } else if (args.length == 1){
            //Only secret numbers count is given
            numCount = Integer.parseInt(args[0]);
        }
    

       secretNumbers sNumbers = new secretNumbers(numCount, secretFloor, secretCeil);

       Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("The secret numbers have been chosen ! Enter a number (not 0) :");

            while(true) {
                
                try {
                int numberEntered = Integer.parseInt(scanner.nextLine());        
                int result = sNumbers.tryNumbers(numberEntered);
                
                //If we get every secret number we win the game !
                if(result == numCount){
                    System.out.println("You won !");
                    System.out.println(congratulations[randomInt(0, congratulations.length -1)]);
                    break;
                }

                System.out.println(result); 
                System.out.println("Choose a new number :"); 

                // Text couldn't be parsed so it wasn't an integer
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number :");
                }
            }
        } catch(Exception  e) {


        // System.in has been closed
        System.out.println("System.in was closed; exiting");
       } finally {
           scanner.close();
       }
    }
 }