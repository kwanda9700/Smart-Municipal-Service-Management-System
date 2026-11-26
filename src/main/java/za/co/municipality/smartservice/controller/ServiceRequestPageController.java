package za.co.municipality.smartservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.municipality.smartservice.service.ServiceRequestService;

@Controller
public class ServiceRequestPageController {
    private final ServiceRequestService service;

    public ServiceRequestPageController(ServiceRequestService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("requests", service.getAllRequests());
        return "requests";
    }
}
