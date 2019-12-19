package com.scc.web;

import com.scc.web.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@RestController
public class CsvController {

  private final OperationService operationService;
  private static final String fileCSV = "./src/main/webapp/file.csv";
  private final File file = new File(fileCSV);

  @Autowired
  public CsvController(OperationService operationService) {
    this.operationService = operationService;
  }

  @RequestMapping(value = "/addEntryToCSV")
  public String addEntry(@RequestParam(value = "entry") String entry) {
    List<List<String>> list =
        operationService.getCheckDuplicateAndAddEntry(
            operationService.getReadCSVFileToList(file), entry);
    operationService.getFileWriterListToCSV(file, list);
    return "+";
  }

  @RequestMapping(value = "/viewEntryToCSV", method = RequestMethod.GET)
  public ModelAndView viewEntry() {
    ModelAndView model = new ModelAndView("/viewEntry.html");
    model.addObject("list", operationService.getReadCSVFileToList(file));
    return model;
  }

  @RequestMapping(value = "/deleteEntryFromBucket")
  public boolean deleteEntryFromBucket(@RequestParam(value = "entryDelete") String entryDelete) {
    List<List<String>> list =
        operationService.getDeleteEntry(operationService.getReadCSVFileToList(file), entryDelete);
    operationService.getFileWriterListToCSV(file, list);
    return true;
  }
}
