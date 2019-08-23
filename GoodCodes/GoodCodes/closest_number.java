import java.io.*;
import java.lang.*;
import java.util.*;
public class GFG{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] iarr;
		StringBuffer outBf = new StringBuffer();
		for(
			int n, k, i, h, l, m, t = GFG.readX(br)[0];
			t>0;
			t--, outBf.append(iarr[(h+l)/2]+"\n")
		)
			for(
				k = GFG.readX(br)[1], iarr = GFG.readX(br), h = iarr.length-1, l = 0, m = (h+l)/2;
				l < h && k!=iarr[m];
				m = (h+l)/2z
			)
				if(Math.abs(iarr[m+1]-k) < Math.abs(iarr[m]-k) || Math.abs(iarr[m]-k) == Math.abs(iarr[m+1]-k) && iarr[m] < k)
					l = m+1;
				else if(Math.abs(iarr[m+1]-k) > Math.abs(iarr[m]-k) || iarr[m] > k)
					h = m;
		System.out.println(outBf);
	}
	public static int[] readX(BufferedReader br)throws IOException{
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}