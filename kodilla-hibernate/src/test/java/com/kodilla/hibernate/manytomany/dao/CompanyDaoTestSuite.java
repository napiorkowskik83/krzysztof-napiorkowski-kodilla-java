package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.CompaniesAndEmployeesFacade;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    CompaniesAndEmployeesFacade databaseFacade;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMastersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
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

    @Test
    public void testFacadeNamedQueries() {

        Employee johnDoe = new Employee("John", "Doe");
        Employee jenniferLawrence = new Employee("Jennifer", "Lawrence");
        Employee chrisDoe = new Employee("Chris", "Johnson");

        Company softwareHouse69 = new Company("Software House 69");
        Company dataJugglers = new Company("DataSpec Jugglers");
        Company softSpecialists = new Company("Soft Specialists");

        softwareHouse69.getEmployees().add(johnDoe);
        softSpecialists.getEmployees().add(johnDoe);
        softSpecialists.getEmployees().add(jenniferLawrence);
        dataJugglers.getEmployees().add(jenniferLawrence);
        dataJugglers.getEmployees().add(chrisDoe);

        List<Company> companies = new ArrayList<>();
        companies.add(softwareHouse69);
        companies.add(dataJugglers);
        companies.add(softSpecialists);

        databaseFacade.addCompanies(companies);

        //When
        List<Employee> employeesWithJohn = databaseFacade.retrieveEmployeesWhichNamesInclude("%john%");
        List<Employee> employeesWithWrenc = databaseFacade.retrieveEmployeesWhichNamesInclude("%wrenc%");
        List<Company> companiesWithSpec = databaseFacade.retrieveCompaniesWhichNamesInclude("%spec%");
        List<Company> companiesWithGgl = databaseFacade.retrieveCompaniesWhichNamesInclude("%ggl%");


        //Then
        Assert.assertEquals(2, employeesWithJohn.size());
        Assert.assertEquals(1, employeesWithWrenc.size());
        Assert.assertEquals(2, companiesWithSpec.size());
        Assert.assertEquals(1, companiesWithGgl.size());

        try {
            //CleanUp
            databaseFacade.cleanUp(companies);

        } catch (Exception e) {
            //do nothing
        }
    }
}
