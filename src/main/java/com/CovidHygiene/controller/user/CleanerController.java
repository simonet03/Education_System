package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.service.user.impl.CleanerServiceImpl;
import com.CovidHygiene.factory.CleanerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@EnableAutoConfiguration
@RequestMapping("/Cleaner")

public class CleanerController {
        @Autowired
        private CleanerServiceImpl cleanerService;

                @PostMapping("/create")
                public Cleaner create(@RequestBody Cleaner cleaner) {

                    Cleaner cl = CleanerFactory.buildCleaner(cleaner.getCleanerNum(), cleaner.getFirstName(),
                    cleaner.getLastName(), cleaner.getAddress());
                    return cleanerService.create(cl);
                }

                @GetMapping("/read/{id}")
                public Cleaner read(@PathVariable Long id) {

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
                public boolean delete(@PathVariable Long id) {

                    return cleanerService.delete(id);
                }
}
