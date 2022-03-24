package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")

public class ColorsController {

    private ColorService colourService;

    public ColorsController(ColorService colourService) {

        this.colourService = colourService;
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateColorRequest createColorRequest) {
        this.colourService.add(createColorRequest);

    }
    @GetMapping("/getall")
    public List<ListColorDto> getAll(){
        return this.colourService.getAll();
    }

}
