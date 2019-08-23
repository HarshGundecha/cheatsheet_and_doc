import java.util.*;
import java.io.*;
import java.lang.*;

public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		String str1, str2;
		int max=0, maxi=0, c=0;
		for(int i, j ; t>0; t--)
		{
			str1 = br.readLine().trim();
			str2 = br.readLine().trim();
			max = maxi = 0;
			for( i=0; i < str2.length(); i++)
			{
				
				for( j=0, c = 0; j<str1.length() && i<str2.length() && str1.charAt(j)==str2.charAt(i); i++, c++, j++);
				if(c > max)
				{
					max = c;
					maxi = i;
					// System.out.println("t:"+t+", max:"+max);
				}
			}
			// System.out.println("length of common str : "+maxi);
			// System.out.println("length of common str : "+max);
			// System.out.println(maxi-1);
			// System.out.println("max:"+max+", maxi:"+str2.substring(maxi-max,maxi));
			System.out.println(((maxi-max==0?-1:maxi-max))+" "+str2.substring(maxi-max,maxi));
			// System.out.println("common str : "+str1.substring(maxi, max));
		}
	}
}