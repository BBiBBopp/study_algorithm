package backjun.silver;
/*
 * ���� : �ߺ� ���� N�� �߿��� M�� ����
 *      ���� o -> �ڿ� �ִ� ���Ұ� �տ� ���� ��� Ž��
 *      �ߺ� x -> �̹� �湮�� ���Ҹ� �ٽ� �湮���� �ʵ��� üũ
 * 
 * dfs 
 * 1 > 2�� �˻����� ���� ��� > 3�� �˻����� ���� ��� > 4 // �˻� �������Ƿ� check[4] = false;
 *                     > 4�� �˻����� ���� ��� > 3
 */
import java.util.Scanner;

public class B15649 {
	static StringBuilder sb = new StringBuilder(); // 384ms
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] checked = new boolean[N];
		int[] arr = new int[M];
		
		dfs(checked, arr, 0);
		
		System.out.println(sb);
	}

	public static void dfs(boolean[] checked, int[] arr, int depth){
		if(depth == arr.length){ // ���ϴ� �迭 ���̰� ������ ������
			for(int i : arr){
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<checked.length; i++){
			if(!checked[i]){ // �湮���� ���� ���
				checked[i] = true;
				arr[depth] = i + 1; // �־��ֱ�
				
				dfs(checked, arr, depth + 1); // ���� ��� üũ
				
				checked[i] = false;
			}
		}
	}
}

/*
 * int�� �迭 ���� �� 2508ms
public class B15649 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] checked = new boolean[N];
		int[] arr = new int[M];
		
		dfs(checked, arr, 0);
		
	}

	public static void dfs(boolean[] checked, int[] arr, int depth){
		if(depth == arr.length){ // ���ϴ� �迭 ���̰� ������ ������
			for(int val : arr){
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<checked.length; i++){
			if(!checked[i]){ // �湮���� ���� ���
				checked[i] = true;
				arr[depth] = i + 1; // �־��ֱ�
				
				dfs(checked, arr, depth + 1); // ���� ��� üũ
				
				checked[i] = false;
			}
		}
	}
}
*/
