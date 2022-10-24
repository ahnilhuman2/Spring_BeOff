package com.lec.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.service.AdminHotelService;

@Controller
@RequestMapping("/hotel/admin")
public class AdminHotelController {

	@Autowired
	private AdminHotelService adminHotelService;

	public AdminHotelController() {
		System.out.println(getClass().getName() + "() 생성");
	}	

	// hotel/admin/list : 로그인 한 관리자(adminhotel) "본인"이 등록한 모든 호텔 리스트 조회
	@GetMapping("/list")
	public String getHotelList(Model model) {
		
		List<Hotel> list = adminHotelService.getHotelList();
		
		model.addAttribute("roomList", adminHotelService.getRoomList());
		
		model.addAttribute("hotelList", list);
		System.out.println(list);
		
		return "/hotel/admin/list";
	}
	
	// hotel/admin/write : 호텔 등록 
	@GetMapping("/hotelWrite")
	public String writeHotel(Model model) {
		List<String> list = adminHotelService.getRegionList();
		model.addAttribute("regionList", list);
		return "/hotel/admin/hotelWrite";
	}
	
	// hotel/admin/write : 룸 등록 : 선택한 호텔의 룸
	@GetMapping("/roomWrite")
	public String roomWrite(String id, Model model) {
		
		System.out.println("id : "+ id);
		
		model.addAttribute("id", id);
		
		return "/hotel/admin/roomWrite";
	}
	
	// hotel/admin/HotelWriteOk : 호텔 등록 완료
	@PostMapping("/HotelWriteOk")
	public String writeOk(String username, String hotelname, String region, String content, Model model) {
		int result = 0;
		result = adminHotelService.registerHotel(username, hotelname, region, content);
		model.addAttribute("result", result);
		return "/hotel/admin/HotelWriteOk";
	}
	
	// hotel/admin/RoomWriteOk : 룸 등록 완료
	@PostMapping("/RoomWriteOk")
	public String writeOk(String id, String roomname, Double price, Long bed, Model model) {
		int result = 0;
		
		result = adminHotelService.registerRoom(id, roomname, price, bed);
		model.addAttribute("result", result);
		
		return "/hotel/admin/RoomWriteOk";
	}
	
	
	// 이거하다말앗음 update.jsp, updateOk.jsp 포함.
	// hotel/admin/update
	@GetMapping("/update")
	public String update(Hotel hotel, Room room, Model model) {
		
		int result = 0;
		
		List<String> list = adminHotelService.getRegionList();
		model.addAttribute("regionList", list);
		
		result = adminHotelService.updateHotel(hotel, room);
		
		model.addAttribute("hotel", hotel);
		model.addAttribute("room", room);
		
		return "/hotel/admin/update";
	}
	

	
	// hotel/admin/delete

}
