import java.util.Scanner;
public class Triangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int n, k = 0;
        System.out.printf("Enter n: ");
        n = keyboard.nextInt();
        for (int i = 1; i <= n; ++i, k = 0) {
            for (int j = 1; j <= n - i; ++j) {
                System.out.print(" ");
            }
            while (k != 2 * i - 1) {
                System.out.print("*");
                ++k;
            }
        System.out.println();
        }
    System.exit(0);
    }
}