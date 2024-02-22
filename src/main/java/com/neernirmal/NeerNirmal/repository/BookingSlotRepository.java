package com.neernirmal.NeerNirmal.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neernirmal.NeerNirmal.entity.BookingSlot;

@Repository
public interface BookingSlotRepository extends JpaRepository<BookingSlot, Long> {
    int countByDate(LocalDate date);
    
    
}