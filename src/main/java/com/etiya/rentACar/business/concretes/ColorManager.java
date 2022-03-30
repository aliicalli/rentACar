package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.ColorDao;
import com.etiya.rentACar.entities.Color;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorManager implements ColorService {

    private ColorDao colorDao;
    private ModelMapperService modelMapperService;

    public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
        this.colorDao = colorDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateColorRequest createColorRequest) {

        String colorName = createColorRequest.getName();
        checkIfColorExists(colorName);

        Color result = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
        this.colorDao.save(result);
        return new SuccessResult("COLOR_ADD");

    }

    @Override
    public Result update(UpdateColorRequest updateColorRequest) {
        Color result = this.modelMapperService.forRequest().map(updateColorRequest,Color.class);
        this.colorDao.save(result);
        return new SuccessResult("COLOR_UPDATED");
    }

    @Override
    public Result delete(DeleteColorRequest deleteColorRequest) {
        int colorId = deleteColorRequest.getId();
        this.colorDao.deleteById(colorId);
        return new SuccessResult("COLOR_DELETED");
    }

    @Override
    public DataResult<List<ListColorDto>> getAll() {
        List<Color> results = this.colorDao.findAll();
        List<ListColorDto> response = results.stream().map(color -> modelMapperService.forDto().map(color, ListColorDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListColorDto>>(response);
    }

    private void checkIfColorExists(String colorName){
        if (this.colorDao.existsColorByNameIgnoreCase(colorName)) {
            throw new BusinessException("Bu Renk daha önce kullanılmış");
        }
    }

}
