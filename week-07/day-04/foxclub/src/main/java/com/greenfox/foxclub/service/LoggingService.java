package com.greenfox.foxclub.service;

import com.greenfox.foxclub.model.LogItem;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

  private List<LogItem> history = new ArrayList<>();

  public List<LogItem> addNewItem(String description) {
    history.add(new LogItem(LocalDateTime.now(ZoneId.of("GMT+02:00")), description));
    return history;
  }

  public List<LogItem> getHistory() {
    return history;
  }
}
