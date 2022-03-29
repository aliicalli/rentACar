package com.etiya.rentACar.business.abstracts;


import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;

import java.util.List;

public interface ColorService {

    void add(CreateColorRequest createColorRequest);
    void update(UpdateColorRequest updateColorRequest);
    void  delete(DeleteColorRequest deleteColorRequest);

    List<ListColorDto> getAll();
}
