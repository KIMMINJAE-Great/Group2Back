package com.dz.back.dto;

public class TradeManagementDTO {

	private int auto_id;
	
	private String bp_classification;  // 거래처구분
	private String bp_name; // 거래처명
	private String bp_code; // 거래처코드
	private String bp_abbreviation; // 거래처약칭
	private String com_reg_num; // 사업자등록번호
	
	private String nationality; // 국적
	private String res_reg_num; // 주민등록번호
	private String rep_name; // 대표자명
	private String bus_conditions; // 업태
	private String sectors; // 업태
	
	private String zip_code; // 우편번호
	private String primary_address; // 기본주소
	private String detailed_address; // 상세주소
	private String phone_num; // 전화번호
	private String fax_num; // 팩스번호
	
	private String home_page; // 홈페이지
	private String mail_address; // 메일주소
	private String main_code; // 주류코드
	private String country_code; // 국가코드
	
	public int getAuto_id() {
		return auto_id;
	}
	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}
	public String getBp_classification() {
		return bp_classification;
	}
	public void setBp_classification(String bp_classification) {
		this.bp_classification = bp_classification;
	}
	public String getBp_name() {
		return bp_name;
	}
	public void setBp_name(String bp_name) {
		this.bp_name = bp_name;
	}
	public String getBp_code() {
		return bp_code;
	}
	public void setBp_code(String bp_code) {
		this.bp_code = bp_code;
	}
	public String getBp_abbreviation() {
		return bp_abbreviation;
	}
	public void setBp_abbreviation(String bp_abbreviation) {
		this.bp_abbreviation = bp_abbreviation;
	}
	public String getCom_reg_num() {
		return com_reg_num;
	}
	public void setCom_reg_num(String com_reg_num) {
		this.com_reg_num = com_reg_num;
	}
	public String getRes_reg_num() {
		return res_reg_num;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getNationality() {
		return nationality;
	}
	public void setRes_reg_num(String res_reg_num) {
		this.res_reg_num = res_reg_num;
	}
	public String getRep_name() {
		return rep_name;
	}
	public void setRep_name(String rep_name) {
		this.rep_name = rep_name;
	}
	public String getBus_conditions() {
		return bus_conditions;
	}
	public void setBus_conditions(String bus_conditions) {
		this.bus_conditions = bus_conditions;
	}
	public String getSectors() {
		return sectors;
	}
	public void setSectors(String sectors) {
		this.sectors = sectors;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getPrimary_address() {
		return primary_address;
	}
	public void setPrimary_address(String primary_address) {
		this.primary_address = primary_address;
	}
	public String getDetailed_address() {
		return detailed_address;
	}
	public void setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getFax_num() {
		return fax_num;
	}
	public void setFax_num(String fax_num) {
		this.fax_num = fax_num;
	}
	public String getHome_page() {
		return home_page;
	}
	public void setHome_page(String home_page) {
		this.home_page = home_page;
	}
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public String getMain_code() {
		return main_code;
	}
	public void setMain_code(String main_code) {
		this.main_code = main_code;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	
	@Override
	public String toString() {
		return "TradeManagementDTO [auto_id=" + auto_id + ", bp_classification=" + bp_classification + ", bp_name="
				+ bp_name + ", bp_code=" + bp_code + ", bp_abbreviation=" + bp_abbreviation + ", com_reg_num="
				+ com_reg_num + ", nationality=" + nationality + ", res_reg_num=" + res_reg_num + ", rep_name="
				+ rep_name + ", bus_conditions=" + bus_conditions + ", sectors=" + sectors + ", zip_code=" + zip_code
				+ ", primary_address=" + primary_address + ", detailed_address=" + detailed_address + ", phone_num="
				+ phone_num + ", fax_num=" + fax_num + ", home_page=" + home_page + ", mail_address=" + mail_address
				+ ", main_code=" + main_code + ", country_code=" + country_code + "]";
	}
}
