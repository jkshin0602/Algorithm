package 재귀_분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 수열의 총 길이 구하기
		int[] D = new int[29];
		D[0] = 3;

		// 수열 S(K)의 길이는 S(K-1) * 2 + (i + 3)
		for (int i = 1; i < 29; i++) {
			D[i] = (D[i - 1] * 2) + (i + 3);
		}

		System.out.println(go(N, D));
	}

	// 수열은 S(K-1) + '새로 만들어지는 부분' + S(K-1) 로 이루어짐
	// 1. 새로 만들어지는 부분에 N을 위치 시키면 m/o 을 판단할 수 있다.
	//	1.1 N에서 S(K-1) 길이를 제외한 후 1이면 m, 그 외면 o 이다.
	// 새로 만들어지는 부분에 n이 위치 할 수 있도록 수열을 줄여주면 된다.
	private static char go(int N, int[] D) {
		if (N == 1) {
			return 'm';
		}
		if (N == 2 || N == 3) {
			return 'o';
		}

		int i = 0;
		// 1.1 조건 만들기, N의 길이를 넘기도록
		while (D[i] < N) {
			i++;
		}

		// N의 길이랑 딱 맞다면 S(K-1)이 끝나는 부분이므로 o
		if (D[i] == N) {
			return 'o';
		}

		// N - S(K-1) == 1 이면, '새로 만들어지는 부분'이 시작하는 곳이므로 m
		if (N - D[i - 1] == 1) {
			return 'm';
		}

		// 그 이상이면, '새로 만들어지는 부분' 중 o
		if (N - D[i - 1] <= i + 3) {
			return 'o';
		}

		// 해당 모든 조건문에 걸리지 않았다면, '새로 만들어지는 부분' 이 후의 S(K-1)에 속하는 것

		// N == 현재 길이
		// D[i-1] == S(K-1) 길이
		// i + 3 == 새로 만들어지는 부분 길이
		// N - D[i-1] + (i+3) == 뒷 부분 S(K-1)의 몇 번째 위치를 찾을 것인지
		return go(N - D[i - 1] - (i + 3), D);
	}
}
