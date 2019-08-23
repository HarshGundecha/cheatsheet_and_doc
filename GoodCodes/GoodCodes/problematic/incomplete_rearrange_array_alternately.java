// 1
// 15
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14

// 0,1,3,7,14,13,2,5,11,6,12,4,9,10,8

// 8,14,0

import java.io.*;
import java.lang.*;
import java.util.*;
public class Test
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr;
		for(int i=0, c, j, temp, temp2, t=Test.readi(br)[0]; t>0; t--)
		{
			// System.out.println(t+"...");
			br.readLine();
			arr = Test.readi(br);
			temp = arr[0];
			// temp2 = ((arr.length-i-1)*2);
			int nn=arr.length+(arr.length%2==0?2:1);
			int last = arr.length-1,ibak=0;
			int swapWith;
			for( c=0, i=arr.length-1;i<arr.length;)
			{
				System.out.println(ibak+" "+i);
				ibak = i;
				if(i==last)
					--last;
				if(++c ==nn)
					break;

				swapWith = ((i < (arr.length/2)) ? ((i*2)+1) : ((arr.length-i-1)*2) );
				temp2 = arr[swapWith];
				arr[swapWith] = temp;
				i = swapWith;
				temp=temp2;

				// if(ibak==arr.length-1)
				// 	i=last;
				if(ibak==last && Math.abs(i-ibak)!=1)
					i=--last;

				// System.out.println(Arrays.toString(arr));
			}
		}
	}
	public static int[] readi(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}