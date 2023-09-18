package com.example.resume2.Controllers;

import com.example.resume2.Repo.JobPlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class JobPlacesController {
    @Autowired
    public JobPlacesRepository jobPlacesRepository;

}
