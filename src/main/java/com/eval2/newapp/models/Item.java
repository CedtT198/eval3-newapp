package com.eval2.newapp.models;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Item {
     public String name;
    public String owner;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDateTime creation;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    public LocalDateTime modified;
    
    String modified_by;
    int docstatus;
    int idx;
    String item_code;
    String item_name;
    String naming_series;
    int lead_time_days;
    int is_free_item;
    String description;
    String item_group;
    String image;
    double qty;
    String stock_uom;
    String uom;
    double conversion_factor;
    double stock_qty;
    double price_list_rate;
    double discount_percentage;
    double discount_amount;
    double distributed_discount_amount;
    double base_price_list_rate;
    double rate;
    double amount;
    double base_rate;
    double base_amount;
    double net_rate;
    double net_amount;
    double base_net_rate;
    double base_net_amount;
    double weight_per_unit;
    double total_weight;
    String warehouse;
    String material_request;
    String request_for_quotation;
    String material_request_item;
    String request_for_quotation_item;
    String item_tax_rate;
    String cost_center;
    int page_break;
    String parent;
    String parentfield;
    String parenttype;
    String doctype;

    public Item() {}
    
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
    public String getItem_code() {
        return item_code;
    }
    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public int getLead_time_days() {
        return lead_time_days;
    }
    public void setLead_time_days(int lead_time_days) {
        this.lead_time_days = lead_time_days;
    }
    public int getIs_free_item() {
        return is_free_item;
    }
    public void setIs_free_item(int is_free_item) {
        this.is_free_item = is_free_item;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getItem_group() {
        return item_group;
    }
    public void setItem_group(String item_group) {
        this.item_group = item_group;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public double getQty() {
        return qty;
    }
    public void setQty(double qty) {
        this.qty = qty;
    }
    public String getStock_uom() {
        return stock_uom;
    }
    public void setStock_uom(String stock_uom) {
        this.stock_uom = stock_uom;
    }
    public String getUom() {
        return uom;
    }
    public void setUom(String uom) {
        this.uom = uom;
    }
    public double getConversion_factor() {
        return conversion_factor;
    }
    public void setConversion_factor(double conversion_factor) {
        this.conversion_factor = conversion_factor;
    }
    public double getStock_qty() {
        return stock_qty;
    }
    public void setStock_qty(double stock_qty) {
        this.stock_qty = stock_qty;
    }
    public double getPrice_list_rate() {
        return price_list_rate;
    }
    public void setPrice_list_rate(double price_list_rate) {
        this.price_list_rate = price_list_rate;
    }
    public double getDiscount_percentage() {
        return discount_percentage;
    }
    public void setDiscount_percentage(double discount_percentage) {
        this.discount_percentage = discount_percentage;
    }
    public double getDiscount_amount() {
        return discount_amount;
    }
    public void setDiscount_amount(double discount_amount) {
        this.discount_amount = discount_amount;
    }
    public double getDistributed_discount_amount() {
        return distributed_discount_amount;
    }
    public void setDistributed_discount_amount(double distributed_discount_amount) {
        this.distributed_discount_amount = distributed_discount_amount;
    }
    public double getBase_price_list_rate() {
        return base_price_list_rate;
    }
    public void setBase_price_list_rate(double base_price_list_rate) {
        this.base_price_list_rate = base_price_list_rate;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getBase_rate() {
        return base_rate;
    }
    public void setBase_rate(double base_rate) {
        this.base_rate = base_rate;
    }
    public double getBase_amount() {
        return base_amount;
    }
    public void setBase_amount(double base_amount) {
        this.base_amount = base_amount;
    }
    public double getNet_rate() {
        return net_rate;
    }
    public void setNet_rate(double net_rate) {
        this.net_rate = net_rate;
    }
    public double getNet_amount() {
        return net_amount;
    }
    public void setNet_amount(double net_amount) {
        this.net_amount = net_amount;
    }
    public double getBase_net_rate() {
        return base_net_rate;
    }
    public void setBase_net_rate(double base_net_rate) {
        this.base_net_rate = base_net_rate;
    }
    public double getBase_net_amount() {
        return base_net_amount;
    }
    public void setBase_net_amount(double base_net_amount) {
        this.base_net_amount = base_net_amount;
    }
    public double getWeight_per_unit() {
        return weight_per_unit;
    }
    public void setWeight_per_unit(double weight_per_unit) {
        this.weight_per_unit = weight_per_unit;
    }
    public double getTotal_weight() {
        return total_weight;
    }
    public void setTotal_weight(double total_weight) {
        this.total_weight = total_weight;
    }
    public String getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
    public String getMaterial_request() {
        return material_request;
    }
    public void setMaterial_request(String material_request) {
        this.material_request = material_request;
    }
    public String getRequest_for_quotation() {
        return request_for_quotation;
    }
    public void setRequest_for_quotation(String request_for_quotation) {
        this.request_for_quotation = request_for_quotation;
    }
    public String getMaterial_request_item() {
        return material_request_item;
    }
    public void setMaterial_request_item(String material_request_item) {
        this.material_request_item = material_request_item;
    }
    public String getRequest_for_quotation_item() {
        return request_for_quotation_item;
    }
    public void setRequest_for_quotation_item(String request_for_quotation_item) {
        this.request_for_quotation_item = request_for_quotation_item;
    }
    public String getItem_tax_rate() {
        return item_tax_rate;
    }
    public void setItem_tax_rate(String item_tax_rate) {
        this.item_tax_rate = item_tax_rate;
    }
    public String getCost_center() {
        return cost_center;
    }
    public void setCost_center(String cost_center) {
        this.cost_center = cost_center;
    }
    public int getPage_break() {
        return page_break;
    }
    public void setPage_break(int page_break) {
        this.page_break = page_break;
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
    public String getDoctype() {
        return doctype;
    }
    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    
}
