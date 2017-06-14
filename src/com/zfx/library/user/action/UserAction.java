package com.zfx.library.user.action;

import javax.annotation.Resource;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zfx.library.user.bean.User;
import com.zfx.library.user.service.UserService;

// ������������ע��Action��
@Controller
// �������μ�struts.xml�ļ���
@ParentPackage("ssh")

@Results({ @Result(name = "index", location = "/admin_index.jsp"),
		   @Result(name = "login", location = "/admin_login.jsp"),
		   @Result(name = "delete", location = "/deleteUser.jsp")
		})
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// ������Դ
	@Resource
	private UserService userService;
	private User user;
	private String msg;
	private List<User> list;


	// ����Action
	@Action("addUser")
	public String add() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
		try {
			userService.addUser(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	// ����Action
		@Action("toDeleteUser")
		public String toDelete() {
			// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
			try {
				list = userService.findAllUser();
				return "delete";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}

		// ����Action
		@Action("deleteUser")
		public String delete() {
			// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
			try {
				userService.deleteUser(user);
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}

	// ����Action
	@Action("updateUser")
	public String update() {
		// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
		try {
			User u = userService.findByName(user.getName());
			if (u == null) {
				return "failure";
			}
			u.setPwd(user.getPwd());
			userService.updateUser(u);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	
	@Action("login")
	public String login() {
	// ��׽�쳣��������쳣�������ɹ�ҳ�����쳣������ʧ��ҳ
	try {
	if (userService.validate(user)) {
	ActionContext ctx = ActionContext.getContext();
	ctx.getSession().put("USER_NAME", user.getName());
	return "index";
	} else {
		
	msg = "�û������������";
	
	return "login";
	}
	} catch (Exception e) {
	e.printStackTrace();
	return "failure";
	}
	}


	// getter & setter

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
}
