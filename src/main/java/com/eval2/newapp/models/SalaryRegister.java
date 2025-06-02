package com.eval2.newapp.models;

import java.util.List;

public class SalaryRegister {
    List<SalaryRegisterResult> results;
    List<Object> total;
    List<SalaryRegisterColumns> columns;
    String message;
    String chart;
    String report_summary;
    int skip_total_row;
    String status;
    double execution_time;
    boolean add_total_row;

    public SalaryRegister() {}

    public List<SalaryRegisterResult> getResults() {
        return results;
    }

    public void setResults(List<SalaryRegisterResult> results) {
        this.results = results;
    }

    public List<Object> getTotal() {
        return total;
    }

    public void setTotal(List<Object> total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public String getReport_summary() {
        return report_summary;
    }

    public void setReport_summary(String report_summary) {
        this.report_summary = report_summary;
    }

    public int getSkip_total_row() {
        return skip_total_row;
    }

    public void setSkip_total_row(int skip_total_row) {
        this.skip_total_row = skip_total_row;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getExecution_time() {
        return execution_time;
    }

    public void setExecution_time(double execution_time) {
        this.execution_time = execution_time;
    }

    public boolean getAdd_total_row() {
        return add_total_row;
    }

    public void setAdd_total_row(boolean add_total_row) {
        this.add_total_row = add_total_row;
    }

    public List<SalaryRegisterColumns> getColumns() {
        return columns;
    }

    public void setColumns(List<SalaryRegisterColumns> columns) {
        this.columns = columns;
    }

    
}
