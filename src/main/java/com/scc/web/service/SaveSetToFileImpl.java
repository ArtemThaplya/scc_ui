package com.scc.web.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SaveSetToFileImpl implements SaveSetToFile {
  private static Logger logger = LoggerFactory.getLogger(AddAndDeleteEntryImpl.class);

  public void saveSetToFile(File filPath, Set<String> set) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter(filPath));
    for (String s : set) {
      out.newLine();
      out.write(String.valueOf(s));
    }
    out.close();
  }
}
