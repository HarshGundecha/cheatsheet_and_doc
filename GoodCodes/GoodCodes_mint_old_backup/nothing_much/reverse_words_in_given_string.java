import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sarr;
		boolean flag;
		StringBuilder sb = new StringBuilder();
		for(int t = Integer.parseInt(br.readLine()); t>0;t--)
		{
			sarr = br.readLine().trim().split("\\.");
			for(int i=sarr.length-1; i>-1; i--)
				sb.append(sarr[i]+".");
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}