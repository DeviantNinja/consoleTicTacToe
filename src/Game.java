import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        TicTacToeLogic tic = new TicTacToeLogic();
        boolean isPlayerOne = true;
        boolean gameOver = false;
        String player = "Player One";


        while(!gameOver) {
            Board.display(tic.getBoard());
            System.out.println();
            System.out.println(player + "'s turn");

            makeMove(isPlayerOne, tic);

            if(tic.winner()) {
                Board.display(tic.getBoard());
                System.out.println(player + " is the winner!");
                gameOver = true;
            }

            isPlayerOne = !isPlayerOne;
            player = isPlayerOne ? "Player One" : "Player Two";
        }
    }

    public static void makeMove(boolean isPlayerOne, TicTacToeLogic tic) {
        int x = getInput("x");
        int y = getInput("y");
        validateMove(x,y,isPlayerOne,tic);
    }

    public static int getInput(String corinate) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter %s : ",corinate);
        while (!input.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number between 1-3: ");
            input.next();
        }
        return input.nextInt();
    }

    public static void validateMove(int x, int y, boolean isPlayerOne, TicTacToeLogic tic) {
        boolean validMove = tic.updateBoard(x,y,isPlayerOne);
        if(!validMove) {
            System.out.println("Invalid Move");
            makeMove(isPlayerOne, tic);
        }
    }

}
