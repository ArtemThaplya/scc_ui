package com.scc.web.service;

import java.io.File;
import java.util.List;

public interface ReadCSVFile {
  List<List<String>> readCSVFileToList(File file);
}
