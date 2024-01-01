package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3079 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] times = new long[N];
		for (int i = 0; i < N; i++) {
			times[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(times);

		long left = 0;
		long right = times[0] * M + 1;

		while (left + 1 < right) {
			long mid = (left + right) / 2;

			long result = check(times, mid);

			// 최대 인원 수가 M 보다 크면, 최대 시간을 줄인다.
			// 최솟값을 구해야 하므로, right를 최대한 땡겨야 한다.
			if (result < M) {
				left = mid;
			}else{
				right = mid;
			}
		}

		//FFFFFF ... TTTTTT 분포
		System.out.println(right);
	}

	//target 초 동안 검사할 수 있는 최대 인원의 수
	private static long check(long[] times, long target) {
		return Arrays.stream(times)
			.map(it -> target / it)
			.sum();
	}
}
