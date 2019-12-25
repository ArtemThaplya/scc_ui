package com.scc.web.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AddAndDeleteEntryImplTest {
  private static final String ENTRY_A = "a,a";
  private static final String ENTRY_B = "b,b";
  private static final String ENTRY_C = "c,c";
  private static final String ENTRY_E = "e,e";
  private Set<String> expected;
  private AddAndDeleteEntryImpl addAndDeleteEntryCheckDuplicateImpl =
      new AddAndDeleteEntryImpl();

  @Before
  public void init() {
    expected = new HashSet<>();
    expected.add(ENTRY_A);
    expected.add(ENTRY_B);
    expected.add(ENTRY_C);
  }

  @Ignore
  @Test
  public void checkDuplicateAndAddEntry() {
    boolean actual = addAndDeleteEntryCheckDuplicateImpl.addEntry(expected, ENTRY_A);

    assertThat(actual, is(true));
  }

  @Ignore
  @Test
  public void deleteEntry() {
     boolean actual = addAndDeleteEntryCheckDuplicateImpl.deleteEntry(expected, ENTRY_A);

    assertThat(actual, is(true));
  }
}
