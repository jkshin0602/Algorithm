package _1주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			String input = br.readLine();

			StringTokenizer st = new StringTokenizer(input);
			String c = st.nextToken();

			switch (c) {
				case "push":
					int value = Integer.parseInt(st.nextToken());
					stack.push(value);
					break;
				case "pop":
					int result = stack.isEmpty() ? -1 : stack.pop();
					System.out.println(result);
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					System.out.println(stack.isEmpty() ? 1 : 0);
					break;
				case "top":
					System.out.println(stack.isEmpty() ? -1 : stack.peek());
					break;
			}
		}
	}
}
