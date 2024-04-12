package blood.BloodManagement.service;

import blood.BloodManagement.model.Donor;

import java.util.List;

public interface DonorService {
    Donor addDonor(Donor donor);
    List<Donor> getAllDonors();
}
