package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
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
    public Result add(@RequestBody CreateColorRequest createColorRequest) {
        return this.colourService.add(createColorRequest);

    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateColorRequest updateColorRequest) {
        return this.colourService.update(updateColorRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
        return this.colourService.delete(deleteColorRequest);
    }

    @GetMapping("/getall")
    public DataResult<List<ListColorDto>> getAll() {
        return this.colourService.getAll();
    }


}
