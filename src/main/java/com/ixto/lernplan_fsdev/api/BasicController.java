package com.ixto.lernplan_fsdev.api;

import com.ixto.lernplan_fsdev.api.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author <a href="mailto:daxford@ixto.de">Daniel Axford</a>
 */
@RestController
@RequestMapping(value = "/")
public class BasicController {

  @GetMapping("/greeting")
  public Greeting greeting(
      @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    String greetingTemplate = "Hello, %s!";
    return new Greeting(UUID.randomUUID(), String.format(greetingTemplate, name));
  }
}
