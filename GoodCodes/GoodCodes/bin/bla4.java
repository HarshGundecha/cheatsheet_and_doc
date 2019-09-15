// 2
// 8
// Hi Hello HelloWorld HiTech HiGeek HiTechWorld HiTechCity HiTechLab
// HA
// 3
// WelcomeGeek WelcomeToGeeksForGeeks GeeksForGeeks
// WTG
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args)throws IOException
	{
		String[] strarr;
		String str, regex;
		boolean flag;
		StringBuilder sb = new StringBuilder();
		for(int i, j, k, t=pi(br.readLine()); t>0; t--)
		{
			br.readLine();
			strarr = reads();
			str = br.readLine();
			sb.append("^");
			for(i=0;i<str.length();i++)
				sb.append(str.charAt(i)+".*");

			regex = sb.toString();
			flag = true;
			for (String sa : strarr)
				if(sa.matches(regex))
				{
					flag = false;
					System.out.print(sa+" ");
				}

			System.out.println((flag?"No match found":""));
			sb.setLength(0);
		}
		// System.out.println(op);        
	}
	public static String[] reads()throws IOException
	{
		return br.readLine().split(" ");
	}

	public static int pi(String str){
		return Integer.parseInt(str);
	}
}