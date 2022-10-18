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

import com.lec.spring.domain.BaseEntity;
import com.lec.spring.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity(name="db_airticket")
public class Airticket extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@ToString.Exclude
	private User user;
	@ManyToOne
	@ToString.Exclude
	private Airplane airplane;
	
	@Column(name="seat")
	private String seat;
	
	@OneToMany(mappedBy = "air")  // 삭제등의 동작 발생시 child 도 함께 삭제
	@ToString.Exclude
	@Builder.Default
	private List<Airticket> airticket = new ArrayList<>();
}
