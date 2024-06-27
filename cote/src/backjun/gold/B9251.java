package backjun.gold;
/*
 * ���� ���� ���ڿ�(Longest Common Substring) : ���ӵǴ� ���ڿ�
 * LCS[i][j] = LCS[i-1][j-1] + 1
 * 
 * ���� ���� �κ� ����(Longest Common Subsequence) : ���ڿ��� ���������� �ʾƵ� �ȴ�.
 * �� ���ڰ� ��ġ�ϴ� ��� : LCS[i][j] = LCS[i-1][j-1] + 1
 * �� ���ڰ� ��ġ���� �ʴ� ��� : LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1])
 * 
 */
import java.util.Scanner;

public class B9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int[][] lcs = new int[str1.length()+1][str2.length()+1];
		int max = 0;
		for(int i=1; i<str1.length()+1; i++){
			for(int j=1; j<str2.length()+1; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
				
				if(lcs[i][j] > max) max = lcs[i][j];
			}
		}
		
		System.out.println(max);
	}
}
