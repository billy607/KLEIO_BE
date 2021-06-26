package com.kleio.app.controller;

import com.kleio.app.entities.Poi;
import com.kleio.app.service.poiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "api/v1/poi")
@RestController
@AllArgsConstructor
public class PoiController {

    @Autowired
    private final poiService poiService;

    @GetMapping(path = "/{universityId}", name = "get poi information by universityId")
    public List<Poi> getPoiByUniversityId(@PathVariable("universityId") int universityId) {
        return poiService.getPoiByUniversityId(universityId);
    }
}
