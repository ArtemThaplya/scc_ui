package com.scc.web;

import com.scc.web.s3.services.S3Services;
import com.scc.web.service.CreateSetWithFile;
import com.scc.web.service.OperationService;
import com.scc.web.service.SetSingleton;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
  private final S3Services s3Services;

  @Value("${jsa.s3.uploadfile}")
  private String uploadFilePath;

  @Value("${jsa.s3.key}")
  private String downloadKey;

  @Autowired
  public CsvController(OperationService operationService, S3Services s3Services) {
    this.operationService = operationService;
    this.s3Services = s3Services;
  }

  @RequestMapping(value = "/addEntryToCSV")
  public boolean addEntry(@RequestParam(value = "entry") String entry) {
    logger.info("---------------- START DOWNLOAD FILE ----------------");
    s3Services.downloadFile(downloadKey);

    SetSingleton setSingleton = SetSingleton
        .getInstance(operationService.getCreateSetWithFile(FILE_PATH_CSV));
    logger.info(String.valueOf(setSingleton.set));
    return operationService
        .getAddEntry(setSingleton.set, entry);
  }

  @RequestMapping(value = "/deleteEntry")
  public ModelAndView deleteEntryFromBucket(
      @RequestParam(value = "entryDelete") String entryDelete) {
    logger.info("---------------- START DOWNLOAD FILE ----------------");
    s3Services.downloadFile(downloadKey);

    SetSingleton setSingleton = SetSingleton
        .getInstance(operationService.getCreateSetWithFile(FILE_PATH_CSV));
    operationService
        .getDeleteEntry(setSingleton.set, entryDelete);
    return new ModelAndView("viewSet");
  }

  @RequestMapping(value = "/viewSet", method = RequestMethod.GET)
  public ModelAndView viewPersonList(Model model) {
    logger.info("---------------- START DOWNLOAD FILE ----------------");
    s3Services.downloadFile(downloadKey);

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
    logger.info("---------------- START UPLOAD FILE ----------------");
    s3Services.uploadFile(downloadKey, uploadFilePath);
    return true;
  }
}
