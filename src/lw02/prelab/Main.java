import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while (sc.hasNext()) {
            String name = sc.next();
            String type = sc.next();
            String amount = sc.next();

            String[] transaction = {name, type, amount};
            transactions.add(transaction);

            boolean exists = false;

            for (String[] customer : customers) {
                if (customer[0].equals(name)) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                customers.add(new String[]{name, "0"});
            }
        }

        Queue<String[]> queue = new LinkedList<>();

        while (!transactions.isEmpty()) {
            queue.offer(transactions.removeFirst());
        }

        Stack<String[]> failedTransactions = new Stack<>();

        while (!queue.isEmpty()) {
            String[] transaction = queue.poll();

            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (String[] customer : customers) {
                if (customer[0].equals(name)) {

                    int balance = Integer.parseInt(customer[1]);

                    if (type.equals("DEPOSIT")) {
                        balance += amount;
                        customer[1] = String.valueOf(balance);
                    } 
                    else if (type.equals("WITHDRAW")) {

                        if (amount > balance) {
                            failedTransactions.push(transaction);
                        } 
                        else {
                            balance -= amount;
                            customer[1] = String.valueOf(balance);
                        }
                    }

                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");

        for (String[] customer : customers) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println();

        System.out.println("=== Failed Transactions ===");

        while (!failedTransactions.isEmpty()) {
            String[] transaction = failedTransactions.pop();

            System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2]);
        }
    }
}