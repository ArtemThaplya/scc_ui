package com.scc.web.service;

import com.scc.web.service.ReadCSVFileImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadCSVFileTest {
  private List<List<String>> expected;

  @Before
  public void init() {
    expected = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    list1.add("a,a");
    list2.add("b,b");
    expected.add(list1);
    expected.add(list2);
  }

  @Test
  public void readCSVFileToList() {
    ReadCSVFileImpl readCSVFile = new ReadCSVFileImpl();
    File file = new File("./src/test/resources/fileTest.csv");
    List<List<String>> actual = readCSVFile.readCSVFileToList(file);

    assertEquals(expected, actual);
  }
}
