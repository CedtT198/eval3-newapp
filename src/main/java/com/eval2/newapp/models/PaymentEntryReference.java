package com.eval2.newapp.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PaymentEntryReference {
    public String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDate creation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDate modified;

    public String modified_by;
    public String owner;
    public int docstatus;
    public int idx;
    public String reference_doctype;
    public String reference_name;
    public String due_date;
    public String bill_no;
    public String payment_term;
    public double payment_term_outstanding;
    public String account_type;
    public String payment_type;
    public String reconcile_effect_on;
    public double total_amount;
    public double outstanding_amount;
    public double allocated_amount;
    public double exchange_rate;
    public double exchange_gain_loss;
    public String account;
    public String payment_request;
    public String parent;
    public String parentfield;
    public String parenttype;

    public PaymentEntryReference() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getCreation() {
        return creation;
    }
    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }
    public LocalDate getModified() {
        return modified;
    }
    public void setModified(LocalDate modified) {
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
    public String getReference_doctype() {
        return reference_doctype;
    }
    public void setReference_doctype(String reference_doctype) {
        this.reference_doctype = reference_doctype;
    }
    public String getReference_name() {
        return reference_name;
    }
    public void setReference_name(String reference_name) {
        this.reference_name = reference_name;
    }
    public String getDue_date() {
        return due_date;
    }
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
    public String getBill_no() {
        return bill_no;
    }
    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }
    public String getPayment_term() {
        return payment_term;
    }
    public void setPayment_term(String payment_term) {
        this.payment_term = payment_term;
    }
    public double getPayment_term_outstanding() {
        return payment_term_outstanding;
    }
    public void setPayment_term_outstanding(double payment_term_outstanding) {
        this.payment_term_outstanding = payment_term_outstanding;
    }
    public String getAccount_type() {
        return account_type;
    }
    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
    public String getPayment_type() {
        return payment_type;
    }
    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
    public String getReconcile_effect_on() {
        return reconcile_effect_on;
    }
    public void setReconcile_effect_on(String reconcile_effect_on) {
        this.reconcile_effect_on = reconcile_effect_on;
    }
    public double getTotal_amount() {
        return total_amount;
    }
    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
    public double getOutstanding_amount() {
        return outstanding_amount;
    }
    public void setOutstanding_amount(double outstanding_amount) {
        this.outstanding_amount = outstanding_amount;
    }
    public double getAllocated_amount() {
        return allocated_amount;
    }
    public void setAllocated_amount(double allocated_amount) {
        this.allocated_amount = allocated_amount;
    }
    public double getExchange_rate() {
        return exchange_rate;
    }
    public void setExchange_rate(double exchange_rate) {
        this.exchange_rate = exchange_rate;
    }
    public double getExchange_gain_loss() {
        return exchange_gain_loss;
    }
    public void setExchange_gain_loss(double exchange_gain_loss) {
        this.exchange_gain_loss = exchange_gain_loss;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPayment_request() {
        return payment_request;
    }
    public void setPayment_request(String payment_request) {
        this.payment_request = payment_request;
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
}
