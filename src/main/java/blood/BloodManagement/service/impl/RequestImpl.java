package blood.BloodManagement.service.impl;

import blood.BloodManagement.model.BloodDonateRequest;
import blood.BloodManagement.repository.BloodDonateRepository;
import blood.BloodManagement.service.BloodDonateRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequestImpl implements BloodDonateRequestService {
    @Autowired
    private BloodDonateRepository bloodDonateRepository;
    @Override
    public BloodDonateRequest saveBloodDonateRequest(BloodDonateRequest bloodDonateRequest) {
        return bloodDonateRepository.save(bloodDonateRequest);
    }

    @Override
    public void deleteBloodDonateRequest(BloodDonateRequest bloodDonateRequest) {

    }

    @Override
    public List<BloodDonateRequest> getAllRequest() {
        return bloodDonateRepository.findAll();
    }

    @Override
    public BloodDonateRequest getByBloodGroup(String bloodGroup) {
        return null;
    }
}
