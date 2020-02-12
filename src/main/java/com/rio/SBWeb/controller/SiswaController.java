package com.rio.SBWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rio.SBWeb.model.Siswa;
import com.rio.SBWeb.services.SiswaServices;

@Controller
public class SiswaController {

	private SiswaServices siswaServices;
	
	
	@Autowired
	public void setSiswaServices(SiswaServices siswaServices) {
		this.siswaServices = siswaServices;
	}


	@RequestMapping("/pageSiswa")
	public String listMahasiswa(Model model) {
		model.addAttribute("siswa", siswaServices.listSiswas()); 
		return "pageSiswa";
		
	}
	
	@RequestMapping(value = "/pageSiswa/create", method = RequestMethod.GET)
	public String fromAddData(Model model) {
		model.addAttribute("siswa", new Siswa());
		return "pageFormSiswa";
	}
	
	@RequestMapping(value = "/pageSiswa/create", method = RequestMethod.POST)
	public String saveDataSiswa(Model model, Siswa siswa) {
		model.addAttribute("siswa", siswaServices.saveOrUpdate(siswa));
		return "redirect:/pageSiswa";
	}
	
	@RequestMapping(value = "/pageSiswa/edit/{id_siswa}", method = RequestMethod.GET)
	public String editData(@PathVariable Integer id_siswa, Model model) {
		model.addAttribute("siswa", siswaServices.getId(id_siswa));
		return "pageFormSiswa";
		
	}
	
	@RequestMapping(value = "/pageSiswa/delete/{id_siswa}")
	public String delete(@PathVariable Integer id_siswa) {
		siswaServices.delete(id_siswa);
		return "redirect:/pageSiswa";
		
	}
	
	
}
