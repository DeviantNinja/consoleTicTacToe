public class TicTacToeLogic {
    private String[][] board;

    public TicTacToeLogic() {
        initialize();
    }

    public String[][] getBoard() {
        return board;
    }

    private void initialize() {
        board = new String[][]{{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};
    }

    //returns false if invalid move, returns true if valid
    public boolean updateBoard(int x, int y, boolean playerOne) {
        if(x < 1 || x > 3) return false;
        if(y < 1 || y > 3) return false;
        if(!board[y-1][x-1].equals(" ")) return false; //check if cell has already been used

        if(playerOne) {
            board[x-1][y-1] = "X";
        } else {
            board[x-1][y-1] = "O";
        }

        return true;
    }

    public boolean checkWinner() {
        if(checkHorizontalWinner()) return true;
        if(checkVerticalWinner()) return true;
        if(checkRightDiagonal()) return true;
        if(checkLeftDiagonal()) return true;
        return false;
    }
    //TODO need to change the check conditions as currently will win even if its just spaces.
    //TODO check if the X and Y are the wrong way around.
    //TODO should use .equals() with Stringss
    private boolean checkHorizontalWinner() {
        for (int row = 0; row < 3; row++) {
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2]) return true;
        }
        return false;
    }
    //TODO need to change the check conditions as currently will win even if its just spaces.
    private boolean checkVerticalWinner() {
        for (int col = 0; col < 3; col++) {
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col]) return true;
        }
        return false;
    }
    //TODO need to change the check conditions as currently will win even if its just spaces.
    private boolean checkRightDiagonal() {
        return board[0][0] == board[1][1] && board[1][1] == board[2][2];
    }
    //TODO need to change the check conditions as currently will win even if its just spaces.
    private boolean checkLeftDiagonal() {
        return board[0][2] == board[1][1] && board[1][1] == board[2][0];
    }

}
