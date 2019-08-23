import java.io.*;
import java.util.*;
public class GFG
{
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)throws IOException
	{
		int[] arr, rightMin;
		for(int i,mini,maxi,t=GFG.readi()[0]; t>0; t--)
		{
			br.readLine();
			arr = GFG.readi();
			rightMin = new int[arr.length];
			for( mini = arr.length-1, i = arr.length-1; i>-1; i-- )
			{
				if( arr[i] < arr[mini] )
					mini = i;
				rightMin[i] = arr[mini];
			}
			for( maxi=0, i=1; i < arr.length-1; i++ )
			if(arr[i]>=arr[maxi])
			{
				maxi=i;
				if(arr[i]<=rightMin[i+1])
					break;
			}
			System.out.println((i==arr.length-1?-1:arr[i]));
		}
	}
	public static int[] readi()throws IOException{
		return Arrays.stream(br.readLine().trim().replaceAll(" +"," ").split(" ")).mapToInt(Integer::parseInt).toArray();
	}	
}