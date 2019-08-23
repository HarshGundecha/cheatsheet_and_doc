import java.io.*;
import java.util.*;
public class GFG{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] iarr;
		for(
			int target, front, sum,i,t=GFG.readi(br)[0];
			t > 0;
			t--, sb.append(((target==sum)?(++front+" "+i):("-1"))+"\n")
		)
			for(
				target = GFG.readi(br)[1], iarr = GFG.readi(br), front=0, sum=0, i=0; 
				i < iarr.length && sum != target; 
				i++
			)
				for(sum+=iarr[i];sum > target && front < iarr.length;sum -= iarr[front++]);
		System.out.println(sb);
	}
	public static int[] readi(BufferedReader br)throws IOException{
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}