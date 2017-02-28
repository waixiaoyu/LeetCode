import java.util.LinkedList;
import java.util.List;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lResult = new LinkedList<>();
        int[] nMarks = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            nMarks[nums[i]]++;
        }
        for (int i = 0; i < nMarks.length; i++) {
            if (nMarks[i] > 1) {
                lResult.add(i);
            }
        }
        return lResult;
    }

    public static void main(String[] args) {
        Solution442 s = new Solution442();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(s.findDuplicates(nums));
    }
}
