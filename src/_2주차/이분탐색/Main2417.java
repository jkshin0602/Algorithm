package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2417 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		if (N == 0) {
			System.out.println(0);
			return;
		}

		long left = -1;
		long right = Long.MAX_VALUE - 1;

		while (left + 1 < right) {
			long mid = (left + right) / 2;

			if (Math.pow(mid, 2) < N) {
				left = mid;
			}else{
				right = mid;
			}
		}

		System.out.println(right);
	}
}

// FFFFF mid TTTTTT
//
