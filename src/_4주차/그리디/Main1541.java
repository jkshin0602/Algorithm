package _4주차.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// - 연산을 만나면 괄호 시작, - 연산이 끝나면 괄호 닫기
		String[] input = br.readLine().split("-");

		int ans = 0;

		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			// + 를 모두 더해준다.
			String[] split = input[i].split("\\+");
			for (String s : split) {
				sum += Integer.parseInt(s);
			}

			// 첫 시작이면 해당 숫자는 처음 값으로 초기화
			if (i == 0) {
				ans += sum;
			} else {
				ans -= sum;
			}
		}

		System.out.println(ans);
	}
}
