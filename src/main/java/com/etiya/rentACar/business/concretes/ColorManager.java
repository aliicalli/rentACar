package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.ColorDao;
import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Color;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class ColorManager implements ColorService {

    private ColorDao colorDao;
    private ModelMapperService modelMapperService;

    public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
        this.colorDao = colorDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateColorRequest createColorRequest) {

        Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
        ExampleMatcher nameMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id").withMatcher("name", ignoreCase());
        Example<Color> example = Example.of(color, nameMatcher);
        if (!this.colorDao.exists(example)) {
            this.colorDao.save(color);
        } else {
            throw new RuntimeException("Aynı isimden mevcut");
        }


    }

    @Override
    public List<ListColorDto> getAll() {
        List<Color> colors = this.colorDao.findAll();
        List<ListColorDto> response = colors.stream().map(color -> modelMapperService.forDto().map(color, ListColorDto.class)).collect(Collectors.toList());
        return response;
    }


}
