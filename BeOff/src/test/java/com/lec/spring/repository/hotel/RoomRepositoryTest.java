package com.lec.spring.repository.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lec.spring.domain.Region;
import com.lec.spring.domain.User;
import com.lec.spring.domain.hotel.Hotel;
import com.lec.spring.domain.hotel.Room;
import com.lec.spring.domain.hotel.Roomfile;
import com.lec.spring.repository.RegionRepository;
import com.lec.spring.repository.UserRepository;

@SpringBootTest
class RoomRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminHotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RoomfileRepository roomfileRepository;
	@Autowired
	private RegionRepository regionRepository;
	
	@Test
	void test() {
		User adminhotel = userRepository.findByUsername("ADMINHOTEL");

		User user1 = userRepository.findByUsername("USER1");
		User user2 = userRepository.findByUsername("USER2");

		Region korea = regionRepository.findByRegion("한국");
		Region japan = regionRepository.findByRegion("일본");
		Region usa = regionRepository.findByRegion("미국");

		// 호텔 입력

		Hotel h1 = Hotel.builder().hotelname("시그니엘(서울)").content("국내 최고 호텔입니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h2 = Hotel.builder().hotelname("포시즌스").content("널찍한 객실 공간에 고급스러움을 느낄 수 있습니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h3 = Hotel.builder().hotelname("파라다이스시티").content("조식이 맛있습니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h4 = Hotel.builder().hotelname("롯데호텔").content("위치와 전망이 좋습니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h5 = Hotel.builder().hotelname("JW 메리어트").content("품격 있는 숙박을 원한다면 JW 메리어트를 선택하세요").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h6 = Hotel.builder().hotelname("반얀트리").content("고급진 객실 객실이 있습니다.").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h7 = Hotel.builder().hotelname("앰배서더").content("세련된 호텔입니다").user(adminhotel).region(korea).avgstar(0).build();
		Hotel h8 = Hotel.builder().hotelname("더 리츠칼튼").content("공항에서 거리가 가까워요").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h9 = Hotel.builder().hotelname("뉴 오타니 도쿄").content("작은 폭포와 멋진 전망이 있습니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h10 = Hotel.builder().hotelname("만다린 오리엔탈").content("지하철 역과 가깝고 고급 레스토랑이 있습니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h11 = Hotel.builder().hotelname("아만 도쿄").content("위생, 서비스가 최고입니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h12 = Hotel.builder().hotelname("게이오 플라자 호텔").content("풍부한 아침 식사가 준비되어있습니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h13 = Hotel.builder().hotelname("류메이칸 오차노미즈").content("시티투어를 하기 편리한 관광명소에 있습니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h14 = Hotel.builder().hotelname("가조엔 도쿄").content("호텔의 첫인상은 굉장합니다.").user(adminhotel).region(japan).avgstar(0).build();
		Hotel h15 = Hotel.builder().hotelname("로우 NYC").content("4성급 호텔, 타임스퀘어가 근처에 있습니다").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h16 = Hotel.builder().hotelname("그랜드 하얏트 뉴욕").content("뉴욕 관광명소들이 자리잡고 있습니다").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h17 = Hotel.builder().hotelname("웰링턴").content("가성비가 좋습니다").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h18 = Hotel.builder().hotelname("할레쿨라니").content("와이키키 해번의 아름다운 호텔").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h19 = Hotel.builder().hotelname("카할라 호텔").content("고급진 숙박과 편안함을 가진 카할라 호텔").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h20 = Hotel.builder().hotelname("벨라지오").content("미국 5성급 호텔").user(adminhotel).region(usa).avgstar(0).build();
		Hotel h21 = Hotel.builder().hotelname("윈 라스베가스").content("라스베가스 중심에 있는 호텔").user(adminhotel).region(usa).avgstar(0).build();

		h1 = hotelRepository.save(h1);
		h2 = hotelRepository.save(h2);
		h3 = hotelRepository.save(h3);
		h4 = hotelRepository.save(h4);
		h5 = hotelRepository.save(h5);
		h6 = hotelRepository.save(h6);
		h7 = hotelRepository.save(h7);
		h8 = hotelRepository.save(h8);
		h9 = hotelRepository.save(h9);
		h10 = hotelRepository.save(h10);
		h11 = hotelRepository.save(h11);
		h12 = hotelRepository.save(h12);
		h13 = hotelRepository.save(h13);
		h14 = hotelRepository.save(h14);
		h15 = hotelRepository.save(h15);
		h16 = hotelRepository.save(h16);
		h17 = hotelRepository.save(h17);
		h18 = hotelRepository.save(h18);
		h19 = hotelRepository.save(h19);
		h20 = hotelRepository.save(h20);
		h21 = hotelRepository.save(h21);

		hotelRepository.findAll().forEach(System.out::println);
		
		Room r1 = Room.builder().hotel(h1).roomname("스위트").price(27000).bed((long)3).build();
		Room r2 = Room.builder().hotel(h1).roomname("디럭스").price(150000).bed((long)2).build();
		Room r3 = Room.builder().hotel(h1).roomname("패밀리").price(320000).bed((long)1).build();
		Room r4 = Room.builder().hotel(h2).roomname("스위트").price(11000).bed((long)3).build();
		Room r5 = Room.builder().hotel(h2).roomname("디럭스").price(130000).bed((long)2).build();
		Room r6 = Room.builder().hotel(h2).roomname("패밀리").price(220000).bed((long)4).build();
		Room r7 = Room.builder().hotel(h3).roomname("스위트").price(37000).bed((long)1).build();
		Room r8 = Room.builder().hotel(h3).roomname("디럭스").price(150000).bed((long)3).build();
		Room r9 = Room.builder().hotel(h3).roomname("패밀리").price(310000).bed((long)1).build();
		Room r10 = Room.builder().hotel(h4).roomname("스위트").price(11000).bed((long)2).build();
		Room r11 = Room.builder().hotel(h4).roomname("디럭스").price(120000).bed((long)2).build();
		Room r12 = Room.builder().hotel(h4).roomname("패밀리").price(220000).bed((long)1).build();
		Room r13 = Room.builder().hotel(h5).roomname("스위트").price(27000).bed((long)3).build();
		Room r14 = Room.builder().hotel(h5).roomname("디럭스").price(150000).bed((long)2).build();
		Room r15 = Room.builder().hotel(h5).roomname("패밀리").price(320000).bed((long)4).build();
		Room r16 = Room.builder().hotel(h6).roomname("스위트").price(11000).bed((long)3).build();
		Room r17 = Room.builder().hotel(h6).roomname("디럭스").price(130000).bed((long)2).build();
		Room r18 = Room.builder().hotel(h6).roomname("패밀리").price(220000).bed((long)4).build();
		Room r19 = Room.builder().hotel(h7).roomname("스위트").price(27000).bed((long)3).build();
		Room r20 = Room.builder().hotel(h7).roomname("디럭스").price(150000).bed((long)2).build();
		Room r21 = Room.builder().hotel(h7).roomname("패밀리").price(320000).bed((long)1).build();
		Room r22 = Room.builder().hotel(h8).roomname("스위트").price(11000).bed((long)3).build();
		Room r23 = Room.builder().hotel(h8).roomname("디럭스").price(130000).bed((long)2).build();
		Room r24 = Room.builder().hotel(h8).roomname("패밀리").price(220000).bed((long)4).build();
		Room r25 = Room.builder().hotel(h9).roomname("스위트").price(150000).bed((long)2).build();
		Room r26 = Room.builder().hotel(h9).roomname("디럭스").price(320000).bed((long)1).build();
		Room r27 = Room.builder().hotel(h9).roomname("패밀리").price(11000).bed((long)3).build();
		Room r28 = Room.builder().hotel(h10).roomname("스위트").price(130000).bed((long)2).build();
		Room r29 = Room.builder().hotel(h10).roomname("디럭스").price(220000).bed((long)4).build();
		Room r30 = Room.builder().hotel(h10).roomname("패밀리").price(150000).bed((long)2).build();
		Room r31 = Room.builder().hotel(h11).roomname("스위트").price(320000).bed((long)1).build();
		Room r32 = Room.builder().hotel(h11).roomname("디럭스").price(11000).bed((long)3).build();
		Room r33 = Room.builder().hotel(h11).roomname("패밀리").price(130000).bed((long)2).build();
		Room r34 = Room.builder().hotel(h12).roomname("스위트").price(220000).bed((long)4).build();
		Room r35 = Room.builder().hotel(h12).roomname("디럭스").price(150000).bed((long)2).build();
		Room r36 = Room.builder().hotel(h12).roomname("패밀리").price(320000).bed((long)1).build();
		Room r37 = Room.builder().hotel(h13).roomname("스위트").price(11000).bed((long)3).build();
		Room r38 = Room.builder().hotel(h13).roomname("디럭스").price(130000).bed((long)2).build();
		Room r39 = Room.builder().hotel(h13).roomname("패밀리").price(220000).bed((long)4).build();
		Room r40 = Room.builder().hotel(h14).roomname("스위트").price(150000).bed((long)2).build();
		Room r41 = Room.builder().hotel(h14).roomname("디럭스").price(320000).bed((long)1).build();
		Room r42 = Room.builder().hotel(h14).roomname("패밀리").price(11000).bed((long)3).build();
		Room r43 = Room.builder().hotel(h15).roomname("스위트").price(130000).bed((long)2).build();
		Room r44 = Room.builder().hotel(h15).roomname("디럭스").price(220000).bed((long)4).build();
		Room r45 = Room.builder().hotel(h15).roomname("패밀리").price(150000).bed((long)2).build();
		Room r46 = Room.builder().hotel(h16).roomname("스위트").price(320000).bed((long)1).build();
		Room r47 = Room.builder().hotel(h16).roomname("디럭스").price(11000).bed((long)3).build();
		Room r48 = Room.builder().hotel(h16).roomname("패밀리").price(130000).bed((long)2).build();
		Room r49 = Room.builder().hotel(h17).roomname("스위트").price(220000).bed((long)4).build();
		Room r50 = Room.builder().hotel(h17).roomname("디럭스").price(150000).bed((long)2).build();
		Room r51 = Room.builder().hotel(h17).roomname("패밀리").price(320000).bed((long)1).build();
		Room r52 = Room.builder().hotel(h18).roomname("스위트").price(11000).bed((long)3).build();
		Room r53 = Room.builder().hotel(h18).roomname("디럭스").price(130000).bed((long)2).build();
		Room r54 = Room.builder().hotel(h18).roomname("패밀리").price(220000).bed((long)4).build();	
		Room r55 = Room.builder().hotel(h19).roomname("스위트").price(220000).bed((long)4).build();
		Room r56 = Room.builder().hotel(h19).roomname("디럭스").price(150000).bed((long)2).build();
		Room r57 = Room.builder().hotel(h19).roomname("패밀리").price(320000).bed((long)1).build();
		Room r58 = Room.builder().hotel(h20).roomname("스위트").price(11000).bed((long)3).build();
		Room r59 = Room.builder().hotel(h20).roomname("디럭스").price(130000).bed((long)2).build();
		Room r60 = Room.builder().hotel(h20).roomname("패밀리").price(220000).bed((long)4).build();
		Room r61 = Room.builder().hotel(h21).roomname("스위트").price(220000).bed((long)4).build();
		Room r62 = Room.builder().hotel(h21).roomname("디럭스").price(150000).bed((long)2).build();
		Room r63 = Room.builder().hotel(h21).roomname("패밀리").price(320000).bed((long)1).build();

		r1 = roomRepository.save(r1);
		r2 = roomRepository.save(r2);
		r3 = roomRepository.save(r3);
		r4 = roomRepository.save(r4);
		r5 = roomRepository.save(r5);
		r6 = roomRepository.save(r6);
		r7 = roomRepository.save(r7);
		r8 = roomRepository.save(r8);
		r9 = roomRepository.save(r9);
		r10 = roomRepository.save(r10);
		r11 = roomRepository.save(r11);
		r12 = roomRepository.save(r12);
		r13 = roomRepository.save(r13);
		r14 = roomRepository.save(r14);
		r15 = roomRepository.save(r15);
		r16 = roomRepository.save(r16);
		r17 = roomRepository.save(r17);
		r18 = roomRepository.save(r18);
		r19 = roomRepository.save(r19);
		r20 = roomRepository.save(r20);
		r21 = roomRepository.save(r21);
		r22 = roomRepository.save(r22);
		r23 = roomRepository.save(r23);
		r24 = roomRepository.save(r24);
		r25 = roomRepository.save(r25);
		r26 = roomRepository.save(r26);
		r27 = roomRepository.save(r27);
		r28 = roomRepository.save(r28);
		r29 = roomRepository.save(r29);
		r30 = roomRepository.save(r30);
		r31 = roomRepository.save(r31);
		r32 = roomRepository.save(r32);
		r33 = roomRepository.save(r33);
		r34 = roomRepository.save(r34);
		r35 = roomRepository.save(r35);
		r36 = roomRepository.save(r36);
		r37 = roomRepository.save(r37);
		r38 = roomRepository.save(r38);
		r39 = roomRepository.save(r39);
		r40 = roomRepository.save(r40);
		r41 = roomRepository.save(r41);
		r42 = roomRepository.save(r42);
		r43 = roomRepository.save(r43);
		r44 = roomRepository.save(r44);
		r45 = roomRepository.save(r45);
		r46 = roomRepository.save(r46);
		r47 = roomRepository.save(r47);
		r48 = roomRepository.save(r48);
		r49 = roomRepository.save(r49);
		r50 = roomRepository.save(r50);
		r51 = roomRepository.save(r51);
		r52 = roomRepository.save(r52);
		r53 = roomRepository.save(r53);
		r54 = roomRepository.save(r54);
		r55 = roomRepository.save(r55);
		r56 = roomRepository.save(r56);
		r57 = roomRepository.save(r57);
		r58 = roomRepository.save(r58);
		r59 = roomRepository.save(r59);
		r60 = roomRepository.save(r60);
		r61 = roomRepository.save(r61);
		r62 = roomRepository.save(r62);
		r63 = roomRepository.save(r63);
		
		roomRepository.findAll().forEach(System.out::println);
		
		Roomfile rf1 = Roomfile.builder().file("room1.jpg").source("room1.jpg").room(r1.getId()).build();
		Roomfile rf2 = Roomfile.builder().file("room2.jpg").source("room2.jpg").room(r2.getId()).build();
		Roomfile rf3 = Roomfile.builder().file("room3.jpg").source("room3.jpg").room(r3.getId()).build();
		Roomfile rf4 = Roomfile.builder().file("room4.jpg").source("room4.jpg").room(r4.getId()).build();
		Roomfile rf5 = Roomfile.builder().file("room5.jpg").source("room5.jpg").room(r5.getId()).build();
		Roomfile rf6 = Roomfile.builder().file("room6.jpg").source("room6.jpg").room(r6.getId()).build();
		Roomfile rf7 = Roomfile.builder().file("room7.jpg").source("room7.jpg").room(r7.getId()).build();
		Roomfile rf8 = Roomfile.builder().file("room8.jpg").source("room8.jpg").room(r8.getId()).build();
		Roomfile rf9 = Roomfile.builder().file("room9.jpg").source("room9.jpg").room(r9.getId()).build();
		Roomfile rf10 = Roomfile.builder().file("room10.jpg").source("room10.jpg").room(r10.getId()).build();
		Roomfile rf11 = Roomfile.builder().file("room11.jpg").source("room11.jpg").room(r11.getId()).build();
		Roomfile rf12 = Roomfile.builder().file("room12.jpg").source("room12.jpg").room(r12.getId()).build();
		Roomfile rf13 = Roomfile.builder().file("room13.jpg").source("room13.jpg").room(r13.getId()).build();
		Roomfile rf14 = Roomfile.builder().file("room14.jpg").source("room14.jpg").room(r14.getId()).build();
		Roomfile rf15 = Roomfile.builder().file("room15.jpg").source("room15.jpg").room(r15.getId()).build();
		Roomfile rf16 = Roomfile.builder().file("room16.jpg").source("room16.jpg").room(r16.getId()).build();
		Roomfile rf17 = Roomfile.builder().file("room17.jpg").source("room17.jpg").room(r17.getId()).build();
		Roomfile rf18 = Roomfile.builder().file("room18.jpg").source("room18.jpg").room(r18.getId()).build();
		Roomfile rf19 = Roomfile.builder().file("room19.jpg").source("room19.jpg").room(r19.getId()).build();
		Roomfile rf20 = Roomfile.builder().file("room20.jpg").source("room20.jpg").room(r20.getId()).build();
		Roomfile rf21 = Roomfile.builder().file("room21.jpg").source("room21.jpg").room(r21.getId()).build();
		Roomfile rf22 = Roomfile.builder().file("room22.jpg").source("room22.jpg").room(r22.getId()).build();
		Roomfile rf23 = Roomfile.builder().file("room23.jpg").source("room23.jpg").room(r23.getId()).build();
		Roomfile rf24 = Roomfile.builder().file("room24.jpg").source("room24.jpg").room(r24.getId()).build();
		Roomfile rf25 = Roomfile.builder().file("room25.jpg").source("room25.jpg").room(r25.getId()).build();
		Roomfile rf26 = Roomfile.builder().file("room26.jpg").source("room26.jpg").room(r26.getId()).build();
		Roomfile rf27 = Roomfile.builder().file("room27.jpg").source("room27.jpg").room(r27.getId()).build();
		Roomfile rf28 = Roomfile.builder().file("room28.jpg").source("room28.jpg").room(r28.getId()).build();
		Roomfile rf29 = Roomfile.builder().file("room29.jpg").source("room29.jpg").room(r29.getId()).build();
		Roomfile rf30 = Roomfile.builder().file("room30.jpg").source("room30.jpg").room(r30.getId()).build();
		Roomfile rf31 = Roomfile.builder().file("room31.jpg").source("room31.jpg").room(r31.getId()).build();
		Roomfile rf32 = Roomfile.builder().file("room32.jpg").source("room32.jpg").room(r32.getId()).build();
		Roomfile rf33 = Roomfile.builder().file("room33.jpg").source("room33.jpg").room(r33.getId()).build();
		Roomfile rf34 = Roomfile.builder().file("room34.jpg").source("room34.jpg").room(r34.getId()).build();
		Roomfile rf35 = Roomfile.builder().file("room35.jpg").source("room35.jpg").room(r35.getId()).build();
		Roomfile rf36 = Roomfile.builder().file("room36.jpg").source("room36.jpg").room(r36.getId()).build();
		Roomfile rf37 = Roomfile.builder().file("room37.jpg").source("room37.jpg").room(r37.getId()).build();
		Roomfile rf38 = Roomfile.builder().file("room38.jpg").source("room38.jpg").room(r38.getId()).build();
		Roomfile rf39 = Roomfile.builder().file("room39.jpg").source("room39.jpg").room(r39.getId()).build();
		Roomfile rf40 = Roomfile.builder().file("room40.jpg").source("room40.jpg").room(r40.getId()).build();
		Roomfile rf41 = Roomfile.builder().file("room41.jpg").source("room41.jpg").room(r41.getId()).build();
		Roomfile rf42 = Roomfile.builder().file("room42.jpg").source("room42.jpg").room(r42.getId()).build();
		Roomfile rf43 = Roomfile.builder().file("room43.jpg").source("room43.jpg").room(r43.getId()).build();
		Roomfile rf44 = Roomfile.builder().file("room44.jpg").source("room44.jpg").room(r44.getId()).build();
		Roomfile rf45 = Roomfile.builder().file("room45.jpg").source("room45.jpg").room(r45.getId()).build();
		Roomfile rf46 = Roomfile.builder().file("room46.jpg").source("room46.jpg").room(r46.getId()).build();
		Roomfile rf47 = Roomfile.builder().file("room47.jpg").source("room47.jpg").room(r47.getId()).build();
		Roomfile rf48 = Roomfile.builder().file("room48.jpg").source("room48.jpg").room(r48.getId()).build();
		Roomfile rf49 = Roomfile.builder().file("room49.jpg").source("room49.jpg").room(r49.getId()).build();
		Roomfile rf50 = Roomfile.builder().file("room50.jpg").source("room50.jpg").room(r50.getId()).build();
		Roomfile rf51 = Roomfile.builder().file("room51.jpg").source("room51.jpg").room(r51.getId()).build();
		Roomfile rf52 = Roomfile.builder().file("room52.jpg").source("room52.jpg").room(r52.getId()).build();
		Roomfile rf53 = Roomfile.builder().file("room53.jpg").source("room53.jpg").room(r53.getId()).build();
		Roomfile rf54 = Roomfile.builder().file("room54.jpg").source("room54.jpg").room(r54.getId()).build();
		Roomfile rf55 = Roomfile.builder().file("room55.jpg").source("room55.jpg").room(r55.getId()).build();
		Roomfile rf56 = Roomfile.builder().file("room56.jpg").source("room56.jpg").room(r56.getId()).build();
		Roomfile rf57 = Roomfile.builder().file("room57.jpg").source("room57.jpg").room(r57.getId()).build();
		Roomfile rf58 = Roomfile.builder().file("room58.jpg").source("room58.jpg").room(r58.getId()).build();
		Roomfile rf59 = Roomfile.builder().file("room59.jpg").source("room59.jpg").room(r59.getId()).build();
		Roomfile rf60 = Roomfile.builder().file("room60.jpg").source("room60.jpg").room(r60.getId()).build();
		Roomfile rf61 = Roomfile.builder().file("room61.jpg").source("room61.jpg").room(r61.getId()).build();
		Roomfile rf62 = Roomfile.builder().file("room62.jpg").source("room62.jpg").room(r62.getId()).build();
		Roomfile rf63 = Roomfile.builder().file("room63.jpg").source("room63.jpg").room(r63.getId()).build();
		
		rf1 = roomfileRepository.save(rf1);
		rf2 = roomfileRepository.save(rf2);
		rf3 = roomfileRepository.save(rf3);
		rf4 = roomfileRepository.save(rf4);
		rf5 = roomfileRepository.save(rf5);
		rf6 = roomfileRepository.save(rf6);
		rf7 = roomfileRepository.save(rf7);
		rf8 = roomfileRepository.save(rf8);
		rf9 = roomfileRepository.save(rf9);
		rf10 = roomfileRepository.save(rf10);
		rf11 = roomfileRepository.save(rf11);
		rf12 = roomfileRepository.save(rf12);
		rf13 = roomfileRepository.save(rf13);
		rf14 = roomfileRepository.save(rf14);
		rf15 = roomfileRepository.save(rf15);
		rf16 = roomfileRepository.save(rf16);
		rf17 = roomfileRepository.save(rf17);
		rf18 = roomfileRepository.save(rf18);
		rf19 = roomfileRepository.save(rf19);
		rf20 = roomfileRepository.save(rf20);
		rf21 = roomfileRepository.save(rf21);
		rf22 = roomfileRepository.save(rf22);
		rf23 = roomfileRepository.save(rf23);
		rf24 = roomfileRepository.save(rf24);
		rf25 = roomfileRepository.save(rf25);
		rf26 = roomfileRepository.save(rf26);
		rf27 = roomfileRepository.save(rf27);
		rf28 = roomfileRepository.save(rf28);
		rf29 = roomfileRepository.save(rf29);
		rf30 = roomfileRepository.save(rf30);
		rf31 = roomfileRepository.save(rf31);
		rf32 = roomfileRepository.save(rf32);
		rf33 = roomfileRepository.save(rf33);
		rf34 = roomfileRepository.save(rf34);
		rf35 = roomfileRepository.save(rf35);
		rf36 = roomfileRepository.save(rf36);
		rf37 = roomfileRepository.save(rf37);
		rf38 = roomfileRepository.save(rf38);
		rf39 = roomfileRepository.save(rf39);
		rf40 = roomfileRepository.save(rf40);
		rf41 = roomfileRepository.save(rf41);
		rf42 = roomfileRepository.save(rf42);
		rf43 = roomfileRepository.save(rf43);
		rf44 = roomfileRepository.save(rf44);
		rf45 = roomfileRepository.save(rf45);
		rf46 = roomfileRepository.save(rf46);
		rf47 = roomfileRepository.save(rf47);
		rf48 = roomfileRepository.save(rf48);
		rf49 = roomfileRepository.save(rf49);
		rf50 = roomfileRepository.save(rf50);
		rf51 = roomfileRepository.save(rf51);
		rf52 = roomfileRepository.save(rf52);
		rf53 = roomfileRepository.save(rf53);
		rf54 = roomfileRepository.save(rf54);
		rf55 = roomfileRepository.save(rf55);
		rf56 = roomfileRepository.save(rf56);
		rf57 = roomfileRepository.save(rf57);
		rf58 = roomfileRepository.save(rf58);
		rf59 = roomfileRepository.save(rf59);
		rf60 = roomfileRepository.save(rf60);
		rf61 = roomfileRepository.save(rf61);
		rf62 = roomfileRepository.save(rf62);
		rf63 = roomfileRepository.save(rf63);
		
		roomfileRepository.findAll().forEach(System.out::println);
	}

}
