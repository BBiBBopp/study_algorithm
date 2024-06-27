package backjun.silver;

import java.io.IOException;
import java.util.Scanner;

public class B1012 {
	/*
	 * 사방탐색 (DFS)
	 * [0][0] [0][1] [0][2]
	 * [1][0] [1][1] [1][2]
	 * [2][0] [2][1] [2][2]
	 */

	// → ↓ ← ↑
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int T;
	static int M; // 가로
	static int N; // 세로
	static int Y; // 배추 개수
	static int[][] ground;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int i=0; i<T; i++){
			count = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			Y = sc.nextInt();
			
			ground = new int[M][N];
			for(int j=0; j<Y; j++){
				int m = sc.nextInt();
				int n = sc.nextInt();
				
				ground[m][n] = 1;
			}
			
			check = new boolean[M][N];
			for(int x=0; x<M; x++){
				for(int y=0; y<N; y++){
					if(!check[x][y] && ground[x][y] == 1){
						dfs(x, y);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	static int count;
	static boolean[][] check;
	public static void dfs(int x, int y){
		check[x][y]	= true;
		
		for(int i=0; i<4; i++){
			int cx = x + dx[i];
			int cy = y + dy[i];
			
			// 배열 안에 있는지 확인 (cx, cy가 0보다 작거나, M,N보다 크면 배열 바깥임)
			if(cx >= 0 && cy >= 0 && cx < M && cy < N){
				// 아직 방문하지 않았고, 배추가 심어져있으면 방문함
				if(!check[cx][cy] && ground[cx][cy] == 1){
					dfs(cx, cy);
				}
			}
		}
	}
}
