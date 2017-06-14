package com.zfx.library.reader.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zfx.library.reader.bean.Reader;
import com.zfx.library.reader.service.ReaderService;

//控制器，用于注解Action类
@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")
@Results({
		@Result(name = "reader_add_result", location = "/reader_add_result.jsp"),
		@Result(name = "reader_update_result1", location = "/reader_update_result1.jsp"),
		@Result(name = "reader_update_result2", location = "/reader_update_result2.jsp"),
		@Result(name = "delete", location = "/reader_del.jsp") })
public class ReaderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// 依赖资源
	@Resource
	private ReaderService readerService;
	private Reader reader;
	private List<Reader> list;

	// 定义Action
	@Action("addReader")
	public String add() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("USER_NAME");
			reader.setOper(oper);
			readerService.addReader(reader);
			return "reader_add_result";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("toupdateReader")
	public String toupdate() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			reader = readerService.findByNo(reader.getNo());
			if (reader == null) {
				return "failure";
			}
			return "reader_update_result1";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("updateReader")
	public String update() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			String oper;
			ActionContext ctx = ActionContext.getContext();
			oper = (String) ctx.getSession().get("USER_NAME");
			reader.setOper(oper);
			readerService.updateReader(reader);
			return "reader_update_result2";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("toDeleteReader")
	public String toDelete() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			list = readerService.findAllReader();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// 定义Action
	@Action("deleteReader")
	public String delete() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			reader = readerService.findByNo(reader.getNo());
			readerService.deleteReader(reader);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// getter & setter

	public ReaderService getReaderService() {
		return readerService;
	}

	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public List<Reader> getList() {
		return list;
	}

	public void setList(List<Reader> list) {
		this.list = list;
	}

}
