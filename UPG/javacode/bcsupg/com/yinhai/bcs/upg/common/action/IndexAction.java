package com.yinhai.bcs.upg.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.yinhai.sysapp.Bpo.FunctionMenuService;
import com.yinhai.sysframework.organization.IMenu;
import com.yinhai.sysframework.organization.ISecurityService;
import com.yinhai.sysframework.util.ValidateUtil;
import com.yinhai.sysframework.util.json.JSonFactory;
import com.yinhai.webframework.BaseAction;
import com.yinhai.webframework.session.UserSession;
import com.yinhai.yhcip.app.security.domain.Menu;





//@Namespace("/")

//@Action(value = "indexAction", results = { @Result(name = "success", location = "/index.jsp") })

public class IndexAction extends BaseAction{


	private ISecurityService securityService = (ISecurityService) super

			.getService("security4FrameworkService");

	private FunctionMenuService functionMenuService = (FunctionMenuService) super.getService("functionMenuService");

	

	@Override

	public String execute() throws Exception {

		String parameter = request.getParameter("indexstyle");

		List quickMenu = getUserQuickMenu();

		List list = findAll();

		request.setAttribute("menuTree", JSonFactory.bean2json(quickMenu));

		request.setAttribute("secendLevelMenu", list);

		if (ValidateUtil.isEmpty(parameter)) {

			parameter = SUCCESS;

		}

		return parameter;

	}

	public String findChildMenu()throws Exception{

		writeJsonToClient(findAll());

		return null;

	}

	// 得到当前用户菜单

	public List findAll() throws Exception {

//		IUser iUser=UserSession.getUserSession(request).getUser();
//
//		String rootId = YhecConfigUtil.getRootMenuId();
//
//		String node = rootId;
//		
//		if(request.getParameter("id") !=null && !"".equals(request.getParameter("id"))){//表示异步请求
//
//			node = request.getParameter("id");
//
//		}
//
//		IMenu menu = new Menu();
//
//		menu.setMenuId(node);
//
//		List<IMenu> list = null;
//
//		if(request.getSession().getAttribute("user_seq_list")!=null){//第一次可以从loginsuccessaction中缓存获�?
//
//		  list = (List<IMenu>)request.getSession().getAttribute("user_seq_list");
//
//		  request.getSession().removeAttribute("user_seq_list");
//
//		}else{
//
//			String splitRolePermission = AppManager.getSysConfig("splitRolePermission");
//
//			//用户登录后只显示当前角色的权限，如果要显示所有角色权限就配置成小写false，在config.properties里配�?
//
//			if("false".equals(splitRolePermission)){
//
//				list = securityService.getAllMenusAllRoles(menu, iUser);
//
//			}else{
//
//				list=securityService.getAllMenus(menu,iUser);
//
//			}
//
//		}
//
//		List<HashMap<String,Object>> retlist = new ArrayList<HashMap<String,Object>>();
//
//		
//
//		//记录菜单map，用于对菜单判断是否为叶子菜单时方便取得
//
//		HashMap<String, HashMap<String,Object>> tempMap=new HashMap<String, HashMap<String,Object>>();
//
//		
//
//		//List<IMenu> menusList=securityService.getAllMenus();//得到全部菜单，用于取得菜单的fullpath时用
//
//		
//
//		if(!rootId.equals(node) && node.length()==6){
//
//			HashMap<String,Object> mapFirst = new HashMap<String,Object>();
//
//			mapFirst.put("id", node);
//
//			mapFirst.put("name", securityService.getMenuById(node).getName());
//
//			mapFirst.put("open", true);
//
//			retlist.add(mapFirst);
//
//		}
//
//		if(list!=null && list.size()>0){
//
//			for(int i=0,j=list.size();i<j;i++){
//
//				IMenu tempMenu=list.get(i);
//
//				/* 不显示的功能不在菜单树中显示 liding add in 2012-2-8 */
//
//				if (tempMenu.getPolicy().equals(Menu.CONSTANT_NEEDAUTHENTICATION_HIDDEN) || tempMenu.getPolicy().equals(Menu.CONSTANT_UNNEEDAUTHENTICATION_HIDDEN))
//
//					continue;
//
//				if(tempMenu.getParentId()!=null && tempMenu.getParentId().equals(node)){
//
//					HashMap<String,Object> map = new HashMap<String,Object>();
//
//					map.put("id",tempMenu.getMenuId());
//
//					map.put("pId",tempMenu.getParentId());
//
//					map.put("funUrl", tempMenu.getFunctionUrl());
//
//					map.put("shortId", tempMenu.getShortId());
//
//					map.put("orderId", tempMenu.getOrderId());
//
//					map.put("iconSkin", tempMenu.getUnselectImage());
//
//					map.put("selectImage",tempMenu.getSelectImage());
//
//					map.put("name", tempMenu.getName());
//
//					map.put("helpUrl", tempMenu.getHelpUrl());
//
//					map.put("py", StringUtil.getPYString(tempMenu.getName()));
//
//					map.put("policy", tempMenu.getPolicy());
//
//					map.put("isParent", false);
//
//					map.put("type", tempMenu.getType());
//
//					retlist.add(map);
//					tempMap.put(tempMenu.getMenuId(), map);
//				}
//			}
//
//			for(int i=0,j=list.size();i<j;i++){
//
//				IMenu tempMenu=list.get(i);
//
//				if (tempMenu.getPolicy().equals(Menu.CONSTANT_NEEDAUTHENTICATION_HIDDEN) || tempMenu.getPolicy().equals(Menu.CONSTANT_UNNEEDAUTHENTICATION_HIDDEN))
//					continue;
//				if(tempMenu.getParentId()!=null&&tempMap.get(tempMenu.getParentId())!=null){
//					tempMap.get(tempMenu.getParentId()).put("isParent", true);
//				}
//			}
//		}


//		return retlist;
		return null;

	}

