package org.jointheleague.stephenh.anagrams.test;

import static org.junit.Assert.*;
import static org.jointheleague.stephenh.anagrams.AnagramS.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jointheleague.stephenh.anagrams.AnagramS;
import org.junit.Test;

public class AnagramSTest {
	
	@Test
	public void testTrue() {
		assertTrue(isAnagram("cats", "tacs", true));
		assertTrue(isAnagram("Cats", "tacs", false));
		assertTrue(isAnagram("Cats", "tacs"));
	}
	
	@Test
	public void testFalse() {
		assertFalse(isAnagram("cats", "ack", true));
		assertFalse(isAnagram("Cats", "tacs", true));
		assertFalse(isAnagram(null, null));
		assertFalse(isAnagram("thisthing", "this thing"));
	}
	
	@Test
	public void testloader() {
		List<String> loadedList = new ArrayList<String>();
		try {
			loadedList = new AnagramS().LoadAnagrams();
		} catch (IOException e) {
			e.printStackTrace();
			fail("loadAnagrams threw an IOException");
		}
		assertTrue(loadedList.size() > 0);
	}
}
