package backjun.ruby;

import java.util.Scanner;

public class B5460 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // ǥ���� ����
		int r = sc.nextInt(); // ��� ��
		int swRank = sc.nextInt();

		int[][] ranks = new int[2*n-1][2]; // ������ ���
		for(int i=0; i<ranks.length; i++){
			ranks[i][0] = sc.nextInt();
			ranks[i][1] = sc.nextInt();
		}
		
		if(swRank == 1) {
			// ��  1 ���� ��� ������ �� ������ ��
			System.out.println(n);			
		} else if(swRank == 2*n) {
			// ��  ������ ��� 2��° ���ῡ �������� ���� ����
			System.out.println(2);
		} else if(swRank > n + 1) {
			// ��  n+1 < �� ��� �� ��� ���� ���� 
			
		}
		
		
		
		
			
		
		
		
		
		
		
		// ��  2 ~ n+1 ����� ��� ��� �ڸ� �̵�
		
		

	}
	
}

