import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr;
		for(int i,j,left,right,mid,t=GFG.readi(br)[0];t>0;t--)
		{
			br.readLine();
			arr = GFG.readi(br);
			mid=0;
			for(left = 0,right=arr.length;left<right;)
			{
				mid = (left+right)/2;
				if(arr[mid]>mid+1)
				{
					right = mid-1;
				}
				else if(arr[mid] == mid+1)
				{
					left = mid+1;
					mid = mid+1;					
				}
			}
			// if(mid>0 && mid<arr.length)
			// {
			// 	for(i=mid-1;i<arr.length;i++)
			// 		if(arr[i]!=i+1)
			// 			mid = i+1;
			// }
			// else if(mid<=0)
			// {
			// 	for(i=0;i<arr.length;i++)
			// 		if(arr[i]!=i+1)
			// 			mid = i+1;				
			// }
			// else if(mid>=arr.length)
			// {
			// 	for(i=arr.length-1;i<arr.length;i++)
			// 		if(arr[i]!=i+1)
			// 			mid = i+1;
			// }

			// mid = (left+right)/2;
			// if(arr[mid] == mid+1 )
			// 	System.out.println((mid+2));
			// else if( arr[mid] > mid+1)
			// if((mid+1) == arr.length && arr.length>1)
			// 	System.out.println((arr.length+1));
			// else
			// if(arr[0]!=1)
			// 	System.out.println(1);
			// else
				System.out.println((mid+1));
		}
	}
	public static int[] readi(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}