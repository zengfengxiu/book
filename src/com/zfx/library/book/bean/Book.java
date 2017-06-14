package com.zfx.library.book.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.zfx.library.type.bean.Type;

//实体（Hibernate自动扫描时，会检查所有带此注解的类，并生成映射关系）
@Entity
//此实体类映射的数据表
@Table(name = "TBL_BOOK")
public class Book {
	private Integer id;
	private String no;
	private String name;
	private Type type;
	private String author;
	private Double price;
	private Integer quantity;
	private String publisher;
	private String remark;
	
	// 此属性为ID属性
	@Id
	// 主键生成方式：序列
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	// 定义序列生成器，"generator"与上一行对应，并指定序列名称
	@SequenceGenerator(name = "generator", sequenceName = "SEQ_BOOK")
	// 此属性在数据表中的映射字段
	@Column(name = "BOOK_ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "BOOK_NO")
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	@Column(name = "BOOK_NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name="TYPE_ID")
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	@Column(name = "AUTHOR")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name = "PRICE")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Column(name = "QUANTITY")
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "PUBLISHER")
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
