package backjun.bronze;
/*
 * Arrays.fill(int[], int) : Ư���� ������ �迭 �ʱ�ȭ
 * Arrays.setAll(int[], generator) : ������ ���Ҹ� �Լ��� �������� �ʱ�ȭ(������ ���鼭 generator �򰡽� ����)
 * ���� 1) 
 * 	Arrays.setAll(a, index -> 2*index); : index��° ��ġ�� �ִ� ���� 2*index ����
 * ���� 2) 
 *  Arrays.setAll(a, x -> new Obj(3)); : ������ index�� ���ο� Obj ����
 * 
 * ���� : https://codingdog.tistory.com/entry/java-arrays-fill-%EB%A9%94%EC%86%8C%EB%93%9C%EC%99%80-setAll-%EB%A9%94%EC%86%8C%EB%93%9C%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90%EC%9D%84-%EC%95%8C%EC%95%84%EB%B4%85%EC%8B%9C%EB%8B%A4
 */

/*
 * DP
 * : ������ ������ ���� ���� ������ ������ �и��Ͽ� �κ��� ������ �ذ������ν� ���������� ������ ������ ���� ���ϴ� ���(����� ���ٹ�)
 * 
 * < DP�� ���� �� ���� ��� >
 * - ū ������ ���� ������ ���� �� �־�� �Ѵ�.
 * - ���� �������� �ݺ��� ��Ÿ���� ���Ǹ� �� ���� �������� ������� �׻� ���ƾ� �Ѵ�.
 * - �޸������̼�(memoization) : ��� ���� �������� �� ���� ����� DP ���̺� �����ϸ� ���� ������ �� �� DP ���̺��� ����Ѵ�.
 * 
 * D[N] = D[N-1] + D[N-2]
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class B2747 {
	static int[] D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		D = new int[n+1];
		Arrays.fill(D, -1);
		D[0] = 0;
		D[1] = 1;
		
		// bottom-up ���
		for(int i=2; i<n+1; i++){
			D[i] = D[i-1] + D[i-2];
		}
		
		int answer = D[n];
//		int answer = dp(n);
		
		bw.write(Integer.toString(answer)); 
		bw.flush(); 
		bw.close();

	}
	
	
	// top-down ���
	public static int dp(int n){
		if(D[n] != -1) return D[n];
		else D[n] = dp(n-1) + dp(n-2);
		
		return D[n];
	}
	/*
	 * ���� �����ص��� �ʰ� �Ź� �����Ͽ� ���ʿ��� ������ ����
	 * �ð� �ʰ� �߻�
	public static int dp(int n){
		if(n == 0) return 0;
		else if(n == 1) return 1;
		
		return dp(n-1) + dp(n-2);
	}
	*/
}
