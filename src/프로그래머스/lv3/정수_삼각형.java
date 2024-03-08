package 프로그래머스.lv3;

public class 정수_삼각형 {

	// D[i][j] = max(D[i-1][j-1], D[i-1][j]) + A[i][j])
	// if(j == 0)
	// D[i][j] = A[i][j] + D[i-1][j]

	// if(j == i+1)
	// D[i][j] = A[i][j] + D[i-1][j-1]
	public static int solution(int[][] triangle) {
		if (triangle.length == 1) {
			return triangle[0][0];
		}

		int[][] D = new int[triangle.length][triangle[triangle.length - 1].length];
		D[0][0] = triangle[0][0];
		D[1][0] = D[0][0] + triangle[1][0];
		D[1][1] = D[0][0] + triangle[1][1];

		for (int i = 2; i < triangle.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					D[i][j] = triangle[i][j] + D[i - 1][j];
				} else if (j == i + 1) {
					D[i][j] = triangle[i][j] + D[i - 1][j - 1];
				} else {
					D[i][j] = Math.max(D[i - 1][j - 1], D[i - 1][j]) + triangle[i][j];
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
			answer = Math.max(answer, D[triangle.length - 1][i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(
			new int[][] {
				{7},
				{3, 8},
				{8, 1, 0},
				{2, 7, 4, 4},
				{4, 5, 2, 6, 5}
			}
		));
	}
}
