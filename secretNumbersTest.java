
public class secretNumbersTest {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String [] args) {
       System.out.println("Unit tests"); 

       System.out.println("Testing isFactor()"); 
        startTest(secretNumbers.isFactor(5, 2),false);
        startTest(secretNumbers.isFactor(10, 2),true);
        startTest(secretNumbers.isFactor(14, 7),true);
        startTest(secretNumbers.isFactor(70, 35),true);
        startTest(secretNumbers.isFactor(5, 2),false);
        startTest(secretNumbers.isFactor(0, 1),false);
        startTest(secretNumbers.isFactor(10, 0),false);
       System.out.println("Testing tryNumbers()"); 
        startTest(testTryNumbers(new int[] {2,7,10}, 5), 0);
        startTest(testTryNumbers(new int[] {2,7,10}, 4), 1);
        startTest(testTryNumbers(new int[] {2,7,10}, 14), 2);
        startTest(testTryNumbers(new int[] {2,7,10}, 70), 3);
        startTest(testTryNumbers(new int[] {2,7,10}, 280), 3);
       System.out.println("Testing contains()"); 
        startTest(secretNumbers.contains(new int[] {2,8,19}, 19), true);
        startTest(secretNumbers.contains(new int[] {2,8,100,10,50}, 8), true);
        startTest(secretNumbers.contains(new int[] {2,8,19}, 3), false);
        startTest(secretNumbers.contains(new int[] {}, 10), false);
        startTest(secretNumbers.contains(new int[] {2,8,19,30}, 0), false);
    }

    public static void startTest(boolean result,boolean expected){
        if(result == expected){ 
         System.out.println(ANSI_GREEN +"SUCCESS \u2713"+ ANSI_RESET);
        } else { System.out.println(ANSI_RED + "FAIL \u2717" + ANSI_RESET);}
    }

    public static void startTest(int result,int expected){
        if(result == expected){ 
            System.out.println(ANSI_GREEN +"SUCCESS \u2713"+ ANSI_RESET);
        } else { System.out.println(ANSI_RED + "FAIL \u2717" + ANSI_RESET);}
    }

    public static void startTest(String result,String expected){
        if(result.equals(expected)){ 
            System.out.println(ANSI_GREEN +"SUCCESS \u2713"+ ANSI_RESET);
        } else { System.out.println(ANSI_RED + "FAIL \u2717" + ANSI_RESET);}
    }

    public static int testTryNumbers (int [] secretNumbers,int number){
        secretNumbers secrets = new secretNumbers(3, 1, 10);
        secrets.secretNumberArray = secretNumbers;
        return secrets.tryNumbers(number);
    }
}