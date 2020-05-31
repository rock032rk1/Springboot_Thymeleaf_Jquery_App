package com.spring.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.app.model.Student;
import com.spring.app.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/getAll")
	public String getAll(Model model) {

		List<Student> slist = studentService.getAll();
		model.addAttribute("stud", slist);

		return "students";
	}

	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Student> getOne(Integer id) {
		return studentService.getOne(id);
	}

	@PostMapping("/addNew")
	public String addNew(Student stu) {

		studentService.addNew(stu);

		return "redirect:/students/getAll";
	}

	@PostMapping("/update")
	public String update(Student stu) {

		studentService.update(stu);

		return "redirect:/students/getAll";
	}

	@GetMapping("/delete")
	public String delete(Integer id) {

		studentService.delete(id);

		return "redirect:/students/getAll";
	}

}
