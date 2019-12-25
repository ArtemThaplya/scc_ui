package com.scc.web.service;

import java.util.Set;

public interface AddAndDeleteEntry {

  boolean addEntry(Set<String> set, String entry);

  boolean deleteEntry(Set<String> set, String entry);
}
