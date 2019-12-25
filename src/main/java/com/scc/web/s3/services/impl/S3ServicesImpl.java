package com.scc.web.s3.services.impl;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.scc.web.s3.services.S3Services;
import com.scc.web.s3.util.Utility;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3ServicesImpl implements S3Services {

  private Logger logger = LoggerFactory.getLogger(S3ServicesImpl.class);

  private final AmazonS3 s3client;

  @Value("${jsa.s3.bucket}")
  private String bucketName;

  @Autowired
  public S3ServicesImpl(AmazonS3 s3client) {
    this.s3client = s3client;
  }

  @Override
  public void downloadFile(String keyName) {

    try {
      System.out.println("Downloading an object");
      S3Object s3object = s3client.getObject(new GetObjectRequest(
          bucketName, keyName));
      System.out.println("Content-Type: " +
          s3object.getObjectMetadata().getContentType());
      Utility.displayText(s3object.getObjectContent());
      logger.info("===================== Import File - Done! =====================");
    } catch (AmazonServiceException ase) {
      logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
      logger.info("Error Message:    " + ase.getMessage());
      logger.info("HTTP Status Code: " + ase.getStatusCode());
      logger.info("AWS Error Code:   " + ase.getErrorCode());
      logger.info("Error Type:       " + ase.getErrorType());
      logger.info("Request ID:       " + ase.getRequestId());
    } catch (AmazonClientException ace) {
      logger.info("Caught an AmazonClientException: ");
      logger.info("Error Message: " + ace.getMessage());
    } catch (IOException ioe) {
      logger.info("IOE Error Message: " + ioe.getMessage());
    }
  }

  @Override
  public void uploadFile(String keyName, String uploadFilePath) {

    try {
      File file = new File(uploadFilePath);
      s3client.putObject(new PutObjectRequest(bucketName, keyName, file));
      logger.info("===================== Upload File - Done! =====================");
    } catch (AmazonServiceException ase) {
      logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
      logger.info("Error Message:    " + ase.getMessage());
      logger.info("HTTP Status Code: " + ase.getStatusCode());
      logger.info("AWS Error Code:   " + ase.getErrorCode());
      logger.info("Error Type:       " + ase.getErrorType());
      logger.info("Request ID:       " + ase.getRequestId());
    } catch (AmazonClientException ace) {
      logger.info("Caught an AmazonClientException: ");
      logger.info("Error Message: " + ace.getMessage());
    }
  }
}
