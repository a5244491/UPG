package com.yinhai.tcas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MapInListAdapter extends
		XmlAdapter<MapInListConvertor, List<Map<String, Object>>> {
	@Override
	public MapInListConvertor marshal(List<Map<String, Object>> list)
			throws Exception {
		MapInListConvertor convertor = new MapInListConvertor();
		for (Map<String, Object> map : list) {
			MapConvertor mc = new MapConvertor();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				MapConvertor.MapEntry e = new MapConvertor.MapEntry(entry);// Checked
				mc.addEntry(e);
			}
			convertor.addMapConvertor(mc);
		}
		return convertor;
	}

	@Override
	public List<Map<String, Object>> unmarshal(MapInListConvertor convertor)
			throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (MapConvertor mc : convertor.getMapConvertorList()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (MapConvertor.MapEntry e : mc.getEntries()) {
				map.put(e.getKey(), e.getValue());
			}
			list.add(map);
		}
		return list;
	}
}