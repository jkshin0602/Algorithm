package 프로그래머스.lv3;

import java.util.Arrays;

public class 최고의_집합 {

	public static int[] solution(int n, int s) {
		if (n > s) {
			return new int[] {-1};
		}

		int x = s / n;
		int result = s % n;

		int[] answer = new int[n];
		Arrays.fill(answer, x);

		for (int i = n - 1; i >= 0; i--) {
			if (result <= 0) {
				break;
			}
			answer[i]++;
			result--;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 9)));
		System.out.println(Arrays.toString(solution(2, 1)));
		System.out.println(Arrays.toString(solution(2, 8)));
	}
}
