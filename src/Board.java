public class Board {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void display(String[][] game) {
        System.out.println("     1   2   3 ");
        System.out.println("   +---+---+---+");

        for (int row = 1; row <= 3; row++) {
            System.out.printf(" %d | %s | %s | %s |%n", row, decorator(game[row-1][0]), decorator(game[row-1][1]), decorator(game[row-1][2]) );
            System.out.println("   +---+---+---+");
        }
    }

    private static String decorator(String s){
        switch(s) {
            case "O":
                return BLUE + s + RESET;
            case "X":
                return RED + s + RESET;
            default:
                return s;
        }
    }
}
