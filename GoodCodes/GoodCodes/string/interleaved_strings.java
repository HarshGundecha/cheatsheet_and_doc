//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			String a =sc.next();
			String b = sc.next();
			String c = sc.next();
			GfG g=new GfG();
		
			System.out.println(g.isInterLeave(a,b,c)==true?1:0);
			t--;
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
/*you are required to complete this method */
class GfG{
	public boolean isInterLeave(String a,String b,String c)
	{
		if( c.length()==(a.length()+b.length()) )
		{
			int ai=0, bi=0, ci=0;			
			for(ci=0; ci<c.length();ci++)
			{
				if(ai< a.length() && a.charAt(ai) == c.charAt(ci))
					ai++;
				else if(bi< b.length() && b.charAt(bi) == c.charAt(ci))
					bi++;
				else 
					return false;
			}
			return true;
		}
		else
			return false;
	}
}
