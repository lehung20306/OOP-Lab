import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("first number:");
        double a = sc.nextDouble();
        System.out.print("second number:");
        double b = sc.nextDouble();
        double sum = a + b;
        double difference = a - b;
        double product = a * b;
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        if(b != 0) {
            double quotient = a / b;
            System.out.println("Quotient: " + quotient);
        }
        else {
            System.out.println("Quotient: No result");
        }
        sc.close();
    }
}
