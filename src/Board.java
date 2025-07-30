public class Board {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void display(String[][] game) {


        for (int row = 1; row <= 3; row++) {
            System.out.println("   +---+---+---+");
            System.out.printf(" %d | %s | %s | %s |%n", row, decorator(game[row-1][0]), decorator(game[row-1][1]), decorator(game[row-1][2]) );
        }
        System.out.println("   +---+---+---+");
        System.out.println("     1   2   3 ");

    }

    private static String decorator(String s){
        if(s == null) {
            s = " ";
        }
        return switch (s) {
            case "O" -> BLUE + s + RESET;
            case "X" -> RED + s + RESET;
            default -> s;
        };
    }
}
