package org.crce.interns.controller;
import java.sql.BatchUpdateException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import org.crce.interns.beans.AptitudeBean;
import org.crce.interns.beans.EventBean;
import org.crce.interns.beans.InterviewBean;
import org.crce.interns.beans.Pre_PlacementBean;
import org.crce.interns.service.impl.EventDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventDetailsController {

	@Autowired
	private EventDetailsService eventDetailsService;
	
	@RequestMapping(value="/getEventForm.html", method=RequestMethod.GET)
	public ModelAndView getEventForm(){
		ModelAndView model=new ModelAndView("fill-events");
		return model;
	}
	
	@RequestMapping(value="fill", method=RequestMethod.POST)
	public ModelAndView createEvent(@RequestParam Map<String, String> map) throws ParseException, BatchUpdateException{
		
		ModelAndView model=new ModelAndView("fill-event-success");
		// initialize event bean
		EventBean eventBean=new EventBean();
				
		eventBean.setEvent_id((map.get("event_name")));
				
		eventBean.setEvent_type(map.get("event_type"));
		//eventBean.setCompany_id(Integer.parseInt(map.get("company_id")));
		String cname=map.get("company_name");
		eventBean.setApproved((map.get("approved")));
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2= new SimpleDateFormat("HH:mm:SS"); 
		eventBean.setDate(formatter.parse(map.get("date")));
		eventBean.setDate(formatter2.parse(map.get("time")));
		//eventBean.setTime(((map.get("time"))));
		eventBean.setVenue(map.get("venue"));
		eventDetailsService.create(eventBean,cname);
		model.addObject(eventBean);
		//create event-type beans--
		
		if(eventBean.getEvent_type().equals("aptitude")){
			//initialize aptitude bean
			AptitudeBean aptitudeBean=new AptitudeBean();
			
			//set bean
			aptitudeBean.setEvent_id(eventBean.getEvent_id());
			aptitudeBean.setSubjects_to_be_prepared(map.get("subjects_to_be_prepared"));
			aptitudeBean.setTest_duration((map.get("test_duration")));
			aptitudeBean.setTest_section(map.get("test_section"));
					
			eventDetailsService.create(aptitudeBean);

		}
		
		else if(eventBean.getEvent_type().equals("interview")){
			
			InterviewBean interviewBean=new InterviewBean();
			interviewBean.setEvent_id(eventBean.getEvent_id());
			interviewBean.setInterview_type(map.get("interview_type"));
			eventDetailsService.create(interviewBean);
		}
		
		else if(eventBean.getEvent_type().equals("pre_placement")){
			Pre_PlacementBean pre_placementBean=new Pre_PlacementBean();
			pre_placementBean.setAgenda(map.get("agenda"));
			pre_placementBean.setConducted_by(map.get("conducted_by"));
			pre_placementBean.setEvent_id(eventBean.getEvent_id());
			eventDetailsService.create(pre_placementBean);
		}
		
			System.out.println(eventBean.getEvent_type());

		return model;
	}
	
}
