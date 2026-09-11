package com.example.lab9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab9.model.DepositTransaction;

@Repository
public interface DepositRepository extends JpaRepository<DepositTransaction, Long> {
}