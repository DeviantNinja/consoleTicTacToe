public class TicTacToeLogic {
    private String[][] board;

    public TicTacToeLogic() {
        board = new String[3][3];
    }

    public TicTacToeLogic(String[][] testBoard) {
        board = testBoard;
    }

    public String[][] getBoard() {
        return board;
    }

    //returns false if invalid move, returns true if valid
    public boolean updateBoard(int x, int y, boolean playerOne) {
        if(x < 1 || x > 3) return false;
        if(y < 1 || y > 3) return false;
        if(!board[y-1][x-1].equals(" ")) return false; //check if cell has already been used

        if(playerOne) {
            board[y-1][x-1] = "X";
        } else {
            board[y-1][x-1] = "O";
        }

        return true;
    }

    public boolean checkWinner() {
        return checkHorizontalWinner() ||
               checkVerticalWinner() ||
               checkLeftDiagonal() ||
               checkRightDiagonal();
    }

    private boolean checkHorizontalWinner() {
        for (int row = 0; row < 3; row++) {
            if(board[row][0] != null &&
               board[row][0].equals(board[row][1]) &&
               board[row][1].equals(board[row][2])
            ) return true;
        }
        return false;
    }

    private boolean checkVerticalWinner() {
        for (int col = 0; col < 3; col++) {
            if(board[0][col] != null &&
               board[0][col].equals(board[1][col]) &&
               board[1][col].equals(board[2][col])
            ) return true;
        }
        return false;
    }

    private boolean checkRightDiagonal() {
        return board[0][0] != null &&
               board[0][0].equals(board[1][1]) &&
               board[1][1].equals(board[2][2]);
    }

    private boolean checkLeftDiagonal() {
        return board[0][2] != null &&
               board[0][2].equals(board[1][1]) &&
               board[1][1].equals(board[2][0]);
    }

}
