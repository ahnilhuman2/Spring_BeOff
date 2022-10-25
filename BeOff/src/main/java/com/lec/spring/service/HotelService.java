package com.lec.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;


import com.lec.spring.domain.Region;
import com.lec.spring.domain.hotel.Hcomment;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.domain.qna.FileDTO;
import com.lec.spring.domain.qna.Qna;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.hotel.HcommentRepository;
import com.lec.spring.repository.hotel.HotelRepository;
import com.lec.spring.repository.hotel.RoomRepository;
import com.lec.spring.repository.hotel.RoomfileRepository;
import com.lec.spring.repository.hotel.RoomticketRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HcommentRepository hcommentRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private RoomticketRepository roomticketRepository;
	@Autowired
	private RoomfileRepository roomfileRepository;

	public HotelService() {
		System.out.println(getClass().getName() + "() 생성");
	}

	// hotel 지역 목록
	public List<String> getRegionList() {
		List<String> RList = new ArrayList<String>();
		List<Region> regionList = regionRepository.findAll();
		for (Region r : regionList) {
			RList.add(r.getRegion());
		}
		return RList;
	}
		
	
	//호텔 리스트 + 룸 가격
	public List<Hotel> getHotelList() {
		List<Double> pList = new ArrayList<Double>();
		List<Hotel> h = null;

	
		h = hotelRepository.findAll(Sort.by(Order.asc("id")));
		
		for(Hotel i : h) {
			pList.clear();

			for(Room j : i.getRooms()) {
	
				pList.add(j.getPrice());
			}
			for(Double p : pList) {
				if(i.getPriceList() != null) {
					i.setPriceList(i.getPriceList() + Double.toString(p));
				}else {
					i.setPriceList(Double.toString(p));
				}
				Double a = Collections.max(pList);
				Double b = Collections.min(pList);
				i.setPriceList(Double.toString(b)+"원  ~ " + Double.toString(a)+"원");
			}
		}
		return h;
	}
	
	// 숙소 검색
	public List<Hotel> getSearchHotels(String hotelregion, String checkinDate, String checkoutDate) {
		Region region = regionRepository.findByRegion(hotelregion);
		List<Hotel> list = hotelRepository.findByRegion(region);
		List<Hotel> dellist = new ArrayList<Hotel>();
		Long s = Long.parseLong(checkinDate);
		Long e = Long.parseLong(checkoutDate);
		int roomcnt;
		int ticketcnt;
		List<Long> dateList = new ArrayList<Long>() ; 
		for(Long i = s; i < e ; i++) {
			dateList.add(i);
		}
		for(Hotel h : list) {
			List<Room> rList = h.getRooms();
			roomcnt = rList.size();
			ticketcnt = 0;
			for(Room r : rList) {
				Loop2:
				for(Long d : dateList) {
					if(roomticketRepository.findByDateAndRoom(d,r).size() != 0) {
							ticketcnt ++;
						break Loop2;
					}					
				}
			}
			if(roomcnt == ticketcnt) {
				dellist.add(h);
				
			}
		}
		
		for(Hotel h : dellist) {
			list.remove(h);
			
		}
		return list;
	}



	// 숙소 id 값으로 정보 (hotel, room, comment)
	// detail 
	public Hotel getHotelById(String id) {
		Long lId = Long.parseLong(id);
		Hotel h = hotelRepository.findById(lId).get();

		
		return h;
	}


	


	
	
}
