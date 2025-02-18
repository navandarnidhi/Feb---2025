public class StudentPassFail {
    public static void main(String[] args) {
        int subject1 = 45, subject2 = 38, subject3 = 50; // Hardcoded marks
        int failedSubjects = 0;

        if (subject1 < 40) {
            failedSubjects++;
        }
        if (subject2 < 40) {
            failedSubjects++;
        }
        if (subject3 < 40) {
            failedSubjects++;
        }

        switch (failedSubjects) {
            case 0 -> System.out.println("Congratulations! You passed all subjects.");
            case 1 -> System.out.println("You failed in 1 subject.");
            case 2 -> System.out.println("You failed in 2 subjects.");
            case 3 -> System.out.println("You failed in all 3 subjects.");
        }
    }
}
