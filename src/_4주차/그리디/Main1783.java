package _4주차.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1783 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (N == 1) { //세로의 길이가 1이라면 이동 불가
			System.out.println(1);
		} else if (N == 2) { //세로의 길이가 2라면
			// 4번 초과라면 모든 방법을 사용해야 한다. 위, 아래로 2칸씩 이동이 불가하다.
			// (가로의 길이 + 1) / 2 만큼이 4번 까지 최대 이동 수
			System.out.println(Math.min(4, (M + 1) / 2));
		} else if (M < 7) {
			// 4번 초과라면 모든 방법을 사용해야 한다. 오른쪽으로 1, 2, 1, 2 이후 이동이 불가
			// 즉 M이 7이하라면 4번이 최솟 값
			System.out.println(Math.min(4, M));
		} else {
			// 최대 이동 횟수는 M - 2 이다.
			System.out.println(M - 2);
		}
	}
}
