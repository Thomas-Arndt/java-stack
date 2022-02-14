package com.arndtt.safetravelscrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arndtt.safetravelscrud.models.Expense;
import com.arndtt.safetravelscrud.repositories.ExpenseRepository;

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
	
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	
}
