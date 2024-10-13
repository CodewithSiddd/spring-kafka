package com.CodewithSidd.consumer.repository;

import com.CodewithSidd.consumer.entity.WikiMediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikiMediaData, Long> {



}
