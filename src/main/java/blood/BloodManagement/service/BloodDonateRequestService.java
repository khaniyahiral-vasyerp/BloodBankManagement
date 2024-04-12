package blood.BloodManagement.service;

import blood.BloodManagement.model.BloodDonateRequest;

import java.util.List;

public interface BloodDonateRequestService {
     BloodDonateRequest saveBloodDonateRequest(BloodDonateRequest bloodDonateRequest);

    public void deleteBloodDonateRequest(BloodDonateRequest bloodDonateRequest);

    List<BloodDonateRequest> getAllRequest();

    BloodDonateRequest getByBloodGroup(String bloodGroup);
}
