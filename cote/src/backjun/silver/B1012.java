package backjun.silver;

import java.io.IOException;
import java.util.Scanner;

public class B1012 {
	/*
	 * ���Ž�� (DFS)
	 * [0][0] [0][1] [0][2]
	 * [1][0] [1][1] [1][2]
	 * [2][0] [2][1] [2][2]
	 */

	// �� �� �� ��
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int T;
	static int M; // ����
	static int N; // ����
	static int Y; // ���� ����
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
			
			// �迭 �ȿ� �ִ��� Ȯ�� (cx, cy�� 0���� �۰ų�, M,N���� ũ�� �迭 �ٱ���)
			if(cx >= 0 && cy >= 0 && cx < M && cy < N){
				// ���� �湮���� �ʾҰ�, ���߰� �ɾ��������� �湮��
				if(!check[cx][cy] && ground[cx][cy] == 1){
					dfs(cx, cy);
				}
			}
		}
	}
}