	/**

	 * 异步获取子菜�?

	 * @return

	 * @throws Exception

	 */

	public String getAsyncData() throws Exception {

		String id = request.getParameter("id");

		Map param = new HashMap();

		param.put("parentMenuId", id);

		param.put("yae270", "0"); // 隐藏标志

		List list = getDao().queryForList("menu.getMenus", param);

		if (ValidateUtil.isNotEmpty(list)){

			int menuCount = list.size();

			StringBuffer sb = new StringBuffer("[");

			for (int i = 0; i < menuCount; i++){

				IMenu menu = (IMenu) list.get(i);

				/* 不显示的功能不在菜单树中显示 liding add in 2012-2-8 */

				if (menu.getPolicy().equals(Menu.CONSTANT_NEEDAUTHENTICATION_HIDDEN) || menu.getPolicy().equals(Menu.CONSTANT_UNNEEDAUTHENTICATION_HIDDEN))

					continue;

				sb.append("{id:'" + menu.getMenuId() + "',name:'" + menu.getName() + "',pId:'"

						+ menu.getParentId() + "',funUrl:'" + menu.getFunctionUrl() + "',shortId:'"

						+ menu.getShortId() + "',orderId:'" + menu.getOrderId() + "',iconSkin:'"

						+ menu.getUnselectImage() + "',selectImage:'" + menu.getSelectImage() + "',helpUrl:'"

						+ menu.getHelpUrl() + "',type:'" + menu.getType() + "',policy:" + menu.getPolicy());

				param.put("parentMenuId", menu.getMenuId());

				if (((Integer)getDao().queryForObject("menu.getMenusCount", param)) > 0)

					sb.append(",isParent:true");

				sb.append("}");

				if (i != menuCount - 1)

					sb.append(",");

			}

			sb.append("]");

			writeJsonToClient(sb.toString());

		}

		return null;

	}

	public String findQueryMenu() throws Exception{

		writeJsonToClient(getUserQuickMenu());

		return null;

	}

