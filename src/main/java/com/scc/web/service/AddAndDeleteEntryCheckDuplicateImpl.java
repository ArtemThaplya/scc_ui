package com.scc.web.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class AddAndDeleteEntryCheckDuplicateImpl implements AddAndDeleteEntryCheckDuplicate {
  public List<List<String>> checkDuplicateAndAddEntry(List<List<String>> list, String entry) {
    boolean flag = true;
    for (List<String> list1 : list) {
      String listString = String.join(",", list1);
      if (listString.equals(entry)) {
        flag = false;
      }
    }
    if (flag) {
      List<String> myList = new ArrayList<>(Arrays.asList(entry.split(", ")));
      list.add(myList);
    }
    return list;
  }

  public List<List<String>> deleteEntry(List<List<String>> list, String entry){
        List<String> myList = new ArrayList<>(Collections.singletonList(entry));
        list.remove(myList);
    return list;
  }
}
