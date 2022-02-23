package edu.cnm.deepdive.diceware.controller;

import edu.cnm.deepdive.diceware.service.PassphraseGenerator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passphrases")
public class PassphraseController {

  private final PassphraseGenerator generator;

  public PassphraseController(PassphraseGenerator generator) {
    this.generator = generator;
  }

  @GetMapping(value = "/generate", produces = MediaType.APPLICATION_JSON_VALUE)
  public String[] get(@RequestParam(required = false, defaultValue = "4") int length) {
    return generator.generate(length);
  }

  @GetMapping(value = "/generate", produces = MediaType.TEXT_PLAIN_VALUE)
  public String get(@RequestParam(required = false, defaultValue = "4") int length,
      @RequestParam(required = false, defaultValue = " ") String delimiter) {
    return String.join(delimiter, get(length));
  }
}
