import java.util.LinkedList;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> lResults = new LinkedList<>();
        int[] nArrp = new int[26];
        char[] cArrp = p.toCharArray();
        // init nArrp
        for (char c : cArrp) {
            nArrp[c - 'a']++;
        }
        int nWindowSize = cArrp.length;
        int[] nArrs = new int[26];
        char[] cArrs = s.toCharArray();
        if (nWindowSize > cArrs.length) {
            return lResults;
        } else {
            // compute index 0 first
            int nCount = 0;
            while (nCount < nWindowSize) {
                nArrs[cArrs[nCount] - 'a']++;
                nCount++;
            }
            if (isMatch(nArrs, nArrp)) {
                lResults.add(0);
            }
            int nCurIndex = 1;
            while (nCurIndex + nWindowSize <= cArrs.length) {
                nArrs[cArrs[nCurIndex - 1] - 'a']--;
                nArrs[cArrs[nCurIndex + nWindowSize - 1] - 'a']++;
                if (isMatch(nArrs, nArrp)) {
                    lResults.add(nCurIndex);
                }
                nCurIndex++;
            }
        }
        return lResults;
    }

    private boolean isMatch(int[] nArrs, int[] nArrp) {
        int nCount = 0;
        while (nCount < nArrs.length) {
            if (nArrs[nCount] != nArrp[nCount]) {
                return false;
            }
            nCount++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution438 s = new Solution438();
        System.out.println(s.findAnagrams("abab", "ab"));
    }
}
