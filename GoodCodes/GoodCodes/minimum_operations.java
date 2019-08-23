import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main (String[] args)throws IOException
	{
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i, j, k, t=Integer.parseInt(br.readLine()); t>0; t--)
		{
			int n=Integer.parseInt(br.readLine());
			int c=0;
			while(n!=0)
			{
				if(n%2==0)
				{
					c++; // used to return count of operations
					// sb.insert(0,(n/2)+" * "+2+" = "+n+", "); // to build the expression
					n/=2;
				}
				else
				{
					c++; // used to return count of operations
					// sb.insert(0,(n-1)+" + "+1+" = "+n+", "); // to build the expression
					n--;
				}
			}
			// sb.setLength(sb.length()-2); // to trim garbage from expression
			sb.append(c);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}