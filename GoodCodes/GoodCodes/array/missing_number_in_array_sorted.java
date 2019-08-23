import java.io.*;
import java.util.*;
import java.util.stream.*;
public class GFG
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> iset;
		for(int i,j,left,right,mid,t=GFG.readi(br)[0];t>0;t--)
		{
			br.readLine();
			iset = GFG.readI(br);
			for(i=1;i<=iset.size()+1;i++)
				if(!iset.contains(i))
				{
					System.out.println(i);
					break;
				}
			iset.clear();
		}
	}
	public static int[] readi(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
	public static HashSet readI(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toCollection(HashSet::new));
	}
}