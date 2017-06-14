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

// 控制器，用于注解Action类
@Controller
// 父包（参见struts.xml文件）
@ParentPackage("ssh")

@Results({ @Result(name = "index", location = "/admin_index.jsp"),
		   @Result(name = "login", location = "/admin_login.jsp"),
		   @Result(name = "delete", location = "/deleteUser.jsp")
		})
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 依赖资源
	@Resource
	private UserService userService;
	private User user;
	private String msg;
	private List<User> list;


	// 定义Action
	@Action("addUser")
	public String add() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			userService.addUser(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
	// 定义Action
		@Action("toDeleteUser")
		public String toDelete() {
			// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
			try {
				list = userService.findAllUser();
				return "delete";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}

		// 定义Action
		@Action("deleteUser")
		public String delete() {
			// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
			try {
				userService.deleteUser(user);
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}

	// 定义Action
	@Action("updateUser")
	public String update() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
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
	// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
	try {
	if (userService.validate(user)) {
	ActionContext ctx = ActionContext.getContext();
	ctx.getSession().put("USER_NAME", user.getName());
	return "index";
	} else {
		
	msg = "用户名或密码错误！";
	
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
