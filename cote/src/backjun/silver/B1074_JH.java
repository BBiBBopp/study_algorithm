package backjun.silver;

import java.util.Scanner;

/*
 * N �� �־����� �� r�� c���� �� ��°�� �湮�ϴ��� �����
 */
public class B1074_JH {

	public static void main(String[] args) {
		//N, r, c
		//3, 7, 7
//		int N = 10;
//		int r = 511;
//		int c = 511;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int count = 0;
		double stand = 0;
		//4��� �߿� ���° �鿡 �ִ��� ã�´�.
		double result = Math.pow(2, N);
		//2 n-1
		for (int i = N; i >= 0; i--) {
			stand = Math.pow(2,i-1);
			int row = 0;
			int col = 1;
			if (r >= stand) {
				row = 1;
			} else {
				row = 0;
			}
			if (c >= stand) {
				col = 1;
			} else {
				col = 0;
			}
			if (row==1 && col==1) {
				count += stand*stand*3;
				r -= stand;
				c -= stand;
			} else if (row==1 && col==0) {
				count += stand*stand*2;
				r -= stand;
			} else if (row==0 && col==1) {
				count += stand*stand*1;
				c -= stand;
			} else if (row==0 && col==0) {
				
			}
			
		}
		System.out.println(count);
		
		//
		
		
		
	}
}
