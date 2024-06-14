import java.util.Random;
import java.util.Scanner;

class GuessNumber{

    private int genererated_num=0;
    private final int MAX_COUNT =10;
    private int count ;

    GuessNumber(){
        System.out.println("Welcome to  Number Guess Game :");
    }
    private void generateNum(){
       genererated_num= new Random().nextInt(100)+1;
       System.out.println(" <<< Secret  generated Number: "+ genererated_num+" >>>>");
    }

    private void guessNumber(){
       
        int user_guess=-1;
      while (user_guess != genererated_num) {
        user_guess = getNumber();
        count ++;
        if (user_guess < genererated_num) {
            System.out.println(" Comments: ^^^ Guess value higher than the last guess ^^^");
        }else{
            System.out.println(" Comments: vvv Guess value less than you last guess vvv ");
        }
      }  
      System.out.println("Woorahh!!!!, you successfully guessed the number "+ genererated_num+ " at "+ count +" attempts :) ");
      System.out.println("\n your score : "+((int) (((double) (MAX_COUNT - count) / MAX_COUNT) * 100)+10) +"%");
    }

    private int getNumber(){
        System.out.println(">>> Enter your guess (range 0 ->100 ): ");
        Scanner in = new Scanner(System.in);
        
        int n =-1;
        try {
        n = in.nextInt();
        if (n>=0 && n<= 100) {
            return n;
        }else{
            System.out.println("**** Enter number within a range ****");
            return getNumber();
        }

        } catch (Exception e) {
            System.out.println("#### Enter number only ####");
            generateNum();
        }
        return n;
    }

    public void startGame(){
        count =0;
        generateNum();
        boolean f = true;
        do {
           guessNumber();
           System.out.println("???? Do you like to play again (yes or no ) ????");
           String s = new Scanner(System.in).nextLine();
           System.out.println(s);
           f = (s.equalsIgnoreCase("yes")) ? true : false;
            if (f) {
                generateNum();
            count =0;
            }else{
                System.out.println("Thank you for playing");
            }
        } while (f);
    }
    
}
public class NumberGame {
 public static void main(String[] args) {
    GuessNumber gn = new GuessNumber();
    gn.startGame();
 }   
}
