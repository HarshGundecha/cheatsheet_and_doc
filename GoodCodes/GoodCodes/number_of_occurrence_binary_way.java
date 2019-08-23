//works for sorted only
import java.io.*;
import java.util.*;
public class GFG{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] iarr;
		for(
			int t = GFG.readi(br)[0],k,m,n,reli;
			t>0;
			t--//, sb.append()
		)
		{
			k = GFG.readi(br)[1];
			iarr=GFG.readi(br);
            reli = bin_search(iarr, 0, iarr.length-1, k);
			if(reli != -1)
			{
				for(m = reli; m-1>-1 && iarr[m-1]==k; m--);
				for(n = reli; n+1<iarr.length && iarr[n+1]==k; n++);
				sb.append((n-m+1)+"\n");
			}
			else
				sb.append("-1\n");
		}
		System.out.print(sb);
	}
	public static int[] readi(BufferedReader br)throws IOException {
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
	public static int bin_search(int a[], int l, int r,  int k)
	{		
		for(int m = (l+r)/2; l<=r; m = (l+r)/2)
			if( a[m] < k )
				l = m+1;
			else if( a[m] > k )
				r = m-1;
			else
				return m;
		return -1;
	}
}