import java.io.*;
import java.util.*;
public class GFG{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] iarr;
		for(
			int t = GFG.readi(br)[0], max1, max2, i;
			t>0;
			t--//, sb.append()
		)
		{
			br.readLine();
			iarr = GFG.readi(br);
			for(i=0,max1=-1, max2=-1;i<iarr.length;i++)
				if(iarr[i] > max1)
				{
					max2 = max1;
					max1 = iarr[i];
				}
				else if(iarr[i]>max2)
					max2 = iarr[i];
			sb.append(max2+"\n");
		}
		System.out.print(sb);
	}
	public static int[] readi(BufferedReader br)throws IOException {
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}