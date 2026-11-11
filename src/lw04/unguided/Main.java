
import java.util.Scanner;

public class Main {

    static void bubbleSort(int[] arr, int passes) {
        for (int i = 0; i < passes; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static int binarySearch(int[] arr, int target, int[] steps) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            steps[0]++;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int N = sc.nextInt();
        int[] parcels = new int[N];

        for (int i = 0; i < N; i++) {
            parcels[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }

        sc.close();

        int[] afterTwoPasses = new int[N];

        bubbleSort(parcels, 2);

        for (int i = 0; i < N; i++) {
            afterTwoPasses[i] = parcels[i];
        }

        bubbleSort(parcels, N - 1);

        System.out.println("==== After 2 Passes ====");

        for (int i = 0; i < N; i++) {
            System.out.print(afterTwoPasses[i]);

            if (i < N - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println();

        System.out.println("==== Fully Sorted ====");

        for (int i = 0; i < N; i++) {
            System.out.print(parcels[i]);

            if (i < N - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println();

        System.out.println("==== Search Results ====");

        for (int i = 0; i < M; i++) {
            int target = targets[i];
            int[] steps = {0};

            int idx = binarySearch(parcels, target, steps);

            if (idx != -1) {
                System.out.println(target + ": FOUND at index " + idx
                        + " (steps: " + steps[0] + ")");
            } else {
                System.out.println(target + ": NOT FOUND"
                        + " (steps: " + steps[0] + ")");
            }
        }
    }
}
