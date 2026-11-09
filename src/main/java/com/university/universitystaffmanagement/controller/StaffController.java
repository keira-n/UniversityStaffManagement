
package com.university.universitystaffmanagement.controller;

import com.university.universitystaffmanagement.models.Staff;
import com.university.universitystaffmanagement.service.StaffService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    // Get all staff
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    // Get staff by ID
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(
            @PathVariable String id) {

        return staffService.getStaffById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add staff
    @PostMapping
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    // Update staff
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(
            @PathVariable String id,
            @RequestBody Staff staff) {

        return staffService.updateStaff(id, staff)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete staff
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(
            @PathVariable String id) {

        if (staffService.getStaffById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        staffService.deleteStaff(id);

        return ResponseEntity.noContent().build();
    }
}
