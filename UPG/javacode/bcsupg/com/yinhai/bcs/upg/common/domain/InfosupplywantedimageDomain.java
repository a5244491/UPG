//package com.yinhai.bcs.upg.common.domain;
//
//
//import com.yinhai.sysframework.app.domain.BaseDomain;
//import com.yinhai.sysframework.app.domain.DomainMeta;
//import com.yinhai.sysframework.app.domain.Key;
////
///**
// * 供求信息图片扩展表 Domain
// * @author YINHAI SOFTWARE
// * @copyright Copyrigt 银海软件 2011
// * @version 3.2 2013-8-6 18:35:34
// */
//public class InfosupplywantedimageDomain extends BaseDomain {
//
//	/** 主键 */
//	private Long image_id;
//
//	/** 外键，与supply_wanted大表关联 */
//	private Long sw_id;
//
//	/** 原图地址 */
//	private String image_url;
//
//	/** 排序序号 */
//	private Integer sort_order;
//
//	/** 外键，与publish表关联 */
//	private Long publish_id;
//
//	/** 是否默认图片 1-是 0-否 */
//	private String is_default;
//
//	/** 手机_缩略图地址 */
//	private String thumbnail_app;
//
//	/** 网站缩略图 */
//	private String thumbnail_ec;
//
//	public InfosupplywantedimageDomain() {
//	}
//
//	public InfosupplywantedimageDomain(Long image_id) {
//		this.image_id = image_id;
//	}
//
//	@Override
//	public Key getPK() {
//		Key key = new Key();
//		if (this.getImage_id() == null) {
//			throw new IllegalArgumentException("主键image_id不能为空。");
//		}
//		key.put("image_id", this.getImage_id());
//		return key;
//	}
//
//	/**
//	 * 设置 image_id 主键
//	 * @param image_id 主键
//	 */
//	public void setImage_id(Long image_id) {
//		this.image_id = image_id;
//	}
//
//	/**
//	 * 获取 image_id 主键
//	 * @return 主键
//	 */
//	public Long getImage_id() {
//		return this.image_id;
//	}
//
//	/**
//	 * 设置 sw_id 外键，与supply_wanted大表关联
//	 * @param sw_id 外键，与supply_wanted大表关联
//	 */
//	public void setSw_id(Long sw_id) {
//		this.sw_id = sw_id;
//	}
//
//	/**
//	 * 获取 sw_id 外键，与supply_wanted大表关联
//	 * @return 外键，与supply_wanted大表关联
//	 */
//	public Long getSw_id() {
//		return this.sw_id;
//	}
//
//	/**
//	 * 设置 image_url 原图地址
//	 * @param image_url 原图地址
//	 */
//	public void setImage_url(String image_url) {
//		this.image_url = image_url;
//	}
//
//	/**
//	 * 获取 image_url 原图地址
//	 * @return 原图地址
//	 */
//	public String getImage_url() {
//		return this.image_url;
//	}
//
//	/**
//	 * 设置 sort_order 排序序号
//	 * @param sort_order 排序序号
//	 */
//	public void setSort_order(Integer sort_order) {
//		this.sort_order = sort_order;
//	}
//
//	/**
//	 * 获取 sort_order 排序序号
//	 * @return 排序序号
//	 */
//	public Integer getSort_order() {
//		return this.sort_order;
//	}
//
//	/**
//	 * 设置 publish_id 外键，与publish表关联
//	 * @param publish_id 外键，与publish表关联
//	 */
//	public void setPublish_id(Long publish_id) {
//		this.publish_id = publish_id;
//	}
//
//	/**
//	 * 获取 publish_id 外键，与publish表关联
//	 * @return 外键，与publish表关联
//	 */
//	public Long getPublish_id() {
//		return this.publish_id;
//	}
//
//	/**
//	 * 设置 is_default 是否默认图片 1-是 0-否
//	 * @param is_default 是否默认图片 1-是 0-否
//	 */
//	public void setIs_default(String is_default) {
//		this.is_default = is_default;
//	}
//
//	/**
//	 * 获取 is_default 是否默认图片 1-是 0-否
//	 * @return 是否默认图片 1-是 0-否
//	 */
//	public String getIs_default() {
//		return this.is_default;
//	}
//
//	/**
//	 * 设置 thumbnail_app 手机_缩略图地址
//	 * @param thumbnail_app 手机_缩略图地址
//	 */
//	public void setThumbnail_app(String thumbnail_app) {
//		this.thumbnail_app = thumbnail_app;
//	}
//
//	/**
//	 * 获取 thumbnail_app 手机_缩略图地址
//	 * @return 手机_缩略图地址
//	 */
//	public String getThumbnail_app() {
//		return this.thumbnail_app;
//	}
//
//	/**
//	 * 设置 thumbnail_ec 网站缩略图
//	 * @param thumbnail_ec 网站缩略图
//	 */
//	public void setThumbnail_ec(String thumbnail_ec) {
//		this.thumbnail_ec = thumbnail_ec;
//	}
//
//	/**
//	 * 获取 thumbnail_ec 网站缩略图
//	 * @return 网站缩略图
//	 */
//	public String getThumbnail_ec() {
//		return this.thumbnail_ec;
//	}
//
//	/**
//	 * 转换为map对象
//	 * @return Map
//	 */
//	@Override
//	public java.util.Map toMap() {
//		java.util.Map map = new java.util.HashMap();
//		map.put("image_id", getImage_id()); //主键
//		map.put("sw_id", getSw_id()); //外键，与supply_wanted大表关联
//		map.put("image_url", getImage_url()); //原图地址
//		map.put("sort_order", getSort_order()); //排序序号
//		map.put("publish_id", getPublish_id()); //外键，与publish表关联
//		map.put("is_default", getIs_default()); //是否默认图片 1-是 0-否
//		map.put("thumbnail_app", getThumbnail_app()); //手机_缩略图地址
//		map.put("thumbnail_ec", getThumbnail_ec()); //网站缩略图
//
//		return map;
//	}
//
//	/**
//	 * 转换为DomainMeta对象
//	 * @return DomainMeta
//	 */
//	@Override
//	public DomainMeta getMetadata() {
//		DomainMeta domainMeta = new DomainMeta("InfosupplywantedimageDomain",
//				"info_supply_wanted_image", "供求信息图片扩展表",
//				"info_supply_wanted_image",
//				"javacode/yhec/com/yinhai/yhec/common/domain/Info_supply_wanted_image.xml");
//		domainMeta.appendField("image_id", "image_id", "主键", "Long",
//				"NUMBER(10)", 10, true, true, false);
//		domainMeta.appendField("sw_id", "sw_id", "外键，与supply_wanted大表关联",
//				"Long", "NUMBER(10)", 10, false, false, false);
//		domainMeta.appendField("image_url", "image_url", "原图地址", "String",
//				"VARCHAR2(255)", 255, false, false, false);
//		domainMeta.appendField("sort_order", "sort_order", "排序序号", "Integer",
//				"NUMBER(4)", 4, false, false, false);
//		domainMeta.appendField("publish_id", "publish_id", "外键，与publish表关联",
//				"Long", "NUMBER(10)", 10, false, false, false);
//		domainMeta.appendField("is_default", "is_default", "是否默认图片 1-是 0-否",
//				"String", "CHAR(1)", 1, false, false, false);
//		domainMeta.appendField("thumbnail_app", "thumbnail_app", "手机_缩略图地址",
//				"String", "VARCHAR2(255)", 255, false, false, false);
//		domainMeta.appendField("thumbnail_ec", "thumbnail_ec", "网站缩略图",
//				"String", "VARCHAR2(255)", 255, false, false, false);
//
//		return domainMeta;
//	}
//
//}