	private List getUserQuickMenu() throws Exception{

//		String rootId = YhecConfigUtil.getRootMenuId();
//		String userid=getDto().getUserInfo().getUserId();
//		Map<String, String> mapCom = functionMenuService.getComMenuByUserId(userid);
//
//		//List<IMenu> menusList = securityService.getAllMenus();//得到全部菜单，用于取得菜单的fullpath时用
//
//		List<HashMap<String,Object>> retlist = new ArrayList<HashMap<String,Object>>();
//
//		HashMap<String,Object> mapFirst = new HashMap<String,Object>();
//
//		mapFirst.put("id", rootId);
//
//		mapFirst.put("name", "我的常用菜单");
//
//		mapFirst.put("open", true);
//
//		retlist.add(mapFirst);
//
//		if(mapCom.get("menuids")!=null){	
//
//			String[] menuIds=mapCom.get("menuids").split(",");
//
//			List<IMenu> list=(List<IMenu>)functionMenuService.getMenus4CoMenus(mapCom.get("menuids"));
//
//			if(list!=null){
//				for(int i=0,j=list.size();i<j;i++){
//
//					IMenu menu=(IMenu)list.get(i);
//
//					/* 不显示的功能不在菜单树中显示 liding add in 2012-2-8 */
//
//					if (menu.getPolicy().equals(Menu.CONSTANT_NEEDAUTHENTICATION_HIDDEN) || menu.getPolicy().equals(Menu.CONSTANT_UNNEEDAUTHENTICATION_HIDDEN))
//
//						continue;
//
//					HashMap<String,Object> map = new HashMap<String,Object>();
//
//					map.put("id",menu.getMenuId());
//
//					map.put("pId",rootId);
//
//					map.put("funUrl", menu.getFunctionUrl());
//
//					map.put("shortId", menu.getShortId());
//
//					map.put("orderId", menu.getOrderId());
//
//					map.put("iconSkin", menu.getUnselectImage());
//
//					map.put("selectImage",menu.getSelectImage());
//
//					map.put("name", menu.getName());
//
//					map.put("helpUrl", menu.getHelpUrl());
//
//					map.put("py", StringUtil.getPYString(menu.getName()));
//
//					map.put("policy", menu.getPolicy());
//
//					map.put("isParent", false);
//
//					map.put("type", menu.getType());
//
//				
//
//					retlist.add(map);
//
//				}
//
//				//以下判断常用菜单对应的菜单是否已删除，如果菜单为空，那么常用菜单中就不应该包含该菜单的快捷方式，所以删�?
//                
//				for(int i=0,k=menuIds.length;i<k;i++){  //checked
//					String menuid=menuIds[i];
//					Boolean _del=true;
//					for(int j=0,m=list.size();j<m;j++){  //checked
//						IMenu menu=list.get(j);
//						if(menu.getMenuId().equals(menuid)){
//							_del=false;
//
//							break;
//
//						}
//
//					}
//
//					if(_del){
//
//						delComMenu(menuid);
//
//					}
//
//				}
//
//			}
//
//		}
//
//		
//
//		return retlist;
		
		return null;

	}

	private void delComMenu(String menuid){

		String userid=UserSession.getUserSession(ServletActionContext.getRequest()).getUser().getUserId();

		Map<String, String> map=functionMenuService.getComMenuByUserId(userid);

		String menuids=map.get("menuids");

		if(menuids!=null&&menuids.contains(menuid)){

			if(menuids.equals(menuid)){

				menuids="";

			}else if(menuids.startsWith(menuid+",")){

				menuids=menuids.substring(menuid.length()+1);

			}else if(menuids.endsWith(","+menuid)){

				menuids=menuids.substring(0,menuids.length()-menuid.length()-1);

			}else {

				int index=menuids.indexOf(menuid);

				menuids=menuids.substring(0,index-1)+menuids.substring(index+menuid.length());

			}

			if(menuids.equals("")){

				functionMenuService.deleteComMenu(userid);

			}else{			

				functionMenuService.updateComMenu(userid, menuids);

			}			

		}

	}

	



	// 得到当前用户菜单

