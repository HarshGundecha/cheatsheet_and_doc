// 10
// 5
// 1 2 3 4 5
// 6
// 1 2 3 4 5 6
// 5
// 5 4 3 2 1
// 6
// 6 5 4 3 2 1
// 5
// 4 5 1 2 3
// 6
// 4 5 6 1 2 3
// 5
// 3 2 1 5 4
// 6
// 3 2 1 6 5 4
// 5
// 4 5 1 2 3
// 6
// 3 2 1 6 5 4



// if found increment then ascendubgg
// else descemminf

// if max element1 is at extreme than normal else rotated

// type = (2 ,1)[ iarr[0] < iarr[1] ]
// if max!=iarr[iarr.length-1]
// 	type = 5-type

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;
public class GFG{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] iarr;
		Set<Integer> ihash;
		boolean flag;
		int max, high, low, mid;
		for(int i, j, k, t = GFG.readX(br)[0]; t>0; t--)
		{
			br.readLine();
			iarr = GFG.readX(br);
			for(max = -1, high = iarr.length-1, low = 0, mid = (high+low)/2; low<high;mid = (high+low)/2)
			{
				if(mid+1 < iarr.length)
				{
					//System.out.println("yes111");
					if(iarr[mid] > max)
					{
						// System.out.println("yes222");
						if(iarr[mid+1] < iarr[mid])
						{
							high = mid-1;
							max = iarr[mid];
						}
						else//iarr[mid+1] > mid
						{
							low = mid+1;
							max = iarr[mid+1];
						}
					}
					else if(iarr[mid] < max)
					{
						if(iarr[mid+1] < iarr[mid])
						{
							low = mid-1;
						}
						else//iarr[mid+1] > mid
						{
							low = mid+1;
						}
					}
					else if(iarr[mid] == max)
					{
						if(iarr[mid+1] < iarr[mid])
						{
							high = mid;
							break;
						}
						else//iarr[mid+1] > mid
						{
							low = mid+1;
							max = iarr[mid+1];
							break;
						}
					}
					else break;
				}
				else
				{
					System.out.println("just something : "+iarr[mid]);
					break;
				}
			}
			System.out.println(max);
		}
	}
	public static int[] readX(BufferedReader br)throws IOException{
		return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
	// public static Set<Integer> readX2(BufferedReader br)throws IOException{
	// 	return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new));
	// }
}