package interview;

import java.util.ArrayList;

public class NumbersOnly {
	public static void main(String[] args) {
		String s = "gjasg1235sdh45ch21gv44";
		int count = 0;
		int sum = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sum = sum * 10 + (s.charAt(i) - 48);
			} else if (sum > 0) {
				list.add(sum);
				sum = 0;
			}

		}
		list.add(sum);
		for (int j = list.size() - 1; j >= 0; j--) {
			System.out.print(list.get(j) + " ");
		}
	}
}
