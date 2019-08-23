import java.math.
import java.util.*;
class BinarySearch
{
	public static void main(String args[])
	{
		// InEfficient I/O
		// focus on bin_search() not the main()
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int key =sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.bin_search(arr,0,n-1,key));
			T--;
		}
	}
}

class GfG
{
	int bin_search(int a[], int l, int r,  int k)
	{		
		for(int m = (l+r)/2; l<=r; m = (l+r)/2)
			if( a[m] < k )
				l = m+1;
			else if( a[m] > k )
				r = m-1;
			else
				return m;
		return -1;
	}
}