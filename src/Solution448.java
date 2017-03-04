import java.util.LinkedList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> lResult = new LinkedList<>();
        int[] nMarks = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            nMarks[nums[i]]++;
        }
        for (int i = 1; i < nMarks.length; i++) {
            if (nMarks[i] < 1) {
                lResult.add(i);
            }
        }
        return lResult;
    }
}
