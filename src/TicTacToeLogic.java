public class TicTacToeLogic {
    private final String[][] BOARD;

    public TicTacToeLogic() {
        BOARD = new String[3][3];
    }

    public String[][] getBOARD() {
        return BOARD;
    }

    //returns false if invalid move, returns true if valid
    public boolean updateBoard(int x, int y, boolean playerOne) {
        if(x < 1 || x > 3) return false;
        if(y < 1 || y > 3) return false;
        if(BOARD[y-1][x-1] != null) return false; //check if cell has already been used

        if(playerOne) {
            BOARD[y-1][x-1] = "X";
        } else {
            BOARD[y-1][x-1] = "O";
        }

        return true;
    }

    public boolean winner() {
        return checkHorizontalWinner() ||
               checkVerticalWinner() ||
               checkLeftDiagonal() ||
               checkRightDiagonal();
    }

    private boolean checkHorizontalWinner() {
        for (int row = 0; row < 3; row++) {
            if(BOARD[row][0] != null &&
               BOARD[row][0].equals(BOARD[row][1]) &&
               BOARD[row][1].equals(BOARD[row][2])
            ) return true;
        }
        return false;
    }

    private boolean checkVerticalWinner() {
        for (int col = 0; col < 3; col++) {
            if(BOARD[0][col] != null &&
               BOARD[0][col].equals(BOARD[1][col]) &&
               BOARD[1][col].equals(BOARD[2][col])
            ) return true;
        }
        return false;
    }

    private boolean checkRightDiagonal() {
        return BOARD[0][0] != null &&
               BOARD[0][0].equals(BOARD[1][1]) &&
               BOARD[1][1].equals(BOARD[2][2]);
    }

    private boolean checkLeftDiagonal() {
        return BOARD[0][2] != null &&
               BOARD[0][2].equals(BOARD[1][1]) &&
               BOARD[1][1].equals(BOARD[2][0]);
    }

}
