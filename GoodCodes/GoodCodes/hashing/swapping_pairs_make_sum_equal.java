import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

public class GFG
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)throws IOException
	{
		for(int t=Integer.parseInt(br.readLine()); t>0; t--)
		{
			System.out.append(readi()+"\n");
		}
	}
	public static int readi()throws IOException
	{
		br.readLine();
		int[] sum = new int[2];
		int[] arr1 = Arrays.stream(br.readLine().split(" +"))
									.mapToInt(Integer::parseInt)
									.map(x->{sum[0]+=x;return x;})
									.toArray();
		Set<Integer> arr2 = Arrays.stream(br.readLine().split(" "))
													.mapToInt(Integer::parseInt)
													.map(x->{sum[1]+=x;return x;})
													.boxed()
													.collect(Collectors.toSet());
		int diff = Math.abs(sum[0]-sum[1])/2;
		if(diff==0)
			return 1;
		else 
			if(sum[0]<sum[1])
			{
				for (int i=0;i< arr1.length;i++)
					if(arr2.contains(arr1[i]+diff))
						return 1;
			}
			else
			{
				for (int ii=0; ii<arr1.length;ii++)
					if(arr2.contains(arr1[ii]-diff))
						return 1;
			}
		return -1;
	}
}