package me.onlineresu.data.repositories;

import me.onlineresu.data.models.ResumeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface ResumeRepository extends CrudRepository<ResumeModel, Long> {

    ResumeModel findById(Long id);

}
