import java.io.*;
public class HackerRank
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1,str2;
		String[] sarr;
		for(int i ,x1=0, x2=0, t=Integer.parseInt(br.readLine());t-->0;)
		{
			sarr = br.readLine().split(" ");
			str1 = sarr[0];
			str2 = sarr[1];
			if(str1.length() == str2.length())
				for(i=0;i<str1.length();i++)
				{
					x1 = x1^(int)str1.charAt(i);
					x2 = x2^(int)str2.charAt(i);
				}
			System.out.println((x1==x2 && str1.length() == str2.length() ?"YES":"NO"));
		}
	}
}