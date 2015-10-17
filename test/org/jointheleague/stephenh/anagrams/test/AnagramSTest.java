package org.jointheleague.stephenh.anagrams.test;

import static org.junit.Assert.*;

import static org.jointheleague.stephenh.anagrams.AnagramS.isAnagram;
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

}
