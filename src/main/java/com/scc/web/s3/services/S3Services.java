package com.scc.web.s3.services;

public interface S3Services {
	void downloadFile(String keyName);
	void uploadFile(String keyName, String uploadFilePath);
}
