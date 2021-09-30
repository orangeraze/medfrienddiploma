package ru.orangeraze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.FileEntity;
import ru.orangeraze.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FileEntityRepository extends JpaRepository<FileEntity, String> {

    List<FileEntity> findAllByUser(User user);

}