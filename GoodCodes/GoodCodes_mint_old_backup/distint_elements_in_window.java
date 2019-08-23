import java.lang.*;
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer outBf;
        int i, n, k, t = Integer.parseInt(br.readLine().trim());
        int[] tempIntArr, intArr;
        Map<Integer, Integer> hm;
        while(t-->0)
        {
            hm = new HashMap<>();
            outBf = new StringBuffer();

            tempIntArr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tempIntArr[0];
            k = tempIntArr[1];
            intArr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            for( i=0; i<k-1; i++ )
                hm.put(intArr[i], hm.getOrDefault(intArr[i], 0) + 1);

            for( i=k-1; i<n ; i++ )
            {
                hm.put(intArr[i], hm.getOrDefault(intArr[i], 0) + 1);

                outBf.append(hm.size()+" ");

                if( hm.get(intArr[i-(k-1)]) > 1 )
                    hm.put(intArr[i-(k-1)], hm.get(intArr[i-(k-1)]) - 1);
                else
                    hm.remove(intArr[i-(k-1)]);
            }
            System.out.println(outBf);
        }
    }
}

