package me.onlineresu.services;

import me.onlineresu.data.models.ResumeModel;
import me.onlineresu.data.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public ResumeModel getResume() {
        return resumeRepository.findAll().iterator().next();
    }
}
