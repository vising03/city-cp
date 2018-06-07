package com.gsww.khj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsww.khj.entity.CpFile;

public interface FileRepository extends JpaRepository<CpFile,String>{

	List<CpFile> findByBizIdOrderByUpTimeDesc(String id);

}
