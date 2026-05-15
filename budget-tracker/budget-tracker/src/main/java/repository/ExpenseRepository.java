package com.example.budgettracker.repository;

import com.example.budgettracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateBetween(LocalDate start, LocalDate end);
}