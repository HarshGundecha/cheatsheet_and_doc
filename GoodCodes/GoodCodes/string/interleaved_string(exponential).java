import java.io.*;
public class Test
{
	public static void main(String[] args)
	{
		// String str1="xxy";
		// String str2="xxz";
		// String str3 = "xxxxzy";
		String str1="1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
		String str2="1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
		String str3 = "1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
		System.out.println(isInterLeaving(str1,str2,str3));
	}
	public static boolean isInterLeaving(String a, String b, String c)
	{
		if( a.length() == 0 && b.length() == 0 && c.length() == 0 )
			return true;
		else if(c.length()==0)
			return false;
		else
			return (
				(
					(a.length() > 0 && a.charAt(0)==c.charAt(0)) 
					&& 
					isInterLeaving(a.substring(1),b,c.substring(1))
				)
				||
				(
					(b.length() > 0 && b.charAt(0)==c.charAt(0)) 
					&& 
					isInterLeaving(a,b.substring(1),c.substring(1))
				)
			);
	}
}