import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution269 {

    private final static int NUM = 26;

    public String alienOrder(String[] words) {
        int[] nArrInDegreeNum = new int[26];// store number of indegree, like
                                            // min heap
        // init all to -1, which means there is no such element
        for (int i = 0; i < nArrInDegreeNum.length; i++) {
            nArrInDegreeNum[i] = -1;
        }
        int[][] nArrEdges = new int[26][26];// store edge
        int[] nArrOrders = new int[26];// for the order of alphabet
        int nOrder = 1;
        for (String str : words) {
            char[] cArr = str.toCharArray();
            // if it appears and =-1, set it = 0
            if (nArrInDegreeNum[cArr[0] - 'a'] == -1) {
                nArrInDegreeNum[cArr[0] - 'a'] = 0;
            }
            for (int i = 0; i < cArr.length - 1; i++) {
                if (nArrOrders[cArr[i] - 'a'] == 0) {
                    nArrOrders[cArr[i] - 'a'] = nOrder;
                    nOrder++;
                }
                if (nArrInDegreeNum[cArr[i + 1] - 'a'] == -1) {
                    nArrInDegreeNum[cArr[i + 1] - 'a'] = 0;
                }
                nArrInDegreeNum[cArr[i + 1] - 'a']++;// indegree num ++
                nArrEdges[cArr[i] - 'a'][cArr[i + 1] - 'a']++;// edge ++
            }
        }

        // topol sort
        boolean bFind = true;
        LinkedList<Integer> llFind = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (bFind) {
            bFind = false;
            for (int i = 0; i < nArrOrders.length; i++) {
                if (nArrInDegreeNum[i] == 0) {
                    bFind = true;
                    llFind.add(i);
                    nArrInDegreeNum[i] = -1;
                }
            }
            // if find the indegree==0
            if (bFind) {
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
        // judge whethen all degree is -1, if not return ""
        for (int i = 0; i < NUM; i++) {
            if (nArrInDegreeNum[i] != -1) {
                return "";
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "wrt", "wrf", "er", "et", "rft" };
        Solution269 s = new Solution269();
        System.out.println(s.alienOrder(strs));
    }

    public String alienOrder1(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        String ans = null;
        Set<Character> charSet = new HashSet<>(); // Maintain a set of chars
                                                  // that are not in the graph.
        buildGraph(words, graph, charSet);
        ans = toposortDFS(graph, charSet);
        return ans;
    }

    private Set<Character> getCharSet(String[] words, Set<Character> charSet) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charSet.add(c);
            }
        }
        return charSet;
    }

    private String toposortDFS(Map<Character, List<Character>> graph, Set<Character> charSet) {
        StringBuffer ans = new StringBuffer();
        boolean[] visited = new boolean[26]; // permanent marker.
        boolean[] tempMark = new boolean[26]; // temporary marker

        for (Character v : graph.keySet()) {
            if (!visited[v - 'a']) {
                if (!visitDFS(ans, graph, visited, v, tempMark)) {
                    return "";
                }
            }
        }

        for (Character c : charSet) { // insert orphan chars.
            ans.insert(0, c);
        }
        return ans.reverse().toString();
    }

    private boolean visitDFS(StringBuffer ans, Map<Character, List<Character>> graph, boolean[] visited, Character node,
            boolean[] marked) {
        if (marked[node - 'a']) { // if temporally marked already, it is not
                                  // DAG. return failure(false);
            return false;
        }
        if (!visited[node - 'a']) {
            marked[node - 'a'] = true; // mark the current node temporally.
            List<Character> adjList = graph.get(node);
            if (adjList != null) {
                for (Character m : graph.get(node)) {
                    if (!visitDFS(ans, graph, visited, m, marked))
                        return false;
                }
            }
            // there is no adjacent node, it is a leaf, output the node(char).
            visited[node - 'a'] = true; // mark the node permanently.
            marked[node - 'a'] = false; // remove the temp mark.
            ans.append(node);
        }
        return true;
    }

    private void buildGraph(String[] words, Map<Character, List<Character>> graph, Set<Character> charSet) {

        getCharSet(words, charSet); // Find all chars in the words.

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                for (int k = 0; k < Math.min(words[i].length(), words[j].length()); k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) {

                        charSet.remove(words[i].charAt(k)); // Remove the chars
                                                            // that are in the
                                                            // graph from
                                                            // charSet.
                        charSet.remove(words[j].charAt(k));

                        if (graph.containsKey(words[i].charAt(k))) {
                            List<Character> adjList = graph.get(words[i].charAt(k));
                            if (!adjList.contains(words[j].charAt(k)))
                                graph.get(words[i].charAt(k)).add(words[j].charAt(k));
                        } else {
                            List<Character> adjList = new ArrayList<Character>();
                            adjList.add(words[j].charAt(k));
                            graph.put(words[i].charAt(k), adjList);
                        }
                        break;
                    }
                }
            }
        }
    }
}
