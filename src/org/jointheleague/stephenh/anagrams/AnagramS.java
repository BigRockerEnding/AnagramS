package org.jointheleague.stephenh.anagrams;

import java.util.Arrays;

public class AnagramS {
	public static boolean isAnagram(String wordA, String wordB, boolean isCaseSensitive) {
		if (wordA == null || wordB == null || wordA.length() != wordB.length()) return false;
		if (!isCaseSensitive) { wordA = wordA.toLowerCase(); wordB = wordB.toLowerCase(); }
		
		int[] charsA = new int[128], charsB = new int[128];
		for (int i = 0; i < wordA.length(); i++) {
			int a = wordA.charAt(i);
			charsA[a]++; 
		}
		
		for (int i = 0; i < wordB.length(); i++) {
			int b = wordB.charAt(i);
			charsB[b]++;
		}
		
		return Arrays.equals(charsA, charsB);
	}
	
	public static boolean isAnagram(String wordA, String wordB) {
		return isAnagram(wordA, wordB, false);
	}
}
