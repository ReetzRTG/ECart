package com.niit.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.eshop.dao.CartDao;
import com.niit.eshop.dao.UsersDao;
import com.niit.eshop.model.Cart;
import com.niit.eshop.model.User;
import com.niit.eshop.model.Users;

@Controller  
public class UserController {
	  @Autowired 
	  UsersDao usersDao;
	  @Autowired
	  CartDao cartDao;
	  
	@RequestMapping("/usersform")  
    public ModelAndView showform(){  
        return new ModelAndView("usersform","command",new Users());  
    } 
	
	 /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("users") Users users){  
    	usersDao.addUsers(users);
        return new ModelAndView("redirect:/viewusers");//will redirect to viewusers request mapping  
    }  
    
    /* It provides list of users in model object */  
    @RequestMapping("/viewusers")  
    public ModelAndView viewusers(){  
        List<Users> list=usersDao.getAllUsers();
        return new ModelAndView("viewusers","list",list);  
    }  
    
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editusers/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Users users=usersDao.getUsersById(id);  
        return new ModelAndView("userseditform","command",users);  
    }  
    
    
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("users") Users users){  
    	usersDao.updateUsers(users);
        return new ModelAndView("redirect:/viewusers");  
    }  
    
    /* It deletes record for the given id in URL and redirects to /viewusers */  
    @RequestMapping(value="/deleteusers/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){ 
    	System.out.println("delete is called");
       usersDao.deleteUsers(id);
        return new ModelAndView("redirect:/viewusers");  
    }  
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView userRegistrationView(){
    	return new ModelAndView("userregistrationview", "command",new Users());
    }
    
    @RequestMapping(value="/registerUser",method=RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("users")Users users,HttpSession httpSession){
    	ModelAndView modelAndView=new ModelAndView("userRegistrationView","command",new User());
    	if(usersDao.getUsersById(users.getUserId())!=null){
    		System.out.println("at same use Id");
    		modelAndView.addObject("errorMessage","Please try with different user Id.");
    		return modelAndView;
    		
    	}else{
    		
    		users.setEnabled(true);
    		users.setRole("ROLE_USER");
    		Cart cart=new Cart();
    		cart.setCartStatus(true);
    		
    		if(cartDao.insertCart(cart)){
    			users.setCart(cart);
    			if(usersDao.addUsers(users)){
    				modelAndView.addObject("successMessage","You have been registered successfully.");
    				return modelAndView;
    				
    			}else{
    				
    				modelAndView.addObject("errorMessage","User has not been inserted!");
    				return modelAndView;
    			}
    		}else{
    			
    			modelAndView.addObject("errorMessage","Cart has not been inserted!");
    			return modelAndView;
    		}
    	} 
    }
}