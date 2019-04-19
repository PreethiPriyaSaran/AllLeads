package sample1;

public class Primenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "preethi";
		int i=0;
		for ( i = 1; i <= str.length() - 1; i++) {
			if(i%2 !=0)
			{
			char a = Character.toUpperCase(str.charAt(i));
			System.out.println(a);
		}
			System.out.println(str);
	}
}
}
