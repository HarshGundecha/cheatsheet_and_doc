import java.lang.*;
import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr;
		for(int i,j,currSum,maxSum,t=GFG.readi(br)[0];t>0;t--)
		{
			arr = GFG.readi(br);
			currSum = arr[0];
			maxSum = arr[0];
			for(i=1;i<arr.length;i++)
			{
				currSum = Math.max(a[i],currSum+a[i]);
				maxSum = Math.max(maxSum, currSum);
			}
			System.out.println(maxSum);
		}
	}
	public static int[] readi(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}