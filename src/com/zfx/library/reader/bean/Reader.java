package com.zfx.library.reader.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//ʵ�壨Hibernate�Զ�ɨ��ʱ���������д���ע����࣬������ӳ���ϵ��
@Entity
//��ʵ����ӳ������ݱ�
@Table(name = "TBL_READER")
public class Reader {
	private Integer id;
	private String no;
	private String name;
	private String phone;
	private String address;
	private String remark;
	private String oper;
	
		// ������ΪID����
		@Id
		// �������ɷ�ʽ������
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
		// ����������������"generator"����һ�ж�Ӧ����ָ����������
		@SequenceGenerator(name = "generator", sequenceName = "SEQ_READER")
		// �����������ݱ��е�ӳ���ֶ�
		@Column(name = "READER_ID")
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		@Column(name = "READER_NO")
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		
		@Column(name = "READER_NAME")
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Column(name = "PHONE")
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		@Column(name = "ADDRESS")
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		@Column(name = "REMARK")
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getOper() {
			return oper;
		}
		public void setOper(String oper) {
			this.oper = oper;
		}
		
}
