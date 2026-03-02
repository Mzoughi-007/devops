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
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        // Your code logic
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found for ID: " + id);
        }
    }
}
