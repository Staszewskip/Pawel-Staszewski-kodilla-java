package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.EmployeeCompanyFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeAndCompanyFacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeCompanyFacade employeeCompanyFacade;

    @Test
    void findEmployeesByAnyFragmentOfTheName() {

        //        Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");

        Company dataMasters = new Company("Data Masters");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company blackMatter = new Company("Black Matter");

        dataMasters.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarkson);
        greyMatter.getEmployees().add(johnSmith);
        blackMatter.getEmployees().add(stephanieClarkson);

        johnSmith.getCompanies().add(dataMasters);
        stephanieClarkson.getCompanies().add(dataMaesters);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarkson.getCompanies().add(blackMatter);

        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(blackMatter);
        int blackMatterId = blackMatter.getId();
//        When
        List<Employee> resultEmployeeList = employeeCompanyFacade.fetchEmployees("mi");

//        Then
        assertEquals(1, resultEmployeeList.size());

//        CleanUp
        try {
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(greyMatterId);
            companyDao.deleteById(blackMatterId);
        } catch (Exception e) {
        }
    }

    @Test
    void findCompaniesByAnyFragmentOfTheName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        List<Company> companiesList = employeeCompanyFacade.fetchCompanies("ste");

        //Then
        assertEquals(1, companiesList.size());


        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
