package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] homes = new int[N];
		for (int i = 0; i < N; i++) {
			homes[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(homes);

		int left = 0;
		int right = homes[N - 1] - homes[0] + 2;

		while (left + 1 < right) {
			int mid = (left + right) / 2;

			// 같거나 많다면?
			// 설치할 공유기의 거리를 늘리면, 설치할 수 있는 집의 갯수가 줄어 든다
			if (check(homes, mid) >= C) {
				left = mid;
			} else {
				right = mid;
			}
		}

		//분포
		//FFFFFFF ...(mid) TTTTTT
		System.out.println(right - 1);
	}

	//인접한 공유기 사이가 mid 이상이 되도록 공유기를 C개 이상 배치할 수 있는가?
	// mid = 설치할 공유기의 거리
	// mid 조건으로 공유기를 설치할 경우, 설치할 수 있는 집의 수가 C랑 같거나 많은가?
	private static int check(int[] homes, int mid) {
		int prevHome = homes[0];
		int cnt = 1;

		for (int i = 1; i < homes.length; i++) {
			if (homes[i] - prevHome >= mid) {
				cnt++;
				prevHome = homes[i];
			}
		}

		return cnt;
	}
}
