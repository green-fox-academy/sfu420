package com.greenfox.restapi.controllers;

import com.greenfox.restapi.models.DTO.ArrayHandler;
import com.greenfox.restapi.models.DTO.DoUntil;
import com.greenfox.restapi.models.DTO.Doubling;
import com.greenfox.restapi.models.DTO.ErrorMessage;
import com.greenfox.restapi.models.DTO.Greeter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawController {


  @GetMapping("/doubling")
  public ResponseEntity<?> doubling(@RequestParam(required = false) Integer input) {

    if (input == null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new ErrorMessage("Please provide an input!"));
    }

    Doubling calculate = new Doubling(input);
    return ResponseEntity.status(HttpStatus.OK).body(calculate);
  }


  @GetMapping("/greeter")
  public ResponseEntity<?> greeter(@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String title) {
    if (name == null && title == null) {
      return ResponseEntity.status(400)
          .body(new ErrorMessage("Please provide a name and a title!"));
    } else if (name == null) {
      return ResponseEntity.status(400).body(new ErrorMessage("Please provide a name!"));
    } else if (title == null) {
      return ResponseEntity.status(400).body(new ErrorMessage("Please provide a title!"));
    } else {
      return ResponseEntity.status(200).body(new Greeter(name, title));
    }
  }


  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<?> appenda(@PathVariable String appendable) {
    HashMap<String, String> output = new HashMap<>();
    output.put("appended", appendable.concat("a"));

    return ResponseEntity.ok().body(output);
  }


  @PostMapping("/dountil/{action}")
  public ResponseEntity<?> actions(@PathVariable String action,
                                                  @RequestBody Map<String, Integer> payload) {
    if (payload.get("until") == null) {
      return ResponseEntity.ok().body(new ErrorMessage("Please provide a number!"));
    }

    if (action.equals("sum")) {
      return ResponseEntity.ok().body(new DoUntil().sum(payload.get("until")));
    }

    if (action.equals("factor")) {
      return ResponseEntity.ok().body(new DoUntil().factor(payload.get("until")));
    }
    return null;
  }

  @PostMapping("/arrays")
  public ResponseEntity<?> arrayHandler(@RequestBody ArrayHandler payload) {

    JSONObject response;

    if (payload.getWhat() == null || payload.getWhat().isEmpty() ||
        payload.getNumbers() == null || payload.getNumbers().length == 0) {
      return ResponseEntity.ok(new ErrorMessage("Please provide what to do with the numbers!"));
    }

    if (payload.getWhat().equals("sum")) {
      response = new JSONObject().put("result", payload.sum());
      return ResponseEntity.ok(response.toMap());
    }

    if (payload.getWhat().equals("multiply")) {
      response = new JSONObject().put("result", payload.multiply());
      return ResponseEntity.ok(response.toMap());
    }

    if (payload.getWhat().equals("double")) {
      response = new JSONObject().put("result", payload.doubleIt());
      return ResponseEntity.ok(response.toMap());
    }

    return null;
  }
}