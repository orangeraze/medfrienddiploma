package ru.orangeraze.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.orangeraze.bo.UserDetailsBO;
import ru.orangeraze.entity.FileEntity;
import ru.orangeraze.entity.User;
import ru.orangeraze.repository.FileEntityRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileEntityService {


    private final FileEntityRepository fileEntityRepository;
    private final UserService userService;


//    public List<FileEntity> save(FileEntityDTO fileEntityDTO, UserDetailsBO userDetailsBO) {
//        FileEntity fileEntity = FileEntityMapper.INSTANCE.fromFileEntityDTO(fileEntityDTO);
//        fileEntity.setUser(userService.getById(userDetailsBO.getId()));
//        fileEntityRepository.save(fileEntity);
//        return getAll(userDetailsBO);
//    }

    public List<FileEntity> save(MultipartFile file, UserDetailsBO userDetailsBO) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setUser(userService.getById(userDetailsBO.getId()));
        fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        fileEntityRepository.save(fileEntity);

        return getAll(userDetailsBO);
    }


    public Optional<FileEntity> getFile(String id) {
        return fileEntityRepository.findById(id);
    }

    public List<FileEntity> getAll(UserDetailsBO userDetailsBO) {
        User user = userService.getById(userDetailsBO.getId());
        return fileEntityRepository.findAllByUser(user);
    }

}
