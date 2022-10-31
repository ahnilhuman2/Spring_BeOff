package com.lec.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.service.HotelService;



@Controller
@RequestMapping("/hotel")
public class HotelController {


	private HotelService hotelService;

	@Autowired
	public void setHotelService(HotelService hotelSerivce) {
		this.hotelService = hotelSerivce;
	}
	public HotelController() {
		System.out.println(getClass().getName() + "() 생성");
	}
	
	// /hotel/list
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("regionList", hotelService.getRegionList());	
		model.addAttribute("hotelList", hotelService.getHotelList());
		return "/hotel/list";	
		
	}
	
	
	
	@PostMapping("/list")
	public String searchList(String hotelregion,String inn,String out, Model model) {
		String in1 = inn.replaceAll("-","");
		String out1 = out.replaceAll("-","");
		List<Hotel> list = hotelService.getSearchHotels(hotelregion,in1,out1);
		model.addAttribute("hotelList",list);
		model.addAttribute("hotel",hotelService.getHotelList());
		model.addAttribute("regionList", hotelService.getRegionList());
			
		return "/hotel/list";
	}
	
	
	
	// /hotel/detail
	// 필요한 정보
	// 클릭한 숙소 ID name content -- 
	// 클릭한 숙소의 방 정보  room (image , name, price , bed)
	// 클릭한 숙소의 후기 정보  hcomment(user, reg, star,  content) --
	@GetMapping("/detail")
	public String detail(String id, Model model) {
		model.addAttribute("hotel",hotelService.getHotelById(id));
		model.addAttribute("regionList", hotelService.getRegionList());
		
		return "/hotel/detail"; 
	}
	
	@PostMapping("/detail")
	public String searchList1(String hotelregion,String inn,String out, Model model) {
		String in1 = inn.replaceAll("-","");
		String out1 = out.replaceAll("-","");
		List<Hotel> list = hotelService.getSearchHotels(hotelregion,in1,out1);
		model.addAttribute("hotelList",list);
		model.addAttribute("hotel",hotelService.getHotelList());
		model.addAttribute("regionList", hotelService.getRegionList());;
			
		return "/hotel/list";
	}
	
	
	// /hotel/reserv
	// 필요한 정보
	// 로그인된 유저 ID
	// 룸티켓..?
	
	
	
	
	
	@GetMapping("/reserv")
	public String reserv(String hotelid,String roomid, Model model) {
		model.addAttribute("hotel", hotelService.getHotelById(hotelid));
		model.addAttribute("room", hotelService.getRoomById(roomid));
		model.addAttribute("user", hotelService.getUserData());
		
		
		return "hotel/reserv";
	}


	
}
