package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2792 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] jewels = new int[M];
		for (int i = 0; i < M; i++) {
			jewels[i] = Integer.parseInt(br.readLine());
		}

		int left = 0;
		int right = Arrays.stream(jewels).max().getAsInt()+1;

		while (left + 1 < right) {
			int mid = (left + right) / 2;

			int result = check(jewels, mid);

			// result > N -> N명보다 더 많은 사람이 보석을 가져간 것
			// 더 적게 가져가게 해야함 -> left 를 땡긴다.
			// 한 명이 가져가는 보석의 수를 늘린다.
			if (result > N) {
				left = mid;
			}else {
				right = mid;
			}
			//질투심이 최소가 되도록
			//TTTTTTT ... FFFFFFF
		}
		System.out.println(right);
	}

	private static int check(int[] jewels, int target) {
		return Arrays.stream(jewels)
			.map(it -> {
				int cnt = 0;
				cnt += it / target;
				cnt += it % target > 0 ? 1 : 0;
				return cnt;
			}).sum();
	}
}
