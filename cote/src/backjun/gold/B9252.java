package backjun.gold;

import java.util.Scanner;

public class B9252 {
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
		
		StringBuilder sb = new StringBuilder();
		for(int i=str1.length(); i>0; i--){
			for(int j=str2.length(); j>0; j--){
				if(lcs[i][j] == max) {
					sb.append(str1.charAt(i-1));
					max -= 1;
					i -= 1;
					j -= 1;
				}
			}
		}
		
		System.out.println(sb);
	}
}
