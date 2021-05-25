package security;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;
@Controller
public class RegistrationController {
	@Value("${upload.path}")
	private String uploadPath;
	@Autowired
	private UserRepo userRepo;
@GetMapping("/registration")
public String registration() {
	return "registration";
}
@PostMapping("/registration")
public String addUser(User user,@RequestParam("file") MultipartFile file, Model model) {
	if(file!=null) {
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
	userRepo.save(user);
	return"redirect:/login";
}
}
