package com.scc.web.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ReadCSVFileImpl implements ReadCSVFile {
  private static final char DEFAULT_SEPARATOR = ',';

  public List<List<String>> readCSVFileToList(File file) {
    List<List<String>> records = new ArrayList<List<String>>();
    try (CSVReader csvReader = new CSVReader(new FileReader(file)); ) {
      String[] values = null;
      while ((values = csvReader.readNext()) != null) {
        records.add(Collections.singletonList(String.join(",", values)));
      }
    } catch (IOException | CsvValidationException e) {
      e.printStackTrace();
    }
    return records;
  }

  static void readListToCSVFile(Writer w, List<String> values) throws IOException {
    readListToCSVFile(w, values, DEFAULT_SEPARATOR, ' ');
  }

  public static void readListToCSVFile(Writer w, List<String> values, char separators)
      throws IOException {
    readListToCSVFile(w, values, separators, ' ');
  }

  private static String followCVSformat(String value) {
    String result = value;
    if (result.contains("\"")) {
      result = result.replace("\"", "\"\"");
    }
    return result;
  }

  private static void readListToCSVFile(
      Writer w, List<String> values, char separators, char customQuote) throws IOException {

    boolean first = true;

    if (separators == ' ') {
      separators = DEFAULT_SEPARATOR;
    }
    StringBuilder sb = new StringBuilder();
    for (String value : values) {
      if (!first) {
        sb.append(separators);
      }
      if (customQuote == ' ') {
        sb.append(followCVSformat(value));
      } else {
        sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
      }
      first = false;
    }
    sb.append("\n");
    w.append(sb.toString());
  }
}
