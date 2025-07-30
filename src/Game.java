import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //String[][] test = {{null, null, "X"},{null, null, "X"},{null, null, "X"}};
        TicTacToeLogic tic = new TicTacToeLogic();

        boolean playerOne = true;
        boolean gameOver = false;
        String player = "Player One";

        while(!gameOver) {
            Board.display(tic.getBoard());
            System.out.println();
            System.out.println(player + "'s turn");

            boolean validInput = false;

            //TODO move this logic into a method to make the game loop easier
            //TODO when invalid display a message as such
            while(!validInput){
                int x;
                int y;
                Scanner input = new Scanner(System.in);
                System.out.print("Enter X: ");
                x = input.nextInt();
                System.out.print("Enter Y: ");
                y = input.nextInt();

                if(tic.updateBoard(x,y, playerOne)) {
                    validInput = true;
                }
            }

            if(tic.winner()) {
                Board.display(tic.getBoard());
                System.out.println(player + " is the winner!");
                gameOver = true;
            }

            playerOne = !playerOne;
            player = playerOne ? "Player One" : "Player Two";


        }

    }

}
