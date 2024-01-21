package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int ans = 0;
		for (int i = 666; ; i++) {
			String s = i + "";
			if (s.contains("666")) {
				ans++;
			}

			if (ans == N) {
				System.out.println(i);
				return;
			}
		}
	}
}
