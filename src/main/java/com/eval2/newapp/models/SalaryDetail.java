package com.eval2.newapp.models;

import java.util.ArrayList;
import java.util.List;

public class SalaryDetail {
    Employe employe;
    SalaryAssignment salaryAssignment;
    List<SalaryDetailDTO> salary_details;
    List<String> columns;
    
    public SalaryDetail() {}

    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    public List<SalaryDetailDTO> getSalary_details() {
        return salary_details;
    }
    public void setSalary_details(List<SalaryDetailDTO> salary_details) {
        this.salary_details = salary_details;
    }

    public SalaryAssignment getSalaryAssignment() {
        return salaryAssignment;
    }

    public void setSalaryAssignment(SalaryAssignment salaryAssignment) {
        this.salaryAssignment = salaryAssignment;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }    

    public void setColumns() {
        List<String> columns = new ArrayList<>();
        for (SalaryDetailDTO detail : salary_details) {
            // String col = detail.getSalary_component() + " ("+detail.getAbbr()+")";
            String col = detail.getSalary_component();
            columns.add(col);
        }
        this.columns = columns;
    }    
}
