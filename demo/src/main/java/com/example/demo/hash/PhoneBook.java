package com.example.demo.hash;

import java.util.Arrays;

public class PhoneBook {

	public static void main(String[] args) {
		PhoneBookSolution s = new PhoneBookSolution();
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		System.out.println("결과 : "+s.solution(phone_book));
	}

}


class PhoneBookSolution {
    public boolean solution(String[] phone_book) {
//    	정확성  테스트
//    	테스트 1 〉	통과 (0.20ms, 52.2MB)
//    	테스트 2 〉	통과 (0.21ms, 51.3MB)
//    	테스트 3 〉	통과 (0.22ms, 52.1MB)
//    	테스트 4 〉	통과 (0.22ms, 52.6MB)
//    	테스트 5 〉	통과 (0.27ms, 52.3MB)
//    	테스트 6 〉	통과 (0.21ms, 52.5MB)
//    	테스트 7 〉	통과 (0.24ms, 51.7MB)
//    	테스트 8 〉	통과 (0.20ms, 51.8MB)
//    	테스트 9 〉	통과 (0.24ms, 52.6MB)
//    	테스트 10 〉	통과 (0.24ms, 52.9MB)
//    	테스트 11 〉	통과 (0.21ms, 52.6MB)
//    	효율성  테스트
//    	테스트 1 〉	통과 (19.04ms, 56.5MB)
//    	테스트 2 〉	통과 (16.32ms, 56.5MB)
        Arrays.sort(phone_book);

        int l = phone_book.length;
        
        for (int i = 0; i < l; i++) {
        	for(int j = 1; j < (l-i); j++) {
        		if(i == j) break;
        		if(phone_book[j].startsWith(phone_book[i])) {
        			return false;
        		}
        	}
        }

        return true;
    }
    
    public boolean otherSolution(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
             for(int j=i+1; j<phoneBook.length; j++) {
                 if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                 if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
             }
         }
         return true;
     }
}