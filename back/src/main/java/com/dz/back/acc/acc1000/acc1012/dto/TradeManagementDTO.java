package com.dz.back.acc.acc1000.acc1012.dto;

public class TradeManagementDTO {

	private String co_cd;      /* 회사코드 */
	private String tr_cd;      /* 거래처 코드 */
	private String tr_fg;      /* 거래처 구분 */
	private String tr_nm;      /* 거래처명 */
	private String reg_nb;     /* 사업자 등록 번호 */

	private String tr_al; 	   /* 거래처 약칭 */
	private String tr_na;      /* 국적 */
	private String re_id;      /* 주민등록번호 */
	private String tr_ceo_nm;  /* 대표자명 */
	private String tr_bt;      /* 업태 */

	private String tr_bc;      /* 업종 */
	private String tr_ps_cd;   /* 우편번호 */
	private String tr_ad1;     /* 기본 주소 */
	private String tr_ad2;     /* 상세 주소 */
	private String tr_pn;      /* 전화번호 */

	private String tr_fn;      /* 팩스번호 */
	private String tr_hp;      /* 홈페이지 주소 */
	private String tr_email;   /* 이메일 주소 */
	private String tr_mn_cd;   /* 주류코드 */
	private String tr_ct_cd;   /* 국가코드 */
	
	public String getCo_cd() {
		return co_cd;
	}
	public void setCo_cd(String co_cd) {
		this.co_cd = co_cd;
	}
	public String getTr_cd() {
		return tr_cd;
	}
	public void setTr_cd(String tr_cd) {
		this.tr_cd = tr_cd;
	}
	public String getTr_fg() {
		return tr_fg;
	}
	public void setTr_fg(String tr_fg) {
		this.tr_fg = tr_fg;
	}
	public String getTr_nm() {
		return tr_nm;
	}
	public void setTr_nm(String tr_nm) {
		this.tr_nm = tr_nm;
	}
	public String getReg_nb() {
		return reg_nb;
	}
	public void setReg_nb(String reg_nb) {
		this.reg_nb = reg_nb;
	}
	public String getTr_al() {
		return tr_al;
	}
	public void setTr_al(String tr_al) {
		this.tr_al = tr_al;
	}
	public String getTr_na() {
		return tr_na;
	}
	public void setTr_na(String tr_na) {
		this.tr_na = tr_na;
	}
	public String getRe_id() {
		return re_id;
	}
	public void setRe_id(String re_id) {
		this.re_id = re_id;
	}
	public String getTr_ceo_nm() {
		return tr_ceo_nm;
	}
	public void setTr_ceo_nm(String tr_ceo_nm) {
		this.tr_ceo_nm = tr_ceo_nm;
	}
	public String getTr_bt() {
		return tr_bt;
	}
	public void setTr_bt(String tr_bt) {
		this.tr_bt = tr_bt;
	}
	public String getTr_bc() {
		return tr_bc;
	}
	public void setTr_bc(String tr_bc) {
		this.tr_bc = tr_bc;
	}
	public String getTr_ps_cd() {
		return tr_ps_cd;
	}
	public void setTr_ps_cd(String tr_ps_cd) {
		this.tr_ps_cd = tr_ps_cd;
	}
	public String getTr_ad1() {
		return tr_ad1;
	}
	public void setTr_ad1(String tr_ad1) {
		this.tr_ad1 = tr_ad1;
	}
	public String getTr_ad2() {
		return tr_ad2;
	}
	public void setTr_ad2(String tr_ad2) {
		this.tr_ad2 = tr_ad2;
	}
	public String getTr_pn() {
		return tr_pn;
	}
	public void setTr_pn(String tr_pn) {
		this.tr_pn = tr_pn;
	}
	public String getTr_fn() {
		return tr_fn;
	}
	public void setTr_fn(String tr_fn) {
		this.tr_fn = tr_fn;
	}
	public String getTr_hp() {
		return tr_hp;
	}
	public void setTr_hp(String tr_hp) {
		this.tr_hp = tr_hp;
	}
	public String getTr_email() {
		return tr_email;
	}
	public void setTr_email(String tr_email) {
		this.tr_email = tr_email;
	}
	public String getTr_mn_cd() {
		return tr_mn_cd;
	}
	public void setTr_mn_cd(String tr_mn_cd) {
		this.tr_mn_cd = tr_mn_cd;
	}
	public String getTr_ct_cd() {
		return tr_ct_cd;
	}
	public void setTr_ct_cd(String tr_ct_cd) {
		this.tr_ct_cd = tr_ct_cd;
	}
	@Override
	public String toString() {
		return "TradeManagementDTO [co_cd=" + co_cd + ", tr_cd=" + tr_cd + ", tr_fg=" + tr_fg + ", tr_nm=" + tr_nm
				+ ", reg_nb=" + reg_nb + ", tr_al=" + tr_al + ", tr_na=" + tr_na + ", re_id=" + re_id + ", tr_ceo_nm="
				+ tr_ceo_nm + ", tr_bt=" + tr_bt + ", tr_bc=" + tr_bc + ", tr_ps_cd=" + tr_ps_cd + ", tr_ad1=" + tr_ad1
				+ ", tr_ad2=" + tr_ad2 + ", tr_pn=" + tr_pn + ", tr_fn=" + tr_fn + ", tr_hp=" + tr_hp + ", tr_email="
				+ tr_email + ", tr_mn_cd=" + tr_mn_cd + ", tr_ct_cd=" + tr_ct_cd + "]";
	}
}
