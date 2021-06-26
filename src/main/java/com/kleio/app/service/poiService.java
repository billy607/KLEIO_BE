package com.kleio.app.service;

import com.kleio.app.entities.Poi;

import java.util.List;

public interface poiService {

    List<Poi> getPoiByUniversityId(int universityId);
}
