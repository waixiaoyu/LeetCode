import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

class RandomizedSet {

	Set<Integer> s;
	Random r;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		s = new HashSet<Integer>();
		r = new Random();

	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (s.contains(val)) {
			return false;
		} else {
			s.add(val);
			return true;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!s.contains(val)) {
			return false;
		} else {
			s.remove(val);
			return true;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int nIndex = r.nextInt(s.size());
		Iterator<Integer> it = s.iterator();
		int nCount = 0;
		while (it.hasNext()) {
			int n = (int) it.next();
			if (nCount == nIndex) {
				return n;
			}
			nCount++;
		}
		return 0;
	}
}

public class Solution380 {
	public static void main(String[] args) {
		RandomizedSet randomSet = new RandomizedSet();
		System.out.println(randomSet.insert(1));
		System.out.println(randomSet.remove(2));
		System.out.println(randomSet.insert(2));
		System.out.println(randomSet.getRandom());
		System.out.println(randomSet.remove(1));
		System.out.println(randomSet.insert(2));
		System.out.println(randomSet.getRandom());


	}
}