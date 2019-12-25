package com.scc.web.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateSetWithFile {

  private static Logger logger = LoggerFactory.getLogger(CreateSetWithFile.class);
  private Scanner s = null;

  Set<String> createSetWithFile(String filePath) {
    Set<String> set = new HashSet<>();
    try {
      s = new Scanner(new File(filePath));
    } catch (FileNotFoundException e) {
      logger.info("File not found " + e);
    }
    while (Objects.requireNonNull(s).hasNext()) {
      set.add(s.next());
    }
    s.close();
    return set;
  }
}
