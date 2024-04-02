//package com.jpa.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.model.Aaa;
//import com.jpa.service.AaaService;
//
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@RestController
//public class AaaController {
//	@Autowired
//	private AaaService aaaService;
//	
//	@Autowired
//	private Aaa aaa;
//	
//	@RequestMapping("/jpa/insert")
//	public String insert(@RequestBody Aaa aaa) {
//		return aaaService.insert(aaa);
//	}	
//	@RequestMapping("/jpa/delete")
//	public String delete(@RequestBody Aaa aaa) {
//		return aaaService.delete(aaa.getA());
//	}	
//
//	@RequestMapping("/jpa/update")
//	public String update(@RequestBody Aaa aaa) {
//		return aaaService.update(aaa);
//	}	
//	
//	
//	@RequestMapping("/jpa/query")
//	public List<Aaa> query(@RequestBody Aaa aaa) {
//		return aaaService.query();
//	}
//	
//}
