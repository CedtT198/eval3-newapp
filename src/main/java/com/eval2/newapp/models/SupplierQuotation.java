package com.eval2.newapp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SupplierQuotation {
    
    public String name;
    public String owner;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDateTime creation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDateTime modified;
    
    public String modified_by;
    public int docstatus;
    public int idx;
    public String title;
    public String naming_series;
    public String supplier;
    public String supplier_name;
    public String company;
    public String status;
    public LocalDate transaction_date;
    public LocalDate valid_till;
    public String quotation_number;
    public String amended_from;
    public String cost_center;
    public String project;
    public String currency;
    public double conversion_rate;
    public String buying_price_list;
    public String price_list_currency;
    public double plc_conversion_rate;
    public int ignore_pricing_rule;
    public double total_qty;
    public double total_net_weight;
    public double base_total;
    public double base_net_total;
    public double total;
    public double net_total;
    public String tax_category;
    public String taxes_and_charges;
    public String shipping_rule;
    public String incoterm;
    public String named_place;
    public double base_taxes_and_charges_added;
    public double base_taxes_and_charges_deducted;
    public double base_total_taxes_and_charges;
    public double taxes_and_charges_added;
    public double taxes_and_charges_deducted;
    public double total_taxes_and_charges;
    public String apply_discount_on;
    public double base_discount_amount;
    public double additional_discount_percentage;
    public double discount_amount;
    public double base_grand_total;
    public double base_rounding_adjustment;
    public double base_rounded_total;
    public String base_in_words;
    public double grand_total;
    public double rounding_adjustment;
    public double rounded_total;
    public String in_words;
    public int disable_rounded_total;
    public String other_charges_calculation;
    public String supplier_address;
    public String address_display;
    public String contact_person;
    public String contact_display;
    public String contact_mobile;
    public String contact_email;
    public String shipping_address;
    public String shipping_address_display;
    public String billing_address;
    public String billing_address_display;
    public String tc_name;
    public String terms;
    public String letter_head;
    public int group_same_items;
    public String select_print_heading;
    public String language;
    public String auto_repeat;
    public int is_subcontracted;
    public String opportunity;

    public SupplierQuotation() {}

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
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getTransaction_date() {
        return transaction_date;
    }
    public void setTransaction_date(LocalDate transaction_date) {
        this.transaction_date = transaction_date;
    }
    public LocalDate getValid_till() {
        return valid_till;
    }
    public void setValid_till(LocalDate valid_till) {
        this.valid_till = valid_till;
    }
    public String getQuotation_number() {
        return quotation_number;
    }
    public void setQuotation_number(String quotation_number) {
        this.quotation_number = quotation_number;
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
    public int getDisable_rounded_total() {
        return disable_rounded_total;
    }
    public void setDisable_rounded_total(int disable_rounded_total) {
        this.disable_rounded_total = disable_rounded_total;
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
    public String getAuto_repeat() {
        return auto_repeat;
    }
    public void setAuto_repeat(String auto_repeat) {
        this.auto_repeat = auto_repeat;
    }
    public int getIs_subcontracted() {
        return is_subcontracted;
    }
    public void setIs_subcontracted(int is_subcontracted) {
        this.is_subcontracted = is_subcontracted;
    }
    public String getOpportunity() {
        return opportunity;
    }
    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }

}
