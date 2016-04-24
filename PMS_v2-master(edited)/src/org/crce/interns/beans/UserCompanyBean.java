package org.crce.interns.beans;

//import org.crce.interns.model.UserCompanyId;

public class UserCompanyBean {
	
		private String username;
				
		private int company_id;

		private String company;
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public int getCompany_id() {
			return company_id;
		}
		public void setCompany_id(int company_id) {
			this.company_id = company_id;
		}

}
