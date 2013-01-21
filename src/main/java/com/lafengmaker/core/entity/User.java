package com.lafengmaker.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;


@Entity(name="t_user")
public class User {
		private Long id;
		private String username;
		private String name;
		private String password;
		private Integer logintimes;
		private String email;
		private String status;
		private String role;
		private String isdelete;
		@GenericGenerator(name = "generator", strategy = "increment")
		@Id
		@GeneratedValue(generator = "generator")
		@Column(name = "id",  nullable = false)
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		@NotEmpty(message="用户名不能为空")
		@Column(length=20,nullable=false)
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		@NotEmpty(message="密码不能为空")
		@Column(length=50,nullable=false)
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Column(length=20)
		public String getEmail() {
			return email;
		}
		public Integer getLogintimes() {
			return logintimes;
		}
		public void setLogintimes(Integer logintimes) {
			this.logintimes = logintimes;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Column(length=1)
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Column(length=1)
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public User(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		@Column(length=20)
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public User() {
			super();
			this.isdelete="0";
		}
		@Column(length=1)
		public String getIsdelete() {
			return isdelete;
		}
		public void setIsdelete(String isdelete) {
			this.isdelete = isdelete;
		}
		
		
}
