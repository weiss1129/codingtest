package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2026/02/02
 * @author weiss
 * 문제
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 * 
 * 출력
 * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 */
public class P11659 {
	public static void main(String[] args) {
		// 배열 구간 합 구하기
		// 1. 합배열 생성
		// 2. 구간 i ~ j 합 => S[j] - S[i - 1]
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(bf.readLine());
			int numberCount = Integer.parseInt(st.nextToken());
			int questionCount = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			List<Integer> prefixSum = new ArrayList<Integer>();
			int num = 0;
			int sum = 0;
			while (st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
				sum += num;
				prefixSum.add(sum);
			}
			
			int index1 = 0;
			int index2 = 0;
			StringBuilder res = new StringBuilder();
			for(int i = 0; i < questionCount; i++) {
				index1 = Integer.parseInt(st.nextToken());
				index2 = Integer.parseInt(st.nextToken());
				res.append(prefixSum.get(index2) - prefixSum.get(index1 - 1));
				res.append("\r\n");
			}
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
