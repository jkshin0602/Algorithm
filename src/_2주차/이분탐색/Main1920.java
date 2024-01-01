package _2주차.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(A,B[i]) ? 1 : 0);
		}
	}

	private static boolean binarySearch(int[] A, int target) {
		int left = 0;
		int right = A.length;

		while (left < right) {
			int mid = (left + right) / 2;

			if (A[mid] == target) {
				return true;
			}

			if (A[mid] > target) {
				right = mid;
			}else{
				left = mid + 1;
			}
		}

		return false;
	}
}
