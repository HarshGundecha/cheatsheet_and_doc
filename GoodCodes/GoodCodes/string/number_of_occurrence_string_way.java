// works for both sorted and unsorted, since processes by string and not by int
import java.io.*;
import java.util.*;
public class GFG{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String k;
		for(
			int t = GFG.readi(br)[0],m,n,reli;
			t>0;
			t--//, sb.append()
		)
		{
			k = String.valueOf(GFG.readi(br)[1]);
			sb.append(GFG.readFiltered(br, k)+"\n");
		}
		System.out.print(sb);
	}
	public static int[] readi(BufferedReader br)throws IOException {
		return Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
	public static int readFiltered(BufferedReader br, String findMe)throws IOException {
		int temp = (int)Arrays.stream(br.readLine().trim().split(" ")).filter(str->str.equals(findMe)).count();
		return temp!=0?temp:-1;
	}
}