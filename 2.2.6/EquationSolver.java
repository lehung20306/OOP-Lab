import java.util.Scanner;

public class EquationSolver {
    public static void solve1(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("infinite solutions");
            }
            else {
                System.out.println("no solution");
            }
        }
        else {
            double rs = - b / a;
            System.out.println("x = " + rs);
        }
    }

    public static void solve2(double a11, double a12, double b1, double a21, double a22, double b2) {
        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;
        if (d != 0) {
            System.out.println("x1 = " + d1 / d);
            System.out.println("x2 = " + d2 / d);
        }
        else {
            if (d1 == 0 && d2 == 0) {
                System.out.println("infinite solutions");
            }
            else {
                System.out.println("no solution");
            }
        }
    }

    public static void solve3(double a, double b, double c) {
        if (a == 0) {
            solve1(b, c);
        }
        else {
            double denta = b * b - 4 * a * c;
            if (denta > 0) {
                double no1 = (- b + Math.sqrt(denta)) / (2 * a);
                double no2 = (- b - Math.sqrt(denta)) / (2 * a);
                System.out.println("x = " + no1 + " or x = " + no2);
            }
            else if (denta == 0) {
                System.out.println("x = " + (- b / (2 * a)));
            }
            else {
                System.out.println("no solution");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Linear equation ax + b = 0");
        System.out.println("2. Linear system a11x1 + a12x2 = b1  a21x1 + a22x2 = b2");
        System.out.println("3. Quadratic equation ax^2 + bx + c = 0");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("a:");
            double a = sc.nextDouble();
            System.out.println("b:");
            double b = sc.nextDouble();
            solve1(a, b);
        }
        else if (choice == 2) {
            System.out.println("a11:");
            double a11 = sc.nextDouble();
            System.out.println("a12:");
            double a12 = sc.nextDouble();
            System.out.println("b1:");
            double b1 = sc.nextDouble();
            System.out.println("a21:");
            double a21 = sc.nextDouble();
            System.out.println("a22:");
            double a22 = sc.nextDouble();
            System.out.println("b2:");
            double b2 = sc.nextDouble();
            solve2(a11, a12, b1, a21, a22, b2);
        }
        else if (choice == 3) {
            System.out.println("a:");
            double a = sc.nextDouble();
            System.out.println("b:");
            double b = sc.nextDouble();
            System.out.println("c:");
            double c = sc.nextDouble();
            solve3(a, b, c);
        }
        else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
