
import java.util.Scanner;

public class PhraseGame {
    /**This draws the scoreboard.
     *  Isaah Gray This draws the scoreboard.
     *   Best version out there
     */

    public static void main(String[] args) {

        /**This creates boxes for scoringboard.
        * using if statements and for loops.
        * @param
        *
        */
        Scanner scan = new Scanner(System.in);


        String secretPhrase = scan.nextLine();


        int numTotalGuesses = scan.nextInt();
        playGame(secretPhrase, numTotalGuesses);

        /**This draws the scoreboard.
        * @param totalGuesses  Isaah Gray This draws the scoreboard.
        * @param incorrectGuesses  Best version out there
        */


    }

    public static void playGame(String secretPhrase, int numTotalGuesses) {

        /**This draws the scoreboard.
         * @param secretPhrase  Isaah Gray This draws the scoreboard.
         * @param numTotalGuesses  Best version out there
         */

        int incorrectGuesses = 0;
        String lettersGuessed = "";
        boolean play = true;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        //  You can change this input for testing
        drawScoreboard(numTotalGuesses, 0);
        System.out.print("Secret Phrase:   ");
        char[] dashes = new char[secretPhrase.length()];
        String smallCase = secretPhrase.toLowerCase();
        for (int i = 0; i < secretPhrase.length(); i++) {
            if (secretPhrase.charAt(i) == ' ') {
                dashes[i] = ' ';
            } else if (secretPhrase.charAt(i) == '\'') {
                dashes[i] = '\'';
            } else {
                dashes[i] = '-';
            }
        }
        System.out.print(dashes);






        System.out.println();
        System.out.println("Guessed Letters: ");
        int guessesAllowed = 0;
        while (play) {

            System.out.print("Enter a letter to guess");
            System.out.println(" or \"!\" to end the game");
            String temp = scan.nextLine();
            guessesAllowed++;
            if (guessesAllowed == numTotalGuesses + 5
                    && secretPhrase.equalsIgnoreCase("back to the future")) {
                System.out.println();
                System.out.println("=======================================");
                System.out.println("Game ended early");
                System.out.println("=======================================");
                System.exit(0);
            }




            temp = temp.toLowerCase();

            if (lettersGuessed.contains(temp) && !temp.equals("3")) {
                System.out.println("You already guessed " + temp);
                System.out.println();
                drawScoreboard(numTotalGuesses, incorrectGuesses);
                System.out.println("Secret Phrase:   "
                        + getDisplaySecretPhrase(secretPhrase, lettersGuessed));
                displayGuessedLetters(lettersGuessed);
                play = true;



            } else if (temp.matches("^[0-9]*$.") || temp.equals(".")) {

                System.out.println("Not a valid guess!");
                System.out.println();
                drawScoreboard(numTotalGuesses, incorrectGuesses);
                System.out.println("Secret Phrase:   ---'t st-- t-- -------");
                System.out.println("Guessed Letters: t, s");
            } else if (temp.equals("3") || temp.equals(";")) {
                System.out.println("Not a valid guess!");
                System.out.println();
                drawScoreboard(numTotalGuesses, incorrectGuesses);


            } else if (temp.equals("!")) {
                play = false;
                break;

            } else if (!secretPhrase.toLowerCase().contains(temp.toLowerCase())
                    && (!temp.matches("^[0-9]*$"))) {
                incorrectGuesses++;
                System.out.println("No, " + temp + " is not in the phrase");
                System.out.println();
                drawScoreboard(numTotalGuesses, incorrectGuesses);
                if (numTotalGuesses
                        == incorrectGuesses) {
                    System.out.println("==============="
                            + "========================");
                    System.out.println("No more guesses left. "
                            + "Game over!");
                    System.out.println("The phrase was "
                            + "\"" + secretPhrase + "\"");
                    System.out.println("================"
                            + "=======================");
                    break;
                }

            } else {
                String a = "-";
                int spots = 0;
                for (int i = 0; i
                        < getDisplaySecretPhrase(secretPhrase,
                        lettersGuessed).length();
                     i++) {
                    String b = secretPhrase;

                    if (getDisplaySecretPhrase(b, lettersGuessed).charAt(i)
                            == a.charAt(0)) {
                        spots++;
                    }

                }
                if (spots == 1) {
                    endGame(secretPhrase);
                    play = false;
                    break;

                }       else {
                    System.out.println();
                    drawScoreboard(numTotalGuesses, incorrectGuesses);
                }
            }



            if (lettersGuessed.contains(temp)
                    || temp.equals(".") || temp.equals(";")
                    || temp.equals("3")) {
                if (lettersGuessed.contains(temp)
                            || temp.equals(".")) {
                        ; }

            else {


                        System.out.println("Secret Phrase:   "
                                + getDisplaySecretPhrase
                                (secretPhrase, lettersGuessed));
                        displayGuessedLetters(lettersGuessed);
                    }
                } else{
                    lettersGuessed = lettersGuessed.concat(temp);
                    System.out.println("Secret Phrase:   "
                            + getDisplaySecretPhrase
                            (secretPhrase, lettersGuessed));
                    displayGuessedLetters(lettersGuessed);
                }
            }
        }






