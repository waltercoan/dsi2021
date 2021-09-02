package br.univille.walterdsi2021.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.univille.walterdsi2021.service.StorageFilesService;

@Service
public class StorageFilesServiceImpl implements StorageFilesService{

    @Value("${appdsi2021.tempfolder}")
    private String tempFolder;
    private Path root = null;

    @Override
    public String save(MultipartFile file) {
        root = Paths.get(tempFolder);
        UUID uuid = UUID.randomUUID();
        String novoNome = String.format("%s.%s", uuid.toString(), file.getOriginalFilename().split("\\.")[1]);
        Path nomeArquivo = this.root.resolve(novoNome);
        try {
            Files.copy(file.getInputStream(), nomeArquivo);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return nomeArquivo.toAbsolutePath().toString();
    }
    
}
