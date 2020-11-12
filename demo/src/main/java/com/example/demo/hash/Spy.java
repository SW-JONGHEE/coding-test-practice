package com.example.demo.hash;

// 프로그래머스 코딩테스트 연습 해시, 위장
public class Spy {
//	입출력 결과 예시
//	[[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	-> 5
//	[[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]				-> 3
	
	public static void main(String[] args) {
		SpySolution s = new SpySolution();
		String[][] clothes = {
				{"yellow_hat", "headgear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "headgear"},
				{"green", "a"},
				{"green_eye", "eyewear"},
				{"green_b", "b"}
		};
		
		System.out.println("result : " +s.solution(clothes));
	}

}

class SpySolution {
	// 틀렸어 왜틀렸지?????
    public int solution(String[][] clothes) {
        int answer = clothes.length;
        int l = clothes.length;
        
        for(int i = 0; i < l; i ++) {
        	for (int j = i+1; j < l; j++) {
        		if(!clothes[i][1].equals(clothes[j][1])) { 
        			answer++;
        		}
        	}
        }
        
        return answer;
    }
}