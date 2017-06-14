package com.zfx.library.type.bean;

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
@Table(name = "TBL_TYPE")
public class Type {
	private Integer id;
	private String name;
	
	
	// ������ΪID����
		@Id
		// �������ɷ�ʽ������
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
		// ����������������"generator"����һ�ж�Ӧ����ָ����������
		@SequenceGenerator(name = "generator", sequenceName = "SEQ_TYPE")
		// �����������ݱ��е�ӳ���ֶ�
		@Column(name = "TYPE_ID")
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		@Column(name = "TYPE_NAME")
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}
