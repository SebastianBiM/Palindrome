package Palindrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static String solution(ArrayList<Integer> list) {
		
		Map<Long, int[]> map = new HashMap<>();
			
		int j = 0;		
		int[] var;
		
	for(int x : list){
			for (j = list.get(0); j <= x; j++) {
				if(list.contains(j)){
					if(!map.containsKey(x * j)){	
						if (isPalindrome(Long.toString(x * j))) {
							long t = x * j;
							var = new int[2];
							var[0] = x;
							var[1] = j;
							
							map.put(t, var);
						}
					}	
				}
			}		
	}

	
		String finalScore = Long.toString(Collections.max(map.keySet()));
		var = map.get(Long.valueOf(finalScore));
		
		return "Palindrome : " +
		 			finalScore + 
		 				" Multipliers : " +
		 					var[0] + 
		 						" && " +
		 							var[1];
}	

	public static boolean isPalindrome(String s){
		int n = s.length();
		for (int i = 0; i < (n / 2); ++i) {
			if (s.charAt((int) i) != s.charAt((int) (n - i - 1))) {
				return false;
			}
		}
		return true;
	}


	
	public static void primeList(ArrayList<Integer> list){
		for(int i = 10000; i <= 99999; i++){
			if(isPrime(i)){
				list.add(i);
			}
		}
	}
	
	public static boolean isPrime(int n) {
	    for (int i = 2; i <= n / 2; i++)   {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		
		primeList(list);

		System.out.println(solution(list));
	}

}
