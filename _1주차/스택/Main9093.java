package _1주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9093 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String input = br.readLine();

			Stack<Character> stack = new Stack<>();

			for (char c : input.toCharArray()) {
				if (c == ' ') {
					makeAnswer(stack, sb);
					sb.append(' ');
					continue;
				}
				stack.push(c);
			}

			makeAnswer(stack, sb);

			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void makeAnswer(Stack<Character> stack, StringBuilder sb) {
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}
