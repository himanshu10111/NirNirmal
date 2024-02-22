package com.neernirmal.NeerNirmal.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neernirmal.NeerNirmal.entity.BookingSlot;
import com.neernirmal.NeerNirmal.repository.BookingSlotRepository;

@Service
public class BookingSlotService {

    @Autowired
    private BookingSlotRepository bookingSlotRepository;

    public BookingSlot bookSlot(BookingSlot slot) {
        int bookedSlots = bookingSlotRepository.countByDate(slot.getDate());
        if (bookedSlots >= 10) {
            throw new IllegalStateException("All slots for this date are booked.");
        }
        return bookingSlotRepository.save(slot); // This returns the saved entity, including the generated ID.
    }

    
    public int remainingSlots(LocalDate date) {
        int bookedSlots = bookingSlotRepository.countByDate(date);
        int totalSlots = 10; // Assuming a fixed number of 10 slots per day
        return Math.max(totalSlots - bookedSlots, 0); // Ensure the remaining slots number is not negative
    }
    
    
    public BookingSlot getBookingById(Long id) {
        return bookingSlotRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking with ID " + id + " not found"));
    }

}
