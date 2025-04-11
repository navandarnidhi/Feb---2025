class Solution {
    public int[] subarraySum(int[] arr, int targetSum) {
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            while (currentSum > targetSum) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == targetSum) {
                int[] result = new int[end - start + 1];
                for (int i = start; i <= end; i++) {
                    result[i - start] = arr[i];
                }
                return result;
            }
        }

        return new int[0]; // Return an empty array if no subarray is found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1, 2, 3, 7, 5};
        int targetSum = 12;

        int[] result = solution.subarraySum(arr, targetSum);

        if (result.length > 0) {
            System.out.print("{");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        } else {
            System.out.println("No subarray found with the given sum.");
        }

        int[] arr2 = {1, 4, 0, 0, 3, 10, 5};
        int targetSum2 = 7;

        int[] result2 = solution.subarraySum(arr2, targetSum2);

        if (result2.length > 0) {
            System.out.print("{");
            for (int i = 0; i < result2.length; i++) {
                System.out.print(result2[i]);
                if (i < result2.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        } else {
            System.out.println("No subarray found with the given sum.");
        }
    }
}