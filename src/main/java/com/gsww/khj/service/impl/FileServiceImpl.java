package com.gsww.khj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsww.khj.entity.CpFile;
import com.gsww.khj.repository.FileRepository;
import com.gsww.khj.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileRepository fileRepository;

	@Override
	public CpFile save(CpFile cpFile) {
		return fileRepository.save(cpFile);
	}

	@Override
	public CpFile getFile(String id) {
		CpFile cpfile = fileRepository.getOne(id);
		return cpfile;
	}

	@Override
	public List<CpFile> getFileList(String id) {
		return fileRepository.findByBizIdOrderByUpTimeDesc(id);
	}

}
