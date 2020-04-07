package com.demo.app.repositories;


import com.demo.app.entities.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSiteRepository extends JpaRepository<Website,Long> {
}
