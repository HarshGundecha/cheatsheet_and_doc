import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sarr;
		boolean flag;
		int len, cnt=1;
		StringBuilder sb = new StringBuilder();
		for(int t = Integer.parseInt(br.readLine()); t>0; t--)
		{
			br.readLine();
			cnt = 0;
			len = String.join("", br.readLine().trim().split("0")).length()-1;
			while(len>0)
				cnt+=len--;
			System.out.println(cnt);
			sb.setLength(0);
		}
	}
}