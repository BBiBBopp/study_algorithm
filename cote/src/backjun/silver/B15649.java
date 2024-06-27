package backjun.silver;
/*
 * 순열 : 중복 없이 N개 중에서 M개 선택
 *      순서 o -> 뒤에 있는 원소가 앞에 오는 경우 탐색
 *      중복 x -> 이미 방문한 원소를 다시 방문하지 않도록 체크
 * 
 * dfs 
 * 1 > 2가 검사하지 않은 경우 > 3이 검사하지 않은 경우 > 4 // 검사 끝났으므로 check[4] = false;
 *                     > 4가 검사하지 않은 경우 > 3
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
		if(depth == arr.length){ // 구하는 배열 깊이가 나오면 끝내기
			for(int i : arr){
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<checked.length; i++){
			if(!checked[i]){ // 방문하지 않은 경우
				checked[i] = true;
				arr[depth] = i + 1; // 넣어주기
				
				dfs(checked, arr, depth + 1); // 다음 요소 체크
				
				checked[i] = false;
			}
		}
	}
}

/*
 * int형 배열 선언 시 2508ms
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
		if(depth == arr.length){ // 구하는 배열 깊이가 나오면 끝내기
			for(int val : arr){
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<checked.length; i++){
			if(!checked[i]){ // 방문하지 않은 경우
				checked[i] = true;
				arr[depth] = i + 1; // 넣어주기
				
				dfs(checked, arr, depth + 1); // 다음 요소 체크
				
				checked[i] = false;
			}
		}
	}
}
*/
