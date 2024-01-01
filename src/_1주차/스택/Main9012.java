package _1주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String input = br.readLine();
			int state = 0;

			for (char c : input.toCharArray()) {
				if (state < 0) {
					break;
				}

				if (c == '(') {
					state++;
					continue;
				}
				state--;
			}

			System.out.println(state == 0 ? "YES" : "NO");
		}
	}
}
