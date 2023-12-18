package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long[] lanCables = new long[K];
		for (int i = 0; i < K; i++) {
			lanCables[i] = Integer.parseInt(br.readLine());
		}

		long left = 1;
		long right = Integer.MAX_VALUE;

		// N 개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.
		while (left <= right) {
			long mid = (left + right) / 2;

			long result = divideLan(lanCables, mid);

			// 결과가 N 보다 크다면 자르는 랜선의 길이를 올려야 한다 -> left 를 땡겨야 한다.
			if (result >= N) {
				left = mid + 1;
			}
			// 결과가 N 보다 작으면 자르는 랜선의 길이를 낮춰야 한다 -> right 를 땡겨야 한다.
			else {
				right = mid - 1;
			}
		}

		System.out.println(right);
	}

	private static long divideLan(long[] lanCables, long len) {
		return Arrays.stream(lanCables)
			.map(lanCable -> lanCable / len)
			.sum();
	}
}
