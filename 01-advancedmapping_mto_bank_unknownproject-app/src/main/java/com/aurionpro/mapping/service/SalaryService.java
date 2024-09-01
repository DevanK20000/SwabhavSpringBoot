package com.aurionpro.mapping.service;

import com.aurionpro.mapping.dto.PageRespose;
import com.aurionpro.mapping.dto.SalaryResponse;
import com.aurionpro.mapping.entity.Salary;
import com.aurionpro.mapping.entity.SalaryTransaction;

public interface SalaryService{
	PageRespose<SalaryResponse> getAllSalary(int pageNo, int pageSize);
	SalaryResponse getSalaryById(Integer salaryId);
	Salary addSalary(Salary salary);
	Salary updateSalary(Salary salary);
	void deleteSalary(Integer salaryId);
	SalaryTransaction getSalaryTransactionBySalaryId(Integer salaryId);
	Salary updateSalaryTransactionBySalaryId(Integer salaryId, SalaryTransaction salaryTransaction);

}
