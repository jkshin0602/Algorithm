package _4주차.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();

		Integer[] nums = new Integer[N.length()];
		for (int i = 0; i < N.length(); i++) {
			nums[i] = N.charAt(i) - '0';
		}

		Arrays.sort(nums, (o1, o2) -> o2 - o1);

		int sum = Arrays.stream(nums).mapToInt(Integer::intValue).sum();

		String result = Arrays.toString(nums)
			.replace("[", "")
			.replace("]", "")
			.replace(",", "")
			.replace(" ", "");

		System.out.println(sum % 3 == 0 && result.charAt(result.length()-1) == '0' ? result : - 1);
	}
}
