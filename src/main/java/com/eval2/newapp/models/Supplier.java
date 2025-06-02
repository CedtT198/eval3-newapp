package com.eval2.newapp.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Supplier {
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
    String supplier_name;
    String country;
    String supplier_group;
    String supplier_type;
    int is_transporter;
    String image;
    String default_currency;
    String default_bank_account;
    String default_price_list;
    int is_internal_supplier;
    String represents_company;
    String supplier_details;
    String website;
    String language;
    String tax_id;
    String tax_category;
    String tax_withholding_category;
    String supplier_primary_address;
    String primary_address;
    String supplier_primary_contact;
    String mobile_no;
    String email_id;
    String payment_terms;
    int allow_purchase_invoice_creation_without_purchase_order;
    int allow_purchase_invoice_creation_without_purchase_receipt;
    int is_frozen;
    int disabled;
    int warn_rfqs;
    int warn_pos;
    int prevent_rfqs;
    int prevent_pos;
    int on_hold;
    String hold_type;
    LocalDateTime release_date;

    public Supplier() {}

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

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSupplier_group() {
        return supplier_group;
    }

    public void setSupplier_group(String supplier_group) {
        this.supplier_group = supplier_group;
    }

    public String getSupplier_type() {
        return supplier_type;
    }

    public void setSupplier_type(String supplier_type) {
        this.supplier_type = supplier_type;
    }

    public int getIs_transporter() {
        return is_transporter;
    }

    public void setIs_transporter(int is_transporter) {
        this.is_transporter = is_transporter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDefault_currency() {
        return default_currency;
    }

    public void setDefault_currency(String default_currency) {
        this.default_currency = default_currency;
    }

    public String getDefault_bank_account() {
        return default_bank_account;
    }

    public void setDefault_bank_account(String default_bank_account) {
        this.default_bank_account = default_bank_account;
    }

    public String getDefault_price_list() {
        return default_price_list;
    }

    public void setDefault_price_list(String default_price_list) {
        this.default_price_list = default_price_list;
    }

    public int getIs_internal_supplier() {
        return is_internal_supplier;
    }

    public void setIs_internal_supplier(int is_internal_supplier) {
        this.is_internal_supplier = is_internal_supplier;
    }

    public String getRepresents_company() {
        return represents_company;
    }

    public void setRepresents_company(String represents_company) {
        this.represents_company = represents_company;
    }

    public String getSupplier_details() {
        return supplier_details;
    }

    public void setSupplier_details(String supplier_details) {
        this.supplier_details = supplier_details;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getTax_category() {
        return tax_category;
    }

    public void setTax_category(String tax_category) {
        this.tax_category = tax_category;
    }

    public String getTax_withholding_category() {
        return tax_withholding_category;
    }

    public void setTax_withholding_category(String tax_withholding_category) {
        this.tax_withholding_category = tax_withholding_category;
    }

    public String getSupplier_primary_address() {
        return supplier_primary_address;
    }

    public void setSupplier_primary_address(String supplier_primary_address) {
        this.supplier_primary_address = supplier_primary_address;
    }

    public String getPrimary_address() {
        return primary_address;
    }

    public void setPrimary_address(String primary_address) {
        this.primary_address = primary_address;
    }

    public String getSupplier_primary_contact() {
        return supplier_primary_contact;
    }

    public void setSupplier_primary_contact(String supplier_primary_contact) {
        this.supplier_primary_contact = supplier_primary_contact;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPayment_terms() {
        return payment_terms;
    }

    public void setPayment_terms(String payment_terms) {
        this.payment_terms = payment_terms;
    }

    public int getAllow_purchase_invoice_creation_without_purchase_order() {
        return allow_purchase_invoice_creation_without_purchase_order;
    }

    public void setAllow_purchase_invoice_creation_without_purchase_order(
            int allow_purchase_invoice_creation_without_purchase_order) {
        this.allow_purchase_invoice_creation_without_purchase_order = allow_purchase_invoice_creation_without_purchase_order;
    }

    public int getAllow_purchase_invoice_creation_without_purchase_receipt() {
        return allow_purchase_invoice_creation_without_purchase_receipt;
    }

    public void setAllow_purchase_invoice_creation_without_purchase_receipt(
            int allow_purchase_invoice_creation_without_purchase_receipt) {
        this.allow_purchase_invoice_creation_without_purchase_receipt = allow_purchase_invoice_creation_without_purchase_receipt;
    }

    public int getIs_frozen() {
        return is_frozen;
    }

    public void setIs_frozen(int is_frozen) {
        this.is_frozen = is_frozen;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public int getWarn_rfqs() {
        return warn_rfqs;
    }

    public void setWarn_rfqs(int warn_rfqs) {
        this.warn_rfqs = warn_rfqs;
    }

    public int getWarn_pos() {
        return warn_pos;
    }

    public void setWarn_pos(int warn_pos) {
        this.warn_pos = warn_pos;
    }

    public int getPrevent_rfqs() {
        return prevent_rfqs;
    }

    public void setPrevent_rfqs(int prevent_rfqs) {
        this.prevent_rfqs = prevent_rfqs;
    }

    public int getPrevent_pos() {
        return prevent_pos;
    }

    public void setPrevent_pos(int prevent_pos) {
        this.prevent_pos = prevent_pos;
    }

    public int getOn_hold() {
        return on_hold;
    }

    public void setOn_hold(int on_hold) {
        this.on_hold = on_hold;
    }

    public String getHold_type() {
        return hold_type;
    }

    public void setHold_type(String hold_type) {
        this.hold_type = hold_type;
    }

    public LocalDateTime getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDateTime release_date) {
        this.release_date = release_date;
    }

    
}
