import java.util.Scanner;
import java.util.*;
class NoToRoman
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			
			GfG g = new GfG();
			g.convertToRoman(N);
			t--;
		}
	}
}
/*This is a function problem.You only need to complete the function given below*/
/*you are required to complete this function*/
class GfG
{
    void convertToRoman(int n)
    {
			String str = n+"";
			int i=0, len = str.length();
			StringBuilder sb = new StringBuilder();
			// I, V, X, 	L, 	C, 	D 	and M. 
			// 1, 5, 10, 50, 100, 500 and 1,000.
			String[][] romans = new String[][]{
				{"", "I","II","III","IV","V","VI","VII","VIII","IX","X"},
				{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
				{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
				{"", "M", "MM", "MMM", "MMMM"}
			};
			for( i=0; i < len; i++ )
				sb.append(romans[len-i-1][Character.getNumericValue(str.charAt(i))]);
			System.out.println(sb);
    }
}