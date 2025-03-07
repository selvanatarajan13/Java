import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindLuckyNumberMatrix {

    public List<Integer> luckyNumber(int[][] matrix) {

        int row = matrix.length;
        int cols = matrix[0].length;

        System.out.println("The given matrix row size : " + row);
        System.out.println("The given matrix coln size : " +cols);
        System.out.println();
        System.out.println("Matrix : ");
        // display the matrix
        for (int i=0; i<row; i++) {
            for (int j=0; j<cols; j++) {
                System.out.print(matrix[i][j] + "    ");
            }
            System.out.println();
        }
        System.out.println();

        // find the minimum number in the row
        int rMin;
        List<Integer> rowMin = new ArrayList<>();
        for (int i=0; i<row; i++) {
            rMin = matrix[i][0];
            for (int j=0; j<cols; j++) {
                rMin = Math.min(rMin, matrix[i][j]);
            }
            rowMin.add(rMin);
        }

        System.out.println();
        for (int element : rowMin) {
            System.out.print(element + " ");
        }
        System.out.println();

        // find the maximum number in the column
        int cMax;
        List<Integer> colMax = new ArrayList<>();
        for (int j=0; j<cols; j++) {
            cMax = matrix[0][j];
            for (int i=0; i<row; i++) {
                cMax = Math.max(cMax, matrix[i][j]);
            }
            colMax.add(cMax);
        }


        // find the lucky number
        List<Integer> luckyNumber = new ArrayList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<cols; j++) {
                if (matrix[i][j] == rowMin.get(i) && matrix[i][j]==colMax.get(j)) {
                    luckyNumber.add(matrix[i][j]);
                }
            }
        }

        System.out.print("The given matrix lucky numbers are : " + luckyNumber);
        return luckyNumber;
    }
}
