package com.scc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class OperationService {
  private final AddAndDeleteEntryCheckDuplicate addAndDeleteEntryCheckDuplicate;
  private final ReadCSVFile readCSVFile;
  private final FileWriterListToCSV fileWriterListToCSV;

  @Autowired
  public OperationService(
      AddAndDeleteEntryCheckDuplicate addAndDeleteEntryCheckDuplicate,
      ReadCSVFile readCSVFile,
      FileWriterListToCSV fileWriterListToCSV) {
    this.addAndDeleteEntryCheckDuplicate = addAndDeleteEntryCheckDuplicate;
    this.readCSVFile = readCSVFile;
    this.fileWriterListToCSV = fileWriterListToCSV;
  }

  public List<List<String>> getCheckDuplicateAndAddEntry(List<List<String>> list, String entry) {
    addAndDeleteEntryCheckDuplicate.checkDuplicateAndAddEntry(list, entry);
    return list;
  }

  public List<List<String>> getDeleteEntry(List<List<String>> list, String entryDelete) {
    return addAndDeleteEntryCheckDuplicate.deleteEntry(list, entryDelete);
  }

  public List<List<String>> getReadCSVFileToList(File file) {
    return readCSVFile.readCSVFileToList(file);
  }

  public void getFileWriterListToCSV(File fileCSV, List<List<String>> list) {
    try {
      fileWriterListToCSV.fileWriterListToCSV(fileCSV, list);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
//  public boolean getCheckStatusOperation(){
//    return addAndDeleteEntryCheckDuplicate.checkStatusOperation();
//  }
}
