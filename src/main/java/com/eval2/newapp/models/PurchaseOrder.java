package com.eval2.newapp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseOrder {
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
    String order_confirmation_no;
    LocalDate order_confirmation_date;
    LocalDate transaction_date;
    LocalDate schedule_date;
    String company;
    int apply_tds;
    String tax_withholding_category;
    int is_subcontracted;
    String supplier_warehouse;
    String amended_from;
    String cost_center;
    String project;
    String currency;
    double conversion_rate;
    String buying_price_list;
    String price_list_currency;
    double plc_conversion_rate;
    int ignore_pricing_rule;
    String scan_barcode;
    String set_from_warehouse;
    String set_warehouse;
    double total_qty;
    double total_net_weight;
    double base_total;
    double base_net_total;
    double total;
    double net_total;
    double tax_withholding_net_total;
    double base_tax_withholding_net_total;
    String set_reserve_warehouse;
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
    String base_in_words;
    double base_rounded_total;
    double grand_total;
    double rounding_adjustment;
    double rounded_total;
    int disable_rounded_total;
    String in_words;
    double advance_paid;
    String apply_discount_on;
    double base_discount_amount;
    double additional_discount_percentage;
    double discount_amount;
    String other_charges_calculation; 
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
    String customer; 
    String customer_name; 
    String customer_contact_person; 
    String customer_contact_display; 
    String customer_contact_mobile; 
    String customer_contact_email; 
    String payment_terms_template; 
    String tc_name; 
    String terms; 
    String status;
    String advance_payment_status;
    double per_billed;
    double per_received;
    String letter_head; 
    int group_same_items;
    String select_print_heading; 
    String language;
    LocalDate from_date; 
    LocalDate to_date; 
    String auto_repeat; 
    int is_internal_supplier;
    String represents_company;
    String ref_sq; 
    String party_account_currency;
    String inter_company_order_reference; 
    int is_old_subcontracting_flow;

    public PurchaseOrder() {}

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
    public String getOrder_confirmation_no() {
        return order_confirmation_no;
    }
    public void setOrder_confirmation_no(String order_confirmation_no) {
        this.order_confirmation_no = order_confirmation_no;
    }
    public LocalDate getOrder_confirmation_date() {
        return order_confirmation_date;
    }
    public void setOrder_confirmation_date(LocalDate order_confirmation_date) {
        this.order_confirmation_date = order_confirmation_date;
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
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
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
    public int getIs_subcontracted() {
        return is_subcontracted;
    }
    public void setIs_subcontracted(int is_subcontracted) {
        this.is_subcontracted = is_subcontracted;
    }
    public String getSupplier_warehouse() {
        return supplier_warehouse;
    }
    public void setSupplier_warehouse(String supplier_warehouse) {
        this.supplier_warehouse = supplier_warehouse;
    }
    public String getAmended_from() {
        return amended_from;
    }
    public void setAmended_from(String amended_from) {
        this.amended_from = amended_from;
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
    public String getSet_reserve_warehouse() {
        return set_reserve_warehouse;
    }
    public void setSet_reserve_warehouse(String set_reserve_warehouse) {
        this.set_reserve_warehouse = set_reserve_warehouse;
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
    public String getBase_in_words() {
        return base_in_words;
    }
    public void setBase_in_words(String base_in_words) {
        this.base_in_words = base_in_words;
    }
    public double getBase_rounded_total() {
        return base_rounded_total;
    }
    public void setBase_rounded_total(double base_rounded_total) {
        this.base_rounded_total = base_rounded_total;
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
    public double getRounded_total() {
        return rounded_total;
    }
    public void setRounded_total(double rounded_total) {
        this.rounded_total = rounded_total;
    }
    public int getDisable_rounded_total() {
        return disable_rounded_total;
    }
    public void setDisable_rounded_total(int disable_rounded_total) {
        this.disable_rounded_total = disable_rounded_total;
    }
    public String getIn_words() {
        return in_words;
    }
    public void setIn_words(String in_words) {
        this.in_words = in_words;
    }
    public double getAdvance_paid() {
        return advance_paid;
    }
    public void setAdvance_paid(double advance_paid) {
        this.advance_paid = advance_paid;
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
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public String getCustomer_contact_person() {
        return customer_contact_person;
    }
    public void setCustomer_contact_person(String customer_contact_person) {
        this.customer_contact_person = customer_contact_person;
    }
    public String getCustomer_contact_display() {
        return customer_contact_display;
    }
    public void setCustomer_contact_display(String customer_contact_display) {
        this.customer_contact_display = customer_contact_display;
    }
    public String getCustomer_contact_mobile() {
        return customer_contact_mobile;
    }
    public void setCustomer_contact_mobile(String customer_contact_mobile) {
        this.customer_contact_mobile = customer_contact_mobile;
    }
    public String getCustomer_contact_email() {
        return customer_contact_email;
    }
    public void setCustomer_contact_email(String customer_contact_email) {
        this.customer_contact_email = customer_contact_email;
    }
    public String getPayment_terms_template() {
        return payment_terms_template;
    }
    public void setPayment_terms_template(String payment_terms_template) {
        this.payment_terms_template = payment_terms_template;
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
    public String getAdvance_payment_status() {
        return advance_payment_status;
    }
    public void setAdvance_payment_status(String advance_payment_status) {
        this.advance_payment_status = advance_payment_status;
    }
    public double getPer_billed() {
        return per_billed;
    }
    public void setPer_billed(double per_billed) {
        this.per_billed = per_billed;
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
    public LocalDate getFrom_date() {
        return from_date;
    }
    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }
    public LocalDate getTo_date() {
        return to_date;
    }
    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }
    public String getAuto_repeat() {
        return auto_repeat;
    }
    public void setAuto_repeat(String auto_repeat) {
        this.auto_repeat = auto_repeat;
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
    public String getRef_sq() {
        return ref_sq;
    }
    public void setRef_sq(String ref_sq) {
        this.ref_sq = ref_sq;
    }
    public String getParty_account_currency() {
        return party_account_currency;
    }
    public void setParty_account_currency(String party_account_currency) {
        this.party_account_currency = party_account_currency;
    }
    public String getInter_company_order_reference() {
        return inter_company_order_reference;
    }
    public void setInter_company_order_reference(String inter_company_order_reference) {
        this.inter_company_order_reference = inter_company_order_reference;
    }
    public int getIs_old_subcontracting_flow() {
        return is_old_subcontracting_flow;
    }
    public void setIs_old_subcontracting_flow(int is_old_subcontracting_flow) {
        this.is_old_subcontracting_flow = is_old_subcontracting_flow;
    }
}
