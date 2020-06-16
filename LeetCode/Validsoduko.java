import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class Validsoduko {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner y = new Scanner(new FileReader("test.txt"));

        char[][] ar = new char[9][9];
        for (int i = 0; i < 9; i++) {
            ar[i] = y.nextLine().toCharArray();

        }

        System.out.println(isValidSudoku(ar));

    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            cols[i] = col;
            boxes[i] = box;
        }
        for (int row = 0; row < boxes.length; row++) {
            HashSet<Character> rowchars = new HashSet<>();
            for (int col = 0; col < boxes.length; col++) {
                char c = board[row][col];
                if (c == '.')
                    continue;
                if (rowchars.contains(c) || cols[col].contains(c) || boxes[(3 * (row / 3)) + (col / 3)].contains(c))
                    return false;
                else {
                    rowchars.add(c);
                    cols[col].add(c);
                    boxes[(3 * (row / 3)) + (col / 3)].add(c);
                }
            }
        }
        return true;
    }
}