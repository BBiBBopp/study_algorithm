package backjun.bronze;
/*
 * Arrays.fill(int[], int) : 특정한 값으로 배열 초기화
 * Arrays.setAll(int[], generator) : 각각의 원소를 함수의 내용으로 초기화(루프를 돌면서 generator 평가식 수행)
 * 예시 1) 
 * 	Arrays.setAll(a, index -> 2*index); : index번째 위치에 있는 값에 2*index 적용
 * 예시 2) 
 *  Arrays.setAll(a, x -> new Obj(3)); : 각각의 index에 새로운 Obj 생성
 * 
 * 참조 : https://codingdog.tistory.com/entry/java-arrays-fill-%EB%A9%94%EC%86%8C%EB%93%9C%EC%99%80-setAll-%EB%A9%94%EC%86%8C%EB%93%9C%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90%EC%9D%84-%EC%95%8C%EC%95%84%EB%B4%85%EC%8B%9C%EB%8B%A4
 */

/*
 * DP
 * : 복잡한 문제를 여러 개의 간단한 문제로 분리하여 부분의 문제를 해결함으로써 최종적으로 복잡한 문제의 답을 구하는 방법(상향식 접근법)
 * 
 * < DP의 원리 및 구현 방식 >
 * - 큰 문제를 작은 문제로 나눌 수 있어야 한다.
 * - 작은 문제들이 반복돼 나타나고 사용되며 이 작은 문제들의 결과값은 항상 같아야 한다.
 * - 메모이제이션(memoization) : 모든 작은 문제들은 한 번만 계산해 DP 테이블에 저장하며 추후 재사용할 때 이 DP 테이블을 사용한다.
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
		
		// bottom-up 방식
		for(int i=2; i<n+1; i++){
			D[i] = D[i-1] + D[i-2];
		}
		
		int answer = D[n];
//		int answer = dp(n);
		
		bw.write(Integer.toString(answer)); 
		bw.flush(); 
		bw.close();

	}
	
	
	// top-down 방식
	public static int dp(int n){
		if(D[n] != -1) return D[n];
		else D[n] = dp(n-1) + dp(n-2);
		
		return D[n];
	}
	/*
	 * 값을 저장해두지 않고 매번 재계산하여 불필요한 연산이 잦음
	 * 시간 초과 발생
	public static int dp(int n){
		if(n == 0) return 0;
		else if(n == 1) return 1;
		
		return dp(n-1) + dp(n-2);
	}
	*/
}
