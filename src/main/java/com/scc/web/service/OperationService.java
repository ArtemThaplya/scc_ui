package com.scc.web.service;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationService {
  private final SaveSetToFile saveSetToFile;
  private final AddAndDeleteEntry addAndDeleteEntry;
  private final CreateSetWithFile createSetWithFile;

  @Autowired
  public OperationService(
      SaveSetToFile saveSetToFile, AddAndDeleteEntry addAndDeleteEntry,
      CreateSetWithFile createSetWithFile) {
    this.saveSetToFile = saveSetToFile;
    this.addAndDeleteEntry = addAndDeleteEntry;
    this.createSetWithFile = createSetWithFile;
  }

  public boolean getAddEntry(Set<String> set, String entry) {
    return addAndDeleteEntry.addEntry(set, entry);
  }

  public boolean getDeleteEntry(Set<String> set, String entry) {
    return addAndDeleteEntry.deleteEntry(set, entry);
  }

  public void getSaveSetToFile(File filePath, Set<String> set) throws IOException {
    saveSetToFile.saveSetToFile(filePath, set);
  }

  public Set<String> getCreateSetWithFile(String filePath) {
    return createSetWithFile.createSetWithFile(filePath);

  }
}
