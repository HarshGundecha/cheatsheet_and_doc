import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;
public class GFG{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] iarr;
		Set<Integer> ihash;
		StringBuffer outBf;
		boolean flag;
		for(int i, j, t = GFG.readX(br)[0]; t>0; t--)
		{
			br.readLine();
			iarr = GFG.readX2(br);
			ihash = Arrays.stream(iarr).boxed().collect(Collectors.toCollection(HashSet::new));
			outer:
			for( flag = false, i=0; i<iarr.length-1; i++)
				for(j=i+1; j<iarr.length; j++)
					if(ihash.contains( iarr[i]+iarr[j] ))
					{
						flag = true;
						break outer;
					}
			System.out.println(flag?"Yes":"No");
		}
	}
	public static int[] readX(BufferedReader br)throws IOException{
		return Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	public static int[] readX2(BufferedReader br)throws IOException{
		return Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).map(x->x*x).toArray();
	}
}