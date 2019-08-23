import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.IntStream;
public class GFG
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp;
		int[][] mat;
		Queue<Integer> q;
		boolean[] isVisited;
		boolean layerFlag=false;
		for(int eLeft,layerCount=0,curr,count=0,r,c,i,j,t=Integer.parseInt(br.readLine());t-->0;)
		{
			temp = br.readLine().split(" +");
			r = Integer.parseInt(temp[0]);
			c = Integer.parseInt(temp[1]);
			temp = br.readLine().split(" +");
			q = new LinkedList<>();
			mat = new int[r][c];


			eLeft = makeArray(q, mat, temp);
			
			for(
				layerCount = 0, layerFlag = false, isVisited = new boolean[r*c];
				!q.isEmpty();
			)
			{
				curr = q.remove();
				if(!isVisited[curr])
				{
					int cRow=curr/c, cCol = curr%c, allDir;
					int[][] pos= { {cRow-1, cCol}, {cRow, cCol-1}, {cRow+1, cCol}, {cRow, cCol+1} };
					for(allDir = 0;allDir<4;allDir++)
						layerFlag |= orangeFresher(q, mat, pos[allDir]);
					isVisited[curr] = true;
				}
				if(--eLeft==0)
				{
					eLeft = q.size();
					if(layerFlag)
					{
						layerCount++;
						layerFlag = false;
					}
				}
			}
			System.out.println(((layerCount>0 && freshOranges(mat)==0) ? layerCount :-1 ) );
		}
	}

	public static int makeArray(Queue<Integer> q, int[][] mat, String[] temp)
	{
		for(int r = mat.length, c = mat[0].length,j, count=0, i=0; i<r; i++)
			for(j=0; j<c; j++)
				if( (mat[i][j] = Integer.parseInt(temp[count++])) == 2 )
					q.add(count-1);
		return q.size();	
	}

	public static boolean orangeFresher(Queue<Integer> q, int[][] mat, int[] pos)
	{
		int newcRow = pos[0], newcCol = pos[1], r = mat.length, c = mat[0].length;
		if(newcRow>-1 && newcRow<r && newcCol>-1 && newcCol<c && mat[newcRow][newcCol]==1)
		{
			q.add(newcRow*c+newcCol);
			mat[newcRow][newcCol] = 2;
			return true;
		}
		else
			return false;
	}

	public static int freshOranges(int mat[][])
	{
		int r = mat.length, c = mat[0].length;
		return (int)IntStream.range(0, r*c).map(x->mat[x/c][x%c]==1?1:0).filter(xx->xx==1).count();
	}
}