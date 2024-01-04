package com.playdata.eungae.member.domain;

import com.playdata.eungae.member.dto.MemberUpdateRequestDto;
import org.hibernate.annotations.DynamicInsert;

import com.playdata.eungae.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "member")
@Entity
public class Member extends BaseEntity {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long memberSeq;

	@Column(nullable = false, unique = true, updatable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false, length = 15)
	private String phoneNumber;

	@Column(nullable = false)
	private String birthDate;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String addressDetail;

	@Column(nullable = false)
	private String zipCode;

	private Integer xCoordinate;

	private Integer yCoordinate;
	
	@Column(columnDefinition = "varchar(5) default '0'")
	private boolean kakaoCheck;

	public void updateMemberDetails(MemberUpdateRequestDto updateRequestDto){
		this.name = updateRequestDto.getName();
		this.phoneNumber = updateRequestDto.getPhoneNumber();
		this.address = updateRequestDto.getAddress();
		this.addressDetail = updateRequestDto.getAddressDetail();
		this.zipCode = updateRequestDto.getZipCode();
	}
}
