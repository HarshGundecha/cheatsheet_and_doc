import java.lang.*;
import java.io.*;
import java.util.*;
//import java.util.stream.Stream; 

public class ChocolateDistribution
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, i, s, min, t = Integer.parseInt(br.readLine().trim());
        int[] intArr;
        StringBuffer sb = new StringBuffer();
        while(t-->0)
        {
            n = Integer.parseInt(br.readLine().trim());
            intArr = Arrays.stream(br.readLine().trim().split(" "))
                    //.parallel()
                    // .sorted((a,b)->b.compareTo(a)) //descending sort, if used keep it above mapToInt else below
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            s = Integer.parseInt(br.readLine().trim())-1;
            for( min = Integer.MAX_VALUE, i=0; i<n-s; i++)
                min = (intArr[i+s]-intArr[i] < min ? intArr[i+s]-intArr[i] : min);
            sb.append(min+"\n");
        }
        System.out.println(sb);
    }
}