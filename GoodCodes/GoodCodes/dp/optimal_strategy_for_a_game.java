import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[][] ans;
	public static void main (String[] args)throws IOException
	{
		int[] arr;
		for(int t=Integer.parseInt(br.readLine()); t>0; t--)
		{
			br.readLine();
			arr = GFG.readi();
			ans = new int[arr.length][arr.length];
			System.out.println(GFG.recur(arr,0,arr.length-1));
		}
	}
	public static int[] readi()throws IOException
	{
		return Arrays.stream(br.readLine().split(" +")).mapToInt(Integer::parseInt).toArray();
	}
	public static int recur(int[] arr, int i , int j)
	{
		if(i==j || i+1==j)
			ans[i][j] = Math.max(arr[i],arr[j]);
		else if(ans[i][j]==0)
			ans[i][j] = Math.max(
				arr[i] + Math.min( GFG.recur(arr, i+2, j), GFG.recur(arr, i+1,j-1)),
				arr[j] + Math.min( GFG.recur(arr, i+1,j-1), GFG.recur(arr, i,j-2))
			);
		return ans[i][j];
	}
}