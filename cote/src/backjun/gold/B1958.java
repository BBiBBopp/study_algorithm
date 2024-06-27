package backjun.gold;

import java.util.Scanner;

public class B1958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String str3 = sc.nextLine();
		
		int[][][] lcs = new int[str1.length()+1][str2.length()+1][str3.length()+1];
		int max = 0;
		for(int i=1; i<str1.length()+1; i++){
			for(int j=1; j<str2.length()+1; j++){
				for(int k=1; k<str3.length()+1;k++){
					if(str1.charAt(i-1) == str2.charAt(j-1) && str1.charAt(i-1) == str3.charAt(k-1)){
						lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1;
					} else {
						lcs[i][j][k] = Math.max(Math.max(lcs[i-1][j][k], lcs[i][j-1][k]), lcs[i][j][k-1]);
					}
					
					if(lcs[i][j][k] > max) max = lcs[i][j][k];
				}
			}
		}
		
		System.out.println(max);
	}
}
