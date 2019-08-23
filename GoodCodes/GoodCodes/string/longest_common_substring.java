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
		int[][] x;
		int max, maxi;
		for(int i, j ; t>0; t--)
		{
			br.readLine();
			str1 = br.readLine().trim();
			str2 = br.readLine().trim();
			x = new int[str1.length()+1][str2.length()+1];
			max = 0;
			maxi=0;
			for( i=0; i<str1.length(); i++ )
				for( j=0; j<str2.length(); j++ )
					if( str1.charAt(i) == str2.charAt(j) )
					{
						x[i+1][j+1] = x[i][j]+1;
						if( x[i+1][j+1] > max )
						{
							max = x[i+1][j+1];
							maxi = i-max+1;
						}
					}
			// System.out.println("length of common str : "+maxi);
			// System.out.println("length of common str : "+max);
			System.out.println(max);
			// System.out.println("common str : "+str1.substring(maxi, max));
		}
	}
}