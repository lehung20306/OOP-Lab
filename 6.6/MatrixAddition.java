import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of rows:");
        int rows = sc.nextInt();
        System.out.println("Number of columns:");
        int cols = sc.nextInt();
        int[][] a = new int [rows][cols];
        int[][] b = new int [rows][cols];
        int[][] c = new int [rows][cols];
        System.out.println("Enter elements for Matrix a:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter elements for Matrix b:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                b[i][j] = sc.nextInt();
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println("Sum:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
