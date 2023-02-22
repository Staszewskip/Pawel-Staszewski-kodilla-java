package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCompanyFacade {

    private CompanyDao companyDao;
    private EmployeeDao employeeDao;

    public EmployeeCompanyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Employee> fetchEmployees(String partOfTheEmployeeName) {
        return employeeDao.findEmployeesByAnyFragmentOfTheName(partOfTheEmployeeName);
    }

    public List<Company> fetchCompanies(String partOfTheCompanyName) {
        return companyDao.findCompaniesByAnyFragmentOfTheName(partOfTheCompanyName);
    }
}
