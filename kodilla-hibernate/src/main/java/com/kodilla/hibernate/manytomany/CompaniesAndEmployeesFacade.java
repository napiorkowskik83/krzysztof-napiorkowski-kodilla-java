package com.kodilla.hibernate.manytomany;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompaniesAndEmployeesFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public CompaniesAndEmployeesFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public void addCompanies(List<Company> companies) {
        AddCompaniesToEmployeesCompanyLists(companies);
        for (Company company : companies) {
            companyDao.save(company);
        }
    }

    private void AddCompaniesToEmployeesCompanyLists(List<Company> companies) {
        for (Company company : companies) {
            for (Employee employee : company.getEmployees()) {
                employee.getCompanies().add(company);
            }
        }
    }

    public List<Company> retrieveCompaniesWhichNamesInclude(String phrase) {
        return companyDao.retrieveCompaniesWhichNamesInclude(phrase);
    }

    public List<Employee> retrieveEmployeesWhichNamesInclude(String phrase) {
        return employeeDao.retrieveEmployeesWhichNamesInclude(phrase);
    }

    public void cleanUp(List<Company> companies) {
        for (Company company : companies) {
            companyDao.deleteById(company.getId());
        }
    }
}
