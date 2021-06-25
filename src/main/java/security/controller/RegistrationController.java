package security.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import security.domain.Certificate;
import security.domain.Rating;
import security.domain.Role;
import security.domain.User;
import security.repo.CertificateRepo;
import security.repo.RatingRepo;
import security.repo.UserRepo;

import java.util.UUID;
@Controller
public class RegistrationController {
	@Value("${upload.path}")
	private String uploadPath;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RatingRepo ratingRepo;
	@Autowired
	private CertificateRepo certificateRepo;
	Object[] arr= {1,2,3,4,5};
@GetMapping("/registration")
public String registration() {
	return "registration";
}
@PostMapping("/registration")
public String addUser(User user,@RequestParam("file") MultipartFile file, Model model) {
	if(!(file.getSize()<=0)) {
		File uploadFolder=new File(uploadPath);
		if(!uploadFolder.exists())uploadFolder.mkdir();
			String ind=UUID.randomUUID().toString();
			String fileName=ind +"."+file.getOriginalFilename();
			try {
				file.transferTo(new File(uploadPath+"/"+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			user.setFileName(fileName);
	}
	User userfrDb=userRepo.findByUsername(user.getUsername());
	if(userfrDb!=null) {
		model.addAttribute("message","User exists!");
		return "registration";
	}
	user.setActive(true);
	user.setRoles(Collections.singleton(Role.USER));
	user.setFileName(null);
	userRepo.save(user);
	return"redirect:/login";
}
@GetMapping("/point")
public String point() {
	return "point";
	
}
@PostMapping("/point")
public String pointPost(@RequestParam(name="math")int math,
		@RequestParam(name="physics")int physics,@RequestParam(name="history")int history,
		@RequestParam(name="ukrainean")int ukrainean,@RequestParam(name="english")int english,Model model,
		@RequestParam("file") MultipartFile file) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	User user=userRepo.findByUsername(auth.getName());
	Certificate cert=new Certificate();
	if(!(file.getSize()<=0)||user.getFileName()!=null) {
			String ind=UUID.randomUUID().toString();
			String fileName=ind +"."+user.getUsername();
			try {
				cert.setFile(file.getBytes());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			cert.setId(user.getId());
			user.setFileName(fileName);
	}
	
	try {
		
		user.getRating().getEnglish();

	}catch(NullPointerException ex) {
		Rating rt=new Rating(math,physics,history,ukrainean,english);
		rt.setId(user.getId());
		ratingRepo.save(rt);
		user.setRating(rt);
		certificateRepo.save(cert);
		user.setCertificate(cert);
		userRepo.save(user);
		
		return "point";
	}
	 model.addAttribute("message", "raiting is finalized!"); 
	 return "point";
}
}
