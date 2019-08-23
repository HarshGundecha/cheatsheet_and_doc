import java.io.*;
import java.util.*;

public class GFG
{
	public static void main(String[] args)throws IOException
	{
		String[] sarr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int prefixi, i, j, minLength, t;
		char ctc;
		for(t=Integer.parseInt(br.readLine().trim());t>0;t--)
		{
			br.readLine();
			sarr = br.readLine().trim().split(" ");
			prefixi = 0;
			minLength = sarr[0].length();
			outer:
			for( i=0; i < minLength; prefixi++, i++ )
				for(ctc = sarr[0].charAt(prefixi), j = 0; j < sarr.length; j++ )
				{
					if( minLength > sarr[j].length() )
						minLength = sarr[j].length();
					if( sarr[j].charAt(i) != ctc )
						break outer;
				}
			System.out.println((sarr[0].substring(0,prefixi).compareTo("")==0?"-1":sarr[0].substring(0,prefixi)));			
		}
	}
}