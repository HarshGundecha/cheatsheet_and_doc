import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		boolean flag;
		for(int pstart,pend,j,c,t = Integer.parseInt(br.readLine()); t>0;t--)
		{
			str = br.readLine().trim();
			pstart=0;pend=1;
			for(i=1;i<str.length()-1;i++)
			{
				for(c=0, j=i; i-j>-1 && i+j<str.length(); j++)
				{
					c++;
				}
				if((i+j)-(i-j) > pend-pstart)
				{
					pstart = i-j;
					pend = i+j;
				}
			}			

			System.out.println(flag?"Yes":"No");
		}
	}
}