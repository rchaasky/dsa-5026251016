
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }

        sc.close();

        int passes = 3;

        for (int i = 1; i <= passes; i++) {

            int key = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] < key) {
                A[j + 1] = A[j];
                j--;
            }

            A[j + 1] = key;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(A[i]);

            if (i < N - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        for (int i = 0; i < M; i++) {

            int target = targets[i];
            int idx = -1;

            for (int j = 0; j < N; j++) {
                if (A[j] == target) {
                    idx = j;
                    break;
                }
            }

            if (idx != -1) {
                System.out.println(target + ": FOUND at index " + idx);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
    }
}
