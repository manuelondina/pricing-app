package com.inditex.testapp.app.mapper;

import org.mapstruct.Mapper;

import com.inditex.testapp.app.dto.ResponseDTO;
import com.inditex.testapp.domain.model.Price;

@Mapper(componentModel = "spring")
public interface ResponseMapper extends EntityMapper<ResponseDTO, Price> {
}