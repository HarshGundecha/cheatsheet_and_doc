import java.lang.*;
import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer,Integer> imap = new HashMap<>();
		int[] arr;
		for(int i,j,count,tmp,t = GFG.readi(br)[0];t>0;t--)
		{
			br.readLine();

			arr = GFG.readi(br);
			for(i=0;i<arr.length-1;i++)
				for(j=i+1;j<arr.length;j++)
					imap.put( arr[i]+arr[j], imap.getOrDefault(arr[i]+arr[j], 0)+1 );
			count = 0;
			for(i=0;i<arr.length;i++)
				if( (tmp = imap.getOrDefault(arr[i], -1))!=-1 )
					count+=tmp;
			System.out.println((count==0?-1:count));
			imap.clear();
		}

	}
	public static int[] readi(BufferedReader br)throws IOException{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}