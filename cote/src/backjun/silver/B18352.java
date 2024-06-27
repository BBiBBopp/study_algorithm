/*
 * �ܹ��� 

 * �ִܰŸ� �迭(int)
 *   1 2 3 4
 * 1 0 1 1 0
 * 2 0 0 1 1 
 * 3 0 0 0 0
 * 4 0 0 0 0
 * 
 * �ʺ�켱 Ž��
 * ���� ���� Queue�� �ֱ�
 * ����� ���� �湮���� ���� ��� Queue�� �ֱ�
 * Queue�� ����� �� ����
 * 
 * ex)
 * Queue : 1
 * list[1][2] = 1, list[1][3] = 1
 * 1 ��� �������ϱ� ����
 * Queue : 2, 3
 * 2
 * list[2][3] = 1, list[2][4] = 1
 * 2 ����
 * 3
 * ����
 * ��
 */
package backjun.silver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B18352 {
	static int N;
	static int M;
	static int K;
	static int X;
	static int[] visited;
	static int[][] road;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();
		
		road = new int[N+1][N+1];
		HashMap<Integer, Integer> roadMap = new HashMap<>();
		
		
		for(int i=1; i<=N; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			road[a][b] = 1;
		}
		
		visited = new int[N+1];
		Arrays.setAll(visited, x -> -1);
		
		bfs(X);
		
		int answer = 0;
		for(int i : visited){
			if(i == K) answer++;
		}
		
		System.out.println((answer == 0) ? -1 : answer);
	}
	
	
	public static void bfs(int start){
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = 0;
		
		while(!q.isEmpty()){
			int now = q.poll();
			
			// ���� ���ÿ� ����� ���ø� �湮�� ���� ������
//			for(int i=1; i<=N; i){
//				if(i == 1 && visited[i] == -1){
//					// ���� ���ÿ��� +1���� ������ �Ÿ� ������Ʈ
//					visited[i] = visited[now] + 1;
//					q.offer(i);
//				}
//			}
		}
	}
}
