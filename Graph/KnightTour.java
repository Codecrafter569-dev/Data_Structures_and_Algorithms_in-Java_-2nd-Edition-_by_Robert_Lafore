import java.util.*;
public class KnightTour{
	private final int N;
	private final int[][] board;
	private final int[] dx = {2,1,-1,-2,-2,-1,1,2};
	private final int[] dy = {1,2,2,1,-1,-2,-2,-1};
	
	public KnightTour(int N){
		this.N = N;
		board = new int[N][N];
		for(int i = 0;i < N;i++){
			
			Arrays.fill(board[i],-1);
		}
		
	}
	public boolean solveFrom(int startX,int startY){
		board[startX][startY] = 0;
		if(dfs(startX,startY,1)){
			return true;
		}else{
			board[startX][startY] = -1;
			return false;
			
		}
		
	}
	private boolean dfs(int x ,int y,int moveCount){
		if(moveCount == N*N){
			return true;
		}
		for(int i = 0;i <dx.length;i++){
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(isValid(nx,ny)){
				board[nx][ny] =  moveCount;
				if(dfs(nx,ny,moveCount+1)){
					
					return true;
				}
				board[nx][ny] = -1;
			}
		}
		return false;
	}
	private boolean isValid(int x ,int y){
		return x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1;
		
	}
	public void printSolution(){
		for(int i = 0;i < N;i++){
			for(int j = 0;j < N;j++){
				System.out.printf("%2d ",board[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		int size = 5;
		int startX = 0, startY = 0;
		if(args.length >= 1){
			size = Integer.parseInt(args[0]);
		}
		if(args.length == 3){
			startX = Integer.parseInt(args[1]);
			startY = Integer.parseInt(args[2]);
		}
		KnightTour kt = new KnightTour(size);
		System.out.println("Attempting Knight's Tour on : "+size+"x"+size+" board starting at ("+startX+","+startY+")...");
		long start = System.currentTimeMillis();
		if(kt.solveFrom(startX,startY)){
			long elapsed = System.currentTimeMillis()-start;
			System.out.println("Solution found in "+elapsed+" ms: ");
			kt.printSolution();
			
		}else{
			long elapsed = System.currentTimeMillis()-start;
			System.out.println("No solution found ("+elapsed+" ms)");
			
		}
	}
}