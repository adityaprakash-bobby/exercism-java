package org.example;

/*
. O . X .
. X X O .
O O O X .
. X O X O
X O O O X
*/
public class Connect {


    public static boolean isTraverseLeftToRight(String[] board) {
        int boardSize = board.length;

        for (int i = 0; i < boardSize; i++) {
            String str = board[i].replace(" ", "");

            for (int j = 0; j < boardSize; j++) {
                System.out.print(str.charAt(j) + " ");
            }

            System.out.println();
        }

        return false;
    }

    public static void main(String[] args) {
        String[] input = {
                ". O . X .",
                " . X X O .",
                "  O O O X .",
                "   . X O X O",
                "    X O O O X",
        };

        isTraverseLeftToRight(input);
    }
}
