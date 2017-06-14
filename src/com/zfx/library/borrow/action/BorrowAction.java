package com.zfx.library.borrow.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import com.zfx.library.borrow.bean.Borrow;
import com.zfx.library.borrow.bean.BorrowResult;
import com.zfx.library.borrow.service.BorrowService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("ssh")
@Results({
		@Result(name = "borrow_result", location = "/borrow_add_result.jsp"),
		@Result(name = "return_result1", location = "/borrow_return_result1.jsp"),
		@Result(name = "return_result2", location = "/borrow_return_result2.jsp"),
		@Result(name = "renew_result1", location = "/borrow_renew_result1.jsp"),
		@Result(name = "renew_result2", location = "/borrow_renew_result2.jsp"),
		@Result(name = "query_result", location = "/borrow_query_result.jsp") })
public class BorrowAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private BorrowService borrowService;
	private Borrow borrow;
	private BorrowResult br;
	private List<BorrowResult> brList;

	// 借阅
	@Action("addBorrow")
	public String addBorrow() {
		try {
			// 写入借阅日期
			borrow.setBorrowDate(new Date());

			// 写入操作员
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("USER_NAME");
			borrow.setOper(oper);

			borrowService.addBorrow(borrow);

			// 根据图书编号和读者编号查询借阅记录
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());
			return "borrow_result";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 跳转归还
	@Action("toAddReturn")
	public String toAddReturn() {
		try {
			// 根据图书编号查询借阅记录
			brList = borrowService.findBorrowResultByBookNo(borrow.getBookNo());
			return "return_result1";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 归还
	@Action("addReturn")
	public String addReturn() {
		try {
			// 根据图书编号和读者编号查询借阅记录
			// 因为后面要修改还书日期字段，改完后就查不到借阅记录了，所以事先查一下
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());

			// 根据图书编号和读者编号查询借阅记录
			// 修改还书日期
			borrow = borrowService.findBorrowByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());
			borrow.setReturnDate(new Date());
			borrowService.addReturn(borrow);

			return "return_result2";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 跳转续借
	@Action("toAddRenew")
	public String toAddRenew() {
		try {
			// 根据图书编号查询借阅记录
			brList = borrowService.findBorrowResultByBookNo(borrow.getBookNo());
			return "renew_result1";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 续借
	@Action("addRenew")
	public String addRenew() {
		try {
			// 续借等于还书+借书

			// 原借书记录
			Borrow oldBorrow = borrowService.findBorrowByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());

			// 续借记录，利用工具类，从原借书记录中复制各项属性
			Borrow newBorrow = new Borrow();
			BeanUtils.copyProperties(oldBorrow, newBorrow);

			// 归还
			oldBorrow.setReturnDate(new Date());

			// 新增借书记录，修改借阅日期和操作员
			newBorrow.setBorrowDate(new Date());
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("USER_NAME");
			newBorrow.setOper(oper);

			// 续借
			borrowService.addRenew(oldBorrow, newBorrow);

			// 根据图书编号和读者编号查询借阅记录
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());

			return "renew_result2";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 借阅查询
	@Action("listBorrow")
	public String listBorrow() {
		try {
			// 根据读者编号查询借阅记录
			brList = borrowService.findBorrowResultByReaderNo(borrow
					.getReaderNo());
			return "query_result";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// getter & setter

	public BorrowService getBorrowService() {
		return borrowService;
	}

	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}

	public BorrowResult getBr() {
		return br;
	}

	public void setBr(BorrowResult br) {
		this.br = br;
	}

	public List<BorrowResult> getBrList() {
		return brList;
	}

	public void setBrList(List<BorrowResult> brList) {
		this.brList = brList;
	}
}
