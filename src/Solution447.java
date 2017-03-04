import java.util.HashMap;
import java.util.Map;

public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int nResult = 0;
        int[][] nDisMatrix = new int[points.length][points[0].length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int nDis = 0;
                if (nDisMatrix[i][j] > 0) {
                    nDis = nDisMatrix[i][j];
                } else {
                    nDis = getInstance(points[i], points[j]);
                    nDisMatrix[i][j] = nDis;
                    nDisMatrix[j][i] = nDis;
                }
                map.put(nDis, map.getOrDefault(nDis, 0) + 1);
            }
            for (int ii : map.values()) {
                nResult += ii * (ii - 1);
            }
            map.clear();
        }
        return nResult;
    }

    private int getInstance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
