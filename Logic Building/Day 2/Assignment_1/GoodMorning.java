import java.time.LocalTime;

public class GoodMorning {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(LocalTime.of(5, 0)) && currentTime.isBefore(LocalTime.of(12, 0))) {
            System.out.println("Good Morning");
        } else {
            System.out.println("It's not morning.");
        }
    }
}
