import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution500 {
	final Set<Character> line1 = new HashSet<Character>();
	{

		{
			line1.add('Q');
			line1.add('W');
			line1.add('E');
			line1.add('R');
			line1.add('T');
			line1.add('Y');
			line1.add('U');
			line1.add('I');
			line1.add('O');
			line1.add('P');
		}
	};
	final Set<Character> line2 = new HashSet<Character>();
	{

		{
			line2.add('A');
			line2.add('S');
			line2.add('D');
			line2.add('F');
			line2.add('G');
			line2.add('H');
			line2.add('J');
			line2.add('K');
			line2.add('L');
		}
	};
	final Set<Character> line3 = new HashSet<Character>();
	{

		{
			line3.add('Z');
			line3.add('X');
			line3.add('C');
			line3.add('V');
			line3.add('B');
			line3.add('N');
			line3.add('M');
		}
	};

	public String[] findWords(String[] words) {
		List<String> l = new LinkedList<>();
		for (String string : words) {
			char[] cs = string.toUpperCase().toCharArray();
			Set<Character> line = null;
			if (line1.contains(cs[0])) {
				line = line1;
			} else if (line2.contains(cs[0])) {
				line = line2;
			} else {
				line = line3;
			}
			boolean b = true;
			for (char c : cs) {
				if (!line.contains(c)) {
					b = false;
					break;
				}
			}
			if (b) {
				l.add(string);
			}
		}
		return (String[]) l.toArray(new String[l.size()]);
	}

	public static void main(String[] args) {
		Solution500 s = new Solution500();
		String[] words = { "Hello", "Alaska", "Dad", "Peace" };
		System.out.println(s.findWords(words));
	}
}
