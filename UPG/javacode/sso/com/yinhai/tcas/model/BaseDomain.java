package com.yinhai.tcas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import com.yinhai.tcas.util.CasUtil;

public class BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map key;

	@Override
	public boolean equals(Object other) {
		if (null == other)
			return false;
		if (this == other)
			return true;
		if (other.getClass().toString().equals(this.getClass().toString())) {
			BaseDomain local = (BaseDomain) other;
			if (this.getKey().equals(local.getKey())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return sort(getKey()).hashCode();
	}

	public Map getKey() {
		if (key != null) {
			return this.key;
		}
		return null;
	}

	public void setKey(Map key) {
		this.key = key;
	}

	private String sort(Map pk) {
		StringBuffer result = new StringBuffer("");
		ArrayList list = new ArrayList(pk.keySet());
		Collections.sort(list);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			result.append(obj.toString())
					.append("`")
					.append(CasUtil.isEmpty(pk.get(obj)) ? "" : pk.get(obj)
							.toString()).append(it.hasNext() ? "^" : "");
		}
		return result.toString();
	}

}