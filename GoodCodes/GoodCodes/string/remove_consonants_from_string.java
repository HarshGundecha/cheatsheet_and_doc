import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder str = new StringBuilder();
		boolean flag;
		for(int i=0;i<t;i++)
		{
			flag = false;
			str = str.append(br.readLine().trim());
			for(int j=0;j<str.length();j++)
				if(!isConsonant(str.charAt(j)))
				{
					flag = true;
					System.out.print(str.charAt(j));
				}
			if(!flag)
				System.out.print("No Vowel");
			System.out.println();
			str.setLength(0);
		}
	}
	public static boolean isConsonant(Character c)
	{
		Character[] carr = new Character[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
		Set<Character> chs = new HashSet<Character>(Arrays.asList(carr));
		return chs.contains(c);
	}	
}	
