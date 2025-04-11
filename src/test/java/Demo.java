import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int input = 11;
        
        List<List<Integer>> result = findCombinations(array1, input);
        
        if (!result.isEmpty()) {
            System.out.println("Combinations found:");
            for (List<Integer> combination : result) {
                System.out.println(combination);
            }
        } else {
            System.out.println("No combinations found.");
        }
    }
    
    public static List<List<Integer>> findCombinations(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        findCombinations(nums, target, 0, current, result);
        return result;
    }
    
    private static void findCombinations(int[] nums, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                current.add(nums[i]);
                findCombinations(nums, target - nums[i], i + 1, current, result); // Use i + 1 to avoid reusing the same number
                current.remove(current.size() - 1);
            }
        }
    }
}
