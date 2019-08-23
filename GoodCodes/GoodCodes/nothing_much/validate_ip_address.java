//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
public class validip {
	public static void main(String[] args){
		Scanner sc= new Scanner (System.in);
		int t = sc.nextInt();
		while(t-->0){
			String s = sc.next();
			Solution obj = new Solution();
			
			if(obj.isValidIP(s))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Solution {
	public boolean isValidIP(String s){


		String[] sarr = s.trim().split("\\.");
		if(sarr.length!=4 || s.charAt(0)=='.' || s.charAt(s.length()-1)=='.')
			return false;
		for(int i=0; i<4; i++)
		{
			try{
				switch(sarr[i].length())
				{
					case 1:
						if(Integer.parseInt(sarr[i]) < 0)
							return false;
						break;
					case 2:
						if(Integer.parseInt(sarr[i]) < 10)
							return false;
						break;
					case 3:
						if(Integer.parseInt(sarr[i]) < 100 || Integer.parseInt(sarr[i]) > 255 )
							return false;
					break;
					default:
						return false;
				}				
			}
			catch(Exception e)
			{
				return false;
			}
		}
		return true;






	}
}