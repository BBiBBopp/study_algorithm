package backjun.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10809 {
/*
	5
	OOXXOXXOOO		10
	OOXXOOXXOO		9
	OXOXOXOXOXOXOX	7
	OOOOOOOOOO		55
	OOOOXOOOOXOOOOX	30
*/
	static String O = "O";
	static String X = "X";
	
	public static void main(String[] args) {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int n = Integer.parseInt(br.readLine());
			String[] strings = new String[n];
			for(int i=0; i<n;i++){
				strings[i] = br.readLine();
			}
			
			int tempScore;
			int sum = 0;
			
			for(int i=0; i<n; i++){
				String[] OX = strings[i].split("");
				
				tempScore = 0;
				sum = 0;
				for(String answer : OX){
					if(answer.equals(O)){
						tempScore++;
						sum += tempScore ;
					} else {
						tempScore = 0;
					}
				}
				
				bw.write(Integer.toString(sum) + "\n");
			}
			bw.flush(); 
			bw.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
