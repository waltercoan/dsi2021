package br.univille.walterdsi2021.service;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface StorageFilesService {
    String save(MultipartFile file);
}
