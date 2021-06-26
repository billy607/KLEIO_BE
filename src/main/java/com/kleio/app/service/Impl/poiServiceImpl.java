package com.kleio.app.service.Impl;

import com.kleio.app.entities.Poi;
import com.kleio.app.repository.PoiRepository;
import com.kleio.app.service.poiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class poiServiceImpl implements poiService {

    @Autowired
    private final PoiRepository poiRepository;

    @Override
    public List<Poi> getPoiByUniversityId(final int universityId) {
        return poiRepository.getByUniversityId(universityId);
    }
}
