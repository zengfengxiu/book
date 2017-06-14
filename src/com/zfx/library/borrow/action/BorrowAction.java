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

	// ����
	@Action("addBorrow")
	public String addBorrow() {
		try {
			// д���������
			borrow.setBorrowDate(new Date());

			// д�����Ա
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("USER_NAME");
			borrow.setOper(oper);

			borrowService.addBorrow(borrow);

			// ����ͼ���źͶ��߱�Ų�ѯ���ļ�¼
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());
			return "borrow_result";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// ��ת�黹
	@Action("toAddReturn")
	public String toAddReturn() {
		try {
			// ����ͼ���Ų�ѯ���ļ�¼
			brList = borrowService.findBorrowResultByBookNo(borrow.getBookNo());
			return "return_result1";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// �黹
	@Action("addReturn")
	public String addReturn() {
		try {
			// ����ͼ���źͶ��߱�Ų�ѯ���ļ�¼
			// ��Ϊ����Ҫ�޸Ļ��������ֶΣ������Ͳ鲻�����ļ�¼�ˣ��������Ȳ�һ��
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());

			// ����ͼ���źͶ��߱�Ų�ѯ���ļ�¼
			// �޸Ļ�������
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

	// ��ת����
	@Action("toAddRenew")
	public String toAddRenew() {
		try {
			// ����ͼ���Ų�ѯ���ļ�¼
			brList = borrowService.findBorrowResultByBookNo(borrow.getBookNo());
			return "renew_result1";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// ����
	@Action("addRenew")
	public String addRenew() {
		try {
			// ������ڻ���+����

			// ԭ�����¼
			Borrow oldBorrow = borrowService.findBorrowByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());

			// �����¼�����ù����࣬��ԭ�����¼�и��Ƹ�������
			Borrow newBorrow = new Borrow();
			BeanUtils.copyProperties(oldBorrow, newBorrow);

			// �黹
			oldBorrow.setReturnDate(new Date());

			// ���������¼���޸Ľ������ںͲ���Ա
			newBorrow.setBorrowDate(new Date());
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("USER_NAME");
			newBorrow.setOper(oper);

			// ����
			borrowService.addRenew(oldBorrow, newBorrow);

			// ����ͼ���źͶ��߱�Ų�ѯ���ļ�¼
			br = borrowService.findBorrowResultByBookNoAndReaderNo(
					borrow.getBookNo(), borrow.getReaderNo());

			return "renew_result2";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// ���Ĳ�ѯ
	@Action("listBorrow")
	public String listBorrow() {
		try {
			// ���ݶ��߱�Ų�ѯ���ļ�¼
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
