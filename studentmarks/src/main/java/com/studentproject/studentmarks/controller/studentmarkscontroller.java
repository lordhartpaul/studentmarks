package com.studentproject.studentmarks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.studentproject.studentmarks.dao.studentmarksDAO;
import com.studentproject.studentmarks.model.studentmarks;

@Controller
public class studentmarkscontroller {
	
	@Autowired
	private studentmarksDAO studentmarksDao;
	
	
	@RequestMapping(value = "/entry", method=RequestMethod.GET)
	public String newEntries(ModelMap model) {
		
		studentmarks studentmark = new studentmarks();
		model.addAttribute("studentmark", studentmark);
		return "entry";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveEntries(@Valid studentmarks studentmark,BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			
			return "entry";
			
		}
		
		studentmarksDao.save(studentmark);
		  
		return "redirect:/viewstudentmarks/1";
	}
	
	@RequestMapping("/viewstudentmarks")  
    public ModelAndView viewstudentmarks(){  
        List<studentmarks> list=studentmarksDao.getAllstudentmarkss();
        return new ModelAndView("viewstudentmarks","list",list);  
    } 
	
	@RequestMapping(value="/viewstudentmarks/{pageid}")
	public ModelAndView edit(@PathVariable int pageid) {
		
		int total=2;
		
		
		if(pageid==1) {
			
		}else {
			pageid=(pageid-1)*total+1;
		}
		List<studentmarks> list=studentmarksDao.getstudentmarkssByPage(pageid, total);
		return new ModelAndView("viewstudentmarks", "list", list);
		
	}
	@RequestMapping(value="/editstudentmarks/{id}")  
    public String edit(@PathVariable int id,ModelMap model){  
       studentmarks studentmark=studentmarksDao.getstudentmarksById(id);  
       model.addAttribute("studentmark", studentmark);
		return "editstudentmarks";
        
        
    }
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("studentmark") studentmarks p) {
		System.out.println("id is"+p.getId());
		studentmarksDao.update(p);
		return new ModelAndView("redirect:/viewstudentmarks/1");
	}
	
	@RequestMapping(value="/deletestudentmarks/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		
		studentmarksDao.delete(id);
		
		return new ModelAndView("redirect:/viewstudentmarks/1");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView delete() {
		
		studentmarksDao.delete();
		
		return new ModelAndView("redirect:/viewstudentmarks/1");
	}
	
	@ModelAttribute("pageCount")
	public List<String> initializePageCount(){
		
		int total = 2;
		List<String> pageCount = new ArrayList<String>();
		int count = studentmarksDao.count();
		int result = ((count/total)+ (count%total));
		for(int k=0;k<result;k++) {
			pageCount.add(new Integer(k).toString());
		}
		
		return pageCount;
	}

}
