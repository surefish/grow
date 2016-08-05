package com.begin.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_Account")
public class TAccount extends StatusEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String accountID;

	private String accounts;// 帐号
	private String password;// 密码

	

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "accounts", targetEntity = TStudent.class)
	private Set<TStudent> tStudents;


	
	

	public Set<TStudent> gettStudents() {
		return tStudents;
	}

	public void settStudents(Set<TStudent> tStudents) {
		this.tStudents = tStudents;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
