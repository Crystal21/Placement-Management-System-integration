package org.crce.interns.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.JobBean;
import org.crce.interns.model.Job;
//import org.crce.interns.model.Allotment;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.service.ManageProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ManageProfile extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 299371520070307716L;
	
	@Autowired
	private ManageProfileService manageProfileService;

	/*
	@RequestMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	*/

	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	// public ModelAndView addProfile(@ModelAttribute("profileBean")ProfileBean
	// profileBean,BindingResult result) {
	public ModelAndView addProfile(@RequestParam Map<String, String> r) throws Exception {
		// manageProfileService.addProfile(profileBean);

		JobBean jobBean = new JobBean();
		CriteriaBean criteriaBean = new CriteriaBean();
		CompanyBean companyBean = new CompanyBean();

		jobBean.setJob_id(r.get("job_id"));
		jobBean.setEvent_id(r.get("event_id"));
		jobBean.setJob_description(r.get("job_description"));
		jobBean.setJob_category(r.get("job_category"));
		jobBean.setCtc(r.get("ctc"));
		jobBean.setSkills_required(r.get("skills_required"));
		jobBean.setDocs_required(r.get("docs_required"));

		jobBean.setModified_date(null);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//Date sdf=new Date();
		//DateFormat sdf = new SimpleDateFormat("");
		//DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//jobBean.setDrive_date(Date("drive_date"));
		
		//if(sdf.parse(r.get("drive_date"))==null)
		//	jobBean.setDrive_date(null);
		
		//else
		jobBean.setDrive_date(sdf.parse(r.get("drive_date")));
				
		jobBean.setCreated_by(r.get("created_by"));
		jobBean.setCreated_date(sdf.parse(r.get("created_date")));
		jobBean.setModified_by(r.get("modified_by"));
		//jobBean.setModified_date(sdf.parse(r.get("modified_date")));

		criteriaBean.setCriteria_id(Integer.parseInt(r.get("criteria_id")));
		criteriaBean.setEligible_branches(r.get("eligible_branches"));
		criteriaBean.setEligible_branches(r.get("eligible_branches"));
		criteriaBean.setYear_of_passing(r.get("year_of_passing"));
		criteriaBean.setPlaced_students_allowed(r.get("placed_students_allowed"));
		criteriaBean.setPercentage(r.get("percentage"));
		criteriaBean.setCgpa(r.get("cgpa"));
		criteriaBean.setNo_of_live_kts_allowed(r.get("no_of_live_kts_allowed"));
		criteriaBean.setNo_of_dead_kts_allowed(r.get("no_of_dead_kts_allowed"));
		criteriaBean.setYear_gap_allowed(r.get("year_gap_allowed"));
		criteriaBean.setSsc_percentage(r.get("ssc_percentage"));
		criteriaBean.setHsc_or_dip_percentage(r.get("hsc_or_dip_percentage"));
		criteriaBean.setLast_date_to_apply(sdf.parse(r.get("last_date_to_apply")));
		
		companyBean.setCompany_id(Integer.parseInt(r.get("company_id")));
		companyBean.setCompany_name(r.get("company_name"));
		companyBean.setCompany_address(r.get("company_address"));
		companyBean.setCriteria_id(criteriaBean.getCriteria_id());
		//companyBean.setCriteria(criteriaBean.getCriteria_id());
		
		
		manageProfileService.addProfile(jobBean);
		manageProfileService.addProfile(criteriaBean);
		manageProfileService.addProfile(companyBean);

		return new ModelAndView("TPO");
	}

	@RequestMapping(value = "/addProfile", method = RequestMethod.GET)
	public ModelAndView createProfile(Model model) {
		// ProfileBean profileBean = new ProfileBean();
		JobBean jobBean = new JobBean(); // declaring
		CriteriaBean criteriaBean = new CriteriaBean();
		CompanyBean companyBean = new CompanyBean();

		model.addAttribute("profileBean", jobBean); // adding in model
		model.addAttribute("profileBean", criteriaBean);
		model.addAttribute("profileBean", companyBean);
		
		System.out.println("In Profile Controller");
		return new ModelAndView("addProfile");
		
	}
	
	@RequestMapping(value="/viewProfile", method = RequestMethod.GET)
	public ModelAndView listProfile() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profiles",  prepareListofBean(manageProfileService.listProfile()));
		return new ModelAndView("viewProfile", model);
	}
	
	private List<JobBean> prepareListofBean(List<Job> profiles) {
		
		List<JobBean> beans = null;
		if(profiles != null && !profiles.isEmpty())
		{
			beans = new ArrayList<JobBean>();
			JobBean bean = null;
			for(Job profile : profiles)
			{
				bean = new JobBean();
				bean.setJob_id(profile.getJob_id());
				bean.setEvent_id(profile.getEvent_id());
				bean.setJob_description(profile.getJob_description());
				bean.setJob_category(profile.getJob_category());
				bean.setCtc(profile.getCtc());
				bean.setSkills_required(profile.getSkills_required());
				bean.setDocs_required(profile.getDocs_required());
				//bean.setJob_id(profile.getDrive_date());
				//bean.setJob_id(profile.getCreated_date());
				//bean.setJob_id(profile.getCreated_by());
				//bean.setJob_id(profile.getModified_date());
				//bean.setJob_id(profile.getModified_by());

				
				beans.add(bean);			
			}
		}
		return beans;
	}

}
