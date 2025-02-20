public class StudentPassFail {
    public static void main(String[] args) {
        // Marks for three subject
        int subject1 = 45;
        int subject2 = 35;
        int subject3 = 50;

        int failedSubjects = 0;
        if (subject1 < 40) failedSubjects++;
        if (subject2 < 40) failedSubjects++;
        if (subject3 < 40) failedSubjects++;

        switch (failedSubjects) {
            case 0:
                System.out.println("Congratulations! You passed all subjects.");
                break;
            case 1:
                System.out.println("You failed in 1 subject.");
                break;
            case 2:
                System.out.println("You failed in 2 subjects.");
                break;
            case 3:
                System.out.println("You failed in all 3 subjects.");
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}
