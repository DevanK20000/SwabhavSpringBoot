package com.aurionpro.mapping.util;

import com.aurionpro.mapping.dto.*;
import com.aurionpro.mapping.entity.*;
import java.util.stream.Collectors;

public class DTOToEntityConverter {

    public static Bank convertToBank(BankDTO bankDTO) {
        Bank bank = new Bank();
        bank.setBankId(bankDTO.getBankId());
        bank.setBankName(bankDTO.getBankName());
        bank.setIfsco(bankDTO.getIfsco());
        bank.setSalaryAccounts(bankDTO.getSalaryAccounts().stream()
                .map(DTOToEntityConverter::convertToSalaryAccountWithoutBank)
                .collect(Collectors.toList()));
        return bank;
    }

    public static Client convertToClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setClientId(clientDTO.getClientId());
        client.setCompanyName(clientDTO.getCompanyName());
        client.setRegistrationNumber(clientDTO.getRegistrationNumber());
        client.setContactPerson(clientDTO.getContactPerson());
        client.setContactEmail(clientDTO.getContactEmail());
        client.setContactNumber(clientDTO.getContactNumber());
        client.setAddress(clientDTO.getAddress());
        client.setStatus(clientDTO.getStatus());
        client.setCreationDate(clientDTO.getCreationDate());
        client.setClientKycStatus(clientDTO.getClientKycStatus());
        client.setEmployees(clientDTO.getEmployees().stream()
                .map(DTOToEntityConverter::convertToEmployeeWithoutClient)
                .collect(Collectors.toList()));
        return client;
    }

    public static Employee convertToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPosition(employeeDTO.getPosition());
        employee.setHireDate(employeeDTO.getHireDate());
        employee.setSalary(employeeDTO.getSalary());
        employee.setSalaryAccount(convertToSalaryAccountWithoutEmployee(employeeDTO.getSalaryAccount()));
        employee.setBankIfscNumber(employeeDTO.getBankIfscNumber());
        employee.setEmployeeStatus(employeeDTO.getEmployeeStatus());
        employee.setClient(convertToClientWithoutEmployees(employeeDTO.getClient()));
        return employee;
    }

    public static Salary convertToSalary(SalaryDTO salaryDTO) {
        Salary salary = new Salary();
        salary.setSalaryId(salaryDTO.getSalaryId());
        salary.setSalaryMonth(salaryDTO.getSalaryMonth());
        salary.setGrossSalary(salaryDTO.getGrossSalary());
        salary.setDeductions(salaryDTO.getDeductions());
        salary.setNetSalary(salaryDTO.getNetSalary());
        salary.setPaymentDate(salaryDTO.getPaymentDate());
        salary.setStatus(salaryDTO.getStatus());
        return salary;
    }

    public static SalaryAccount convertToSalaryAccount(SalaryAccountDTO salaryAccountDTO) {
        SalaryAccount salaryAccount = new SalaryAccount();
        salaryAccount.setAccountNumber(salaryAccountDTO.getAccountNumber());
        salaryAccount.setAccountHolderName(salaryAccountDTO.getAccountHolderName());
        salaryAccount.setSalaryTransactions(salaryAccountDTO.getSalaryTransactions().stream()
                .map(DTOToEntityConverter::convertToSalaryTransactionWithoutSalaryAccount)
                .collect(Collectors.toList()));
        salaryAccount.setBank(convertToBankWithoutSalaryAccounts(salaryAccountDTO.getBank()));
        return salaryAccount;
    }

    public static SalaryTransaction convertToSalaryTransaction(SalaryTransactionDTO salaryTransactionDTO) {
        SalaryTransaction salaryTransaction = new SalaryTransaction();
        salaryTransaction.setTransactionId(salaryTransactionDTO.getTransactionId());
        salaryTransaction.setTransactionDate(salaryTransactionDTO.getTransactionDate());
        salaryTransaction.setAmount(salaryTransactionDTO.getAmount());
        salaryTransaction.setStatus(salaryTransactionDTO.getStatus());
        salaryTransaction.setSalary(convertToSalary(salaryTransactionDTO.getSalary()));
        salaryTransaction.setSalaryAccount(convertToSalaryAccountWithoutSalaryTransactions(salaryTransactionDTO.getSalaryAccount()));
        return salaryTransaction;
    }

    // Helper methods to avoid circular references
    private static SalaryAccount convertToSalaryAccountWithoutBank(SalaryAccountDTO salaryAccountDTO) {
        SalaryAccount salaryAccount = new SalaryAccount();
        salaryAccount.setAccountNumber(salaryAccountDTO.getAccountNumber());
        salaryAccount.setAccountHolderName(salaryAccountDTO.getAccountHolderName());
        salaryAccount.setSalaryTransactions(salaryAccountDTO.getSalaryTransactions().stream()
                .map(DTOToEntityConverter::convertToSalaryTransactionWithoutSalaryAccount)
                .collect(Collectors.toList()));
        return salaryAccount;
    }

    private static SalaryTransaction convertToSalaryTransactionWithoutSalaryAccount(SalaryTransactionDTO salaryTransactionDTO) {
        SalaryTransaction salaryTransaction = new SalaryTransaction();
        salaryTransaction.setTransactionId(salaryTransactionDTO.getTransactionId());
        salaryTransaction.setTransactionDate(salaryTransactionDTO.getTransactionDate());
        salaryTransaction.setAmount(salaryTransactionDTO.getAmount());
        salaryTransaction.setStatus(salaryTransactionDTO.getStatus());
        salaryTransaction.setSalary(convertToSalary(salaryTransactionDTO.getSalary()));
        return salaryTransaction;
    }

    private static Bank convertToBankWithoutSalaryAccounts(BankDTO bankDTO) {
        Bank bank = new Bank();
        bank.setBankId(bankDTO.getBankId());
        bank.setBankName(bankDTO.getBankName());
        bank.setIfsco(bankDTO.getIfsco());
        return bank;
    }

    private static Client convertToClientWithoutEmployees(ClientDTO clientDTO) {
        Client client = new Client();
        client.setClientId(clientDTO.getClientId());
        client.setCompanyName(clientDTO.getCompanyName());
        client.setRegistrationNumber(clientDTO.getRegistrationNumber());
        client.setContactPerson(clientDTO.getContactPerson());
        client.setContactEmail(clientDTO.getContactEmail());
        client.setContactNumber(clientDTO.getContactNumber());
        client.setAddress(clientDTO.getAddress());
        client.setStatus(clientDTO.getStatus());
        client.setCreationDate(clientDTO.getCreationDate());
        client.setClientKycStatus(clientDTO.getClientKycStatus());
        return client;
    }

    private static Employee convertToEmployeeWithoutClient(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPosition(employeeDTO.getPosition());
        employee.setHireDate(employeeDTO.getHireDate());
        employee.setSalary(employeeDTO.getSalary());
        employee.setSalaryAccount(convertToSalaryAccountWithoutEmployee(employeeDTO.getSalaryAccount()));
        employee.setBankIfscNumber(employeeDTO.getBankIfscNumber());
        employee.setEmployeeStatus(employeeDTO.getEmployeeStatus());
        return employee;
    }

    private static SalaryAccount convertToSalaryAccountWithoutEmployee(SalaryAccountDTO salaryAccountDTO) {
        SalaryAccount salaryAccount = new SalaryAccount();
        salaryAccount.setAccountNumber(salaryAccountDTO.getAccountNumber());
        salaryAccount.setAccountHolderName(salaryAccountDTO.getAccountHolderName());
        salaryAccount.setSalaryTransactions(salaryAccountDTO.getSalaryTransactions().stream()
                .map(DTOToEntityConverter::convertToSalaryTransactionWithoutSalaryAccount)
                .collect(Collectors.toList()));
        salaryAccount.setBank(convertToBankWithoutSalaryAccounts(salaryAccountDTO.getBank()));
        return salaryAccount;
    }

    private static SalaryAccount convertToSalaryAccountWithoutSalaryTransactions(SalaryAccountDTO salaryAccountDTO) {
        SalaryAccount salaryAccount = new SalaryAccount();
        salaryAccount.setAccountNumber(salaryAccountDTO.getAccountNumber());
        salaryAccount.setAccountHolderName(salaryAccountDTO.getAccountHolderName());
        return salaryAccount;
    }
}
