package com.scc.web;

import com.scc.web.service.CreateSetWithFile;
import com.scc.web.service.OperationService;
import com.scc.web.service.SetSingleton;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CsvController {
  private final OperationService operationService;
  private static final String FILE_PATH_CSV = "./src/main/webapp/file.csv";
  private static Logger logger = LoggerFactory.getLogger(CreateSetWithFile.class);


  @Autowired
  public CsvController(OperationService operationService) {
    this.operationService = operationService;
  }

  @RequestMapping(value = "/addEntryToCSV")
  public boolean addEntry(@RequestParam(value = "entry") String entry) {
    SetSingleton setSingleton = SetSingleton
        .getInstance(operationService.getCreateSetWithFile(FILE_PATH_CSV));
    logger.info(String.valueOf(setSingleton.set));
    return operationService
        .getAddEntry(setSingleton.set, entry);
  }

  @RequestMapping(value = "/deleteEntry")
  public ModelAndView deleteEntryFromBucket(
      @RequestParam(value = "entryDelete") String entryDelete) {
    SetSingleton setSingleton = SetSingleton
        .getInstance(operationService.getCreateSetWithFile(FILE_PATH_CSV));
    operationService
        .getDeleteEntry(setSingleton.set, entryDelete);
    return new ModelAndView("viewSet");
  }

  @RequestMapping(value = "/viewSet", method = RequestMethod.GET)
  public ModelAndView viewPersonList(Model model) {
    SetSingleton setSingleton = SetSingleton
        .getInstance(operationService.getCreateSetWithFile(FILE_PATH_CSV));
    model.addAttribute("resultObjectList", setSingleton.set);
    return new ModelAndView("viewSet");
  }

  @RequestMapping(value = "/saveEntry")
  public boolean saveEntriesToCsv() throws IOException {
    SetSingleton setSingleton = SetSingleton
        .getInstance(operationService.getCreateSetWithFile(FILE_PATH_CSV));
    operationService.getSaveSetToFile(new File(FILE_PATH_CSV),
        setSingleton.set);
    return true;
  }
}
