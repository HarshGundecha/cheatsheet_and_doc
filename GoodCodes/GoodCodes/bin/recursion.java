import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

public class GFG
{
	static int[][] mat;
	static int cc,x,y,k;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)throws IOException
	{
		for(int t=Integer.parseInt(br.readLine()); t>0; t--)
		{
			System.out.append(readi()+"\n");
		}
	}
	public static int pi(String o){
		return Integer.parseInt(o);
	}
	public static String readi()throws IOException
	{
		String[] temp = br.readLine().split(" +");
		int r = pi(temp[0]), i, j, count = 0, c = pi(temp[1]);
		temp = br.readLine().split(" +");
		mat = new int[r][c];
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		for(i=0;i<r;i++)
			for(j=0;j<c;j++)
				mat[i][j] = pi(temp[count++]);

		temp = br.readLine().split(" +");
		x = pi(temp[0]);
		y = pi(temp[1]);
		k = pi(temp[2]);
		cc = mat[x][y];
		mat[x][y] = k;
		floodFill();

		for(count=0,i=0;i<r;i++)
			for(j=0;j<c;j++)
				sb.append(mat[i][j]+" ");
		return sb.toString();
	}

	public static void floodFill()
	{
		int[][] coords = {{x-1,y}, {x,y-1}, {x+1,y}, {x,y+1}};
		for(int i=0;i<4;i++)
		{
			x = coords[i][0];
			y = coords[i][1];
			if(x>-1 && y>-1 && x<mat.length && y<mat[0].length && mat[x][y]==cc)
			{
				mat[x][y]=k;
				floodFill();
			}
		}
	}
}