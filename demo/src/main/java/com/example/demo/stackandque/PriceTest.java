package com.example.demo.stackandque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PriceTest {

	public static void main(String[] args) {
		PriceTestSolution s = new PriceTestSolution();
//		progresses: [96, 99, 98, 97]
//				speeds: [1,1,1,1]
//				answer: [4]
		int[] progresses = {96, 99, 98, 97};
		int[] speeds = {1,1,1,1};
		System.out.println(s.solution(progresses, speeds));
	}

}


class PriceTestSolution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
        int l = progresses.length;
        int[] workerTimeArr = new int[l];
        
        for(int i = 0; i < progresses.length; i++) {
        	int workerTime = 0;
        	workerTime += (100 - progresses[i]) / speeds[i];
        	if((100 - progresses[i]) % speeds[i] != 0) {
        		workerTime ++;
        	}
        	
        	workerTimeArr[i] = workerTime;
        }
        
        int targeti = 0;
        int worker = 1;
        List<Integer> answerList = new ArrayList<>();
        
        for(int i=0; i< workerTimeArr.length - 1; i++) {
        	int target = workerTimeArr[targeti];
        	if(target < workerTimeArr[i+1]) {
        		answerList.add(worker);
        		targeti = i;
        		worker = 1;
        	} else {
        		worker++;
        	}
        	
        	if(i == workerTimeArr.length -2) {
        		answerList.add(worker);
        	}
        	
        }
        
        answer = new int[answerList.size()];
        int a = 0;
        Iterator<Integer> itr = answerList.iterator();
        while(itr.hasNext()) {
        	answer[a++] = itr.next();
        }
        
        return answer;
    }
	
    public int[] solutionFail(int[] progresses, int[] speeds) {
        int[] answer = {};
        int l = progresses.length;
        int[] workerTimeArr = new int[l];
        
        for(int i = 0; i < progresses.length; i++) {
        	int workerTime = (100 - progresses[i]) / speeds[i];
        	if((100 - progresses[i]) % speeds[i] > 0) {
        		workerTime ++;
        	}
        	
        	workerTimeArr[i] = workerTime;
        }
        
        List<Integer> answerList = new ArrayList<>();
        int worker = 1;
        
        for(int i = 0; i < workerTimeArr.length - 1; i++) {
        	if(workerTimeArr[i] < workerTimeArr[i+1]) {
        		answerList.add(worker);
    			worker = 1;
        	} else {
        		worker++;
        	}
        	
        	if(i == workerTimeArr.length -2) {
        		answerList.add(worker);
        	}
        	
        }
        
        answer = new int[answerList.size()];
        int a = 0;
        Iterator<Integer> itr = answerList.iterator();
        while(itr.hasNext()) {
        	answer[a++] = itr.next();
        }
        
        return answer;
    }
}