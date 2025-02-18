public class DaysOfWeek {
    public static void main(String[] args) {
        int day = 3; // Hardcoded value (Change this for different days)

        switch (day) {
            case 1 -> {
                System.out.println("Monday");
                System.out.println("Weekday");
            }
            case 2 -> {
                System.out.println("Tuesday");
                System.out.println("Weekday");
            }
            case 3 -> {
                System.out.println("Wednesday");
                System.out.println("Weekday");
            }
            case 4 -> {
                System.out.println("Thursday");
                System.out.println("Weekday");
            }
            case 5 -> {
                System.out.println("Friday");
                System.out.println("Weekday");
            }
            case 6 -> {
                System.out.println("Saturday");
                System.out.println("Weekend");
            }
            case 7 -> {
                System.out.println("Sunday");
                System.out.println("Weekend");
            }
            default -> System.out.println("Invalid input! Enter a number between 1 and 7.");
        }
    }
}
