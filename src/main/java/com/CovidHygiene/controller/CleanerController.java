package com.CovidHygiene.controller;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.service.user.impl.CleanerServiceImpl;
import com.CovidHygiene.factory.CleanerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/Cleaner")

public class CleanerController {

        private final CleanerServiceImpl cleanerService;

    public CleanerController(@Qualifier("CleanerServiceImpl") CleanerServiceImpl cleanerService) {
        this.cleanerService = cleanerService;
    }

    @PostMapping("/create")
                public Cleaner create(@RequestBody Cleaner cleaner) {

                    Cleaner cl = CleanerFactory.buildCleaner(cleaner.getCleanerNum(), cleaner.getFirstName(),
                    cleaner.getLastName(), cleaner.getAddress());
                    return cleanerService.create(cl);
                }

                @GetMapping("/read/{id}")
                public Cleaner read(@PathVariable String id) {

                    return cleanerService.read(id);
                }

                @PostMapping("/update")
                public Cleaner update(@RequestBody Cleaner cleaner) {

                    return cleanerService.update(cleaner);
                }

                @GetMapping("/getAll")
                public Set<Cleaner> getAll() {

                    return cleanerService.getAll();
                }

                @DeleteMapping("/delete/{id}")
                public boolean delete(@PathVariable String id) {

                    return cleanerService.delete(id);
                }
}
