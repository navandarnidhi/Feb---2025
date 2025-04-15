import java.util.*;

public class AlternatePosNeg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] >= 0) pos.add(arr[i]);
            else neg.add(arr[i]);
        }

        int i = 0, j = 0, k = 0;
        while (i < pos.size() && j < neg.size()) {
            arr[k++] = neg.get(j++);
            arr[k++] = pos.get(i++);
        }
        while (j < neg.size()) arr[k++] = neg.get(j++);
        while (i < pos.size()) arr[k++] = pos.get(i++);

        System.out.println("Rearranged Array: " + Arrays.toString(arr));
    }
}
