import java.util.Scanner;

// ============================================================
// Add your imports here as you implement each solution, e.g.:
// import Arrays_and_Hashing.ContainsDuplicate;
// import Arrays_and_Hashing.TwoSum;
// import Two_Pointers.ValidPalindrome;
// ============================================================
import Arrays_and_Hashing.ContainsDuplicate;

/**
 * Blind 75 - Java Solutions  (MyMain.java)
 *
 * Menu-driven launcher for all 18 Blind 75 topic groups.
 * Pick a topic -> pick a problem -> see output.
 *
 * HOW TO ADD A NEW SOLUTION:
 *   1. Create YourSolution.java in the correct topic folder.
 *   2. Add the correct package declaration at the top of that file.
 *   3. Add a static run() and main() method to your solution file.
 *   4. Import it here and wire it into the topic's method below.
 */
public class MyMain {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printTopicMenu();
            int topic = readInt("Select a topic (0 to exit): ");
            if (topic == 0) {
                System.out.println("\nGoodbye! Keep grinding!\n");
                break;
            }
            handleTopic(topic);
        }
        sc.close();
    }

    // -------------------------------------------------------------------------
    //  TOP-LEVEL TOPIC MENU
    // -------------------------------------------------------------------------
    static void printTopicMenu() {
        System.out.println("\n==============================================");
        System.out.println("         BLIND 75 -- TOPIC SELECTOR          ");
        System.out.println("==============================================");
        System.out.println("  01. Arrays & Hashing");
        System.out.println("  02. Two Pointers");
        System.out.println("  03. Sliding Window");
        System.out.println("  04. Stack");
        System.out.println("  05. Binary Search");
        System.out.println("  06. Linked List");
        System.out.println("  07. Trees");
        System.out.println("  08. Tries");
        System.out.println("  09. Heap / Priority Queue");
        System.out.println("  10. Backtracking");
        System.out.println("  11. Graphs");
        System.out.println("  12. Advanced Graphs");
        System.out.println("  13. 1D Dynamic Programming");
        System.out.println("  14. 2D Dynamic Programming");
        System.out.println("  15. Greedy");
        System.out.println("  16. Intervals");
        System.out.println("  17. Math & Geometry");
        System.out.println("  18. Bit Manipulation");
        System.out.println("   0. Exit");
        System.out.println("==============================================");
    }

    // -------------------------------------------------------------------------
    //  TOPIC DISPATCHER
    // -------------------------------------------------------------------------
    static void handleTopic(int topic) {
        switch (topic) {
            case 1  -> arraysAndHashing();
            case 2  -> comingSoon("Two Pointers");
            case 3  -> comingSoon("Sliding Window");
            case 4  -> comingSoon("Stack");
            case 5  -> comingSoon("Binary Search");
            case 6  -> comingSoon("Linked List");
            case 7  -> comingSoon("Trees");
            case 8  -> comingSoon("Tries");
            case 9  -> comingSoon("Heap / Priority Queue");
            case 10 -> comingSoon("Backtracking");
            case 11 -> comingSoon("Graphs");
            case 12 -> comingSoon("Advanced Graphs");
            case 13 -> comingSoon("1D Dynamic Programming");
            case 14 -> comingSoon("2D Dynamic Programming");
            case 15 -> comingSoon("Greedy");
            case 16 -> comingSoon("Intervals");
            case 17 -> comingSoon("Math & Geometry");
            case 18 -> comingSoon("Bit Manipulation");
            default -> System.out.println("  Invalid choice. Please try again.");
        }
    }

    // -------------------------------------------------------------------------
    //  01  ARRAYS & HASHING
    //  TODO: Add cases and imports as you solve each problem.
    // -------------------------------------------------------------------------
    static void arraysAndHashing() {
        System.out.println("\n--- Arrays & Hashing ---");
        System.out.println("  1. Contains Duplicate");
        // TODO: Add more problems below as you implement them, e.g.:
        // System.out.println("  2. Valid Anagram");
        // System.out.println("  3. Two Sum");
        System.out.println("  0. Back");
        int choice = readInt("Select a problem: ");
        switch (choice) {
            case 1 -> ContainsDuplicate.run();
            // TODO: Add cases here as you add more solutions, e.g.:
            // case 2 -> ValidAnagram.run();
            // case 3 -> TwoSum.run();
            case 0 -> {}
            default -> System.out.println("  Invalid choice.");
        }
    }

    // -------------------------------------------------------------------------
    //  02  TWO POINTERS
    //  TODO: Implement solutions, then replace comingSoon() with a sub-menu.
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    //  03  SLIDING WINDOW
    //  TODO: Implement solutions, then replace comingSoon() with a sub-menu.
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    //  HELPER METHODS
    // -------------------------------------------------------------------------
    static void comingSoon(String topic) {
        System.out.println("\n  [" + topic + "] -- Coming soon! Implement and wire it up.");
    }

    static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
