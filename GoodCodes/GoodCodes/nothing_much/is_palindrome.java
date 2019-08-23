import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		boolean flag;
		for(int t = Integer.parseInt(br.readLine()); t>0;t--)
		{
			br.readLine();
			str = br.readLine().trim();
			flag=true;
			for(int i=0;i<str.length()/2;i++)
				if(str.charAt(i)!=str.charAt((str.length()-1)-i))
					flag = false;
			System.out.println(flag?"Yes":"No");
		}
	}
}