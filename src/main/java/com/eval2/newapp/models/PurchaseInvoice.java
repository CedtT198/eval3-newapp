package com.eval2.newapp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseInvoice {
    public String name;
    public String owner;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDateTime creation;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDateTime modified;
    
    String modified_by;
    int docstatus;
    int idx;
    String title;
    String naming_series;
    String supplier;
    String supplier_name;
    String tax_id;
    String company;
    LocalDate posting_date;
    String posting_time;
    int set_posting_time;
    LocalDate due_date;
    int is_paid;
    int is_return;
    String return_against;
    int update_outstanding_for_self;
    int update_billed_amount_in_purchase_order;
    int update_billed_amount_in_purchase_receipt;
    int apply_tds;
    String tax_withholding_category;
    String amended_from;
    String bill_no;
    String bill_date;
    String cost_center;
    String project;
    String currency;
    double conversion_rate;
    int use_transaction_date_exchange_rate;
    String buying_price_list;
    String price_list_currency;
    double plc_conversion_rate;
    int ignore_pricing_rule;
    String scan_barcode;
    int update_stock;
    String set_warehouse;
    String set_from_warehouse;
    int is_subcontracted;
    String rejected_warehouse;
    String supplier_warehouse;
    double total_qty;
    double total_net_weight;
    double base_total;
    double base_net_total;
    double total;
    double net_total;
    double tax_withholding_net_total;
    double base_tax_withholding_net_total;
    String tax_category;
    String taxes_and_charges;
    String shipping_rule;
    String incoterm;
    String named_place;
    double base_taxes_and_charges_added;
    double base_taxes_and_charges_deducted;
    double base_total_taxes_and_charges;
    double taxes_and_charges_added;
    double taxes_and_charges_deducted;
    double total_taxes_and_charges;
    double base_grand_total;
    double base_rounding_adjustment;
    double base_rounded_total;
    String base_in_words;
    double grand_total;
    double rounding_adjustment;
    int use_company_roundoff_cost_center;
    double rounded_total;
    String in_words;
    double total_advance;
    double outstanding_amount;
    int disable_rounded_total;
    String apply_discount_on;
    double base_discount_amount;
    double additional_discount_percentage;
    double discount_amount;
    String other_charges_calculation;
    String mode_of_payment;
    double base_paid_amount;
    String clearance_date;
    String cash_bank_account;
    double paid_amount;
    int allocate_advances_automatically;
    int only_include_allocated_payments;
    double write_off_amount;
    double base_write_off_amount;
    String write_off_account;
    String write_off_cost_center;
    String supplier_address;
    String address_display;
    String contact_person;
    String contact_display;
    String contact_mobile;
    String contact_email;
    String shipping_address;
    String shipping_address_display;
    String billing_address;
    String billing_address_display;
    String payment_terms_template;
    int ignore_default_payment_terms_template;
    String tc_name;
    String terms;
    String status;
    double per_received;
    String credit_to;
    String party_account_currency;
    String is_opening;
    String against_expense_account;
    String unrealized_profit_loss_account;
    String subscription;
    String auto_repeat;
    String from_date;
    String to_date;
    String letter_head;
    int group_same_items;
    String select_print_heading;
    String language;
    int on_hold;
    String release_date;
    String hold_comment;
    int is_internal_supplier;
    String represents_company;
    String supplier_group;
    String sender;
    String inter_company_invoice_reference;
    int is_old_subcontracting_flow;
    String remarks;

    public PurchaseInvoice() {}
    
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getNaming_series() {
        return naming_series;
    }
    public void setNaming_series(String naming_series) {
        this.naming_series = naming_series;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getSupplier_name() {
        return supplier_name;
    }
    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }
    public String getTax_id() {
        return tax_id;
    }
    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public LocalDate getPosting_date() {
        return posting_date;
    }
    public void setPosting_date(LocalDate posting_date) {
        this.posting_date = posting_date;
    }
    public String getPosting_time() {
        return posting_time;
    }
    public void setPosting_time(String posting_time) {
        this.posting_time = posting_time;
    }
    public int getSet_posting_time() {
        return set_posting_time;
    }
    public void setSet_posting_time(int set_posting_time) {
        this.set_posting_time = set_posting_time;
    }
    public LocalDate getDue_date() {
        return due_date;
    }
    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }
    public int getIs_paid() {
        return is_paid;
    }
    public void setIs_paid(int is_paid) {
        this.is_paid = is_paid;
    }
    public int getIs_return() {
        return is_return;
    }
    public void setIs_return(int is_return) {
        this.is_return = is_return;
    }
    public String getReturn_against() {
        return return_against;
    }
    public void setReturn_against(String return_against) {
        this.return_against = return_against;
    }
    public int getUpdate_outstanding_for_self() {
        return update_outstanding_for_self;
    }
    public void setUpdate_outstanding_for_self(int update_outstanding_for_self) {
        this.update_outstanding_for_self = update_outstanding_for_self;
    }
    public int getUpdate_billed_amount_in_purchase_order() {
        return update_billed_amount_in_purchase_order;
    }
    public void setUpdate_billed_amount_in_purchase_order(int update_billed_amount_in_purchase_order) {
        this.update_billed_amount_in_purchase_order = update_billed_amount_in_purchase_order;
    }
    public int getUpdate_billed_amount_in_purchase_receipt() {
        return update_billed_amount_in_purchase_receipt;
    }
    public void setUpdate_billed_amount_in_purchase_receipt(int update_billed_amount_in_purchase_receipt) {
        this.update_billed_amount_in_purchase_receipt = update_billed_amount_in_purchase_receipt;
    }
    public int getApply_tds() {
        return apply_tds;
    }
    public void setApply_tds(int apply_tds) {
        this.apply_tds = apply_tds;
    }
    public String getTax_withholding_category() {
        return tax_withholding_category;
    }
    public void setTax_withholding_category(String tax_withholding_category) {
        this.tax_withholding_category = tax_withholding_category;
    }
    public String getAmended_from() {
        return amended_from;
    }
    public void setAmended_from(String amended_from) {
        this.amended_from = amended_from;
    }
    public String getBill_no() {
        return bill_no;
    }
    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }
    public String getBill_date() {
        return bill_date;
    }
    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }
    public String getCost_center() {
        return cost_center;
    }
    public void setCost_center(String cost_center) {
        this.cost_center = cost_center;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public double getConversion_rate() {
        return conversion_rate;
    }
    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }
    public int getUse_transaction_date_exchange_rate() {
        return use_transaction_date_exchange_rate;
    }
    public void setUse_transaction_date_exchange_rate(int use_transaction_date_exchange_rate) {
        this.use_transaction_date_exchange_rate = use_transaction_date_exchange_rate;
    }
    public String getBuying_price_list() {
        return buying_price_list;
    }
    public void setBuying_price_list(String buying_price_list) {
        this.buying_price_list = buying_price_list;
    }
    public String getPrice_list_currency() {
        return price_list_currency;
    }
    public void setPrice_list_currency(String price_list_currency) {
        this.price_list_currency = price_list_currency;
    }
    public double getPlc_conversion_rate() {
        return plc_conversion_rate;
    }
    public void setPlc_conversion_rate(double plc_conversion_rate) {
        this.plc_conversion_rate = plc_conversion_rate;
    }
    public int getIgnore_pricing_rule() {
        return ignore_pricing_rule;
    }
    public void setIgnore_pricing_rule(int ignore_pricing_rule) {
        this.ignore_pricing_rule = ignore_pricing_rule;
    }
    public String getScan_barcode() {
        return scan_barcode;
    }
    public void setScan_barcode(String scan_barcode) {
        this.scan_barcode = scan_barcode;
    }
    public int getUpdate_stock() {
        return update_stock;
    }
    public void setUpdate_stock(int update_stock) {
        this.update_stock = update_stock;
    }
    public String getSet_warehouse() {
        return set_warehouse;
    }
    public void setSet_warehouse(String set_warehouse) {
        this.set_warehouse = set_warehouse;
    }
    public String getSet_from_warehouse() {
        return set_from_warehouse;
    }
    public void setSet_from_warehouse(String set_from_warehouse) {
        this.set_from_warehouse = set_from_warehouse;
    }
    public int getIs_subcontracted() {
        return is_subcontracted;
    }
    public void setIs_subcontracted(int is_subcontracted) {
        this.is_subcontracted = is_subcontracted;
    }
    public String getRejected_warehouse() {
        return rejected_warehouse;
    }
    public void setRejected_warehouse(String rejected_warehouse) {
        this.rejected_warehouse = rejected_warehouse;
    }
    public String getSupplier_warehouse() {
        return supplier_warehouse;
    }
    public void setSupplier_warehouse(String supplier_warehouse) {
        this.supplier_warehouse = supplier_warehouse;
    }
    public double getTotal_qty() {
        return total_qty;
    }
    public void setTotal_qty(double total_qty) {
        this.total_qty = total_qty;
    }
    public double getTotal_net_weight() {
        return total_net_weight;
    }
    public void setTotal_net_weight(double total_net_weight) {
        this.total_net_weight = total_net_weight;
    }
    public double getBase_total() {
        return base_total;
    }
    public void setBase_total(double base_total) {
        this.base_total = base_total;
    }
    public double getBase_net_total() {
        return base_net_total;
    }
    public void setBase_net_total(double base_net_total) {
        this.base_net_total = base_net_total;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public double getNet_total() {
        return net_total;
    }
    public void setNet_total(double net_total) {
        this.net_total = net_total;
    }
    public double getTax_withholding_net_total() {
        return tax_withholding_net_total;
    }
    public void setTax_withholding_net_total(double tax_withholding_net_total) {
        this.tax_withholding_net_total = tax_withholding_net_total;
    }
    public double getBase_tax_withholding_net_total() {
        return base_tax_withholding_net_total;
    }
    public void setBase_tax_withholding_net_total(double base_tax_withholding_net_total) {
        this.base_tax_withholding_net_total = base_tax_withholding_net_total;
    }
    public String getTax_category() {
        return tax_category;
    }
    public void setTax_category(String tax_category) {
        this.tax_category = tax_category;
    }
    public String getTaxes_and_charges() {
        return taxes_and_charges;
    }
    public void setTaxes_and_charges(String taxes_and_charges) {
        this.taxes_and_charges = taxes_and_charges;
    }
    public String getShipping_rule() {
        return shipping_rule;
    }
    public void setShipping_rule(String shipping_rule) {
        this.shipping_rule = shipping_rule;
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
    public double getBase_taxes_and_charges_added() {
        return base_taxes_and_charges_added;
    }
    public void setBase_taxes_and_charges_added(double base_taxes_and_charges_added) {
        this.base_taxes_and_charges_added = base_taxes_and_charges_added;
    }
    public double getBase_taxes_and_charges_deducted() {
        return base_taxes_and_charges_deducted;
    }
    public void setBase_taxes_and_charges_deducted(double base_taxes_and_charges_deducted) {
        this.base_taxes_and_charges_deducted = base_taxes_and_charges_deducted;
    }
    public double getBase_total_taxes_and_charges() {
        return base_total_taxes_and_charges;
    }
    public void setBase_total_taxes_and_charges(double base_total_taxes_and_charges) {
        this.base_total_taxes_and_charges = base_total_taxes_and_charges;
    }
    public double getTaxes_and_charges_added() {
        return taxes_and_charges_added;
    }
    public void setTaxes_and_charges_added(double taxes_and_charges_added) {
        this.taxes_and_charges_added = taxes_and_charges_added;
    }
    public double getTaxes_and_charges_deducted() {
        return taxes_and_charges_deducted;
    }
    public void setTaxes_and_charges_deducted(double taxes_and_charges_deducted) {
        this.taxes_and_charges_deducted = taxes_and_charges_deducted;
    }
    public double getTotal_taxes_and_charges() {
        return total_taxes_and_charges;
    }
    public void setTotal_taxes_and_charges(double total_taxes_and_charges) {
        this.total_taxes_and_charges = total_taxes_and_charges;
    }
    public double getBase_grand_total() {
        return base_grand_total;
    }
    public void setBase_grand_total(double base_grand_total) {
        this.base_grand_total = base_grand_total;
    }
    public double getBase_rounding_adjustment() {
        return base_rounding_adjustment;
    }
    public void setBase_rounding_adjustment(double base_rounding_adjustment) {
        this.base_rounding_adjustment = base_rounding_adjustment;
    }
    public double getBase_rounded_total() {
        return base_rounded_total;
    }
    public void setBase_rounded_total(double base_rounded_total) {
        this.base_rounded_total = base_rounded_total;
    }
    public String getBase_in_words() {
        return base_in_words;
    }
    public void setBase_in_words(String base_in_words) {
        this.base_in_words = base_in_words;
    }
    public double getGrand_total() {
        return grand_total;
    }
    public void setGrand_total(double grand_total) {
        this.grand_total = grand_total;
    }
    public double getRounding_adjustment() {
        return rounding_adjustment;
    }
    public void setRounding_adjustment(double rounding_adjustment) {
        this.rounding_adjustment = rounding_adjustment;
    }
    public int getUse_company_roundoff_cost_center() {
        return use_company_roundoff_cost_center;
    }
    public void setUse_company_roundoff_cost_center(int use_company_roundoff_cost_center) {
        this.use_company_roundoff_cost_center = use_company_roundoff_cost_center;
    }
    public double getRounded_total() {
        return rounded_total;
    }
    public void setRounded_total(double rounded_total) {
        this.rounded_total = rounded_total;
    }
    public String getIn_words() {
        return in_words;
    }
    public void setIn_words(String in_words) {
        this.in_words = in_words;
    }
    public double getTotal_advance() {
        return total_advance;
    }
    public void setTotal_advance(double total_advance) {
        this.total_advance = total_advance;
    }
    public double getOutstanding_amount() {
        return outstanding_amount;
    }
    public void setOutstanding_amount(double outstanding_amount) {
        this.outstanding_amount = outstanding_amount;
    }
    public int getDisable_rounded_total() {
        return disable_rounded_total;
    }
    public void setDisable_rounded_total(int disable_rounded_total) {
        this.disable_rounded_total = disable_rounded_total;
    }
    public String getApply_discount_on() {
        return apply_discount_on;
    }
    public void setApply_discount_on(String apply_discount_on) {
        this.apply_discount_on = apply_discount_on;
    }
    public double getBase_discount_amount() {
        return base_discount_amount;
    }
    public void setBase_discount_amount(double base_discount_amount) {
        this.base_discount_amount = base_discount_amount;
    }
    public double getAdditional_discount_percentage() {
        return additional_discount_percentage;
    }
    public void setAdditional_discount_percentage(double additional_discount_percentage) {
        this.additional_discount_percentage = additional_discount_percentage;
    }
    public double getDiscount_amount() {
        return discount_amount;
    }
    public void setDiscount_amount(double discount_amount) {
        this.discount_amount = discount_amount;
    }
    public String getOther_charges_calculation() {
        return other_charges_calculation;
    }
    public void setOther_charges_calculation(String other_charges_calculation) {
        this.other_charges_calculation = other_charges_calculation;
    }
    public String getMode_of_payment() {
        return mode_of_payment;
    }
    public void setMode_of_payment(String mode_of_payment) {
        this.mode_of_payment = mode_of_payment;
    }
    public double getBase_paid_amount() {
        return base_paid_amount;
    }
    public void setBase_paid_amount(double base_paid_amount) {
        this.base_paid_amount = base_paid_amount;
    }
    public String getClearance_date() {
        return clearance_date;
    }
    public void setClearance_date(String clearance_date) {
        this.clearance_date = clearance_date;
    }
    public String getCash_bank_account() {
        return cash_bank_account;
    }
    public void setCash_bank_account(String cash_bank_account) {
        this.cash_bank_account = cash_bank_account;
    }
    public double getPaid_amount() {
        return paid_amount;
    }
    public void setPaid_amount(double paid_amount) {
        this.paid_amount = paid_amount;
    }
    public int getAllocate_advances_automatically() {
        return allocate_advances_automatically;
    }
    public void setAllocate_advances_automatically(int allocate_advances_automatically) {
        this.allocate_advances_automatically = allocate_advances_automatically;
    }
    public int getOnly_include_allocated_payments() {
        return only_include_allocated_payments;
    }
    public void setOnly_include_allocated_payments(int only_include_allocated_payments) {
        this.only_include_allocated_payments = only_include_allocated_payments;
    }
    public double getWrite_off_amount() {
        return write_off_amount;
    }
    public void setWrite_off_amount(double write_off_amount) {
        this.write_off_amount = write_off_amount;
    }
    public double getBase_write_off_amount() {
        return base_write_off_amount;
    }
    public void setBase_write_off_amount(double base_write_off_amount) {
        this.base_write_off_amount = base_write_off_amount;
    }
    public String getWrite_off_account() {
        return write_off_account;
    }
    public void setWrite_off_account(String write_off_account) {
        this.write_off_account = write_off_account;
    }
    public String getWrite_off_cost_center() {
        return write_off_cost_center;
    }
    public void setWrite_off_cost_center(String write_off_cost_center) {
        this.write_off_cost_center = write_off_cost_center;
    }
    public String getSupplier_address() {
        return supplier_address;
    }
    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }
    public String getAddress_display() {
        return address_display;
    }
    public void setAddress_display(String address_display) {
        this.address_display = address_display;
    }
    public String getContact_person() {
        return contact_person;
    }
    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }
    public String getContact_display() {
        return contact_display;
    }
    public void setContact_display(String contact_display) {
        this.contact_display = contact_display;
    }
    public String getContact_mobile() {
        return contact_mobile;
    }
    public void setContact_mobile(String contact_mobile) {
        this.contact_mobile = contact_mobile;
    }
    public String getContact_email() {
        return contact_email;
    }
    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }
    public String getShipping_address() {
        return shipping_address;
    }
    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }
    public String getShipping_address_display() {
        return shipping_address_display;
    }
    public void setShipping_address_display(String shipping_address_display) {
        this.shipping_address_display = shipping_address_display;
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
    public String getPayment_terms_template() {
        return payment_terms_template;
    }
    public void setPayment_terms_template(String payment_terms_template) {
        this.payment_terms_template = payment_terms_template;
    }
    public int getIgnore_default_payment_terms_template() {
        return ignore_default_payment_terms_template;
    }
    public void setIgnore_default_payment_terms_template(int ignore_default_payment_terms_template) {
        this.ignore_default_payment_terms_template = ignore_default_payment_terms_template;
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
    public double getPer_received() {
        return per_received;
    }
    public void setPer_received(double per_received) {
        this.per_received = per_received;
    }
    public String getCredit_to() {
        return credit_to;
    }
    public void setCredit_to(String credit_to) {
        this.credit_to = credit_to;
    }
    public String getParty_account_currency() {
        return party_account_currency;
    }
    public void setParty_account_currency(String party_account_currency) {
        this.party_account_currency = party_account_currency;
    }
    public String getIs_opening() {
        return is_opening;
    }
    public void setIs_opening(String is_opening) {
        this.is_opening = is_opening;
    }
    public String getAgainst_expense_account() {
        return against_expense_account;
    }
    public void setAgainst_expense_account(String against_expense_account) {
        this.against_expense_account = against_expense_account;
    }
    public String getUnrealized_profit_loss_account() {
        return unrealized_profit_loss_account;
    }
    public void setUnrealized_profit_loss_account(String unrealized_profit_loss_account) {
        this.unrealized_profit_loss_account = unrealized_profit_loss_account;
    }
    public String getSubscription() {
        return subscription;
    }
    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }
    public String getAuto_repeat() {
        return auto_repeat;
    }
    public void setAuto_repeat(String auto_repeat) {
        this.auto_repeat = auto_repeat;
    }
    public String getFrom_date() {
        return from_date;
    }
    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }
    public String getTo_date() {
        return to_date;
    }
    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }
    public String getLetter_head() {
        return letter_head;
    }
    public void setLetter_head(String letter_head) {
        this.letter_head = letter_head;
    }
    public int getGroup_same_items() {
        return group_same_items;
    }
    public void setGroup_same_items(int group_same_items) {
        this.group_same_items = group_same_items;
    }
    public String getSelect_print_heading() {
        return select_print_heading;
    }
    public void setSelect_print_heading(String select_print_heading) {
        this.select_print_heading = select_print_heading;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public int getOn_hold() {
        return on_hold;
    }
    public void setOn_hold(int on_hold) {
        this.on_hold = on_hold;
    }
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public String getHold_comment() {
        return hold_comment;
    }
    public void setHold_comment(String hold_comment) {
        this.hold_comment = hold_comment;
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
    public String getSupplier_group() {
        return supplier_group;
    }
    public void setSupplier_group(String supplier_group) {
        this.supplier_group = supplier_group;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getInter_company_invoice_reference() {
        return inter_company_invoice_reference;
    }
    public void setInter_company_invoice_reference(String inter_company_invoice_reference) {
        this.inter_company_invoice_reference = inter_company_invoice_reference;
    }
    public int getIs_old_subcontracting_flow() {
        return is_old_subcontracting_flow;
    }
    public void setIs_old_subcontracting_flow(int is_old_subcontracting_flow) {
        this.is_old_subcontracting_flow = is_old_subcontracting_flow;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
