package com.test.casestudy.anagrams;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class AnagramServiceTest {

  private final AnagramService anagramService = new AnagramService();

  @Test
  void testNullText() {
    final var text = "text11";

    assertThat(anagramService.areTextsAnagram(null, null)).isFalse();
    assertThat(anagramService.areTextsAnagram(null, text)).isFalse();
    assertThat(anagramService.areTextsAnagram(text, null)).isFalse();
  }

  @ParameterizedTest
  @MethodSource("provideValidAnagrams")
  void testValidAnagrams(final String text1, final String text2) {
    assertThat(anagramService.areTextsAnagram(text1, text2)).isTrue();
  }

  @ParameterizedTest
  @MethodSource("provideInvalidAnagrams")
  void testInvalidAnagrams(final String text1, final String text2) {
    assertThat(anagramService.areTextsAnagram(text1, text2)).isFalse();
  }

  private static Stream<Arguments> provideValidAnagrams() {
    return Stream.of(
        Arguments.of("text1", "text1"),
        Arguments.of("anagram", "gramana"),
        Arguments.of("baño", "ñoba"),
        Arguments.of("earth", "heart"),
        Arguments.of("Cat", "aCt"),
        Arguments.of("bad credit", "debit card"));
  }

  private static Stream<Arguments> provideInvalidAnagrams() {
    return Stream.of(
        Arguments.of("text1", "text2"),
        Arguments.of("Cat", "act"),
        Arguments.of("bad credit", "debitcard"),
        Arguments.of("text1", "text11"));
  }
}
