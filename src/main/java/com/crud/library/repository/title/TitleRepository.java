package com.crud.library.repository.title;

import com.crud.library.domain.title.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends CrudRepository<Title, Integer> {



}
