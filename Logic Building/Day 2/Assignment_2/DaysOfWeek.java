public class DaysOfWeek {
    public static void main(String[] args) {
        int day = 3; // Hardcoded value; Change this to test different days

        switch (day) {
            case 1:
                System.out.println("Monday - Weekday");
                break;
            case 2:
                System.out.println("Tuesday - Weekday");
                break;
            case 3:
                System.out.println("Wednesday - Weekday");
                break;
            case 4:
                System.out.println("Thursday - Weekday");
                break;
            case 5:
                System.out.println("Friday - Weekday");
                break;
            case 6:
                System.out.println("Saturday - Weekend");
                break;
            case 7:
                System.out.println("Sunday - Weekend");
                break;
            default:
                System.out.println("Invalid input! Enter a number between 1 and 7.");
        }
    }
}
