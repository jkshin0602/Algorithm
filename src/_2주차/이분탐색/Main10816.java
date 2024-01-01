package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main10816 {

	public static void main1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			map.put(input, map.getOrDefault(input, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		int[] findCards = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			findCards[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int result = map.getOrDefault(findCards[i], 0);
			sb.append(result).append(" ");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);

		int M = Integer.parseInt(br.readLine());
		int[] findCards = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			findCards[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int first = findLowerBound(cards, findCards[i]);
			int last = findUpperBound(cards, findCards[i]);
			sb.append(last - first).append(" ");
		}

		System.out.println(sb);
	}

	//-10 -10 2 3 3 6 7 10 10 10
	//10 9 -5 2 3 4 5 -10


	//target 의 가장 작은 index
	private static int findLowerBound(int[] cards, int num) {
		int left = 0;
		int right = cards.length ;

		while (left < right) {
			int mid = (left + right) / 2;

			if (num <= cards[mid]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}

		return right;
	}

	//target 의 가장 큰 idx + 1
	private static int findUpperBound(int[] cards, int num) {
		int left = 0;
		int right = cards.length;

		while (left < right) {
			int mid = (left + right) / 2;

			if (num < cards[mid]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}

		return right;
	}
}
