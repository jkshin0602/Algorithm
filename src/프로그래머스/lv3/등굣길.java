package 프로그래머스.lv3;

public class 등굣길 {
	private static final int MOD = 1_000_000_007;

	public static int solution(int m, int n, int[][] puddles) {
		int[][] D = new int[101][101];

		for (int[] puddle : puddles) {
			int x = puddle[0];
			int y = puddle[1];
			D[y][x] = -1;
		}

		if (D[2][1] != -1) {
			D[2][1] = 1;
		}

		if (D[1][2] != -1) {
			D[1][2] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (D[i][j] == -1) { // 탐색 하는 곳이 물 웅덩이라면 탐색 x
					continue;
				}

				if (D[i][j - 1] != -1) { // 위쪽이 물웅덩이가 아니라면
					D[i][j] = (D[i][j] + D[i][j - 1]) % MOD;
				}

				if (D[i - 1][j] != -1) { // 왼쪽이 물웅덩이가 아니라면
					D[i][j] = (D[i][j] + D[i - 1][j]) % MOD;
				}

			}
		}

		return D[n][m];
	}

	public static void main(String[] args) {
		System.out.println(
			solution(
				4,
				3,
				new int[][] {{2, 2}}
			)
		); // 4
	}

	// 물에 잠기지 않은 지역을 통해 학교로 가려고 한다
	// 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있다
	// 집의 좌표는 (1, 1), 학교가 있는 좌표는 (m, n)

	// 오른쪽과 아래쪽으로만 움직일 수 있다.
	// 집에서 학교까지 갈 수 있는 최단 경로의 개수를 1,000,000,007 로 나눈 나머지

	// 격자의 크기 m, n
	// 물이 잠긴 지역의 좌표 2차원 배열

	// 격자의 크기는 1 <= m, n <= 100
	// m 과 1이 모두 1인 경우는 x

	// 0 <= 물에 잠긴 지역 <= 10
	// 집과 학교가 물에 잠기지는 않음

}
