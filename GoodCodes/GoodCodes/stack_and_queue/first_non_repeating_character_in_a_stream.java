import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args)throws IOException
	{ 
		for(int t=Integer.parseInt(br.readLine()); t-->0;)
		{
			br.readLine();
			GFG.readi();
		}
		System.out.flush();
	}
	public static void readi()throws IOException
	{
		Character[] chrArr = Arrays.stream(br.readLine().split(" ")).map(x->x.charAt(0)).toArray(Character[]::new);
		String prevAns="-1";
		Map<Character, Integer> hmap = new HashMap<>();
		PrintStream ps = System.out;
		for( int i=0,prevAi=0,j; i<chrArr.length; i++ )
		{
			hmap.put(chrArr[i],hmap.getOrDefault(chrArr[i], 0)+1);

			//even after inserting current character if previous answer is unique, then that is the answer
			if(hmap.getOrDefault(chrArr[prevAi], 0)==1)
				prevAns = chrArr[prevAi]+"";

			//if previous is -1 or after inserting current char previous becomes non unique
			else 
			{
				for(j=prevAi; j<=i && hmap.getOrDefault(chrArr[j],0)!=1; j++);
				prevAi = j==i+1?i:j;
				prevAns = j==i+1?"-1":chrArr[j]+"";
			}
			ps.append(prevAns+" ");
		}
		ps.append("\n");
	}
}