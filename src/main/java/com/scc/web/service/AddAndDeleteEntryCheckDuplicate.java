package com.scc.web.service;

import java.util.List;

public interface AddAndDeleteEntryCheckDuplicate {
  List<List<String>> checkDuplicateAndAddEntry(List<List<String>> list, String entry);

  List<List<String>> deleteEntry(List<List<String>> list, String entry);

//  boolean checkStatusOperation();
}
