package security.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.sql.ordering.antlr.OrderingSpecification.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import security.domain.Fac;
import security.repo.FacRepo;

@Controller
public class FacController {
	@Autowired
private FacRepo facRepo;
	@GetMapping("/fac")
	public String fac(Model model) {
		model.addAttribute("names", facRepo.findAll());
		System.out.println(facRepo.findAll());
		return "fac";
	}

	@PostMapping("/filter1")
	public String facFilter1(Model model) {
		List<Fac> f=facRepo.findAll();
		Collections.sort(f ,new Comparator<Fac>()
        {
            public int compare(Fac f1, Fac f2)
            {
                return f1.getName().compareTo(f2.getName());
            }        
        });
		model.addAttribute("names",f);
		return "fac";
	}
	@PostMapping("/filter3")
	public String facFilter3(Model model) {
		List<Fac> f1=facRepo.findAll();
		Collections.sort(f1 ,new Comparator<Fac>()
        {
            public int compare(Fac f1, Fac f2)
            {
            	
                return Integer.compare(f1.getAverage(), f2.getAverage());
            }        
        });
		Collections.reverse(f1);
		model.addAttribute("names",f1);
		return "fac";
	}
	@PostMapping("/filter2")
	public String facFilter2(Model model) {
		List<Fac> f2=facRepo.findAll();
		Collections.sort(f2 ,new Comparator<Fac>()
        {
            public int compare(Fac f1, Fac f2)
            {
                return f1.getName().compareTo(f2.getName());
            }        
        });
		Collections.reverse(f2);
		model.addAttribute("names",f2);
		return "fac";
	}
	@PostMapping("/ufac")
	public String uFac(String id) {
		System.out.println(" "+"  "+ id+"   ");
		return "fac";
		
	}
}
