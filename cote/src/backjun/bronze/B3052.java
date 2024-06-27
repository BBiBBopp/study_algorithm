package backjun.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class B3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = 10;
		
		int[] numbers = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<n;i++){
			numbers[i] = Integer.parseInt(br.readLine());
			set.add(numbers[i]%42);
		}
		bw.write(Integer.toString(set.size())); 
		bw.flush(); 
		bw.close(); 
	}
}
