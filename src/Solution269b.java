import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution269b {

    private static final int NUM = 26;

    private int[] nArrInDegreeNum;
    private int[][] nArrEdges;
    private int[] nArrOrders;

    public String alienOrder(String[] words) {
        nArrInDegreeNum = new int[NUM]; // store number of indegree, like
                                        // min heap
        // init all to -1, which means there is no such element
        for (int i = 0; i < NUM; i++) {
            nArrInDegreeNum[i] = -1;
        }
        nArrEdges = new int[26][26]; // store edge
        nArrOrders = new int[26]; // for the order of alphabet
        int nOrder = 1;

        // init all character appeared to 0, and decide the order of alph
        for (String string : words) {
            // if it appears and =-2, set it = -1
            for (char c : string.toCharArray()) {
                if (nArrInDegreeNum[c - 'a'] == -1) {
                    nArrInDegreeNum[c - 'a'] = 0;
                }
                if (nArrOrders[c - 'a'] == 0) {
                    nArrOrders[c - 'a'] = nOrder;
                    nOrder++;
                }
            }
        }

        // compare the neighbor strings, and find the first different char
        for (int index = 0; index < words.length; index++) {
            if (index < words.length - 1) {
                findFirstDifferentChar(words[index], words[index + 1]);
            }
        }

        // top sort
        StringBuilder sb = new StringBuilder();
        topologicalSorting(sb);

        // judge whether all degree is -1, if not return ""
        for (int i = 0; i < NUM; i++) {
            if (nArrInDegreeNum[i] != -1) {
                return "";
            }
        }
        return sb.toString();
    }

    private void topologicalSorting(StringBuilder sb) {
        boolean bFind = true;
        LinkedList<Integer> llFind = new LinkedList<>();

        while (bFind) {
            bFind = false;
            for (int i = 0; i < NUM; i++) {
                if (nArrInDegreeNum[i] == 0) {
                    bFind = true;
                    llFind.add(i);
                    nArrInDegreeNum[i] = -1;
                }
            }
            // if find the indegree==0
            if (bFind) {
                // for two same chars, sort as its appeared order
                Collections.sort(llFind, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return nArrOrders[o1] - nArrOrders[o2];
                    }
                });
                for (Integer integer : llFind) {
                    char c = (char) ('a' + integer);
                    sb.append(c);
                    for (int i = 0; i < NUM; i++) {
                        if (nArrEdges[integer][i] > 0) {
                            nArrInDegreeNum[i] -= nArrEdges[integer][i];
                            nArrEdges[integer][i] = 0;
                        }
                    }
                }
                llFind.clear();
            }
        }
    }

    private void findFirstDifferentChar(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int nLength = Math.min(c1.length, c2.length);
        for (int i = 0; i < nLength; i++) {
            if (c1[i] != c2[i]) {
                nArrInDegreeNum[c2[i] - 'a']++;// indegree num ++
                nArrEdges[c1[i] - 'a'][c2[i] - 'a']++;// edge ++
                break;
            }

        }
    }

    public static void main(String[] args) {
        String[] strs = { "wrt", "wrf", "er", "ett", "rftt" };
        Solution269b s = new Solution269b();
        System.out.println(s.alienOrder(strs));
    }

}
