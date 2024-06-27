package backjun.ruby;

import java.util.Scanner;

public class B5460 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 표적의 갯수
		int r = sc.nextInt(); // 경기 수
		int swRank = sc.nextInt();

		int[][] ranks = new int[2*n-1][2]; // 경쟁자 등수
		for(int i=0; i<ranks.length; i++){
			ranks[i][0] = sc.nextInt();
			ranks[i][1] = sc.nextInt();
		}
		
		if(swRank == 1) {
			// ▶  1 등인 경우 무조건 맨 앞으로 감
			System.out.println(n);			
		} else if(swRank == 2*n) {
			// ▶  꼴찌인 경우 2번째 과녁에 서있으면 과녁 고정
			System.out.println(2);
		} else if(swRank > n + 1) {
			// ▶  n+1 < 내 등수 인 경우 과녁 고정 
			
		}
		
		
		
		
			
		
		
		
		
		
		
		// ▶  2 ~ n+1 등급이 경우 계속 자리 이동
		
		

	}
	
}

