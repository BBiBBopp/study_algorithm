package backjun.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[][] str = new String[n][2];
		String[] s;
		
		for(int i=0; i<n;i++){
			str[i] = br.readLine().split(" ");
			s = str[i][1].split("");
			
			for(int j=0; j<s.length;j++){
				for(int k=0; k<Integer.parseInt(str[i][0]);k++){
					bw.write(s[j]); 
				}
			}
			bw.write("\n");
		}

		bw.flush(); 
		bw.close(); 
	}
}
