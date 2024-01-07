package com.playdata.eungae.appointment.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.eungae.appointment.domain.Appointment;
import com.playdata.eungae.appointment.dto.ResponseDetailMedicalHistoryDto;
import com.playdata.eungae.appointment.repository.AppointmentRepository;
import com.playdata.eungae.review.domain.Review;
import com.playdata.eungae.review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

	private final AppointmentRepository appointmentRepository;
	private final ReviewRepository reviewRepository;
	private final int PAGE_SIZE = 20;

	@Transactional(readOnly = true)
	public ResponseDetailMedicalHistoryDto findMedicalHistory(Long appointmentSeq) {

		Appointment appointment = appointmentRepository.findAllWithReview(appointmentSeq)
			.orElseThrow(() -> new IllegalStateException("Can not found Appointment Entity"));
		ResponseDetailMedicalHistoryDto responseDetailMediclaHistoryDto = ResponseDetailMedicalHistoryDto.toDto(appointment);
		responseDetailMediclaHistoryDto.setWriteReview(reviewRepository.findById(appointment.getReviewSeq())
				.isPresent());
		return responseDetailMediclaHistoryDto;

	}
}
