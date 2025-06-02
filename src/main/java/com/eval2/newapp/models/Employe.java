package com.eval2.newapp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Employe {
	public String name;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
	public LocalDateTime creation;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
	public LocalDateTime modified;
	public String modified_by;
	public String owner;
	public int docstatus;
	public int idx;
	public String employee;
	public String naming_series;
	public String first_name;
	public String middle_name;
	public String last_name;
	public String employee_name;
	public String gender;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate date_of_birth;
	public String salutation;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate date_of_joining;
	public String image;
	public String status;
	public String user_id;
	public int create_user_permission;
	public String company;
	public String department;
	public String employee_number;
	public String designation;
	public String reports_to;
	public String branch;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate scheduled_confirmation_date;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate final_confirmation_date;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate contract_end_date;
	public int notice_number_of_days;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate date_of_retirement;
	public String cell_number;
	public String personal_email;
	public String company_email;
	public String prefered_contact_email;
	public String prefered_email;
	public int unsubscribed;
	public String current_address;
	public String current_accommodation_type;
	public String permanent_address;
	public String permanent_accommodation_type;
	public String person_to_be_contacted;
	public String emergency_phone_number;
	public String relation;
	public String attendance_device_id;
	public String holiday_list;
	public double ctc;
	public String salary_currency;
	public String salary_mode;
	public String bank_name;
	public String bank_ac_no;
	public String iban;
	public String marital_status;
	public String family_background;
	public String blood_group;
	public String health_details;
	public String passport_number;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate valid_upto;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate date_of_issue;
	public String place_of_issue;
	public String bio;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate resignation_letter_date;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate relieving_date;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate held_on;
	public String new_workplace;
	public String leave_encashed;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate encashment_date;
	public String reason_for_leaving;
	public String feedback;
	public int lft;
	public int rgt;
	public String old_parent;
	public String user_tags;
	public String comments;
	public String assign;
	public String liked_by;
	public String employment_type;
	public String grade;
	public String job_applicant;
	public String default_shift;
	public String expense_approver;
	public String leave_approver;
	public String shift_request_approver;
	public String payroll_cost_center;
	public String health_insurance_provider;
	public String health_insurance_no;

    public Employe() {}

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getNaming_series() {
        return naming_series;
    }

    public void setNaming_series(String naming_series) {
        this.naming_series = naming_series;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public LocalDate getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(LocalDate date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getCreate_user_permission() {
        return create_user_permission;
    }

    public void setCreate_user_permission(int create_user_permission) {
        this.create_user_permission = create_user_permission;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployee_number() {
        return employee_number;
    }

    public void setEmployee_number(String employee_number) {
        this.employee_number = employee_number;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getReports_to() {
        return reports_to;
    }

    public void setReports_to(String reports_to) {
        this.reports_to = reports_to;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public LocalDate getScheduled_confirmation_date() {
        return scheduled_confirmation_date;
    }

    public void setScheduled_confirmation_date(LocalDate scheduled_confirmation_date) {
        this.scheduled_confirmation_date = scheduled_confirmation_date;
    }

    public LocalDate getFinal_confirmation_date() {
        return final_confirmation_date;
    }

    public void setFinal_confirmation_date(LocalDate final_confirmation_date) {
        this.final_confirmation_date = final_confirmation_date;
    }

    public LocalDate getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(LocalDate contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public int getNotice_number_of_days() {
        return notice_number_of_days;
    }

    public void setNotice_number_of_days(int notice_number_of_days) {
        this.notice_number_of_days = notice_number_of_days;
    }

    public LocalDate getDate_of_retirement() {
        return date_of_retirement;
    }

    public void setDate_of_retirement(LocalDate date_of_retirement) {
        this.date_of_retirement = date_of_retirement;
    }

    public String getCell_number() {
        return cell_number;
    }

    public void setCell_number(String cell_number) {
        this.cell_number = cell_number;
    }

    public String getPersonal_email() {
        return personal_email;
    }

    public void setPersonal_email(String personal_email) {
        this.personal_email = personal_email;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getPrefered_contact_email() {
        return prefered_contact_email;
    }

    public void setPrefered_contact_email(String prefered_contact_email) {
        this.prefered_contact_email = prefered_contact_email;
    }

    public String getPrefered_email() {
        return prefered_email;
    }

    public void setPrefered_email(String prefered_email) {
        this.prefered_email = prefered_email;
    }

    public int getUnsubscribed() {
        return unsubscribed;
    }

    public void setUnsubscribed(int unsubscribed) {
        this.unsubscribed = unsubscribed;
    }

    public String getCurrent_address() {
        return current_address;
    }

    public void setCurrent_address(String current_address) {
        this.current_address = current_address;
    }

    public String getCurrent_accommodation_type() {
        return current_accommodation_type;
    }

    public void setCurrent_accommodation_type(String current_accommodation_type) {
        this.current_accommodation_type = current_accommodation_type;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public String getPermanent_accommodation_type() {
        return permanent_accommodation_type;
    }

    public void setPermanent_accommodation_type(String permanent_accommodation_type) {
        this.permanent_accommodation_type = permanent_accommodation_type;
    }

    public String getPerson_to_be_contacted() {
        return person_to_be_contacted;
    }

    public void setPerson_to_be_contacted(String person_to_be_contacted) {
        this.person_to_be_contacted = person_to_be_contacted;
    }

    public String getEmergency_phone_number() {
        return emergency_phone_number;
    }

    public void setEmergency_phone_number(String emergency_phone_number) {
        this.emergency_phone_number = emergency_phone_number;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getAttendance_device_id() {
        return attendance_device_id;
    }

    public void setAttendance_device_id(String attendance_device_id) {
        this.attendance_device_id = attendance_device_id;
    }

    public String getHoliday_list() {
        return holiday_list;
    }

    public void setHoliday_list(String holiday_list) {
        this.holiday_list = holiday_list;
    }

    public double getCtc() {
        return ctc;
    }

    public void setCtc(double ctc) {
        this.ctc = ctc;
    }

    public String getSalary_currency() {
        return salary_currency;
    }

    public void setSalary_currency(String salary_currency) {
        this.salary_currency = salary_currency;
    }

    public String getSalary_mode() {
        return salary_mode;
    }

    public void setSalary_mode(String salary_mode) {
        this.salary_mode = salary_mode;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_ac_no() {
        return bank_ac_no;
    }

    public void setBank_ac_no(String bank_ac_no) {
        this.bank_ac_no = bank_ac_no;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getFamily_background() {
        return family_background;
    }

    public void setFamily_background(String family_background) {
        this.family_background = family_background;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getHealth_details() {
        return health_details;
    }

    public void setHealth_details(String health_details) {
        this.health_details = health_details;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public LocalDate getValid_upto() {
        return valid_upto;
    }

    public void setValid_upto(LocalDate valid_upto) {
        this.valid_upto = valid_upto;
    }

    public LocalDate getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(LocalDate date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public String getPlace_of_issue() {
        return place_of_issue;
    }

    public void setPlace_of_issue(String place_of_issue) {
        this.place_of_issue = place_of_issue;
    }

    public LocalDate getResignation_letter_date() {
        return resignation_letter_date;
    }

    public void setResignation_letter_date(LocalDate resignation_letter_date) {
        this.resignation_letter_date = resignation_letter_date;
    }

    public LocalDate getRelieving_date() {
        return relieving_date;
    }

    public void setRelieving_date(LocalDate relieving_date) {
        this.relieving_date = relieving_date;
    }

    public LocalDate getHeld_on() {
        return held_on;
    }

    public void setHeld_on(LocalDate held_on) {
        this.held_on = held_on;
    }

    public String getNew_workplace() {
        return new_workplace;
    }

    public void setNew_workplace(String new_workplace) {
        this.new_workplace = new_workplace;
    }

    public String getLeave_encashed() {
        return leave_encashed;
    }

    public void setLeave_encashed(String leave_encashed) {
        this.leave_encashed = leave_encashed;
    }

    public LocalDate getEncashment_date() {
        return encashment_date;
    }

    public void setEncashment_date(LocalDate encashment_date) {
        this.encashment_date = encashment_date;
    }

    public String getReason_for_leaving() {
        return reason_for_leaving;
    }

    public void setReason_for_leaving(String reason_for_leaving) {
        this.reason_for_leaving = reason_for_leaving;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public int getRgt() {
        return rgt;
    }

    public void setRgt(int rgt) {
        this.rgt = rgt;
    }

    public String getOld_parent() {
        return old_parent;
    }

    public void setOld_parent(String old_parent) {
        this.old_parent = old_parent;
    }

    public String getUser_tags() {
        return user_tags;
    }

    public void setUser_tags(String user_tags) {
        this.user_tags = user_tags;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getLiked_by() {
        return liked_by;
    }

    public void setLiked_by(String liked_by) {
        this.liked_by = liked_by;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getJob_applicant() {
        return job_applicant;
    }

    public void setJob_applicant(String job_applicant) {
        this.job_applicant = job_applicant;
    }

    public String getDefault_shift() {
        return default_shift;
    }

    public void setDefault_shift(String default_shift) {
        this.default_shift = default_shift;
    }

    public String getExpense_approver() {
        return expense_approver;
    }

    public void setExpense_approver(String expense_approver) {
        this.expense_approver = expense_approver;
    }

    public String getLeave_approver() {
        return leave_approver;
    }

    public void setLeave_approver(String leave_approver) {
        this.leave_approver = leave_approver;
    }

    public String getShift_request_approver() {
        return shift_request_approver;
    }

    public void setShift_request_approver(String shift_request_approver) {
        this.shift_request_approver = shift_request_approver;
    }

    public String getPayroll_cost_center() {
        return payroll_cost_center;
    }

    public void setPayroll_cost_center(String payroll_cost_center) {
        this.payroll_cost_center = payroll_cost_center;
    }

    public String getHealth_insurance_provider() {
        return health_insurance_provider;
    }

    public void setHealth_insurance_provider(String health_insurance_provider) {
        this.health_insurance_provider = health_insurance_provider;
    }

    public String getHealth_insurance_no() {
        return health_insurance_no;
    }

    public void setHealth_insurance_no(String health_insurance_no) {
        this.health_insurance_no = health_insurance_no;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}