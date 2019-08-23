import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int i, j, c, max=-1, t=GFG.readi(br)[0];
		int[] iarr = new int[t];
		//input
		for(i=0;i<t;i++)
		{
			iarr[i] = Integer.parseInt(br.readLine().trim());
			if(iarr[i] > max)
				max = iarr[i];
		}

		//find primes up to max
		boolean[] barr = getBooleanPrimesUpToN(max);

		//extract all superprimes
		List<Integer> ilist = new ArrayList<>((int)Math.sqrt(max));
		for(i=1; i<=max-2; i+=2)
			if(!barr[i] && !barr[i+2])
				ilist.add(i+2);

		// count superprimes up to N for all testcases
		for(i=0; i<t; sb.append((c==0?-1:c)+"\n"), i++)
			for(c = 0, j=0; j<ilist.size() && ilist.get(j) <= iarr[i]; c++,j++);

		//output
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

	// get the next prime number
	public static int getNextPrime(int i, int n, boolean[] barr)
	{
		if(i<2)
			return 2;
		for(;i<=Math.sqrt(n+1);i++)
			if(!barr[i])
				return i;
		return n+1;
	}

	public static boolean[] getBooleanPrimesUpToN(int n)
	{
		boolean[] barr = new boolean[n+1];
		int i,j;
		barr[0]=barr[1] = true;
		for(i=getNextPrime(0, n, barr); i<=n; i=getNextPrime(i+1, n, barr))
			for(j=i+i; j<=n; j+=i)
				barr[j] = true;
		return barr;
	}

	public static int[] readi(BufferedReader br)throws IOException {
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}