import java.lang.*;
import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, ans;
		Map<Integer, Integer> iimap = new HashMap<>();
		List<Integer> ml = new ArrayList<>(2);
		for(int t=Integer.parseInt(br.readLine()); t>0; t--)
		{
			n = Integer.parseInt(br.readLine());
			ml.add(0, -1);
			ml.add(1, -1);
			Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach((i->{
				iimap.put(i, iimap.getOrDefault(i, 0)+1 );
				if( iimap.get(i) > ml.get(0) )
				{
					ml.set(0,iimap.get(i));
					ml.set(1,i);
				}
			}));
			ans = ((ml.get(0)>(n/2))?ml.get(1):-1);
			System.out.append(ans+"\n");
			iimap.clear();
			ml.clear();
		}
		System.out.flush();
	}
}