package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2026/02/06
 * @author weiss
 * 문제
 * 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 * 
 * 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
 * 
 * 입력
 * 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
 * 
 * 둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
 * 
 * 출력
 * 첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 * 
 */

// 나머지 합
// 1. 합배열 생성
// S[i] = S[i-1] + A[i]
public class P10986 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken()); // 숫자 카운트
			int m = Integer.parseInt(st.nextToken()); // 제수
			long sum = 0;
			
			st = new StringTokenizer(bf.readLine());
			long[] remainList = new long[m];
			for(int i = 1; i <= n; i++) {
				sum = sum + Integer.parseInt(st.nextToken());
				remainList[(int) (sum % m)]++;
			}
			
			long res = remainList[0];
			for(int i = 0; i < m; i++) {
				res = res + (remainList[i] * (remainList[i] - 1) / 2);
			}
			System.out.print(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
