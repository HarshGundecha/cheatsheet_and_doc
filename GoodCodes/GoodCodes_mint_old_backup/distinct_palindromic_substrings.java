import java.util.*;
import java.lang.*;
import java.io.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> sset = new HashSet<>();
		String str;
		int[] tparr1, tparr2;
		for( int c=0, count=0, l,r,t = Integer.parseInt(br.readLine().trim()); t>0; t--  )
		{
			str = br.readLine().trim();
			sset.clear();
			for(int i=0;i<str.length();i++)
			{
				tparr1 = GFG.checkPalindromefromCenter(str, i, i, sset);
				if(i+1<str.length() && str.charAt(i)==str.charAt(i+1))
					if((tparr2 = GFG.checkPalindromefromCenter(str, i, i+1, sset))[2]>=tparr1[2])
						tparr1 = tparr2;
				l = tparr1[0];
				r = tparr1[1];
				c = tparr1[2];
				sset.add(str.substring(l,r));
				// System.out.println(i+" "+str.substring(l,r));
			}
			System.out.println(sset.size());
		}
	}
	@SuppressWarnings("unchecked")
	public static int[] checkPalindromefromCenter(String str, int l, int r, Set sset)
	{
		int c=0;
		for(;l>-1 && r<str.length() && str.charAt(l)==str.charAt(r); l--, r++, c++)
			sset.add(str.substring(l,r+1));
		l=(l<0?0:l+1);
		if(r > str.length())
			r = str.length();
		return new int[]{l,r,c};
	}
}