package com.test.casestudy.anagrams;

import org.springframework.stereotype.Component;

@Component
public class AnagramService {

  private static final int CHARS_COUNT = 256;

  public boolean areTextsAnagram(final String text1, final String text2) {
    if (text1 == null || text2 == null || text1.length() != text2.length()) {
      return false;
    }

    final var charsFrequency = new char[CHARS_COUNT];

    for (int i = 0; i < text1.length(); i++) {
      charsFrequency[text1.charAt(i)]++;
      charsFrequency[text2.charAt(i)]--;
    }

    for (final int frequency : charsFrequency) {
      if (frequency != 0) {
        return false;
      }
    }

    return true;
  }
}
