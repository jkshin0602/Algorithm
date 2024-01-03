package _4주차.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2875 {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {
			if (N / 2 >= M) { //여자가 더 많다면?
				N--;
			} else if (N / 2 < M) {
				M--;
			}
		}

		System.out.println(Math.min(N / 2, M));
	}
}
