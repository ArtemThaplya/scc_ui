package com.scc.web.service;

import com.scc.web.service.AddAndDeleteEntryCheckDuplicateImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddAndDeleteEntryCheckDuplicateImplTest {
  private static final String ENTRY_A = "a,a";
  private static final String ENTRY_B = "b,b";
  private static final String ENTRY_C = "c,c";
  private static final String ENTRY_E = "e,e";
  private List<List<String>> expected;
  private List<String> expected1;
  private List<List<String>> list;
  private AddAndDeleteEntryCheckDuplicateImpl addAndDeleteEntryCheckDuplicateImpl =
      new AddAndDeleteEntryCheckDuplicateImpl();

  @Before
  public void init() {
    list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    list1.add(ENTRY_A);
    list2.add(ENTRY_B);
    list3.add(ENTRY_C);
    list.add(list1);
    list.add(list2);
    list.add(list3);
    expected = new ArrayList<>(list);
    expected1 = new ArrayList<>();
  }

  @Test
  public void checkDuplicateAndAddEntry() {
    expected1.add(ENTRY_E);
    expected.add(expected1);
    List<List<String>> actual =
        addAndDeleteEntryCheckDuplicateImpl.checkDuplicateAndAddEntry(list, ENTRY_E);
    List<List<String>> actual2 =
        addAndDeleteEntryCheckDuplicateImpl.checkDuplicateAndAddEntry(actual, ENTRY_A);

    assertEquals(expected, actual2);
  }

  @Test
  public void deleteEntry() {
    expected1.add(ENTRY_A);
    expected.remove(expected1);
    List<List<String>> actual = addAndDeleteEntryCheckDuplicateImpl.deleteEntry(list, ENTRY_A);

    assertEquals(expected, actual);
  }
}
