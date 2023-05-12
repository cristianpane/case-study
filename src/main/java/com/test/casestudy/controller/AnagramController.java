package com.test.casestudy.controller;

import com.test.casestudy.anagrams.AnagramService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AnagramController {

  private final AnagramService anagramService;

  @Operation(
      summary = "Check if two texts are anagram.",
      parameters = {
        @Parameter(name = "text1", description = "The first text.", required = true),
        @Parameter(name = "text2", description = "The second text.", required = true)
      },
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "True if texts are anagram, otherwise false.")
      })
  @GetMapping("/api/anagrams")
  ResponseEntity<Boolean> areTextsAnagram(
      @RequestParam(name = "text1") final String text1,
      @RequestParam(name = "text2") final String text2) {
    final var response = anagramService.areTextsAnagram(text1, text2);

    return ResponseEntity.ok(response);
  }
}
