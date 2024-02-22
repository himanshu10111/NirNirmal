package com.neernirmal.NeerNirmal.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neernirmal.NeerNirmal.entity.BookingSlot;
import com.neernirmal.NeerNirmal.service.BookingSlotService;

@RestController
@RequestMapping("/slots")
public class BookingSlotController {

    @Autowired
    private BookingSlotService bookingSlotService;

    @PostMapping("/book")
    public ResponseEntity<?> bookSlot(@RequestBody BookingSlot slot) {
        try {
            BookingSlot savedSlot = bookingSlotService.bookSlot(slot);
            return ResponseEntity.ok().body("Slot booked successfully with ID: " + savedSlot.getId());
        } catch (IllegalStateException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Long id) {
        try {
            BookingSlot booking = bookingSlotService.getBookingById(id);
            return ResponseEntity.ok().body(booking);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
    @GetMapping("/remaining")
    public ResponseEntity<?> getRemainingSlots(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            int remainingSlots = bookingSlotService.remainingSlots(date);
            return ResponseEntity.ok().body("Remaining slots for " + date + ": " + remainingSlots);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving remaining slots: " + e.getMessage());
        }
    }
}