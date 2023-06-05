package com.example.railwayinfosystem.controller;

import com.example.railwayinfosystem.model.Train;
import com.example.railwayinfosystem.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/trains")
    public String getTrains(Model model) {
        model.addAttribute("trains", trainService.findAll());
        return "trains";
    }

    @GetMapping("/trains/add")
    public String addTrain(Model model) {
        model.addAttribute("train", new Train());
        return "addTrain";
    }

    @PostMapping("/trains/add")
    public String saveTrain(Train train) {
        trainService.save(train);
        return "redirect:/trains";
    }

    @GetMapping("/trains/search")
    public String displaySearchByNumberForm() {
        return "searchByNumber";
    }

    @PostMapping("/trains/search")
    public String searchTrain(@RequestParam(name="number", required = false) String number, Model model) {
        if(number != null && !number.isEmpty()) {
            model.addAttribute("trains", trainService.findByNumber(number));
        } else {
            model.addAttribute("errorMessage", "No number entered.");
        }
        return "searchResults";
    }

    @GetMapping("/trains/destination")
    public String displaySearchByDestinationForm() {
        return "searchByDestination";
    }

    @PostMapping("/trains/destination")
    public String searchTrainByDestination(@RequestParam(name="destination", required = false) String destination, Model model) {
        if(destination != null && !destination.isEmpty()) {
            model.addAttribute("trains", trainService.findByDestination(destination));
        } else {
            model.addAttribute("errorMessage", "No destination entered.");
        }
        return "searchResults";
    }

}

