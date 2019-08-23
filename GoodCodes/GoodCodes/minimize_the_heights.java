import java.io.*;
import java.util.*;
public class GFG
{
	// @SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder op = new StringBuilder();
		int[][] aarr;
		int[] iarr;
		int[] stats;
		for(int k, min, max, n, i, j, t = GFG.readi(br)[0]; t > 0; t--)
		{
			k = GFG.readi(br)[0];
			br.readLine();
			aarr = GFG.readiFiltered(br);
			iarr = aarr[0];
			stats = aarr[1];
			min = stats[0];
			max = stats[1];


			for( i=0, min=Integer.MAX_VALUE, max = Integer.MIN_VALUE; i<iarr.length; i++ )
			{
				if(iarr[i]-k >= min);
				else if()

			}
		}
		System.out.println(op);
	}

	// public static IntSummaryStatistics getStats(int[] iarr)
	// {
	// 	return Arrays.stream(iarr).collect(Collectors.summarizingInt(Integer::intValue));
	// }

	public static int[][] readiFiltered(BufferedReader br)throws IOException
	{
		List<Integer> ilist = new ArrayList<>(2);
		ilist.add(Integer.MAX_VALUE); //min
		ilist.add(Integer.MIN_VALUE);	//max
		int[] iarr =  Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).filter((x->{
			if(x < ilist.get(0))
			{
				ilist.set(0, x);
				if(x > ilist.get(1))
					ilist.set(1, x);
			}
			else if(x > ilist.get(1))
				ilist.set(1, x);
			return true;
		})).toArray();
		return new int[][]{iarr, new int[]{ilist.get(0), ilist.get(1)}};
	}

	public static int[] readi(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}