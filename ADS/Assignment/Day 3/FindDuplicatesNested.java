import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesNested {
    public static List<Integer> findDuplicates(int[] arr, int n) {
        List<Integer> duplicates = new ArrayList<>();
        
        // To avoid adding the same duplicate multiple times
        boolean[] added = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j] && !added[arr[i]]) {  // Check for duplicate
                    duplicates.add(arr[i]);
                    added[arr[i]] = true;
                    break; // Move to the next unique number
                }
            }
        }

        return duplicates.isEmpty() ? List.of(-1) : duplicates;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 3, 6, 6, 5};
        int n = arr.length;
        System.out.println(findDuplicates(arr, n));  // Output: [1, 3, 6]
    }
}

/*
//Method 2
//Sorting Approach 
//Time Complexity: O(n^2)
//Space complexity: O(1)

import java.util.*;
class ArrayDuplicateDemo1{
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,2,7,8,8,3};
		//unsorted array
		System.out.println(Arrays.toString(arr));
		//sorted arrays
		Arrays.sort(arr);//O(nlogn)
		System.out.println(Arrays.toString(arr));
		
		//Logic for duplicate identification
		for(int i=0;i<arr.length-1;i++){
			
				if(arr[i] == arr[i+1])
					System.out.println(arr[i]);
		}		
	}
}
*/



/*

//Method 3
//Using HashSet
//Time Complexity: O(n)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesOptimized {
    public static List<Integer> findDuplicates(int[] arr, int n) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;  
            arr[index] += n;  
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] / n > 1) {
                duplicates.add(i);
            }
        }

        return duplicates.isEmpty() ? List.of(-1) : duplicates;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 3, 6, 6, 5};
        int n = arr.length;
        System.out.println(findDuplicates(arr, n));  // Output: [1, 3, 6]
    }
}
*/