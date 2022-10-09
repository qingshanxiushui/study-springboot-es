package org.example.yqs.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import org.example.yqs.entity.Person;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, Long> {

    public List<Person> findALLByname(String name);
}
