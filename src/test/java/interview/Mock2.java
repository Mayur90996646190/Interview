package interview;
//Bangalore from am I
public class Mock2 {
	public static void main(String[] args) {
		String str = "I am From Bangalore";
		 String[] ch = str.split(" ");
		for (int i = ch.length-1; i>=0; i--) {
			System.out.print(ch[i]+" ");
		}
	}
}
