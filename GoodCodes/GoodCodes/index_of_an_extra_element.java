import java.io.*;
import java.util.*;
public class GFG{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] iarr1, iarr2;
		for(
			int t = GFG.readi(br)[0], max1, max2, i;
			t>0;
			t--//, sb.append()
		)
		{
			br.readLine();
			sb.append(findExtra(GFG.readi(br), GFG.readi(br), 0)+"\n");
		}
		System.out.print(sb);
	}
	public static int findExtra(int iarr1[],int iarr2[],int n)
	{
		int i=0;
		for(
			int max1=-1, max2=-1;
			i < iarr2.length && iarr1[i]==iarr2[i];
			i++
		);
		return i;
	}
	public static int[] readi(BufferedReader br)throws IOException {
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}