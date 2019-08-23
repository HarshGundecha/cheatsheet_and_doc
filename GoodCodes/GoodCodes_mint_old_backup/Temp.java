import java.lang.*;
import java.io.*;
import java.util.*;
//import java.util.stream.Stream; 

public class Temp
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, i, s, min;
        int[] intArr;
        StringBuffer sb = new StringBuffer();
				//n = Integer.parseInt(br.readLine().trim());
				intArr = Arrays.stream(br.readLine().trim().split(" "))
								//.parallel()
								.boxed()
								.sorted(((a,b)->b.compareTo(a))) //descending sort, if used keep it above mapToInt else below
								.mapToInt(Integer::parseInt)
								// .sorted()
								.toArray();
				for( i=0; i<intArr.length; i++)
					sb.append(intArr[i]+" ");
        System.out.println(sb);
    }
}