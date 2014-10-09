package com.yinhai.tcas.util;

public interface IConst {
	/**序列*/
	public static final String SEQ_TCAS_LOG="SEQ_TCAS_LOG";
	public static final String SEQ_TCAS_USER="SEQ_TCAS_USER";
	
	/**操作动作*/
	public static final String ACTION_NEW_CAS_USER="1";
	public static final String ACTION_NEW_CAS_USER_MAPPING="2";
	public static final String ACTION_NEW_CAS_USER_CASCADE_MAPPING="3";
	public static final String ACTION_EDIT_CAS_USER="4";
	public static final String ACTION_EDIT_CAS_USER_MAPPING="5";
	public static final String ACTION_OFF_CAS_USER_MAPPING="6";
	public static final String ACTION_LOCK_CAS_USER_MAPPING="7";
	public static final String ACTION_LOCK_CAS_USER="71";
	public static final String ACTION_UNLOCK_CAS_USER_MAPPING="8";
	public static final String ACTION_UNLOCK_CAS_USER="81";
	public static final String ACTION_PASS_NEW_CAS_USER_MAPPING="9";
	public static final String ACTION_PASS_NEW_CAS_USER="91";
	public static final String ACTION_REFUSE_NEW_CAS_USER_MAPPING="10";
	public static final String ACTION_REFUSE_NEW_CAS_USER="101";
	public static final String ACTION_DELETE_CAS_USER_CASCADE_MAPPING="11";
	public static final String ACTION_DELETE_CAS_USER_MAPPING="12";
	/**用户状态*/
	public static final String STATE_VALID="1";
	public static final String STATE_WAIT_AUDIT="2";
	public static final String STATE_LOCK="3";
	
	public static final String YES="1";
	public static final String NO="0";
	public static final String DB_DATETIME_SQL="select to_number(SYSDATE - to_date('1970-01-01 8:0:0', 'yyyy-mm-dd hh24:mi:ss')) * 24*60*60*1000 from dual";
}
