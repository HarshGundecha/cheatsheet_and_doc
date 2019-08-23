import java.io.*;
import java.util.*;
import java.util.stream.Stream;
import java.lang.*;
public class GFG
{
	public static void main(String[] args)
	{
		String str;
		int k, n, freq, count,i,count1,count2;
		char c;
		String[] tmparr;
		Scanner sc = new Scanner(System.in);
		for(int t=Integer.parseInt(sc.nextLine()) ; t>0; t--)
		{
			count = count1=count2=0;
			str = sc.nextLine().trim();
			tmparr = sc.nextLine().trim().split(" ");
			n = Integer.parseInt(tmparr[0]);
			k = Integer.parseInt(tmparr[1]);
			c = tmparr[2].charAt(0);

			for(i=0; i<k%str.length(); i++ )
				if(str.charAt(i) == c)
					count1++;
			for(; i<str.length(); i++)
				if(str.charAt(i) == c)
						count2++;


			// count1 = Collections.frequency(Arrays.asList(str.substring(0,k%str.length()).split("")),c+"");
			// count2 = Collections.frequency(Arrays.asList(str.substring(k%str.length(),str.length()).split("")),c+"");

			count = (k/str.length()) * (count1+count2);
			count+=count1;

			// System.out.println(count+"...");

			System.out.println(count);
		}	
	}
}