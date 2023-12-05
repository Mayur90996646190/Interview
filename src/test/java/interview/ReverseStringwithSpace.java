package interview;
//aaabbcccfffff  //3a2b3c5f // Bangalore from am I
public class ReverseStringwithSpace {
	public static void main(String[] args) {
		String str = "I am From Bangalore";
		String s = str.replace(" ", "");
		String s1 = "";
		for(int i=s.length()-1 ; i>=0; i--) {
			s1 = s1 + s.charAt(i);
		}
		int n = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)==' ') {
				System.out.print(" ");
			}
			else
			{
				System.out.print(s1.charAt(n++));
			}
		}
	}
}
