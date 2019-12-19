package com.scc.web.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class FileWriterListToCSVImpl implements FileWriterListToCSV {
  public void fileWriterListToCSV(File fileCSV, List<List<String>> list) throws IOException {
    FileWriter writer = new FileWriter(fileCSV);
    for (List<String> list1 : list) {
      ReadCSVFileImpl.readListToCSVFile(writer, list1);
    }
    writer.flush();
    writer.close();
  }
}
