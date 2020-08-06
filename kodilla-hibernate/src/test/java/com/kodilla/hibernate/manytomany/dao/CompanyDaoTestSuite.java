package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
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

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testNamedQueries() {

        Employee johnDoe = new Employee("John", "Doe");
        Employee jenniferLawrence = new Employee("Jennifer", "Lawrence");
        Employee chrisDoe = new Employee("Chris", "Doe");

        Company softwareHouse69 = new Company("Software House 69");
        Company dataJugglers = new Company("Data Jugglers");
        Company softSpecialists = new Company("Soft Specialists");

        johnDoe.getCompanies().add(softwareHouse69);
        johnDoe.getCompanies().add(softSpecialists);
        jenniferLawrence.getCompanies().add(softSpecialists);
        jenniferLawrence.getCompanies().add(dataJugglers);
        chrisDoe.getCompanies().add(dataJugglers);

        softwareHouse69.getEmployees().add(johnDoe);
        softSpecialists.getEmployees().add(johnDoe);
        softSpecialists.getEmployees().add(jenniferLawrence);
        dataJugglers.getEmployees().add(jenniferLawrence);
        dataJugglers.getEmployees().add(chrisDoe);

        companyDao.save(softwareHouse69);
        int softwareHouse69Id = softwareHouse69.getId();
        companyDao.save(dataJugglers);
        int dataJugglersId = dataJugglers.getId();
        companyDao.save(softSpecialists);
        int softSpecialistsId = softSpecialists.getId();

        //When
        List<Employee> employeesDoe = employeeDao.retrieveEmployeeWithLastname("Doe");
        List<Employee> employeesLawrence = employeeDao.retrieveEmployeeWithLastname("Lawrence");
        List<Employee> employeesTrump = employeeDao.retrieveEmployeeWithLastname("Trump");
        List<Company> sofCompanies = companyDao.retrieveCompaniesWhichNamesStartWith("Sof");
        List<Company> datCompanies = companyDao.retrieveCompaniesWhichNamesStartWith("Dat");
        List<Company> fixCompanies = companyDao.retrieveCompaniesWhichNamesStartWith("Fix");

        //Then
        Assert.assertEquals(2, employeesDoe.size());
        Assert.assertEquals(1, employeesLawrence.size());
        Assert.assertEquals(0, employeesTrump.size());
        Assert.assertEquals(2, sofCompanies.size());
        Assert.assertEquals(1, datCompanies.size());
        Assert.assertEquals(0, fixCompanies.size());

        try {
            //CleanUp
            companyDao.deleteById(softwareHouse69Id);
            companyDao.deleteById(softSpecialistsId);
            companyDao.deleteById(dataJugglersId);

        } catch (Exception e) {
            //do nothing
        }
    }
}
