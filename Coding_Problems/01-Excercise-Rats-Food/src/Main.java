import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int rats = 7, unit = 2, n = 8;
        int[] arr = {2,8,3,5,7,4,1,2};
        minimumFoodRequiredForRats(rats,unit,n,arr);


        int[][] matrix = {{3,7,8},{9,11,13},{15,14,17}};
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];

        int res;
        for (int i=0; i<3;i++) {
            res = matrix[i][0];
            for (int j=0; j<3;j++) {
                res = Math.min(res, matrix[i][j]);
            }
            arr1[i] = res;
        }

        for (int j=0; j<3; j++) {
            res = matrix[j][0];
            for (int i=0; i<3; i++) {
                res = Math.max(res,matrix[i][j]);
            }
            arr2[j] = res;
        }

        for (int element : arr1) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int element : arr2) {
            System.out.print(element + " ");
        }

        System.out.println();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (arr1[j] == arr2[i] ) {
                    System.out.println("Lucky number is : " + arr1[j]);
                }
            }
        }

        //findLuckyNumber(matrix);
    }

    private static void findLuckyNumber(int[][] matrix) {
        int[] arr1 = new int[3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(matrix[i][j]+"  ");
                int res = matrix[i][0];
                res = Math.min(res, matrix[i][j]);
                arr1[i] = res;
            }
            System.out.println();
        }

        System.out.println();
        for (int element : arr1) {
            System.out.print(element + " ");
        }
    }

    private static void minimumFoodRequiredForRats(int rats, int unit, int n, int[] arr) {

        int totalUnitFood = rats * unit;
        int sum = 0;
        int count = 0;

        for (int i=0; i<n; i++) {
            sum = sum + arr[i];
            count += 1;
            if (sum >= totalUnitFood) {
                System.out.println(count);
                break;
            }
        }
    }
}