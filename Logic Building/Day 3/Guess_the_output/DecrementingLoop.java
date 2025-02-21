public class DecrementingLoop { 
    public static void main(String[] args) { 
        int total = 0; 
        for (int i = 5; i > 0; i--) { 
            total += i; 
            if (i == 3) continue; 
            total -= 1; 
        } 
        System.out.println(total); 
    } 

}

// Output - 11