import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== Event Check-In Results =====");

        Set<String> registered = new LinkedHashSet<>();

        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));

        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();
            registered.add(line);
        }

        sc1.close();

        Set<String> checkedIn = new LinkedHashSet<>();
        List<String> results = new ArrayList<>();

        int rejectedAttempts = 0;

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        while (sc2.hasNextLine()) {

            String line = sc2.nextLine();

            if (!registered.contains(line)) {
                results.add(line + ": Rejected (not registered)");
                rejectedAttempts++;
            } 
            
            else if (checkedIn.contains(line)) {
                results.add(line + ": Rejected (already checked in)");
                rejectedAttempts++;
            } 
            
            else {
                checkedIn.add(line);
                results.add(line + ": Checked in");
            }
        }

        sc2.close();

        for (String result : results) {
            System.out.println(result);
        }
        
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students : " + registered.size());
        System.out.println("Successful check-ins : " + checkedIn.size());
        System.out.println("Absent students : " + (registered.size() - checkedIn.size()));
        System.out.println("Rejected attempts : " + rejectedAttempts);
    }
}