package com.eval2.newapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SalaryDetailDTO {

	public String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
	public java.sql.Date creation;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
	public java.sql.Date modified;

	public String modified_by;
	public String owner;
	public int docstatus;
	public int idx;
	public String salary_component;
	public String abbr;
	public double amount;
	public double year_to_date;
	public String additional_salary;
	public int is_recurring_additional_salary;
	public int statistical_component;
	public int depends_on_payment_days;
	public int exempted_from_income_tax;
	public int is_tax_applicable;
	public int is_flexible_benefit;
	public int variable_based_on_taxable_salary;
	public int do_not_include_in_total;
	public int deduct_full_tax_on_selected_payroll_date;
    public String condition;
    public int amount_based_on_formula;
    public String formula;
	public double default_amount;
	public double additional_amount;
	public double tax_on_flexible_benefit;
	public double tax_on_additional_salary;
	public String parent;
	public String parentfield;
	public String parenttype;

    public SalaryDetailDTO() {
        this.salary_component = "";
    }
    public SalaryDetailDTO(String salComp) {
        this.salary_component = salComp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.sql.Date getCreation() {
        return creation;
    }

    public void setCreation(java.sql.Date creation) {
        this.creation = creation;
    }

    public java.sql.Date getModified() {
        return modified;
    }

    public void setModified(java.sql.Date modified) {
        this.modified = modified;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(int docstatus) {
        this.docstatus = docstatus;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getSalary_component() {
        return salary_component;
    }

    public void setSalary_component(String salary_component) {
        this.salary_component = salary_component;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getYear_to_date() {
        return year_to_date;
    }

    public void setYear_to_date(double year_to_date) {
        this.year_to_date = year_to_date;
    }

    public String getAdditional_salary() {
        return additional_salary;
    }

    public void setAdditional_salary(String additional_salary) {
        this.additional_salary = additional_salary;
    }

    public int getIs_recurring_additional_salary() {
        return is_recurring_additional_salary;
    }

    public void setIs_recurring_additional_salary(int is_recurring_additional_salary) {
        this.is_recurring_additional_salary = is_recurring_additional_salary;
    }

    public int getStatistical_component() {
        return statistical_component;
    }

    public void setStatistical_component(int statistical_component) {
        this.statistical_component = statistical_component;
    }

    public int getDepends_on_payment_days() {
        return depends_on_payment_days;
    }

    public void setDepends_on_payment_days(int depends_on_payment_days) {
        this.depends_on_payment_days = depends_on_payment_days;
    }

    public int getExempted_from_income_tax() {
        return exempted_from_income_tax;
    }

    public void setExempted_from_income_tax(int exempted_from_income_tax) {
        this.exempted_from_income_tax = exempted_from_income_tax;
    }

    public int getIs_tax_applicable() {
        return is_tax_applicable;
    }

    public void setIs_tax_applicable(int is_tax_applicable) {
        this.is_tax_applicable = is_tax_applicable;
    }

    public int getIs_flexible_benefit() {
        return is_flexible_benefit;
    }

    public void setIs_flexible_benefit(int is_flexible_benefit) {
        this.is_flexible_benefit = is_flexible_benefit;
    }

    public int getVariable_based_on_taxable_salary() {
        return variable_based_on_taxable_salary;
    }

    public void setVariable_based_on_taxable_salary(int variable_based_on_taxable_salary) {
        this.variable_based_on_taxable_salary = variable_based_on_taxable_salary;
    }

    public int getDo_not_include_in_total() {
        return do_not_include_in_total;
    }

    public void setDo_not_include_in_total(int do_not_include_in_total) {
        this.do_not_include_in_total = do_not_include_in_total;
    }

    public int getDeduct_full_tax_on_selected_payroll_date() {
        return deduct_full_tax_on_selected_payroll_date;
    }

    public void setDeduct_full_tax_on_selected_payroll_date(int deduct_full_tax_on_selected_payroll_date) {
        this.deduct_full_tax_on_selected_payroll_date = deduct_full_tax_on_selected_payroll_date;
    }

    public int getAmount_based_on_formula() {
        return amount_based_on_formula;
    }

    public void setAmount_based_on_formula(int amount_based_on_formula) {
        this.amount_based_on_formula = amount_based_on_formula;
    }

    public double getDefault_amount() {
        return default_amount;
    }

    public void setDefault_amount(double default_amount) {
        this.default_amount = default_amount;
    }

    public double getAdditional_amount() {
        return additional_amount;
    }

    public void setAdditional_amount(double additional_amount) {
        this.additional_amount = additional_amount;
    }

    public double getTax_on_flexible_benefit() {
        return tax_on_flexible_benefit;
    }

    public void setTax_on_flexible_benefit(double tax_on_flexible_benefit) {
        this.tax_on_flexible_benefit = tax_on_flexible_benefit;
    }

    public double getTax_on_additional_salary() {
        return tax_on_additional_salary;
    }

    public void setTax_on_additional_salary(double tax_on_additional_salary) {
        this.tax_on_additional_salary = tax_on_additional_salary;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParentfield() {
        return parentfield;
    }

    public void setParentfield(String parentfield) {
        this.parentfield = parentfield;
    }

    public String getParenttype() {
        return parenttype;
    }

    public void setParenttype(String parenttype) {
        this.parenttype = parenttype;
    }

	public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFormula() {
        return formula;
    }
}
