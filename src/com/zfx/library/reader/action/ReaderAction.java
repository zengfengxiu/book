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

//������������ע��Action��
@Controller
// �������μ�struts.xml�ļ���
@ParentPackage("ssh")
@Results({
		@Result(name = "reader_add_result", location = "/reader_add_result.jsp"),
		@Result(name = "reader_update_result1", location = "/reader_update_result1.jsp"),
		@Result(name = "reader_update_result2", location = "/reader_update_result2.jsp"),
		@Result(name = "delete", location = "/reader_del.jsp") })
public class ReaderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// ������Դ
	@Resource
	private ReaderService readerService;
	private Reader reader;
	private List<Reader> list;

	// ����Action
	@Action("addReader")
	public String add() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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

	// ����Action
	@Action("toupdateReader")
	public String toupdate() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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

	// ����Action
	@Action("updateReader")
	public String update() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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

	// ����Action
	@Action("toDeleteReader")
	public String toDelete() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
		try {
			list = readerService.findAllReader();
			return "delete";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	// ����Action
	@Action("deleteReader")
	public String delete() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
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
