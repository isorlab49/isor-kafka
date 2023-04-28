package com.isor.example.kafka.cache.controller;

import com.isor.example.kafka.cache.model.DictionaryItem;
import com.isor.example.kafka.cache.repositories.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    DictionaryRepository repo;

    @GetMapping("/{id}")
    @Cacheable(value = "dictionary")
    public DictionaryItem getValue(@PathVariable  String id) {
        System.out.println("Returning value for " + id);
        return repo.findById(id).orElse(new DictionaryItem("not_found", "Not found sorry."));
    }

    @GetMapping("/")
    public Iterable<DictionaryItem> findAll() {
        return repo.findAll();
    }

}
