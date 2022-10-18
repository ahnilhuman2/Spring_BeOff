package com.lec.spring.domain.air;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.lec.spring.domain.Region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity(name="db_airplane")
public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@ToString.Exclude
	private Region depart;
	@ManyToOne
	@ToString.Exclude
	private Region arrive;
	@ManyToOne
	@ToString.Exclude
	private Airtime time;
	@ManyToOne
	@ToString.Exclude
	private Airname name;
	
	@Column(name="date", nullable=false)
	private Long date;
	
	@OneToMany(mappedBy = "air")  // 삭제등의 동작 발생시 child 도 함께 삭제
	@ToString.Exclude
	@Builder.Default
	private List<Airticket> airticket = new ArrayList<>();
}
