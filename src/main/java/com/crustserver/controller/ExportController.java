package com.crustserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.crustserver.model.ClassEntity;
import com.crustserver.model.UserEntity;
import com.crustserver.service.ClassService;
import com.crustserver.service.UserService;

@RestController
public class ExportController {

	@Autowired
	private UserService userService;
	@Autowired
	private ClassService classService;
	
	@GetMapping("export/identity/{id}")
	public String exportIdCard(@PathVariable Long id) {
		UserEntity userEntity;
		ClassEntity classEntity;
		try {
			userEntity = this.userService.getUser(id);
			classEntity = this.classService.getClassById(userEntity.getStudentClass());
		} catch (Exception e) {
			return e.toString();
		}
		String idCard = "<html>\n" + 
				"    <head>\n" + 
				"        <title>sample</title>\n" + 
				"    </head>\n" + 
				"    <style>\n" + 
				"\n" + 
				"\n" + 
				".header-section {\n" + 
				"    background-color: blue;\n" + 
				"    height: 40%;\n" + 
				"    background-image: url(\"header-bg.jpg\");\n" + 
				"    color: #ffffff;\n" + 
				"}\n" + 
				".body-section {\n" + 
				"    background-color: #ffffff;\n" + 
				"    height: 50%;\n" + 
				"}\n" + 
				".footer-section {\n" + 
				"    background-image: url(\"header-bg.jpg\");\n" + 
				"    background-color: blue;\n" + 
				"    height: 10%;\n" + 
				"}\n" + 
				".card-container {\n" + 
				"    border: 1px solid;\n" + 
				"    width: 15cm;\n" + 
				"    height:7cm\n" + 
				"}\n" + 
				".account-image {\n" + 
				"    height: 4cm;\n" + 
				"    width: 4cm;\n" + 
				"    border: 0px solid;\n" + 
				"    position: absolute;\n" + 
				"    float: left;\n" + 
				"    top:60px;\n" + 
				"    left: 50px;\n" + 
				"    background-color: aquamarine;\n" + 
				"}\n" + 
				".account-barcode {\n" + 
				"    height: 0.7cm;\n" + 
				"    width: 4cm;\n" + 
				"    border: 0px dotted;\n" + 
				"    position: absolute;\n" + 
				"    float: left;\n" + 
				"    top:220px;\n" + 
				"    left: 50px;\n" + 
				"    background-color: blanchedalmond;\n" + 
				"}\n" + 
				".barcode-image {\n" + 
				"    height: 0.7cm;\n" + 
				"    width: 4cm;\n" + 
				"}\n" + 
				".brand {\n" + 
				"    float: right;\n" + 
				"    position: relative;\n" + 
				"    right: 20px;\n" + 
				"    font-size: 30px;\n" + 
				"    border: 1px solid;\n" + 
				"    max-width: 50%;\n" + 
				"}\n" + 
				".account-content {\n" + 
				"    height: 4cm;\n" + 
				"    width: 50%;\n" + 
				"    border: 0px solid;\n" + 
				"    position: relative;\n" + 
				"    float: right;\n" + 
				"    right: 50px;\n" + 
				"}\n" + 
				".content-container {\n" + 
				"    padding-top: 10px;\n" + 
				"    border-bottom: 1px dotted;\n" + 
				"}\n" + 
				".content-title {\n" + 
				"    font-size: 10px;\n" + 
				"    color: gray;\n" + 
				"}\n" + 
				".content-body {\n" + 
				"\n" + 
				"}\n" + 
				"@media print {\n" + 
				"body {\n" + 
				"    background-color: #ffffff;\n" + 
				"}\n" + 
				"}\n" + 
				"    </style>\n" + 
				"    <body id=\"content\" onload=\"window.print()\">\n" + 
				"        <table class=\"card-container\" border=\"0\"  cellspacing=\"0\">\n" + 
				"            <tr><td class=\"header-section\">\n" + 
				"                <span class=\"brand\">\n" + 
				"                    brand dhsiod hsiudh iahs me\n" + 
				"                </span>\n" + 
				"            </td></tr>\n" + 
				"            <tr><td class=\"body-section\">\n" + 
				"                    <div class=\"account-image\"></div>\n" + 
				"                    <div class=\"account-barcode\">\n" + 
				"                        <img src=\"barcode.jpeg\" class=\"barcode-image\">\n" + 
				"                    </div>\n" + 
				"                    <div class=\"account-content\">\n" + 
				"                        <div class=\"content-container\">\n" + 
				"                            <div class=\"content-title\">NAME</div>\n" + 
				"                            <div class=\"content-body\">"+
				userEntity.getFirstName()+" "+userEntity.getLastName()+"</div>\n" + 
				"                        </div>\n" + 
				"                        <div class=\"content-container\">\n" + 
				"                            <div class=\"content-title\">CODE</div>\n" + 
				"                            <div class=\"content-body\">32u3y23278</div>\n" + 
				"                        </div>\n" + 
				"                        <div class=\"content-container\">\n" + 
				"                            <div class=\"content-title\">Class</div>\n" + 
				"                            <div class=\"content-body\">"+
				classEntity.getClassName()+"</div>\n" + 
				"                        </div>\n" + 
				"                    </div>\n" + 
				"                </td></tr>\n" + 
				"            <tr><td class=\"footer-section\">dksjd</td></tr>\n" + 
				"        </table>\n" + 
				"    </body>\n" + 
				"</html>";
		return idCard;
	}
	

	@GetMapping("export/results/{id}")
	public String exportResults() {
		return "results";
	}

}
