package interview;

public class Interview {
	public static void main(String[] args) {
		String s="Tekion123".toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)>='a' && s.charAt(i)<='z') {
				System.out.print(s.charAt(i));
			}
		}
	}
}
