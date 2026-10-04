import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Problem 1
        List<String> playlist = new ArrayList<>();

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while (scanner.hasNext()) {
            String operation = scanner.next();

            if (operation.equals("ADD")) {
                String song = scanner.nextLine().trim();
                playlist.add(song);
            }

            else if (operation.equals("INSERT")) {
                int index = scanner.nextInt();
                String song = scanner.nextLine().trim();
                playlist.add(index, song);
            }

            else if (operation.equals("REMOVE")) {
                String song = scanner.nextLine().trim();
                playlist.remove(song);
            }
        }

        scanner.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        System.out.println();


        // Problem 2
        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;

        scanner = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        while (scanner.hasNext()) {
            String name = scanner.next();

            if (participants.contains(name)) {
                duplicates++;
            }

            else {
                participants.add(name);
            }
        }

        scanner.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int number = 1;

        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println("Duplicate registrations: " + duplicates);
        System.out.println();


        // Problem 3
        Map<String, Integer> stock = new LinkedHashMap<>();
        int failedSales = 0;

        scanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        while (scanner.hasNext()) {
            String type = scanner.next();
            String product = scanner.next();
            int quantity = scanner.nextInt();

            if (type.equals("ADD")) {
                if (stock.containsKey(product)) {
                    stock.put(product, stock.get(product) + quantity);
                }

                else {
                    stock.put(product, quantity);
                }
            }

            else if (type.equals("SELL")) {
                if (stock.containsKey(product) && stock.get(product) >= quantity) {
                    stock.put(product, stock.get(product) - quantity);
                }

                else {
                    failedSales++;
                }
            }
        }

        scanner.close();

        System.out.println("===== Problem 3 =====");

        for (String product : stock.keySet()) {
            System.out.println(product + ": " + stock.get(product));
        }

        System.out.println("Failed sales: " + failedSales);
    }
}