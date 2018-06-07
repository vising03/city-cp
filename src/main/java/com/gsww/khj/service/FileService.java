package com.gsww.khj.service;

import java.util.List;

import com.gsww.khj.entity.CpFile;

public interface FileService {
	
	CpFile save(CpFile file);

	CpFile getFile(String id);

	List<CpFile> getFileList(String id);
}
