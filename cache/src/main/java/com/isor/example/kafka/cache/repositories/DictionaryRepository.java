package com.isor.example.kafka.cache.repositories;

import com.isor.example.kafka.cache.model.DictionaryItem;
import org.springframework.data.repository.CrudRepository;

public interface DictionaryRepository extends CrudRepository<DictionaryItem, String> { }
