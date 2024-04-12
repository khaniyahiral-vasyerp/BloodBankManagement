package blood.BloodManagement.repository;

import blood.BloodManagement.model.BloodDonateRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BloodDonateRepository extends JpaRepository<BloodDonateRequest,Long> {

    BloodDonateRequest findByBloodGroup(String bloodGroup);
}
