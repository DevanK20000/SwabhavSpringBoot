package com.aurionpro.mapping.util;

import com.aurionpro.mapping.dto.*;
import com.aurionpro.mapping.entity.*;
import java.util.stream.Collectors;

public class EntityToDTOConverter {

    public static BankDTO convertToBankDTO(Bank bank) {
        return new BankDTO(
                bank.getBankId(),
                bank.getBankName(),
                bank.getIfsco(),
                bank.getSalaryAccounts().stream()
                        .map(EntityToDTOConverter::convertToSalaryAccountDTOWithoutBank)
                        .collect(Collectors.toList())
        );
    }

    public static ClientDTO convertToClientDTO(Client client) {
        return new ClientDTO(
                client.getClientId(),
                client.getCompanyName(),
                client.getRegistrationNumber(),
                client.getContactPerson(),
                client.getContactEmail(),
                client.getContactNumber(),
                client.getAddress(),
                client.getStatus(),
                client.getCreationDate(),
                client.getClientKycStatus(),
                client.getEmployees().stream()
                        .map(EntityToDTOConverter::convertToEmployeeDTOWithoutClient)
                        .collect(Collectors.toList())
        );
    }

    public static EmployeeDTO convertToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhoneNumber(),
                employee.getEmail(),
                employee.getPosition(),
                employee.getHireDate(),
                employee.getSalary(),
                convertToSalaryAccountDTOWithoutEmployee(employee.getSalaryAccount()),
                employee.getBankIfscNumber(),
                employee.getEmployeeStatus(),
                convertToClientDTOWithoutEmployees(employee.getClient())
        );
    }

    public static SalaryDTO convertToSalaryDTO(Salary salary) {
        return new SalaryDTO(
                salary.getSalaryId(),
                salary.getSalaryMonth(),
                salary.getGrossSalary(),
                salary.getDeductions(),
                salary.getNetSalary(),
                salary.getPaymentDate(),
                salary.getStatus()
        );
    }

    public static SalaryAccountDTO convertToSalaryAccountDTO(SalaryAccount salaryAccount) {
        return new SalaryAccountDTO(
                salaryAccount.getAccountNumber(),
                salaryAccount.getAccountHolderName(),
                salaryAccount.getSalaryTransactions().stream()
                        .map(EntityToDTOConverter::convertToSalaryTransactionDTOWithoutSalaryAccount)
                        .collect(Collectors.toList()),
                convertToBankDTOWithoutSalaryAccounts(salaryAccount.getBank())
        );
    }

    public static SalaryTransactionDTO convertToSalaryTransactionDTO(SalaryTransaction salaryTransaction) {
        return new SalaryTransactionDTO(
                salaryTransaction.getTransactionId(),
                salaryTransaction.getTransactionDate(),
                salaryTransaction.getAmount(),
                salaryTransaction.getStatus(),
                convertToSalaryDTO(salaryTransaction.getSalary()),
                convertToSalaryAccountDTOWithoutSalaryTransactions(salaryTransaction.getSalaryAccount())
        );
    }

    // Helper methods to avoid circular references
    private static SalaryAccountDTO convertToSalaryAccountDTOWithoutBank(SalaryAccount salaryAccount) {
        return new SalaryAccountDTO(
                salaryAccount.getAccountNumber(),
                salaryAccount.getAccountHolderName(),
                salaryAccount.getSalaryTransactions().stream()
                        .map(EntityToDTOConverter::convertToSalaryTransactionDTOWithoutSalaryAccount)
                        .collect(Collectors.toList()),
                null
        );
    }

    private static SalaryTransactionDTO convertToSalaryTransactionDTOWithoutSalaryAccount(SalaryTransaction salaryTransaction) {
        return new SalaryTransactionDTO(
                salaryTransaction.getTransactionId(),
                salaryTransaction.getTransactionDate(),
                salaryTransaction.getAmount(),
                salaryTransaction.getStatus(),
                convertToSalaryDTO(salaryTransaction.getSalary()),
                null
        );
    }

    private static BankDTO convertToBankDTOWithoutSalaryAccounts(Bank bank) {
        return new BankDTO(
                bank.getBankId(),
                bank.getBankName(),
                bank.getIfsco(),
                null
        );
    }

    private static ClientDTO convertToClientDTOWithoutEmployees(Client client) {
        return new ClientDTO(
                client.getClientId(),
                client.getCompanyName(),
                client.getRegistrationNumber(),
                client.getContactPerson(),
                client.getContactEmail(),
                client.getContactNumber(),
                client.getAddress(),
                client.getStatus(),
                client.getCreationDate(),
                client.getClientKycStatus(),
                null
        );
    }

    private static EmployeeDTO convertToEmployeeDTOWithoutClient(Employee employee) {
        return new EmployeeDTO(
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhoneNumber(),
                employee.getEmail(),
                employee.getPosition(),
                employee.getHireDate(),
                employee.getSalary(),
                convertToSalaryAccountDTOWithoutEmployee(employee.getSalaryAccount()),
                employee.getBankIfscNumber(),
                employee.getEmployeeStatus(),
                null
        );
    }

    private static SalaryAccountDTO convertToSalaryAccountDTOWithoutEmployee(SalaryAccount salaryAccount) {
        return new SalaryAccountDTO(
                salaryAccount.getAccountNumber(),
                salaryAccount.getAccountHolderName(),
                salaryAccount.getSalaryTransactions().stream()
                        .map(EntityToDTOConverter::convertToSalaryTransactionDTOWithoutSalaryAccount)
                        .collect(Collectors.toList()),
                convertToBankDTOWithoutSalaryAccounts(salaryAccount.getBank())
        );
    }

    private static SalaryAccountDTO convertToSalaryAccountDTOWithoutSalaryTransactions(SalaryAccount salaryAccount) {
        return new SalaryAccountDTO(
                salaryAccount.getAccountNumber(),
                salaryAccount.getAccountHolderName(),
                null,
                convertToBankDTOWithoutSalaryAccounts(salaryAccount.getBank())
        );
    }
}
