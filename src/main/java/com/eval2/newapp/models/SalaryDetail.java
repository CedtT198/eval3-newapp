package com.eval2.newapp.models;

import java.util.ArrayList;
import java.util.List;

public class SalaryDetail {
    Employe employe;
    SalaryAssignment salaryAssignment;
    List<SalaryDetailDTO> salary_details;
    List<String> columns;
    // double totalEarnings;
    // double totalDeductions;
    
    public SalaryDetail() {
        this.salaryAssignment= new SalaryAssignment();
    }

    // public double getTotalEarnings() {
    //     return totalEarnings;
    // }
    // public void setTotalEarnings(double totalEarnings) {
    //     this.totalEarnings = totalEarnings;
    // }
    // public double getTotalDeductions() {
    //     return totalDeductions;
    // }
    // public void setTotalDeductions(double totalDeductions) {
    //     this.totalDeductions = totalDeductions;
    // }
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

    // public void setTotalParentField(String field) {
    //     double total = 0;
    //     String fieldLower = field.toLowerCase();
    //     for (SalaryDetailDTO sal : this.getSalary_details()) {
    //         if (sal.getParentfield().toLowerCase().equals(fieldLower)) {
    //             total += sal.getAmount();
    //         }
    //     }

    //     if (fieldLower.equals("earnings")) this.totalEarnings = total;
    //     else if (fieldLower.equals("deductions")) this.totalDeductions = total;
    // }

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
