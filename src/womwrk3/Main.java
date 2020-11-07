package womwrk3;



import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        Scanner vibor = new Scanner(System.in);//сканер для введения варианта захода игры или отмены компиляции и закрытия программы
        Scanner wordSc = new Scanner(System.in);//сканнер для воода слов
        Random randomGenerator = new Random();
        StringBuilder displayWord = new StringBuilder("______________________________");
        String theWord = null;
        String preLetter;

        char letter = 0;
        int randomNumber;
        int lengthOfWord;
        int numberOfLetterInWord = 0;
        int GuessLeft;// переменная считающая количество попыток
        int guessWordNumber = 0;//для запуска игры
        String guessWord;
//int test=0;
        RandomWord troll = new RandomWord();//создание метода
        randomNumber = randomGenerator.nextInt(12);

        theWord = troll.wordDecide(randomNumber);

        System.out.println ("Welcome to GuessGame!");

        lengthOfWord=theWord.length( );
        System.out.println("This word has " + lengthOfWord + " letters.");

        System.out.println("You have 16 guesses.");
        do {

            // for (int g = 15; g >= 0; g--)//цикл прогоняющий количество попыток где попыток не может быть меньше нуля
            // {

            System.out.println("If you want to guess the word, type 1. Else press other number ");

            guessWordNumber = vibor.nextInt();


            if (guessWordNumber == 1)//если пользователь решает запустить игру — нажимает 1
            {
                System.out.println("Enter the word now. Remember, don't capitalize it.");
                guessWord = wordSc.nextLine();// проихводится ввод слова
                if (guessWord.equals(theWord))//сдучай угадывания слова
                {
                    System.out.println("YOU WIN");
                    System.exit(0);//выход из игры
                } else //если не угадал
                {
                    System.out.println("Sorry, this wasn't the correct word. Press 1 if you want to continue ");
                }


                System.out.println("");
                System.out.println("The word so far is " + displayWord);
                System.out.println("");
                // GuessLeft = g + 1;
                // System.out.println("You have " + GuessLeft + " guesses left.");
/*
                    if (GuessLeft == 3) {
                        System.out.println("Sorry, you are (JI O X).");

                    }

                    if (GuessLeft == 1) {
                        System.out.println("You are the worst guess gamer ever... Dont play this game plssss....");
                    }

 */
                char[] charsAnswer = guessWord.toCharArray();
                for (int j = 0; j < lengthOfWord; j++) {
                    if (j >= charsAnswer.length) {
                        break;
                    }
                    if (theWord.charAt(j) != charsAnswer[j]) {
                        charsAnswer[j] = '#';

                    }
                    StringBuilder comment = new StringBuilder(String.valueOf(charsAnswer));
                    for (int i = comment.length(); i < 15; i++) {
                        comment.append("#");


                    }
                    System.out.println(comment);

                }

            } else {
                System.exit(0);//любая другая кнопка кроме единицы вызывает выход из программы
                System.out.println("GAME OVER");
                System.exit(0);

            }

            // }

        } while(true);
    }



}






class RandomWord {
    private static String[] wordArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public String wordDecide(int randomNumber) {
        String theWord;
        theWord = wordArray[randomNumber];
        return theWord;
    }

}