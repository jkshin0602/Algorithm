package _4주차.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] distance = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}

		long[] prices = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			prices[i] = Long.parseLong(st.nextToken());
		}

		long minPrice = prices[0];
		long ans = minPrice * distance[1];

		//다음 목적지에 도착했을 때, 이전 주유소 가격보다 싸면 해당 가격으로 넣는다.
		//비싸면, 기존 가격으로 넣는다.

		for (int i = 2; i < N; i++) {
			if (minPrice > prices[i-1]) {
				minPrice = prices[i-1];
			}
			ans += (minPrice * distance[i]);
		}

		System.out.println(ans);
	}

	// N개의 도시들은 일직선 도로 위에 있다.
	// 제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차로 이동
	// 인접한 두 도시 사이의 도로들은 서로 길이가 다름

	// 처음 출발 할 때는 자동차에 기름이 없어 주유소에서 기름을 넣고 출발
	// 1km/1L 연비
	// 제일 오른쪽 도시로 이동하는 최소 비용 계산
}
