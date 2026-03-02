package tn.esprit.studentmanagement.services;

import tn.esprit.studentmanagement.entities.Enrollment;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentService implements IEnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElseThrow(() -> 
            new EnrollmentNotFoundException("Enrollment with id " + id + " not found"));
    }

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public Department getDepartmentById(Long id) {
        // Your code logic
        if (department == null) {
            throw new EntityNotFoundException("Department not found for ID: " + id);
        }
    }
}
