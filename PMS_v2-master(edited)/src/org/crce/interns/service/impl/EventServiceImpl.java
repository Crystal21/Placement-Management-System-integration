package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.Event_detailsBean;
import org.crce.interns.dao.EventDao;
import org.crce.interns.model.Event_details;
import org.crce.interns.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	public List<Event_detailsBean> convertToBean(List<Event_details> eventList) {
		List<Event_detailsBean> edBeanList = new ArrayList<Event_detailsBean>();
		for (Event_details ed : eventList) {
			Event_detailsBean edBean = new Event_detailsBean();
			BeanUtils.copyProperties(ed, edBean);
			edBeanList.add(edBean);
		}
		return edBeanList;
	}

	@Override
	public List<Event_detailsBean> viewEvents(Integer months) {
		System.out.println("Month in Service Impl :" + months);
		List<Event_details> eventList = eventDao.viewEvents(months);
		if (eventList == null) {
			return null;
		}
		return convertToBean(eventList);
	}

}
