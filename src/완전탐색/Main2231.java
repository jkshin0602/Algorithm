package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int ans = 0;
		for (int i = 1; i < N; i++) {
			String s = i + "";
			int sum = i;
			for (char c : s.toCharArray()) {
				sum += (c - '0');
			}

			if (sum == N) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);
	}
}
