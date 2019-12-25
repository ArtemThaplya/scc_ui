package com.scc.web.service;

import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AddAndDeleteEntryImpl implements AddAndDeleteEntry {

  private static Logger logger = LoggerFactory.getLogger(AddAndDeleteEntryImpl.class);

  public boolean addEntry(Set<String> set, String entry) {
    logger.info("Entry added: " + entry + ". Set, before: " + set);
    return set.add(entry);
  }

  public boolean deleteEntry(Set<String> set, String entry) {
    logger.info("Entry deleted: " + entry + ". Set, before: " + set);
    return set.remove(entry);
  }
}
