package ru.orangeraze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangeraze.bo.AnalysisBO;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, UUID> {
    List<Analysis> findAllByUser(User user);

    List<Analysis> findAllByNameAndUser(String name, User user);
}