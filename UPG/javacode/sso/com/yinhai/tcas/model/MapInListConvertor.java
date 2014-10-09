package com.yinhai.tcas.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MapInListConvertor")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapInListConvertor {
	private List<MapConvertor> mapList = new ArrayList<MapConvertor>();

	public void addMapConvertor(MapConvertor mc) {
		mapList.add(mc);
	}

	public List<MapConvertor> getMapConvertorList() {
		return mapList;
	}
}