import java.util.Scanner;

public class NumberOfDaysInAMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int thang = sc.nextInt();
        int nam = sc.nextInt();
        if(thang < 1 || thang > 12){
            System.out.println("nhap sai");
            return;
        }
        if(thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12){
            System.out.println("31");
        }
        else if(thang == 2){
            if((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0){
                System.out.println("29");
            }
            else{
                System.out.println("28");
            }
        }
        else{
            System.out.println("30");
        }
        sc.close();
    }
}
