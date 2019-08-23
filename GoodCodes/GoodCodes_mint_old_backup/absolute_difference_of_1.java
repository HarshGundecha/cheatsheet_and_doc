import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Trial
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder outBf = new StringBuilder();
		//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 512);
		PrintWriter out = new PrintWriter (new OutputStreamWriter(System.out), true);
		long[] larr;
		long k;
		for(
			int i, t = (int)Trial.readXl(br)[0];
			t > 0;
			outBf.append(larr.length == 0?"-1\n":"\n"), t--
		)
			for(
				k = Trial.readXl(br)[1], larr = Trial.readXlFiltered(br, k), i=0; 
				i < larr.length; 
				outBf.append(larr[i]+" "), i++ 
			);
		//System.out.print(outBf);
		//out.write(outBf.toString());
	    out.append(outBf);
		//out.write();
		out.flush();
	}

	public static long[] readXl(BufferedReader br)throws IOException{
		return Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
	}

	public static long[] readXlFiltered(BufferedReader br, long no)throws IOException{
		return Arrays.stream(
				br.readLine().trim().split(" ")
		)
		.filter((str)->{
			long x = Long.parseLong(str);
			return (x > 9 && x < no) ?
				(
					IntStream.range(0, str.length()-1)
					.filter(i -> Trial.isAbs1(str, i) )
					.count() == str.length()-1
				)
				:
				false;
		})
		.mapToLong(Long::parseLong)
		.toArray();
	}

	public static boolean isAbs1(String str, int i){
		return (Math.abs((Character.getNumericValue(str.charAt(i))-(Character.getNumericValue(str.charAt(i+1)))))==1);
	}
}