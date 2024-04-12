package blood.BloodManagement.controller;

import blood.BloodManagement.model.BloodDonateRequest;
import blood.BloodManagement.model.Donor;
import blood.BloodManagement.service.BloodDonateRequestService;

import blood.BloodManagement.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blood")
public class HomeController {
    @Autowired
    private BloodDonateRequestService requestService;
    @Autowired
    private DonorService donorService;
    @RequestMapping ("/home")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;

    }
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/addBloodDonateRequest")
    public ModelAndView addBloodDonateRequest(ModelAndView modelAndView) {
        modelAndView.setViewName("addBloodDonateRequest");
        return modelAndView;
    }
    @PostMapping("/saveBloodDonateRequest")
    public ModelAndView saveBloodDonateRequest(BloodDonateRequest bloodDonateRequest) {
        requestService.saveBloodDonateRequest(bloodDonateRequest);
        return new ModelAndView("redirect:/blood/home");
    }
    @RequestMapping("/addDonor")
    public ModelAndView addDonor(ModelAndView modelAndView) {
        modelAndView.setViewName("addDoner");
        Donor donor = new Donor();
        modelAndView.addObject("donor", donor);
        return modelAndView;
    }
    @RequestMapping("/viewDonor")
    public ModelAndView viewDonor(ModelAndView modelAndView) {
        modelAndView.setViewName("viewDonor");
        modelAndView.addObject("donors", donorService.getAllDonors());
        return modelAndView;
    }
    @PostMapping("/addDonor")
    public ModelAndView saveDonor(Donor donor) {
        donorService.addDonor(donor);
        return new ModelAndView("redirect:/blood/viewDonor");
    }

}
