import java.util.Arrays;
import java.util.Scanner;

public class ArraySortingAndStatistic {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("So luong phan tu: ");
            int n = sc.nextInt();
            int[] myArray = new int[n];
            System.out.println("Nhap phan tu:");
            for (int i = 0; i < n; i++) {
                System.out.print("Phan tu tai index " + i + ": ");
                myArray[i] = sc.nextInt();
            }
            Arrays.sort(myArray);
            int sum = 0;
            for (int num : myArray) {
                System.out.print(num + " ");
                sum += num;
            }
            System.out.println();
            double average = (double) sum / n;
            System.out.printf("Gia tri TB: %.2f\n", average);
            sc.close();
        }
    }
}
