package ru.orangeraze.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.entity.FileEntity;
import ru.orangeraze.model.FileResponse;
import ru.orangeraze.service.FileEntityService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileEntityService fileEntityService;

    @GetMapping
    public String get(@AuthenticationPrincipal UserDetailsBO userDetailsBO,
                      Model model) {
        List<FileResponse> files = fileEntityService.getAll(userDetailsBO)
                .stream()
                .map(this::mapToFileResponse)
                .collect(Collectors.toList());
        model.addAttribute("files", files);
        return "/files";
    }

    @PostMapping
    public String add(@AuthenticationPrincipal UserDetailsBO userDetailsBO,
                      @RequestParam(name = "file") MultipartFile file,
                      Model model) throws IOException {


        List<FileEntity> files = fileEntityService.save(file, userDetailsBO);

        model.addAttribute("files", files);
        return "/files";
    }

    private FileResponse mapToFileResponse(FileEntity fileEntity) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(String.valueOf(fileEntity.getId()))
                .toUriString();
        FileResponse fileResponse = new FileResponse();
        fileResponse.setId(fileEntity.getId());
        fileResponse.setName(fileEntity.getName());
        fileResponse.setContentType(fileEntity.getContentType());
        fileResponse.setSize(fileEntity.getSize());
        fileResponse.setUrl(downloadURL);
        fileResponse.setDate(fileEntity.getDate());

        return fileResponse;
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Optional<FileEntity> fileEntityOptional = fileEntityService.getFile(id);

        if (!fileEntityOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        FileEntity fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .contentType(MediaType.valueOf(fileEntity.getContentType()))
                .body(fileEntity.getData());
    }
}
