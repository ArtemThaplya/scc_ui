package com.scc.web.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class CreateSetWithFileTest {

  private Set<String> expected = new HashSet<>();
  private CreateSetWithFile createSetWithFile = new CreateSetWithFile();

  @Test
  public void createSetWithFile() {
    expected.add("aaa");
    expected.add("bbb");
    Set<String> actual = createSetWithFile.createSetWithFile("./src/test/resources/fileTest.csv");
    assertThat(actual, is(expected));
  }
}