import java.util.*;
import java.lang.*;
import java.io.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		for(int i=0;i<str.length();i++)
			System.out.println(GFG.checkPalindromefromCenter("abcdmnommonmklop", i, i));		
	}
	public static int checkPalindromefromCenter(String str, int l, int r)
	{
		int c=0;
		for(;l>0 && r<str.length() && str.charAt(l)==str.charAt(r); l--, r++, c++);
		return c;
	}
}
