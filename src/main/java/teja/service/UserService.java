package teja.service;

import java.util.List;

import teja.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teja.repository.CandidateRepository;
import teja.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CandidateRepository canRepo;
	
	public AppUser addUser(AppUser appUser)
	{
		appUser.setRole("ROLE_NORMAL");
		
		return this.userRepo.save(appUser);
	}
	
	public List<AppUser> getAllUsers()
	{
		return this.userRepo.findAll();
	}
	
	public AppUser getUserById(int id)
	{
		return this.userRepo.getById(id);
	}
	
	public void deleteUser(int id)
	{
		this.userRepo.deleteById(id);
	}
	
	public AppUser getUserByEmail(String email)
	{
		return this.userRepo.getUserByEmail(email);
	}
	

	

}
