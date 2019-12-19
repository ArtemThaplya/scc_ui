package com.scc.web.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileWriterListToCSV {
  void fileWriterListToCSV(File fileCSV, List<List<String>> list) throws IOException;
}
