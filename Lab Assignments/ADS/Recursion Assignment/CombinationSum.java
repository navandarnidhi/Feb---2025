import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempList.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, tempList, result);
                tempList.remove(tempList.size() - 1); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take array input
        System.out.print("Enter numbers (space-separated): ");
        String[] input = scanner.nextLine().split(" ");
        int[] candidates = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            candidates[i] = Integer.parseInt(input[i]);
        }

        // Take target input
        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        // Get and print the result
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("Unique combinations that sum to target:");
        for (List<Integer> combo : result) {
            System.out.println(combo);
        }

        scanner.close();
    }
}
