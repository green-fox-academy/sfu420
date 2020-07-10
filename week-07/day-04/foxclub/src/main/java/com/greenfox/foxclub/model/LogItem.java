package com.greenfox.foxclub.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LogItem {
  private LocalDateTime timestamp;
  private String description;
}
