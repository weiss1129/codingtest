package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2026/02/04
 * @author weiss
 * 문제
 * N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.
 * 
 * 예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
 * 
 * 1	2	3	4
 * 2	3	4	5
 * 3	4	5	6
 * 4	5	6	7
 * 여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
 * 
 * 표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)
 * 
 * 출력
 * 총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
 * 
 */
public class P11660 {
	public static void main(String[] args) {
		// 2차원 배열 구간 합 구하기
		// 1. 합배열 생성
		// -> S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j] 
		// 2. (x1, y1) ~ (x2, y2) 값 구하기
		// -> S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1][y1]
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long[][] prefixSum = new long[n + 1][n + 1];
			int num = 0;
			
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j = 1; j <= n; j++) {
					num = Integer.parseInt(st.nextToken());
					prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + num;
				}
			}
			int x1 = 0;
			int x2 = 0;
			int y1 = 0;
			int y2 = 0;
			long sum = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				x1 = Integer.parseInt(st.nextToken());
				y1 = Integer.parseInt(st.nextToken());
				x2 = Integer.parseInt(st.nextToken());
				y2 = Integer.parseInt(st.nextToken());
				sum = prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
				sb.append(sum).append("\n");
			}
			System.out.print(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
