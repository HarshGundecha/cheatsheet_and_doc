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
			x = new int[str1.length()][str2.length()+1];
			max = 0;
			int activeRow=0;
			for( i=0; i<str1.length(); i++,activeRow^=1)
				for( j=0; j<str2.length(); j++ )
				{
					x[activeRow][j+1] = ( str1.charAt(i) == str2.charAt(j) ? x[1-activeRow][j]+1 : 0 );
					if(x[activeRow][j+1] > max)
						max = x[activeRow][j+1]; //to find string store maxi too
				}
			// System.out.println("length of common str : "+maxi);
			// System.out.println("length of common str : "+max);
			System.out.println(max);
			// System.out.println("common str : "+str1.substring(maxi, max));
		}
	}
}