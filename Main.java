import java.util.*;
class NumberGuessingGame {
    private int number;
    private int maxAttempts;
    private Scanner sc;
    private List<Integer> guesses;
    public NumberGuessingGame(int maxAttempts, Scanner sc) {
        this.maxAttempts = maxAttempts;
        this.sc = sc;
        Random r = new Random();
        this.number = r.nextInt(100) + 1;
        this.guesses = new ArrayList<>();
    }
    public int startGame() {
        System.out.println("\n WELCOME TO NUMBER GUESSING GAME !!");
        System.out.println("Guess a number between 1 and 100");
        int lowerHint = Math.max(1, number - 5);
        int  upperHint = Math.min(100, number + 5);
        System.out.println("Hint: Number is between " + lowerHint + " and " + upperHint);
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("\nAttempt " + attempt + ": Enter your guess");
            int guess = sc.nextInt();
            guesses.add(guess);
            if (guess == number) { 
                System.out.println("Correct!! you guessed it in " + attempt +  " 
                attempts ");
                int score = maxAttempts - attempt + 1;
                System.out.println("Your score " +score);
                return score;
            }
            else if ( guess < number) {
                System.out.println("Too Low!!");
            }
            else{
                System.out.println("Too High !!");
            }
            System.out.println("Previous guesses : " + guesses);
            if (attempt == maxAttempts) {
                System.out.println("\n maximum attempts reached !!");
                System.out.println("Correct number was " + number);
                System.out.println(" Your score is 0 ");
            }
        }
        return 0;
    }
    }
    public class Main {
        public static void main (String args[]) {
            Scanner sc = new Scanner(System.in);
            char playAgain;
            int totalScore = 0;
            int rounds = 0;
            do {
                NumberGuessingGame game = new NumberGuessingGame(10, sc);
                int score = game.startGame();
                totalScore += score;
                rounds++;
                System.out.println("\n Do you want to play again ? (Y/N");
                playAgain = sc.next().charAt(0);
            }
            while(playAgain == 'Y' ||  playAgain == 'y');
            System.out.println("\n GAME OVER");
            System.out.println("Rounds played = " + rounds);
            System.out.println("Total score " + totalScore);
            sc.close();

        }

    }