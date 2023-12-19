package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805 {

	//나무의 수 1 <= N <= 1,000,000
	//나무의 길이 1 <= M <= 2,000,000,000
	//톱날의 높이 1 <= H <= 1,000,000,000
	//나무 높이의 합은 항상 M보다 크거나 같다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] trees = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		long left = 1;
		long right = 1_000_000_000;

		while (left <= right) {
			long mid = (left + right) / 2;
			long result = getTrees(trees, mid);

			//result > M 이면, left 를 땡긴다.
			if (result >= M) {
				left = mid + 1;
				continue;
			}
			//result < M 이면, right 를 땡긴다.
			right = mid - 1;
		}

		System.out.println(right);
	}

	private static long getTrees(long[] trees, long cut) {
		return Arrays.stream(trees)
			.filter(it -> it > cut)
			.map(it ->
				it - cut
			).sum();
	}
}

//절단기에 높이 H를 지정해야 한다.
//높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다.
//그 후, 한 줄에 연속해 있는 나무는 H 위의 부분이 잘리고, 낮은 나무는 잘리지 않을 것이다.

//H의 길이가 커지면 -> 가져갈 수 있는 나무의 수가 줄어든다.
//H의 길이가 작아지면 -> 가져갈 수 있는 나무의 수가 늘어난다.
//H의 최대 길이를 찾는다(=upper bound)
