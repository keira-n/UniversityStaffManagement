
package com.university.universitystaffmanagement.service;

import com.university.universitystaffmanagement.models.Staff;
import com.university.universitystaffmanagement.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    // Get all staff
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // Get staff by ID
    public Optional<Staff> getStaffById(String id) {
        return staffRepository.findById(id);
    }

    // Add staff
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    // Update staff
    public Optional<Staff> updateStaff(String id, Staff updatedStaff) {
        return staffRepository.findById(id).map(existingStaff -> {
            existingStaff.setName(updatedStaff.getName());
            existingStaff.setEmail(updatedStaff.getEmail());
            existingStaff.setDepartment(updatedStaff.getDepartment());
            existingStaff.setPosition(updatedStaff.getPosition());
            existingStaff.setPhone(updatedStaff.getPhone());

            return staffRepository.save(existingStaff);
        });
    }

    // Delete staff
    public void deleteStaff(String id) {
        staffRepository.deleteById(id);
    }
}
