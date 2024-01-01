package _4주차.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[N];

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);

		int ans = 0;

		for (int i = N-1; i > 0; i--) {
			ans += cards[i] + cards[i - 1];
			cards[i - 1] = Math.max(cards[i], cards[i - 1]);
		}

		System.out.println(ans);
	}
}
