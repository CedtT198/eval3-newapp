package com.eval2.newapp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestForQuotation {
    String name;
    String owner;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    LocalDateTime creation;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    LocalDateTime modified;
    
    String modified_by;
    int docstatus;
    int idx;
    String naming_series;
    String company;
    String billing_address;
    String billing_address_display;
    String vendor;
    LocalDate transaction_date;
    LocalDate schedule_date;
    String status;
    String amended_from;
    String email_template;
    int send_attached_files;
    int send_document_print;
    String message_for_supplier;
    String incoterm;
    String named_place;
    String tc_name;
    String terms;
    String select_print_heading;
    String letter_head;
    String opportunity;

    public RequestForQuotation(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public LocalDateTime getCreation() {
        return creation;
    }
    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }
    public LocalDateTime getModified() {
        return modified;
    }
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
    public String getModified_by() {
        return modified_by;
    }
    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
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
    public String getNaming_series() {
        return naming_series;
    }
    public void setNaming_series(String naming_series) {
        this.naming_series = naming_series;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getBilling_address() {
        return billing_address;
    }
    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }
    public String getBilling_address_display() {
        return billing_address_display;
    }
    public void setBilling_address_display(String billing_address_display) {
        this.billing_address_display = billing_address_display;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public LocalDate getTransaction_date() {
        return transaction_date;
    }
    public void setTransaction_date(LocalDate transaction_date) {
        this.transaction_date = transaction_date;
    }
    public LocalDate getSchedule_date() {
        return schedule_date;
    }
    public void setSchedule_date(LocalDate schedule_date) {
        this.schedule_date = schedule_date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getAmended_from() {
        return amended_from;
    }
    public void setAmended_from(String amended_from) {
        this.amended_from = amended_from;
    }
    public String getEmail_template() {
        return email_template;
    }
    public void setEmail_template(String email_template) {
        this.email_template = email_template;
    }
    public int getSend_attached_files() {
        return send_attached_files;
    }
    public void setSend_attached_files(int send_attached_files) {
        this.send_attached_files = send_attached_files;
    }
    public int getSend_document_print() {
        return send_document_print;
    }
    public void setSend_document_print(int send_document_print) {
        this.send_document_print = send_document_print;
    }
    public String getMessage_for_supplier() {
        return message_for_supplier;
    }
    public void setMessage_for_supplier(String message_for_supplier) {
        this.message_for_supplier = message_for_supplier;
    }
    public String getIncoterm() {
        return incoterm;
    }
    public void setIncoterm(String incoterm) {
        this.incoterm = incoterm;
    }
    public String getNamed_place() {
        return named_place;
    }
    public void setNamed_place(String named_place) {
        this.named_place = named_place;
    }
    public String getTc_name() {
        return tc_name;
    }
    public void setTc_name(String tc_name) {
        this.tc_name = tc_name;
    }
    public String getTerms() {
        return terms;
    }
    public void setTerms(String terms) {
        this.terms = terms;
    }
    public String getSelect_print_heading() {
        return select_print_heading;
    }
    public void setSelect_print_heading(String select_print_heading) {
        this.select_print_heading = select_print_heading;
    }
    public String getLetter_head() {
        return letter_head;
    }
    public void setLetter_head(String letter_head) {
        this.letter_head = letter_head;
    }
    public String getOpportunity() {
        return opportunity;
    }
    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }

    
}