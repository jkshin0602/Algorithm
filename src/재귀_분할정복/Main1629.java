package 재귀_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		System.out.println(go(A, B, C));
	}

	private static long go(int A, int B, int C) {
		if (B == 1) {
			return A % C;
		}

		long result = go(A, B / 2, C);
		long ans = result * result % C;
		if (B % 2 == 1) {
			ans = ans * A % C;
		}
		return ans;
	}
}
