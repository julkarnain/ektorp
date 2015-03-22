package org.ektorp.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	

	@Autowired
	DrishtiUserRepository dristiUserRepository;
	
	@RequestMapping(value="/register/", method= RequestMethod.GET)
	public ModelAndView viewRegistrationForm()
	{
		return new ModelAndView("/posts/registers","command", new User());
	}
	
	@RequestMapping(value="/login/", method= RequestMethod.GET)
	public ModelAndView viewLoginForm()
	{
		return new ModelAndView("/posts/login","command", new User());
		
	}
	
	@RequestMapping(value="/authenticate/", method= RequestMethod.POST)
	public String checkAuthenticate(@ModelAttribute("command") User user, Model  m)
	{
		List<User> existUser = null;
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		if(username != null && password != null){
			 existUser = userRepository.findByUsername(username, password);
			 
			 if(existUser.size() > 0)
				 
				 m.addAttribute("userList", userRepository.getAll());
				
				return "/posts/users";
			
		}
		m.addAttribute("userList", userRepository.getAll());
		
		return "/posts/users";
	}
	
	@RequestMapping(value="/authenticate-user/", method= RequestMethod.POST)
	public String checkDrishtiAuthenticate(@ModelAttribute("command") DrishtiUser user, Model  m)
	{
		List<DrishtiUser> existUser = null;
		
		String username = "c"; //user.getUsername();
		String password = user.getPassword();
		
		if(username != null){
			
			 existUser = dristiUserRepository.findByUsername(username, password);
			 
			 if(existUser.size() > 0)
				 
				 m.addAttribute("userList",existUser);
				
				return "/posts/drishtiuserdetails";
			
		}
	//	m.addAttribute("userList", dristiUserRepository.getAll());
		
		return "/posts/drishtiuserdetails";
	}
	

	

	@RequestMapping(value="/submit/", method= RequestMethod.POST)
	public String postUser(@ModelAttribute("command") User user, Model m )
	{
		
		if(user.isNew())
		{
			user.setId(user.getUsername());
			user.setPassword(user.getPassword());
			user.setFname(user.getFname());
			user.setLname(user.getLname());
			user.setFathername(user.getFathername());
			user.setEmail(user.getEmail());
			user.setPresentadd(user.getPresentadd());
			user.setPermanentadd(user.getPermanentadd());
			
			userRepository.add(user);
		}
		else
		{
			userRepository.update(user);
		}
		
		m.addAttribute("userList", userRepository.getAll());
		
		return "/posts/users";
	}
	
	
	
}
