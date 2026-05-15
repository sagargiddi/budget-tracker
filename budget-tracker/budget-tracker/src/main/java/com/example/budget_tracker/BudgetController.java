package com.example.budgettracker;

import com.example.budgettracker.model.Expense;
import com.example.budgettracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BudgetController {

    @Autowired
    private ExpenseRepository repository;

    private double totalBudget = 20000.0;

    @GetMapping("/")
    public String dashboard(Model model) {
        List<Expense> expenses = repository.findAll();
        double totalSpent = expenses.stream().mapToDouble(Expense::getAmount).sum();
        double remaining = totalBudget - totalSpent;

        model.addAttribute("totalBudget", totalBudget);
        model.addAttribute("totalSpent", totalSpent);
        model.addAttribute("remaining", remaining);
        model.addAttribute("expenses", expenses);

        return "dashboard";
    }

    @PostMapping("/add")
    public String addExpense(@RequestParam String description,
                             @RequestParam double amount,
                             @RequestParam String category) {

        Expense expense = new Expense(description, amount, LocalDate.now(), category);
        repository.save(expense);
        return "redirect:/";
    }

    @GetMapping("/history")
    public String history(Model model) {
        List<Expense> expenses = repository.findAll();
        model.addAttribute("expenses", expenses);
        return "history";
    }
}