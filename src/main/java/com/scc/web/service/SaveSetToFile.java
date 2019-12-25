package com.scc.web.service;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public interface SaveSetToFile {

  void saveSetToFile(File filePath, Set<String> set) throws IOException;
}
