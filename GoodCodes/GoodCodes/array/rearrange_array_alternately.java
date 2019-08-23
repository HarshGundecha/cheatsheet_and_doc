import java.io.*;
import java.lang.*;
import java.util.*;
public class Test
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr;
		for(int i=0, c, j, temp1, temp2, t=Test.readi(br)[0]; t>0; t--)
		{
			// System.out.println(t+"...");
			br.readLine();
			arr = Test.readi(br);
			temp1 = arr[0];
			temp2 = ((arr.length-i-1)*2);
			int nn=arr.length+(arr.length%2==0?2:1);
			int last = arr.length-1,ibak;
			int swapWith1,swapWith2,temp22,temp21;
			for( c=0, i=0;i<arr.length;)
			{
				ibak = i;
				// System.out.println("..0..");
				if(++c ==nn/2)
					break;

				swapWith1 = ((i*2)+1);
				temp21 = arr[swapWith1];
				arr[swapWith1] = temp1;
				i = swapWith1;
				temp1=temp21;

				swapWith2 = ((arr.length-i-1)*2);
				temp22 = arr[swapWith2];
				arr[swapWith2] = temp22;
				i = swapWith2;

				temp2=temp22;
				// if(ibak==last)
				// 	i=--last;
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	public static int[] readi(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}