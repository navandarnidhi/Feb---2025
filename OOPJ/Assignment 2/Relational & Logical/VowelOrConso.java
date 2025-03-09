public class VowelOrConso {
    public static void main(String[] args) {
        char ch = 'e';

        String result = (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
                         ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') 
                         ? "Vowel" : "Consonant";

        System.out.println(ch + " is a " + result);
    }
}
