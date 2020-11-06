package com.example.demo.hash;

import java.util.Arrays;
import java.util.HashMap;

public class Marathon {

	public static void main(String[] args) {
		MarathonSolution s = new MarathonSolution();
		String[] participant = {"mislav", "stanko", "mislav", "ana"};	//참가자
		String[] completion = {"stanko", "ana", "mislav"};				//완주자
		System.out.println("미완주자 : "+ s.solution(participant, completion));		
	}

}

class MarathonSolution {
    public String solution(String[] participant, String[] completion) {
//테스트 1 〉	통과 (0.24ms, 53.2MB)
//테스트 2 〉	통과 (0.31ms, 52.5MB)
//테스트 3 〉	통과 (7.08ms, 52.9MB)
//테스트 4 〉	통과 (7.27ms, 53.1MB)
//테스트 5 〉	통과 (6.04ms, 52.8MB)
//효율성  테스트
//테스트 1 〉	통과 (144.22ms, 82MB)
//테스트 2 〉	통과 (292.89ms, 88.9MB)
//테스트 3 〉	통과 (340.04ms, 95.1MB)
//테스트 4 〉	통과 (392.11ms, 95.3MB)
//테스트 5 〉	통과 (368.96ms, 97MB)
    	
        Arrays.sort(participant);
        Arrays.sort(completion);

        int l = completion.length;
        for (int i = 0; i < l; i++) {
            if (!participant[i].equalsIgnoreCase(completion[i]))
                return participant[i];
        }

        return participant[l];
    }
    
    
    public String otherSolution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
    
}
