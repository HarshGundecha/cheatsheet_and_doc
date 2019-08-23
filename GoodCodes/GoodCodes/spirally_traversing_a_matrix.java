// 0 1 2 3 4 5 6 7 8

// 0  1  2  3
// 4  5  6  7
// 8  9  10 11
// 12 13 14 15

// 0 1 2 3 7 11 15 14 13 12 8 4 5 6 10 9

// track up/down and left/right
// maintain current spiral size = ceil(sqrt(arr.length)) 

// 10
// hs
// vs
// is = hs;
// incre = 1;
import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] tmparr,arr;
		for(int i, j, row, col, rs, re, ds,de,ls,le,us,ue,t=Integer.parseInt(br.readLine());t-->0;)
		{
			tmparr = GFG.readi(br);
			row = tmparr[0];
			col = tmparr[1];
			arr  = GFG.readi(br);
			rs = 0;
			re = col;
			ds = col*2-1;
			de = arr.length;
			ls = arr.length-2;
			le = arr.length-col-1;
			us = arr.length-col*2;
			ue = 0;
			for(i=0;i<(row>col?row/2:col/2);i++)
			{
				if(re<=us+col)
					for(j=rs;j<re && arr[j]!=-1;j++)
					{
						System.out.print(arr[j]+" ");					
						arr[j]=-1;
					}	
				// System.out.print(rs+" "+re);
				rs+=col+1;
				re+=col-1;

				// System.out.println();

				if(ds<=ue+col+1)
					for(j=ds;j<de && arr[j]!=-1;j+=col)
					{
						System.out.print(arr[j]+" ");					
						arr[j]=-1;
					}	
				// System.out.print(ds+" "+de);
				ds+=col-1;
				de-=col+1;

				// System.out.println();
				if(re<=ls+1)
					for(j=ls;j>le && arr[j]!=-1;j--)
					{
						System.out.print(arr[j]+" ");
						arr[j]=-1;
					}	
				// System.out.print(ls+" "+le);
				ls-=col+1;
				le-=col-1;

				// System.out.println();

				// if(re<=ls+1)
					for(j=us;j>ue && arr[j]!=-1;j-=col)
					{
						System.out.print(arr[j]+" ");
						arr[j]=-1;
					}	
				// System.out.print(us+" "+ue);
				us-=col-1;
				ue+=col+1;


				// rs+=col+1;
				// de-=col+1;
				// ls-=col+1;
				// ue+=col+1;
				// re+=col-1;
				// ds+=col-1;
				// le-=col-1;
				// us-=col-1;

				// System.out.println();
			}
			System.out.println();
		}

	}
	public static int[] readi(BufferedReader br)throws IOException
	{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}