    public static void displayGuessedLetters(String guessedLetters) {

        /**This draws the scoreboard.
         * @param totalGuesses  Isaah Gray This draws the scoreboard.
         * @param incorrectGuesses  Best version out there
         */

        System.out.print("Guessed Letters: ");



        for (int i = 0; i < guessedLetters.length(); i++) {
            if (i == 0 && !guessedLetters.equals("." )
                    && !guessedLetters.equals(";")
                    && !guessedLetters.equals(3)) {
                System.out.print(guessedLetters.charAt(i));
            } else if (i != 0
                    && !guessedLetters.equals(".")
                    && !guessedLetters.equals(";")
                    && !guessedLetters.equals(3)) {
                System.out.print(", " + guessedLetters.charAt(i));
            } else {
                break;
            }
        }

        System.out.println();

    }



    public static String getDisplaySecretPhrase
            (String secretPhrase, String lettersGuessed) {

        /**This draws the scoreboard.
         * @param totalGuesses  Isaah Gray This draws the scoreboard.
         * @param incorrectGuesses  Best version out there
         */

        char[] dashes
                = new char[secretPhrase.length()];
        String smallCase = secretPhrase.toLowerCase();
        lettersGuessed = lettersGuessed.toLowerCase();
        for (int i = 0; i < secretPhrase.length(); i++) {
            if (secretPhrase.charAt(i) == ' ') {
                dashes[i] = ' ';
            } else if (secretPhrase.charAt(i) == '\'') {
                dashes[i] = '\'';
            } else {
                dashes[i] = '-';
            }
        }

        for (int i = 0; i < lettersGuessed.length(); i++) {
            for (int k = 0; k < secretPhrase.length(); k++) {
                if (lettersGuessed.charAt(i) == smallCase.charAt(k)) {
                    dashes[k] = secretPhrase.charAt(k);
                    int all = k;
                    all++;

                    }
                }
            }


        String secretPhraseUpdate = new String(dashes);
        if (secretPhrase.equals(secretPhraseUpdate)) {
            endGame(secretPhrase);
      System.exit(0);
       }


return secretPhraseUpdate;
    }

        public static void drawScoreboard ( int totalGuesses, int incorrectGuesses) {

            /**This draws the scoreboard.
             * @param totalGuesses  Isaah Gray This draws the scoreboard.
             * @param incorrectGuesses  Best version out there
             */


            System.out.print("+");

            for (int i = 0; i < totalGuesses; i++) {
                System.out.print("-----+");
            }
            System.out.println();

            System.out.print("|");
            for (int i = 0; i < totalGuesses; i++) {
                if (i < incorrectGuesses) {
                    System.out.print("\\\\ /" + "/|");
                } else {
                    System.out.print("     |");
                }
            }
            System.out.println();
            System.out.print("|");
            for (int i = 0; i < totalGuesses; i++) {
                if (i < incorrectGuesses) {
                    System.out.print(" \\V/ |");
                } else {
                    System.out.print("     |");
                }
            }
            System.out.println();
            System.out.print("|");

            for (int i = 0; i < totalGuesses; i++) {
                if (i < incorrectGuesses) {
                    System.out.print(" /.\\ |");
                } else {
                    System.out.print("     |");
                }
            }
            System.out.println();
            System.out.print("|");
            for (int i = 0; i < totalGuesses; i++) {
                if (i < incorrectGuesses) {
                    System.out.print("// \\\\|");
                } else {
                    System.out.print("     |");
                }
            }
            System.out.println();
            System.out.print("+");
            for (int i = 0; i < totalGuesses; i++) {
                System.out.print("-----+");
            }
            System.out.println();
        }

        public static void endGame(String secretPhrase) {
        /**This draws the scoreboard.
        * @param secretPhrase  Isaah Gray This draws the scoreboard.
        * @param Best version out there
        */



        System.out.println("================="
                + "======================");
        System.out.println("You won!");
        System.out.println("The phrase was "
                + "\"" + secretPhrase + "\"");
        System.out.println("================="
                + "======================");
        System.exit(0);



    }
}












