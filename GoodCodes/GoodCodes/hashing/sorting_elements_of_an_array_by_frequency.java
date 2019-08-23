import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;
import java.util.stream.IntStream;

class GFG
{
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args)throws IOException
	{			
		for(int t=Integer.parseInt(br.readLine()); t>0; t--)
			System.out.append(readi()+"\n");
		System.out.flush();
	}
	public static String readi()throws IOException
	{
		Map<Integer, Integer> freq = new HashMap<>();
		Map<Integer, List<Integer>> tmap = new TreeMap<>((a,b)->b-a);
		StringBuilder sb = new StringBuilder();
		br.readLine();
		Arrays.stream(br.readLine().split(" +")).mapToInt(Integer::parseInt).forEach(i->freq.put(i, freq.getOrDefault(i, 0)+1));

		freq.entrySet().forEach(e->{
			if(tmap.get(e.getValue())==null)
				tmap.put(e.getValue(), new ArrayList<Integer>(Arrays.asList(e.getKey())));
			else
				tmap.get(e.getValue()).add(e.getKey());			
		});

		tmap.entrySet().forEach(e->e.getValue().forEach(y->IntStream.range(0,e.getKey()).forEach(i->sb.append(y+" "))));
		return sb+"";
	}
}