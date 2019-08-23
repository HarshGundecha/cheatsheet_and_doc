import java.io.*;
import java.lang.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = Integer.parseInt(br.readLine().trim()); t>0;t--)
		{
			br.readLine();
			System.out.println(GFG.LIS(GFG.readi(br)));
		}
	}
	public static int[] readi(BufferedReader br)throws IOException{
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
	public static int LIS(int[] arr)
	{
		int[] lis = new int[arr.length];
		// Arrays.fill(lis,1);
		for( int j, i=0; i<arr.length; i++ )
			for( lis[i]=1, j=0; j<i; j++ )
				if( arr[i] > arr[j] && lis[j]+1 > lis[i])
					lis[i]=lis[j]+1;
		return Arrays.stream(lis).max().getAsInt();
	}
}