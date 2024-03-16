package 프로그래머스.lv3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 숫자_게임 {
	public static int solution(int[] A, int[] B) {
		Arrays.sort(A);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int b : B) {
			pq.add(b);
		}

		int answer = 0;
		for (int a : A) {
			while (!pq.isEmpty()) {
				if (a < pq.peek()) {
					answer++;
					pq.poll();
					break;
				}
				pq.poll();
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {5, 1, 3, 7}, new int[] {2, 2, 6, 8}));
		System.out.println(solution(new int[] {2, 2, 2, 2}, new int[] {1, 1, 1, 1}));
	}

	// 1 <= len <= 100,000
	// 1 <= A[i], B[i] <= 1,000,000,000
}
