import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

public class GFG
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)throws IOException
	{
		StringBuilder sb = new StringBuilder();
		String[] temp;
		for(int r,c,t=Integer.parseInt(br.readLine()); t>0; t--)
		{
			temp = br.readLine().split(" +");
			r = pi(temp[0]);
			c = pi(temp[1]);
			System.out.append(recur(r, c, 0, 0)+"\n");
			sb.setLength(0);
		}
		System.out.flush();
	}

	public static int recur(int r, int c, int x, int y)
	{
		int sum=0;
		if(x==r-1 && y == c-1)
			sum=1;
		else
			if( (x+1) < r && y < c)
				sum+=recur(r, c, (x+1), y);
			if( x < r && (y+1) < c)
				sum+=recur(r, c, x, (y+1));
		return sum;
	}

		public static int pi(String o){
			return Integer.parseInt(o);
		}
}