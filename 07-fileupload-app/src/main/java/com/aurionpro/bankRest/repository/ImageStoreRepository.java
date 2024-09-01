package com.aurionpro.bankRest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aurionpro.bankRest.entity.ImageStore;

import java.util.UUID;

@Repository
public interface ImageStoreRepository extends JpaRepository<ImageStore, Integer> {
}