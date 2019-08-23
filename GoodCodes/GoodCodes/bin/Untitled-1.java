import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
// import javafx.util.Pair;
public class GFG
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)throws IOException
	{
		StringBuilder sb = new StringBuilder();
		for(int r,c,t=Integer.parseInt(br.readLine()); t>0; t--)
		{
			System.out.append(solveIt()+"\n");
			sb.setLength(0);
		}
		System.out.flush();
	}

	public static int solveIt()throws IOException
	{
		int n = pi(br.readLine());
		Pair[] parr = new Pair[n];
		final String[][] strarr = { br.readLine().split(" +"), br.readLine().split(" +") };

		IntStream.range(0, n).forEach(x->parr[x]=new Pair(pi(strarr[0][x]), pi(strarr[1][x])));

		Arrays.sort(parr, (a,b)->a.f-b.f);

		// System.out.println(Arrays.toString(parr));

		return (int)IntStream.range(0, n-1).map(x->{
			if(parr[x].f<=parr[x+1].s)
				return 1;
			else
				return 0;
		}).filter(x->x>0).count();
	}

	public static int pi(String o){
		return Integer.parseInt(o);
	}
}
public class Pair{
	int s, f;
	public Pair(int sa, int fa){
		s = sa;
		f = fa;
	}
	public String toString(){
		return s+" "+f+", ";
	}
}