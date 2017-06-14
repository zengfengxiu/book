package com.zfx.library.type.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//实体（Hibernate自动扫描时，会检查所有带此注解的类，并生成映射关系）
@Entity
//此实体类映射的数据表
@Table(name = "TBL_TYPE")
public class Type {
	private Integer id;
	private String name;
	
	
	// 此属性为ID属性
		@Id
		// 主键生成方式：序列
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
		// 定义序列生成器，"generator"与上一行对应，并指定序列名称
		@SequenceGenerator(name = "generator", sequenceName = "SEQ_TYPE")
		// 此属性在数据表中的映射字段
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
