/*
 * Authors:
 * 			@Melwyn
 * 			@Leon
 * Function: Sending an e-mail
 */
package org.crce.interns.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.crce.interns.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller("sendEmailController")
public class SendEmailController {

	//@Autowired
	//private JavaMailSender javaMailSender;
	
	@Autowired
	public SendEmailService sendEmailService;

	/*
        Return Type: Boolean-True/False
        Function: Checks for Files
	*/

	/*public boolean checkFile(String name) {
		String path = "C:\\Users\\Leon\\Desktop\\Email_Temp";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i=0;i<listOfFiles.length;i++) {
			System.out.println(listOfFiles[i].getName());
			if (listOfFiles[i].getName().equals(name))
				return true;
		}
		return false;
	}*/

	/*
        Return Type: Void
        Function: Deletes the copy of the file made for uploading in Email_Temp directory
	*/

	/*public void deleteFiles() {
		String path = "C:\\Users\\Leon\\Desktop\\Email_Temp";
		File folder = new File(path);
		File[] files = folder.listFiles();
		for (File f:files)
			f.delete();
	}*/

	/*
        Return Type: ModelAndView
        Function: Sends an email along with a attachemnts to multiple recipients
	*/

	@RequestMapping(value = "/SubmitEmail", method = RequestMethod.POST)
	public ModelAndView sendEmail(HttpServletRequest request,
			@RequestParam(value = "fileUpload") CommonsMultipartFile[] file) throws IllegalStateException, IOException {
		
		ModelAndView model = new ModelAndView();
		model = sendEmailService.sendMail(request, file);
		
		return model;
	}

	/*
        Return Type: ModelAndView
        Function: Displays The Compose an e-mail page
	*/
	@RequestMapping(method=RequestMethod.GET, value="/sendMail")
	public ModelAndView email_welcome() {
		System.out.println("Mapped to /sendMail");
		return new ModelAndView("EmailForm");
		//return new ModelAndView("Final");
	}
	/*
        Return Type: ModelAndView
        Function: Displays The Compose an e-mail page
	*/
        /*
	@RequestMapping(method=RequestMethod.GET, value="/")
	public ModelAndView welcome() {
		return new ModelAndView("EmailForm");
	}
        */
}


/*
System.out.println(request.getParameter("message"));
System.out.println(request.getParameter("subject"));
System.out.println(request.getParameter("receiver"));

String path = "C:\\Users\\Leon\\Desktop\\Email_Temp\\";
if (file.length > 0 && file != null) {
	System.out.println("Inside If");
	for (CommonsMultipartFile f : file) {
		if (!f.getOriginalFilename().equals("")) {
			System.out.println(path + f.getOriginalFilename());
			f.transferTo(new File(path + f.getOriginalFilename()));
		}
	}
}

String input = request.getParameter("receiver");
String[] emailIds = input.split(" ");


javaMailSender.send(new MimeMessagePreparator() {
	public void prepare(MimeMessage mimeMessage)
			throws javax.mail.MessagingException, IllegalStateException, IOException {
		System.out.println("Throws Exception");
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

		//mimeMessageHelper.setTo(request.getParameter("receiver"));

		mimeMessageHelper.setTo(emailIds);

		mimeMessageHelper.setSubject(request.getParameter("subject"));

		mimeMessageHelper.setText(request.getParameter("message"));

		for (CommonsMultipartFile f:file) {
			if (checkFile(f.getOriginalFilename()))
			mimeMessageHelper.addAttachment(f.getOriginalFilename(), new File(path+f.getOriginalFilename()));
		}
	}
});


deleteFiles();
ModelAndView model = new ModelAndView("Result");  */