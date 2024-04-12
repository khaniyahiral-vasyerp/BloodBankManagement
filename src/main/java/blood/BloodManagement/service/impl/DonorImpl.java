package blood.BloodManagement.service.impl;

import blood.BloodManagement.model.Donor;
import blood.BloodManagement.repository.DonorRepository;
import blood.BloodManagement.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorImpl  implements DonorService {
    @Autowired
    private DonorRepository repository;


    @Override
    public Donor addDonor(Donor donor) {
        return repository.save(donor);
    }

    @Override
    public List<Donor> getAllDonors() {
        return repository.findAll();
    }
}
