import java.io.*;
import java.util.*;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		boolean flag;
		int vi, viend;
		String tempChar;
		for(int i, j, t = Integer.parseInt(br.readLine()); t>0;t--)
		{
			str = str.append(br.readLine().trim());
			flag=true;
			List<Integer>vlist = new ArrayList<>();
			for(i=0; i<str.length(); i++)
				if(isVowel(str.charAt(i)))
					vlist.add(i);					

			for(i=0; i<(vlist.size()/2); i++)
			{
				vi = vlist.get(i);
				viend=vlist.get((vlist.size()-1)-i);
				tempChar = String.valueOf(str.charAt(vi));
				str.replace(vi, vi+1, String.valueOf(str.charAt(viend)));
				str.replace(viend, viend+1, tempChar);
			}
			System.out.println(str);
			str.setLength(0);
		}
	}
	public static boolean isVowel(Character c)
	{
		Character[] carr = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		Set<Character> chs = new HashSet<>(Arrays.asList(carr));
		return chs.contains(c);
	}
}