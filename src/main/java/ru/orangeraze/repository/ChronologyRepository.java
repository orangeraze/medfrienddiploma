package ru.orangeraze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangeraze.entity.Analysis;
import ru.orangeraze.entity.Chronology;
import ru.orangeraze.entity.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChronologyRepository extends JpaRepository<Chronology, UUID> {
    List<Chronology> findAllByUser(User user);
}