import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 100000);
		String str;
		int q, k, Q, r;
		String[] tmparr;
		for(int t=Integer.parseInt(br.readLine()) ; t>0; t--)
		{
			Q = Integer.parseInt(br.readLine().trim().split(" ")[1]);
			str = br.readLine().trim();
			r=0;
			while(Q-->0)
			{
				tmparr = br.readLine().trim().split(" ");
				q = Integer.parseInt(tmparr[0]);
				k = Integer.parseInt(tmparr[1]);
				if(q==1)
					r+=(str.length()-(k%str.length()));
				else
					System.out.println(str.charAt(
						((r+k)%str.length())
					));
			}

		}	
	}
}