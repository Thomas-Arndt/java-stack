package com.arndtt.safetravelsedit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arndtt.safetravelsedit.models.Expense;
import com.arndtt.safetravelsedit.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public Expense updateExpense(Expense expense) {
		Optional<Expense> optionalExpense = expenseRepository.findById(expense.getId());
		if(optionalExpense.isPresent()) {
			return expenseRepository.save(expense);
		} else {
			return null;
		}
	}
	
}