	public List findAll_desktop() throws Exception {

//		String rootId = YhecConfigUtil.getRootMenuId();
//		IUser iUser = UserSession.getUserSession(request).getUser();
//
//		String node = Menu.CONSTANT_ROOT_ID;// 01 为跟菜单id
//
//		if (request.getParameter("id") != null
//
//				&& !"".equals(request.getParameter("id"))) {// 表示异步请求
//
//			node = request.getParameter("id");
//
//		}
//
//		IMenu menu = new Menu();
//
//		menu.setMenuId(node);
//
//		List<IMenu> list = null;
//
//		if (request.getSession().getAttribute("user_seq_list") != null) {// 第一次可以从loginsuccessaction中缓存获�?
//
//			list = (List<IMenu>) request.getSession().getAttribute(
//
//					"user_seq_list");
//
//			request.getSession().removeAttribute("user_seq_list");
//
//		} else {
//
//			String splitRolePermission = AppManager.getSysConfig("splitRolePermission");
//
//			//用户登录后只显示当前角色的权限，如果要显示所有角色权限就配置成小写false，在config.properties里配�?
//
//			if("false".equals(splitRolePermission)){
//
//				list = securityService.getAllMenusAllRoles(menu, iUser);
//
//			}else{
//
//				list=securityService.getAllMenus(menu,iUser);
//
//			}
//
//		}
//
//		List<HashMap<String, Object>> retlist = new ArrayList<HashMap<String, Object>>();
//
//
//
//		// 记录菜单map，用于对菜单判断是否为叶子菜单时方便取得
//
//		HashMap<String, HashMap<String, Object>> tempMap = new HashMap<String, HashMap<String, Object>>();
//
//
//
//		// List<IMenu>
//
//		// menusList=securityService.getAllMenus();//得到全部菜单，用于取得菜单的fullpath时用
//
//
//
//		if (!rootId.equals(node) && node.length() == 6) {
//
//			HashMap<String, Object> mapFirst = new HashMap<String, Object>();
//
//			mapFirst.put("id", node);
//
//			mapFirst.put("name", securityService.getMenuById(node).getName());
//
//			mapFirst.put("open", true);
//
//			retlist.add(mapFirst);
//
//		}
//
//		if (list != null && list.size() > 0) {
//
//			for (int i = 0,j=list.size(); i < j; i++) {
//
//				IMenu tempMenu = list.get(i);
//
//				/* 不显示的功能不在菜单树中显示 liding add in 2012-2-8 */
//
//				if (tempMenu.getPolicy().equals(
//
//						Menu.CONSTANT_NEEDAUTHENTICATION_HIDDEN)
//
//						|| tempMenu.getPolicy().equals(
//
//								Menu.CONSTANT_UNNEEDAUTHENTICATION_HIDDEN))
//
//					continue;
//
//				if (tempMenu.getParentId() != null) {
//
//					HashMap<String, Object> map = new HashMap<String, Object>();
//
//					map.put("id", tempMenu.getMenuId());
//
//					map.put("pId", tempMenu.getParentId());
//
//					map.put("funUrl", tempMenu.getFunctionUrl());
//
//					map.put("shortId", tempMenu.getShortId());
//
//					map.put("orderId", tempMenu.getOrderId());
//
//					map.put("iconSkin", tempMenu.getUnselectImage());
//
//					map.put("selectImage", tempMenu.getSelectImage());
//
//					map.put("name", tempMenu.getName());
//
//					map.put("helpUrl", tempMenu.getHelpUrl());
//
//					map.put("py", StringUtil.getPYString(tempMenu.getName()));
//
//					map.put("policy", tempMenu.getPolicy());
//
//					map.put("isParent", false);
//
//					map.put("type", tempMenu.getType());
//
//
//
//					retlist.add(map);
//
//					tempMap.put(tempMenu.getMenuId(), map);
//
//				}
//
//			}
//
//			for (int i = 0,j=list.size(); i < j; i++) {
//
//				IMenu tempMenu = list.get(i);
//
//				if (tempMenu.getParentId() != null
//
//						&& tempMap.get(tempMenu.getParentId()) != null) {
//
//					tempMap.get(tempMenu.getParentId()).put("isParent", true);
//
//				}
//
//			}
//
//		}
//
//
//
//		// if(request.getParameter("id") !=null &&
//
//		// !"".equals(request.getParameter("id"))){
//
//		// writeJsonToClient(retlist);
//
//		// }else{
//
//		// request.setAttribute("menuTree", JSonFactory.bean2json(retlist));
//
//		// }
//
//		return retlist;
		return null;

	}

	

	public String findChildMenu_desktop()throws Exception{

		writeJsonToClient(findAll_desktop());

		return null;

	}

	

	public String getAllMenus() throws Exception {

		UserSession us = UserSession.getUserSession(request);

		List lst = new ArrayList();

		if (null != us) {

			lst = securityService.getAllMenus(us.getUser());

		}

		super.writeJsonToClient(lst);

		return null;

	}
	
	public static void main(String[] args) {
		String s = "3_1|4_2|5_3";
		String ss[] = s.split("\\|");
		for(int i = 0 ; i < ss.length ; i ++) {
			System.out.println(ss[i]);
		}
	}

}


