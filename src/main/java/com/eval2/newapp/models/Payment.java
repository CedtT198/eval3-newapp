package com.eval2.newapp.models;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Payment {
    public String name;
    public String owner;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDateTime creation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDateTime modified;

    public String modified_by;
    public int docstatus;
    public int idx;
    public String naming_series;
    public String payment_type;
    public String payment_order_status;
    public String posting_date;
    public String company;
    public String mode_of_payment;
    public String party_type;
    public String party;
    public String party_name;
    public int book_advance_payments_in_separate_party_account;
    public int reconcile_on_advance_payment_date;
    public String advance_reconciliation_takes_effect_on;
    public String bank_account;
    public String party_bank_account;
    public String contact_person;
    public String contact_email;
    public String paid_from;
    public String paid_from_account_type;
    public String paid_from_account_currency;
    public String paid_to;
    public String paid_to_account_type;
    public String paid_to_account_currency;
    public double paid_amount;
    public double paid_amount_after_tax;
    public double source_exchange_rate;
    public double base_paid_amount;
    public double base_paid_amount_after_tax;
    public double received_amount;
    public double received_amount_after_tax;
    public double target_exchange_rate;
    public double base_received_amount;
    public double base_received_amount_after_tax;
    public double total_allocated_amount;
    public double base_total_allocated_amount;
    public double unallocated_amount;
    public double difference_amount;
    public String purchase_taxes_and_charges_template;
    public String sales_taxes_and_charges_template;
    public int apply_tax_withholding_amount;
    public String tax_withholding_category;
    public double base_total_taxes_and_charges;
    public double total_taxes_and_charges;
    public String reference_no;
    public String reference_date;
    public String clearance_date;
    public String project;
    public String cost_center;
    public String status;
    public int custom_remarks;
    public String remarks;
    public String base_in_words;
    public String is_opening;
    public String letter_head;
    public String print_heading;
    public String bank;
    public String bank_account_no;
    public String payment_order;
    public String in_words;
    public String auto_repeat;
    public String amended_from;
    public String title;
    public List<Object> references;

    public Payment() {}
    
    public List<Object> getReferences() {
        return references;
    }
    public void setReferences(List<Object> references) {
        this.references = references;
    }
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
    public String getPayment_type() {
        return payment_type;
    }
    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
    public String getPayment_order_status() {
        return payment_order_status;
    }
    public void setPayment_order_status(String payment_order_status) {
        this.payment_order_status = payment_order_status;
    }
    public String getPosting_date() {
        return posting_date;
    }
    public void setPosting_date(String posting_date) {
        this.posting_date = posting_date;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getMode_of_payment() {
        return mode_of_payment;
    }
    public void setMode_of_payment(String mode_of_payment) {
        this.mode_of_payment = mode_of_payment;
    }
    public String getParty_type() {
        return party_type;
    }
    public void setParty_type(String party_type) {
        this.party_type = party_type;
    }
    public String getParty() {
        return party;
    }
    public void setParty(String party) {
        this.party = party;
    }
    public String getParty_name() {
        return party_name;
    }
    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }
    public int getBook_advance_payments_in_separate_party_account() {
        return book_advance_payments_in_separate_party_account;
    }
    public void setBook_advance_payments_in_separate_party_account(int book_advance_payments_in_separate_party_account) {
        this.book_advance_payments_in_separate_party_account = book_advance_payments_in_separate_party_account;
    }
    public int getReconcile_on_advance_payment_date() {
        return reconcile_on_advance_payment_date;
    }
    public void setReconcile_on_advance_payment_date(int reconcile_on_advance_payment_date) {
        this.reconcile_on_advance_payment_date = reconcile_on_advance_payment_date;
    }
    public String getAdvance_reconciliation_takes_effect_on() {
        return advance_reconciliation_takes_effect_on;
    }
    public void setAdvance_reconciliation_takes_effect_on(String advance_reconciliation_takes_effect_on) {
        this.advance_reconciliation_takes_effect_on = advance_reconciliation_takes_effect_on;
    }
    public String getBank_account() {
        return bank_account;
    }
    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }
    public String getParty_bank_account() {
        return party_bank_account;
    }
    public void setParty_bank_account(String party_bank_account) {
        this.party_bank_account = party_bank_account;
    }
    public String getContact_person() {
        return contact_person;
    }
    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }
    public String getContact_email() {
        return contact_email;
    }
    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }
    public String getPaid_from() {
        return paid_from;
    }
    public void setPaid_from(String paid_from) {
        this.paid_from = paid_from;
    }
    public String getPaid_from_account_type() {
        return paid_from_account_type;
    }
    public void setPaid_from_account_type(String paid_from_account_type) {
        this.paid_from_account_type = paid_from_account_type;
    }
    public String getPaid_from_account_currency() {
        return paid_from_account_currency;
    }
    public void setPaid_from_account_currency(String paid_from_account_currency) {
        this.paid_from_account_currency = paid_from_account_currency;
    }
    public String getPaid_to() {
        return paid_to;
    }
    public void setPaid_to(String paid_to) {
        this.paid_to = paid_to;
    }
    public String getPaid_to_account_type() {
        return paid_to_account_type;
    }
    public void setPaid_to_account_type(String paid_to_account_type) {
        this.paid_to_account_type = paid_to_account_type;
    }
    public String getPaid_to_account_currency() {
        return paid_to_account_currency;
    }
    public void setPaid_to_account_currency(String paid_to_account_currency) {
        this.paid_to_account_currency = paid_to_account_currency;
    }
    public double getPaid_amount() {
        return paid_amount;
    }
    public void setPaid_amount(double paid_amount) {
        this.paid_amount = paid_amount;
    }
    public double getPaid_amount_after_tax() {
        return paid_amount_after_tax;
    }
    public void setPaid_amount_after_tax(double paid_amount_after_tax) {
        this.paid_amount_after_tax = paid_amount_after_tax;
    }
    public double getSource_exchange_rate() {
        return source_exchange_rate;
    }
    public void setSource_exchange_rate(double source_exchange_rate) {
        this.source_exchange_rate = source_exchange_rate;
    }
    public double getBase_paid_amount() {
        return base_paid_amount;
    }
    public void setBase_paid_amount(double base_paid_amount) {
        this.base_paid_amount = base_paid_amount;
    }
    public double getBase_paid_amount_after_tax() {
        return base_paid_amount_after_tax;
    }
    public void setBase_paid_amount_after_tax(double base_paid_amount_after_tax) {
        this.base_paid_amount_after_tax = base_paid_amount_after_tax;
    }
    public double getReceived_amount() {
        return received_amount;
    }
    public void setReceived_amount(double received_amount) {
        this.received_amount = received_amount;
    }
    public double getReceived_amount_after_tax() {
        return received_amount_after_tax;
    }
    public void setReceived_amount_after_tax(double received_amount_after_tax) {
        this.received_amount_after_tax = received_amount_after_tax;
    }
    public double getTarget_exchange_rate() {
        return target_exchange_rate;
    }
    public void setTarget_exchange_rate(double target_exchange_rate) {
        this.target_exchange_rate = target_exchange_rate;
    }
    public double getBase_received_amount() {
        return base_received_amount;
    }
    public void setBase_received_amount(double base_received_amount) {
        this.base_received_amount = base_received_amount;
    }
    public double getBase_received_amount_after_tax() {
        return base_received_amount_after_tax;
    }
    public void setBase_received_amount_after_tax(double base_received_amount_after_tax) {
        this.base_received_amount_after_tax = base_received_amount_after_tax;
    }
    public double getTotal_allocated_amount() {
        return total_allocated_amount;
    }
    public void setTotal_allocated_amount(double total_allocated_amount) {
        this.total_allocated_amount = total_allocated_amount;
    }
    public double getBase_total_allocated_amount() {
        return base_total_allocated_amount;
    }
    public void setBase_total_allocated_amount(double base_total_allocated_amount) {
        this.base_total_allocated_amount = base_total_allocated_amount;
    }
    public double getUnallocated_amount() {
        return unallocated_amount;
    }
    public void setUnallocated_amount(double unallocated_amount) {
        this.unallocated_amount = unallocated_amount;
    }
    public double getDifference_amount() {
        return difference_amount;
    }
    public void setDifference_amount(double difference_amount) {
        this.difference_amount = difference_amount;
    }
    public String getPurchase_taxes_and_charges_template() {
        return purchase_taxes_and_charges_template;
    }
    public void setPurchase_taxes_and_charges_template(String purchase_taxes_and_charges_template) {
        this.purchase_taxes_and_charges_template = purchase_taxes_and_charges_template;
    }
    public String getSales_taxes_and_charges_template() {
        return sales_taxes_and_charges_template;
    }
    public void setSales_taxes_and_charges_template(String sales_taxes_and_charges_template) {
        this.sales_taxes_and_charges_template = sales_taxes_and_charges_template;
    }
    public int getApply_tax_withholding_amount() {
        return apply_tax_withholding_amount;
    }
    public void setApply_tax_withholding_amount(int apply_tax_withholding_amount) {
        this.apply_tax_withholding_amount = apply_tax_withholding_amount;
    }
    public String getTax_withholding_category() {
        return tax_withholding_category;
    }
    public void setTax_withholding_category(String tax_withholding_category) {
        this.tax_withholding_category = tax_withholding_category;
    }
    public double getBase_total_taxes_and_charges() {
        return base_total_taxes_and_charges;
    }
    public void setBase_total_taxes_and_charges(double base_total_taxes_and_charges) {
        this.base_total_taxes_and_charges = base_total_taxes_and_charges;
    }
    public double getTotal_taxes_and_charges() {
        return total_taxes_and_charges;
    }
    public void setTotal_taxes_and_charges(double total_taxes_and_charges) {
        this.total_taxes_and_charges = total_taxes_and_charges;
    }
    public String getReference_no() {
        return reference_no;
    }
    public void setReference_no(String reference_no) {
        this.reference_no = reference_no;
    }
    public String getReference_date() {
        return reference_date;
    }
    public void setReference_date(String reference_date) {
        this.reference_date = reference_date;
    }
    public String getClearance_date() {
        return clearance_date;
    }
    public void setClearance_date(String clearance_date) {
        this.clearance_date = clearance_date;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public String getCost_center() {
        return cost_center;
    }
    public void setCost_center(String cost_center) {
        this.cost_center = cost_center;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getCustom_remarks() {
        return custom_remarks;
    }
    public void setCustom_remarks(int custom_remarks) {
        this.custom_remarks = custom_remarks;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getBase_in_words() {
        return base_in_words;
    }
    public void setBase_in_words(String base_in_words) {
        this.base_in_words = base_in_words;
    }
    public String getIs_opening() {
        return is_opening;
    }
    public void setIs_opening(String is_opening) {
        this.is_opening = is_opening;
    }
    public String getLetter_head() {
        return letter_head;
    }
    public void setLetter_head(String letter_head) {
        this.letter_head = letter_head;
    }
    public String getPrint_heading() {
        return print_heading;
    }
    public void setPrint_heading(String print_heading) {
        this.print_heading = print_heading;
    }
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public String getBank_account_no() {
        return bank_account_no;
    }
    public void setBank_account_no(String bank_account_no) {
        this.bank_account_no = bank_account_no;
    }
    public String getPayment_order() {
        return payment_order;
    }
    public void setPayment_order(String payment_order) {
        this.payment_order = payment_order;
    }
    public String getIn_words() {
        return in_words;
    }
    public void setIn_words(String in_words) {
        this.in_words = in_words;
    }
    public String getAuto_repeat() {
        return auto_repeat;
    }
    public void setAuto_repeat(String auto_repeat) {
        this.auto_repeat = auto_repeat;
    }
    public String getAmended_from() {
        return amended_from;
    }
    public void setAmended_from(String amended_from) {
        this.amended_from = amended_from;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
