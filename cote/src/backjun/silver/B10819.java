package backjun.silver;
/*
 * N���� ������ �̷���� �迭 A 
 * |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| �ִ� ���ϱ�
 */
import java.util.Scanner;

public class B10819 {
	static int N;
	static int[] A;
	static boolean[] checked;
	static int[] arr;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		N = sc.nextInt();
		A = new int[N];
		
		for(int i=0; i<N; i++){
			A[i] = sc.nextInt();
		}
		
		checked = new boolean[N];
		int[] arr = new int[N]; // ���ĵ� �迭�� ���� ����
		dfs(arr, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int[] arr, int depth){
		int temp;
		if(depth == N){
			temp = 0;
			for(int i=1; i<N; i++){
				temp += Math.abs(arr[i] - arr[i-1]);
			}
			if(temp>max) max = temp;
			return;
		}
		
		for(int i=0; i<N; i++){
			if(!checked[i]){
				checked[i] = true;
				arr[depth] = A[i];
				
				dfs(arr, depth+1);
				
				checked[i] = false;
			}
		}
	}
}
