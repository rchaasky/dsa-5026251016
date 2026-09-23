package lw01.unguided;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(Main.class.getResourceAsStream("washes.txt"));

            int total = scanner.nextInt();
            WashService[] services = new WashService[total];

            for (int i = 0; i < total; i++) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                int units = scanner.nextInt();

                if (type.equals("MOTORCYCLE")) {
                    services[i] = new MotorcycleWash(id, days, units);
                } else if (type.equals("CAR")) {
                    services[i] = new CarWash(id, days, units);
                }
            }

            scanner.close();

            for (WashService service : services) {
                System.out.println(service.summary());
            }

        } catch (FileNotFoundException e) {
            System.out.println("washes.txt not found.");
        }
    }
}