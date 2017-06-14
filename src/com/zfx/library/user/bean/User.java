package com.zfx.library.user.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// ʵ�壨Hibernate�Զ�ɨ��ʱ���������д���ע����࣬������ӳ���ϵ��
@Entity
// ��ʵ����ӳ������ݱ�
@Table(name = "TBL_USER")
public class User {
	private Integer id;
	private String name;
	private String pwd;

	// ������ΪID����
	@Id
	// �������ɷ�ʽ������
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	// ����������������"generator"����һ�ж�Ӧ����ָ����������
	@SequenceGenerator(name = "generator", sequenceName = "SEQ_USER")
	// �����������ݱ��е�ӳ���ֶ�
	@Column(name = "USER_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "USER_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PWD")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
