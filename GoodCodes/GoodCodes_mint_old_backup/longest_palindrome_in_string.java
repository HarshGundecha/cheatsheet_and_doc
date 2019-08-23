// 9
// abcdcbjkllkjbcd
// aaaabbaa
// abcdcbjklkjbcd
// qrrc
// m
// aa
// aaa
// baa
// baaa

// loop through all the character
// for each character treverse both of its side and see if palindrom is found
// 	if found and if its length is bigger then the previous one then register this as biggest palindrome uptil now else ignore and proceed
// 	//whenever a palindrome is found you can advance the character pointer to the end of found palindrom's index+1, given that palindromes cant overlap
	
// pstart=0,pend=1
// for(i=1;i<sarr[i].length()-1;i++)
// {
// 	for(c=0, j=i; i-j>-1 && i+j<sarr[i].length(); j++)
// 	{
// 		c++;
// 	}
// 	if((i+j)-(i-j) > pennd-pstart)
// 	{
// 		pstart = i-j;
// 		pend = i+j;
// 	}
// }
import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int[] tmpArr1,tmpArr2;
		for(int pstart,pend,i,r,l,c=0,t = Integer.parseInt(br.readLine()); t>0;t--)
		{
			str = br.readLine().trim();
			for(pstart=0, pend=1, i=0; i<str.length(); i++)
			{
				tmpArr1 = checkPalindromeFromCenter(str, i, i);
				if(i+1<str.length() && str.charAt(i)==str.charAt(i+1))
				{
					tmpArr2 = checkPalindromeFromCenter(str, i, i+1);
					if( tmpArr2[0] >= tmpArr1[0] )
						tmpArr1 = tmpArr2;
				}
				l = tmpArr1[1];
				r = tmpArr1[2];
				if( l>-1 && r<=str.length() && (r-l) > (pend-pstart) )
				{
					pstart = l;
					pend = r;
					c = tmpArr1[0];
					i+=c-2;
				}
			}
			System.out.println(str.substring(pstart, pend));
		}
	}

	public static int[] checkPalindromeFromCenter(String str, int l, int r)
	{
		int c=0;
		for(;l>-1 && r<str.length() && str.charAt(l)==str.charAt(r);)
		{
			c++;
			l--;
			r++;
		}
		return new int[]{c,++l,r};
	}
}