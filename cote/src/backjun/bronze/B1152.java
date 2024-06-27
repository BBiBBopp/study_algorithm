package backjun.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().trim();
		
		int count = str.split(" ").length;
		
		if (str.length() == 0) {
			count = 0;
		}
		
		System.out.println(count);
	}
}
