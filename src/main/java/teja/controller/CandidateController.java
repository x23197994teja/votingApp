package teja.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import teja.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import teja.model.Candidate;
import teja.service.CandidateService;
import teja.service.UserService;

@Controller
public class CandidateController {
	
	@Autowired
	private CandidateService canServ;
	
	@Autowired
	private UserService userServ;
	
	@PostMapping("/addcandidate") // vote
	public String addCandidate(@RequestParam("candidate") String candidate,
			Principal p, Model model, HttpSession session)
	{
		String email = p.getName();
		AppUser appUser = userServ.getUserByEmail(email);
	
		
		if(appUser.getStatus() == null)
		{
			try {
				// add a vote to the selectedCandidate
				Candidate selectedCan = canServ.getCandidateByCandidate(candidate);
				selectedCan.setVotes(selectedCan.getVotes() + 1);
				canServ.addCandidate(selectedCan); // update candidate
				
				appUser.setStatus("Voted");
				userServ.addUser(appUser); // update user
				
				session.setAttribute("vmsg", "Successfully Voted...");
			}
			catch(Exception e)
			{
				session.setAttribute("vmsg", "Something went wrong...");
				e.printStackTrace();
				return "redirect:user/";
			}
			
			
		}
		
		
		return "redirect:user/";
		
	}

}
