import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution399 {
	String[][] equations;
	double[] values;

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		this.equations = equations;
		this.values = values;
		double[] results = new double[queries.length];
		for (int i = 0; i < results.length; i++) {
			results[i] = query(queries[i]);
		}
		return results;

	}

	private double query(String[] query) {
		String x = query[0];
		String y = query[1];
		if (x.equals(y)) {
			for (int i = 0; i < equations.length; i++) {
				if (equations[i][0].equals(x) || equations[i][1].equals(x)) {
					return 1.0;
				}
			}
		} else {
			// chech whether equation contains x and y
			for (int i = 0; i < equations.length; i++) {
				if (equations[i][0].equals(x) && equations[i][1].equals(y)) {
					return values[i];
				} else if (equations[i][0].equals(y) && equations[i][1].equals(x)) {
					return 1 / values[i];
				} else {
					for (int j = i+1; j < equations.length; j++) {
						if (areBothContains(i, j, x, y)) {
							if ((x.equals(equations[i][0]) && y.equals(equations[j][1]))
									|| (y.equals(equations[i][1]) && x.equals(equations[j][0]))) {
								return values[i] * values[j];
							} else if ((x.equals(equations[i][1]) && y.equals(equations[j][0]))
									|| ((y.equals(equations[i][0]) && x.equals(equations[j][1])))) {
								return 1 / (values[i] * values[j]);
							} else if ((x.equals(equations[i][0]) && y.equals(equations[j][0]))
									|| (y.equals(equations[i][1]) && x.equals(equations[j][1]))) {
								return values[i] / values[j];
							} else if ((y.equals(equations[i][0]) && x.equals(equations[j][0]))
									|| (x.equals(equations[i][1]) && y.equals(equations[j][1]))) {
								return values[j] / values[i];
							}
						}
					}
				}
			}
		}
		return -1.0;
	}

	private boolean areBothContains(int i, int j, String x, String y) {
		List<String> list = new LinkedList();
		list.add(equations[i][0]);
		list.add(equations[i][1]);
		list.add(equations[j][0]);
		list.add(equations[j][1]);

		list.remove(x);
		list.remove(y);

		return list.size() == 2 && list.get(0).equals(list.get(1));

	}

	public static void main(String[] args) {
		Solution399 s = new Solution399();
		String[][] equations = { { "a", "b" }, { "b", "c" } };
		double[] values = { 2.0, 3.0 };
		String[][] queries = { { "a", "c" }, { "b", "c" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
		System.out.println(s.calcEquation(equations, values, queries));
	}
}
