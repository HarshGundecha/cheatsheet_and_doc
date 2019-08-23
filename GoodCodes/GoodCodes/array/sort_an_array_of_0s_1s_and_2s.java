import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	// @SuppressWarnings("unchecked")
	public static void main (String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		for(int i, j, k, t=GFG.readi(br)[0]; t>0; t--)
		{
			br.readLine();
			GFG.readI(br,sb);
			System.out.println(sb);
			sb.setLength(0);	
		}
	}

	public static int[] readi(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	public static void readI(BufferedReader br, StringBuilder sb)throws IOException
	{
		// @SuppressWarnings("unchecked")
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		Arrays.stream(br.readLine().split(" ")).forEach((x->{
			switch(x)
			{
				case "0":
					sb.append("0 ");
				break;
				case "1":
					sb1.append("1 ");
				break;
				case "2":
					sb2.append("2 ");
				break;
			}
		}));
		sb.append(sb1);
		sb.append(sb2);
	}
}