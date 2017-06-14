package com.zfx.library.type.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zfx.library.type.bean.Type;
import com.zfx.library.type.service.TypeService;



//控制器，用于注解Action类
@Controller
@ParentPackage("ssh")
@Results({
	   @Result(name = "delete", location = "/type_del.jsp")
	})
public class TypeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 依赖资源
	@Resource
	private TypeService typeService;
	private Type type;
	private List<Type> list;
	
	
	@Action("addType")	
	public String add() {
		// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
		try {
			typeService.addType(type);
			return "success";
			} catch (Exception e) {
			e.printStackTrace();
			return "failure";
			}
		}
	
	// 定义Action
			@Action("toDeleteType")
			public String toDelete() {
				// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
				try {
					list = typeService.findAllType();
					return "delete";
				} catch (Exception e) {
					e.printStackTrace();
					return "failure";
				}
			}

			// 定义Action
			@Action("deleteType")
			public String delete() {
				// 捕捉异常，如果无异常则跳至成功页，有异常则跳至失败页
				try {
					typeService.deleteType(type);
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "failure";
				}
			}
	
		// getter & setter

		public TypeService getTypeService() {
			return typeService;
		}

		public void setTypeService(TypeService typeService) {
			this.typeService = typeService;
		}

		public Type getType() {
			return type;
		}

		public void setType(Type type) {
			this.type = type;
		}

		public List<Type> getList() {
			return list;
		}

		public void setList(List<Type> list) {
			this.list = list;
		}
		
}

