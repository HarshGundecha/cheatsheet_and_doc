import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, t = Integer.parseInt(br.readLine().trim());
		int[] tempIntArr;
		while(t-- > 0)
		{
			tempIntArr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
			n = tempIntArr[0];
			final int d = tempIntArr[1]%2==0?1:0;

			final int[] cArr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
			final int[] pArr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

			System.out.println(IntStream.range(0, n).filter(i->cArr[i]%2==d).map(i->pArr[i]).sum());

			// for(sum = 0, i=0; i<n; i++)
			// 	if(cArr[i]%2==d)
			// 		sum+=pArr[i];
			// System.out.println(sum);
		}
	}
}