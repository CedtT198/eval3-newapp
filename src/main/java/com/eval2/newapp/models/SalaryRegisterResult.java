package com.eval2.newapp.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalaryRegisterResult {
    @JsonProperty("salary_slip_id")
    String salary_slip_id;
    @JsonProperty("employee")
    String employee;
    @JsonProperty("employee_name")
    String employee_name;

    @JsonProperty("data_of_joining")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate data_of_joining;
    @JsonProperty("branch")
    String branch;
    @JsonProperty("department")
    String department;
    @JsonProperty("designation")
    String designation;
    @JsonProperty("company")
    String company;

    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate start_date;
    
    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate end_date;
    @JsonProperty("leave_without_pay")
    double leave_without_pay;
    @JsonProperty("absent_days")
    double absent_days;
    @JsonProperty("payment_days")
    double payment_days;
    @JsonProperty("currency")
    String currency;
    @JsonProperty("total_loan_repayment")
    double total_loan_repayment;
    @JsonProperty("gross_pay")
    double gross_pay;
    @JsonProperty("total_deduction")
    double total_deduction;
    @JsonProperty("net_pay")
    double net_pay;
    
    Map<String, Double> salary_components = new HashMap<>();

    public SalaryRegisterResult() {}

    public String getSalary_slip_id() {
        return salary_slip_id;
    }
    public void setSalary_slip_id(String salary_slip_id) {
        this.salary_slip_id = salary_slip_id;
    }
    public String getEmployee() {
        return employee;
    }
    public void setEmployee(String employee) {
        this.employee = employee;
    }
    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    public LocalDate getData_of_joining() {
        return data_of_joining;
    }
    public void setData_of_joining(LocalDate data_of_joining) {
        this.data_of_joining = data_of_joining;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public LocalDate getStart_date() {
        return start_date;
    }
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }
    public LocalDate getEnd_date() {
        return end_date;
    }
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
    public double getLeave_without_pay() {
        return leave_without_pay;
    }
    public void setLeave_without_pay(double leave_without_pay) {
        this.leave_without_pay = leave_without_pay;
    }
    public double getAbsent_days() {
        return absent_days;
    }
    public void setAbsent_days(double absent_days) {
        this.absent_days = absent_days;
    }
    public double getPayment_days() {
        return payment_days;
    }
    public void setPayment_days(double payment_days) {
        this.payment_days = payment_days;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public double getTotal_loan_repayment() {
        return total_loan_repayment;
    }
    public void setTotal_loan_repayment(double total_loan_repayment) {
        this.total_loan_repayment = total_loan_repayment;
    }
    public double getGross_pay() {
        return gross_pay;
    }
    public void setGross_pay(double gross_pay) {
        this.gross_pay = gross_pay;
    }
    public double getTotal_deduction() {
        return total_deduction;
    }
    public void setTotal_deduction(double total_deduction) {
        this.total_deduction = total_deduction;
    }
    public double getNet_pay() {
        return net_pay;
    }
    public void setNet_pay(double net_pay) {
        this.net_pay = net_pay;
    }

    public Map<String, Double> getSalary_components() {
        return salary_components;
    }

    public void setSalary_components(Map<String, Double> salary_components) {
        this.salary_components = salary_components;
    }

    @JsonAnySetter
    public void setSalary_componentsDynamicField(String key, Double value) {
        this.salary_components.put(key, value);
    }
}
