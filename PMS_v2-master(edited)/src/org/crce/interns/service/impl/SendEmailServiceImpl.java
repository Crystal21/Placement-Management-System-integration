package org.crce.interns.service.impl;

import java.io.File;
import java.io.IOException;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.crce.interns.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Service("sendEmailServiceImpl")
public class SendEmailServiceImpl implements SendEmailService	{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public ModelAndView sendMail(HttpServletRequest request,
			@RequestParam(value = "fileUpload") CommonsMultipartFile[] file)
	{
		System.out.println(request.getParameter("message"));
		System.out.println(request.getParameter("subject"));
		System.out.println(request.getParameter("receiver"));

		String path = "C:\\Users\\Crystal\\Desktop\\Email_Temp\\";
		if (file.length > 0 && file != null) {
			System.out.println("Inside If");
			for (CommonsMultipartFile f : file) {
				if (!f.getOriginalFilename().equals("")) {
					System.out.println(path + f.getOriginalFilename());
					try {
						f.transferTo(new File(path + f.getOriginalFilename()));
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		return new ModelAndView("EmailForm");
	}
	
	
	/*
    Return Type: Boolean-True/False
    Function: Checks for Files
*/

public boolean checkFile(String name) {
	String path = "C:\\Users\\Crystal\\Desktop\\Email_Temp";
	File folder = new File(path);
	File[] listOfFiles = folder.listFiles();
	for (int i=0;i<listOfFiles.length;i++) {
		System.out.println(listOfFiles[i].getName());
		if (listOfFiles[i].getName().equals(name))
			return true;
	}
	return false;
}

/*
    Return Type: Void
    Function: Deletes the copy of the file made for uploading in Email_Temp directory
*/

public void deleteFiles() {
	String path = "C:\\Users\\Crystal\\Desktop\\Email_Temp";
	File folder = new File(path);
	File[] files = folder.listFiles();
	for (File f:files)
		f.delete();
}

}
