import java.io.*;
import java.util.*;
public class GFG
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)throws IOException
	{
		short[] arr, dep;
		for(int i, j, n, pf, maxPf, t = Integer.parseInt(br.readLine()); t-->0;)
		{
			n = Integer.parseInt(br.readLine());
			arr = GFG.readi(n);
			dep = GFG.readi(n);
			for( j = 0 ,maxPf = pf = i = 1; i < n-1 && j< n;)
				if(dep[j] >= arr[i])
				{
					i++;
					if(++pf > maxPf)
						maxPf = pf;
				}
				else
				{
					pf--;
					j++;
				}
			System.out.append(maxPf+"\n");
		}
		System.out.flush();
	}
	public static short[] readi(int n)throws IOException{
		String[] temarr = br.readLine().split(" ");
		short[] shortArr = new short[n];
		for (int i=0; i<n; i++)
			shortArr[i] = Short.parseShort(temarr[i]);
		Arrays.sort(shortArr);
		return shortArr;
	}
}