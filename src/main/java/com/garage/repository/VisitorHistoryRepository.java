package com.garage.repository;

import com.garage.model.VisitorHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorHistoryRepository extends JpaRepository<VisitorHistory,Integer> {
}
