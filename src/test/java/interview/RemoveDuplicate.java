package interview;

import java.util.LinkedHashSet;

public class RemoveDuplicate {
	public static void main(String[] args) {
		int[] a= {12,10,10,11,12,13};
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		for (Integer i : set) {
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				if(i==a[j]) {
					count++;
				}
			}
			if(count==1) {
				System.out.print(i+" ");
			}
		}
	}
}
