package org.jointheleague.stephenh.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class AnagramS {
	public static void main(String[] args) {
		new AnagramS().run();
	}
	
	private void run() {
		speak("Enter the word you would like to find anagrams for!");
		String wordy = JOptionPane.showInputDialog("");
		List<String> loadedList;
		List<String> anagrams = new ArrayList<>();
		try {
			loadedList = LoadAnagrams();
			for (String loadedWord : loadedList) {
				if (isAnagram(wordy, loadedWord)) {
					anagrams.add(loadedWord);
				}
			}
			speak("Here are the anagrams:");
			for (String anagramed : anagrams) {
				System.out.println(anagramed);
				speak(anagramed);
			}
		} catch (IOException e) {
			e.printStackTrace();
			speak("I'm sorry, an error has occured in the anagram finding process");
		}
	}
	
	private void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	
	public List<String> LoadAnagrams() throws IOException {
		List<String> lotOWords = new ArrayList<>();
		InputStream streamer = getClass().getResourceAsStream("res/words.txt");
		try (BufferedReader readMe = new BufferedReader(new InputStreamReader(streamer))) {
			String linear = null;
			while ((linear = readMe.readLine()) != null) {
				lotOWords.add(linear);
			}
		}
		return lotOWords;
		
	}
}
