import java.util.Scanner;
public class AddMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arrA = new int[100][100];
        int[][] arrB = new int[100][100];

        System.out.println("Enter size m x n of matrix A[m][n]:");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println("Enter matrix A:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                arrA[i][j] = scanner.nextInt();
            }
        System.out.println("Enter matrix B:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                arrB[i][j] = scanner.nextInt();
            }
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                arrA[i][j] += arrB[i][j];
            }
        
        System.out.println("Result:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arrA[i][j] + " ");
            }
            System.out.print("\n");
        }
    System.exit(0);
    }
}
