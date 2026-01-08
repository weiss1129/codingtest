package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2026/01/08
 * @author weiss
 * 문제
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 * 
 * 출력
 * 입력으로 주어진 숫자 N개의 합을 출력한다.
 * 
 *
 */
public class P11720 {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input1 = "";
        String input2 = "";
        int res = 0;
        
        try {
            input1 = bf.readLine();
            input2 = bf.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        int index = Integer.parseInt(input1);
        char[] array = input2.toCharArray();
        for(char c : array) {
        	res += Character.getNumericValue(c);
        }
        
        System.out.println(res);
    }
}
