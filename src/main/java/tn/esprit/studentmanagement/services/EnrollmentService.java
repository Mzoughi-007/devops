package tn.esprit.studentmanagement.services;

import tn.esprit.studentmanagement.entities.Enrollment;
import tn.esprit.studentmanagement.repositories.EnrollmentRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        // Retrieve enrollment from repository
        Optional<Enrollment> enrollment = enrollmentRepository.findById(id);
        
        // If the enrollment is not found, throw exception
        if (!enrollment.isPresent()) {
            throw new EntityNotFoundException("Enrollment not found for ID: " + id);
        }
        
        return enrollment.get();  // Return the found enrollment
    }

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
