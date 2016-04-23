package org.crce.interns.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public ModelAndView sendMail(HttpServletRequest request,
            @RequestParam(value = "fileUpload") CommonsMultipartFile[] file) {
        System.out.println(request.getParameter("message"));
        System.out.println(request.getParameter("subject"));
        System.out.println(request.getParameter("receiver"));

        String path = "C:\\";
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
        String CompsFTPC, CompsSTPC, ProdSTPC, ProdFTPC, ElexFTPC, ElexSTPC, ITFTPC, ITSTPC, compsClass, itClass, prodClass, elexClass;
        compsClass = "leonsurajd69@gmail.com";
        itClass = "dsouza.nevil45@gmail.com";
        prodClass = "cuthinho.crystal95@gmail.com";
        elexClass = "melwyn95@gmail.com";

        //Comps TPCs
        CompsFTPC = "dsouza.nevil45@gmail.com cuthinho.crystal95@gmail.com leonsurajd69@gmail.com";
        CompsSTPC = "sankpal22pankaj@gmail.com adarshgupta139@gmail.com leonsurajd69@gmail.com";
        //CompsSTPC = "leonsurajd69@gmail.com";
        //Prod TPCs
        ProdFTPC = "leonsurajd69@gmail.com adarshgupta139@gmail.com leonsurajd69@gmail.com";
        ProdSTPC = "rashmisri1995@gmail.com fionalobo23@gmail.com leonsurajd69@gmail.com";

        //Elex TPCs
        ElexFTPC = "frcrcecompsinterns@gmail.com leonsurajd69@gmail.com";
        ElexSTPC = "andreaf2395@gmail.com leonsurajd69@gmail.com";

        //IT TPCs
        ITFTPC = "anuissac1202@gmail.com leonsurajd69@gmail.com";
        ITSTPC = "leonsurajd69@gmail.com lillitarhea@gmail.com";
        //ITSTPC = "leonsurajd69@gmail.com";

        String allSTPC = CompsSTPC + " " + ElexSTPC + " " + ProdSTPC + " " + ITSTPC;
        String allFTPC = CompsFTPC + " " + ElexFTPC + " " + ProdFTPC + " " + ITFTPC;
        String allTPC = allSTPC + " " + allFTPC;
        String allClass = prodClass + " " + elexClass + " " + itClass + " " + compsClass;
        String keywordReceivers = request.getParameter("receiver");

        String[] keywordReceiversSplit = keywordReceivers.split(" ");
        List<String> list = new ArrayList<String>();
        List<String> loweredList = new ArrayList<String>();
        list.addAll(Arrays.asList(keywordReceiversSplit));
        System.out.println(list);
        list.stream().forEach((st) -> {
            loweredList.add(st.toLowerCase());
        });
        System.out.println(loweredList);

        //boolean t=loweredList.contains("itstpc");
        //System.out.println(t);
        loweredList.remove(",");
        //System.out.println(loweredList);
        if (loweredList.contains("compsstpc,")) {
            //System.out.println("compsstpc,");
            int pos = loweredList.indexOf("compsstpc,");
            //System.out.println(pos);
            loweredList.remove("compsstpc,");
            loweredList.add(pos, CompsSTPC);
            //System.out.println(loweredList);
        } else if (loweredList.contains("compsstpc")) {
            // System.out.println("compsstpc");
            int pos = loweredList.indexOf("compsstpc");
            // System.out.println(pos);
            loweredList.remove("compsstpc");
            loweredList.add(pos, CompsSTPC);
            System.out.println(loweredList);
        }
        if (loweredList.contains("itstpc,")) {
            //System.out.println("itstpcstpc,");
            int pos = loweredList.indexOf("itstpc,");
            //System.out.println(pos);
            loweredList.remove("itstpc,");
            loweredList.add(pos, ITSTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("itstpc")) {
            // System.out.println("itstpc");
            int pos = loweredList.indexOf("itstpc");
            // System.out.println(pos);
            loweredList.remove("itstpc");
            loweredList.add(pos, ITSTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("prodstpc,")) {
            // System.out.println("prodstpc,");
            int pos = loweredList.indexOf("prodstpc,");
            // System.out.println(pos);
            loweredList.remove("prodstpc,");
            loweredList.add(pos, ProdSTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("prodstpc")) {
            // System.out.println("prodstpc");
            int pos = loweredList.indexOf("prodstpc");
            //System.out.println(pos);
            loweredList.remove("prodstpc");
            loweredList.add(pos, ProdSTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("elexstpc,")) {
            // System.out.println("elexstpc,");
            int pos = loweredList.indexOf("elexstpc,");
            // System.out.println(pos);
            loweredList.remove("elexstpc,");
            loweredList.add(pos, ElexSTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("elexstpc")) {
            // System.out.println("elexstpc");
            int pos = loweredList.indexOf("elexstpc");
            // System.out.println(pos);
            loweredList.remove("elexstpc");
            loweredList.add(pos, ElexSTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("compsftpc,")) {
            //  System.out.println("compsftpc,");
            int pos = loweredList.indexOf("compsftpc,");
            // System.out.println(pos);
            loweredList.remove("compsftpc,");
            loweredList.add(pos, CompsFTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("compsftpc")) {
            // System.out.println("compsftpc");
            int pos = loweredList.indexOf("compsftpc");
            // System.out.println(pos);
            loweredList.remove("compsftpc");
            loweredList.add(pos, CompsFTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("prodftpc,")) {
            // System.out.println("prodftpc,");
            int pos = loweredList.indexOf("prodftpc,");
            // System.out.println(pos);
            loweredList.remove("prodftpc,");
            loweredList.add(pos, ProdFTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("prodftpc")) {
            // System.out.println("compsstpc");
            int pos = loweredList.indexOf("prodftpc");
            // System.out.println(pos);
            loweredList.remove("prodftpc");
            loweredList.add(pos, ProdFTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("elexftpc,")) {
            // System.out.println("elexftpc,");
            int pos = loweredList.indexOf("elexftpc,");
            // System.out.println(pos);
            loweredList.remove("elexftpc,");
            loweredList.add(pos, ElexFTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("elexftpc")) {
            // System.out.println("elexftpc");
            int pos = loweredList.indexOf("elexftpc");
            //  System.out.println(pos);
            loweredList.remove("elexftpc");
            loweredList.add(pos, ElexFTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("itftpc,")) {
            //  System.out.println("itftpc,");
            int pos = loweredList.indexOf("itftpc,");
            //  System.out.println(pos);
            loweredList.remove("itftpc,");
            loweredList.add(pos, ITFTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("itftpc")) {
            // System.out.println("itftpc");
            int pos = loweredList.indexOf("itftpc");
            // System.out.println(pos);
            loweredList.remove("itftpc");
            loweredList.add(pos, ITFTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("stpc,")) {
            System.out.println("stpc,");
            int pos = loweredList.indexOf("stpc,");
            System.out.println(pos);
            loweredList.remove("stpc,");
            loweredList.add(pos, allSTPC);
            System.out.println(loweredList);
        } else if (loweredList.contains("stpc")) {
            System.out.println("stpc");
            int pos = loweredList.indexOf("stpc");
            System.out.println(pos);
            loweredList.remove("stpc");
            loweredList.add(pos, allSTPC);
            System.out.println(loweredList);
        }
        if (loweredList.contains("ftpc,")) {
            System.out.println("ftpc,");
            int pos = loweredList.indexOf("ftpc,");
            System.out.println(pos);
            loweredList.remove("ftpc,");
            loweredList.add(pos, allFTPC);
            System.out.println(loweredList);
        } else if (loweredList.contains("ftpc")) {
            System.out.println("ftpc");
            int pos = loweredList.indexOf("ftpc");
            System.out.println(pos);
            loweredList.remove("ftpc");
            loweredList.add(pos, allFTPC);
            System.out.println(loweredList);
        }
        if (loweredList.contains("tpc,")) {
            System.out.println("tpc,");
            int pos = loweredList.indexOf("tpc,");
            System.out.println(pos);
            loweredList.remove("tpc,");
            loweredList.add(pos, allTPC);
            System.out.println(loweredList);
        } else if (loweredList.contains("tpc")) {
            System.out.println("tpc");
            int pos = loweredList.indexOf("tpc");
            System.out.println(pos);
            loweredList.remove("tpc");
            loweredList.add(pos, allTPC);
            System.out.println(loweredList);
        }
        if (loweredList.contains("prodclass,")) {
            // System.out.println("tpc,");
            int pos = loweredList.indexOf("prodclass,");
            //System.out.println(pos);
            loweredList.remove("prodclass,");
            loweredList.add(pos, prodClass);
            // System.out.println(loweredList);
        } else if (loweredList.contains("prodclass")) {
            // System.out.println("tpc");
            int pos = loweredList.indexOf("prodclass");
            //System.out.println(pos);
            loweredList.remove("prodclass");
            loweredList.add(pos, prodClass);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("itclass,")) {
            System.out.println("tpc,");
            int pos = loweredList.indexOf("itclass,");
            System.out.println(pos);
            loweredList.remove("itclass,");
            loweredList.add(pos, itClass);
            System.out.println(loweredList);
        } else if (loweredList.contains("itclass")) {
            //System.out.println("tpc");
            int pos = loweredList.indexOf("itclass");
            System.out.println(pos);
            loweredList.remove("itclass");
            loweredList.add(pos, itClass);
            System.out.println(loweredList);
        }
        if (loweredList.contains("compsclass,")) {
            System.out.println("tpc,");
            int pos = loweredList.indexOf("compsclass,");
            System.out.println(pos);
            loweredList.remove("compsclass,");
            loweredList.add(pos, compsClass);
            System.out.println(loweredList);
        } else if (loweredList.contains("compsclass")) {
            System.out.println("tpc");
            int pos = loweredList.indexOf("compsclass");
            System.out.println(pos);
            loweredList.remove("compsclass");
            loweredList.add(pos, compsClass);
            System.out.println(loweredList);
        }
        if (loweredList.contains("elexclass,")) {
            System.out.println("elexclass,");
            int pos = loweredList.indexOf("elexclass,");
            System.out.println(pos);
            loweredList.remove("elexclass,");
            loweredList.add(pos, elexClass);
            System.out.println(loweredList);
        } else if (loweredList.contains("elexclass")) {
            System.out.println("tpc");
            int pos = loweredList.indexOf("elexclass");
            System.out.println(pos);
            loweredList.remove("elexclass");
            loweredList.add(pos, elexClass);
            System.out.println(loweredList);
        }
        if (loweredList.contains("allclasses,")) {
            System.out.println("allclasses,");
            int pos = loweredList.indexOf("allclasses,");
            System.out.println(pos);
            loweredList.remove("allclasses,");
            loweredList.add(pos, allClass);
            System.out.println(loweredList);
        } else if (loweredList.contains("allclasses")) {
            System.out.println("tpc");
            int pos = loweredList.indexOf("allclasses");
            System.out.println(pos);
            loweredList.remove("allclasses");
            loweredList.add(pos, allClass);
            System.out.println(loweredList);
        }
//        if (keywordReceivers.equalsIgnoreCase("CompsSTPC")) {
//            input = CompsFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ProdSTPC")) {
//            input = ProdSTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ElexSTPC")) {
//            input = ElexSTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ITSTPC")) {
//            input = ITSTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ITFTPC")) {
//            input = ITFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("CompsFTPC")) {
//            input = CompsFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ProdFTPC")) {
//            input = ProdFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ElexFTPC")) {
//            input = ElexFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("STPC")) {
//            input = allSTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("FTPC")) {
//            input = allFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("TPC")) {
//            input = allTPC;
//        }

        String input[] = new String[loweredList.size()];
        // System.out.println("input array");
        input = loweredList.toArray(input);
        String finalList = Arrays.toString(input).replace("[", "").replace("]", "");
        System.out.println("Final List");
        System.out.println(finalList);
        String stream = Arrays.toString(input);
        System.out.println("Stream");
        System.out.println(stream);

        String[] emailIds = finalList.split(" ");

        javaMailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage)
                    throws javax.mail.MessagingException, IllegalStateException, IOException {
                System.out.println("Throws Exception");
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                //mimeMessageHelper.setTo(request.getParameter("receiver"));
                mimeMessageHelper.setTo(emailIds);

                mimeMessageHelper.setSubject(request.getParameter("subject"));

                mimeMessageHelper.setText(request.getParameter("message"));

                for (CommonsMultipartFile f : file) {
                    if (checkFile(f.getOriginalFilename())) {
                        mimeMessageHelper.addAttachment(f.getOriginalFilename(), new File(path + f.getOriginalFilename()));
                    }
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
        String path = "C:\\";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println(listOfFiles[i].getName());
            if (listOfFiles[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /*
     Return Type: Void
     Function: Deletes the copy of the file made for uploading in Email_Temp directory
     */
    public void deleteFiles() {
        String path = "C:\\";
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File f : files) {
            f.delete();
        }
    }

}
