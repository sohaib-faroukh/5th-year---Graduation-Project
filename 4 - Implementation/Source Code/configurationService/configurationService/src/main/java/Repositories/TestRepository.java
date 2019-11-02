package Repositories;

import Models.test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends CrudRepository<test, Long> {

    @Override
    Iterable<test> findAll();

    Iterable<test> findByName(String name);

    
    test findOneByName(String name);
}

