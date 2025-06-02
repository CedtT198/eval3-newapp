package com.eval2.newapp.models;

import java.time.LocalDateTime;

public class MaterialRequest {
    String name;
    String owner;
    LocalDateTime creation;
    LocalDateTime modified;
    String modified_by;
    int docstatus;
    int idx;
    String naming_series;
    String title;
    String material_request_type;
    String customer;
    String company;
    String transaction_date;
    String schedule_date;
    String amended_from;
    String scan_barcode;
    String set_from_warehouse;
    String set_warehouse;
    String tc_name;
    String terms;
    String status;
    double per_ordered;
    String transfer_status;
    double per_received;
    String letter_head;
    String select_print_heading;
    String job_card;
    String work_order;

    public MaterialRequest() {}

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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMaterial_request_type() {
        return material_request_type;
    }
    public void setMaterial_request_type(String material_request_type) {
        this.material_request_type = material_request_type;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getTransaction_date() {
        return transaction_date;
    }
    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }
    public String getSchedule_date() {
        return schedule_date;
    }
    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }
    public String getAmended_from() {
        return amended_from;
    }
    public void setAmended_from(String amended_from) {
        this.amended_from = amended_from;
    }
    public String getScan_barcode() {
        return scan_barcode;
    }
    public void setScan_barcode(String scan_barcode) {
        this.scan_barcode = scan_barcode;
    }
    public String getSet_from_warehouse() {
        return set_from_warehouse;
    }
    public void setSet_from_warehouse(String set_from_warehouse) {
        this.set_from_warehouse = set_from_warehouse;
    }
    public String getSet_warehouse() {
        return set_warehouse;
    }
    public void setSet_warehouse(String set_warehouse) {
        this.set_warehouse = set_warehouse;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getPer_ordered() {
        return per_ordered;
    }
    public void setPer_ordered(double per_ordered) {
        this.per_ordered = per_ordered;
    }
    public String getTransfer_status() {
        return transfer_status;
    }
    public void setTransfer_status(String transfer_status) {
        this.transfer_status = transfer_status;
    }
    public double getPer_received() {
        return per_received;
    }
    public void setPer_received(double per_received) {
        this.per_received = per_received;
    }
    public String getLetter_head() {
        return letter_head;
    }
    public void setLetter_head(String letter_head) {
        this.letter_head = letter_head;
    }
    public String getSelect_print_heading() {
        return select_print_heading;
    }
    public void setSelect_print_heading(String select_print_heading) {
        this.select_print_heading = select_print_heading;
    }
    public String getJob_card() {
        return job_card;
    }
    public void setJob_card(String job_card) {
        this.job_card = job_card;
    }
    public String getWork_order() {
        return work_order;
    }
    public void setWork_order(String work_order) {
        this.work_order = work_order;
    }
}
