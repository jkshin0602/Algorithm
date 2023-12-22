package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main10815 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] findCards = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			findCards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);

		String result = Arrays.stream(findCards)
			.mapToObj(it -> binarySearch(cards, it) ? "1" : "0")
			.collect(Collectors.joining(" "));
		System.out.println(result);
	}

	private static boolean binarySearch(int[] cards, int target) {
		int left = -1;
		int right = cards.length;

		while (left + 1 < right) {
			int mid = (left + right) / 2;

			if (cards[mid] == target) {
				return true;
			} else if (cards[mid] > target) {
				right = mid;
			}else{
				left = mid;
			}
		}

		return false;
	}
}
