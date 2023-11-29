package com.GreenCodeSolution.CollectionOfData.util.mapper;
import com.GreenCodeSolution.CollectionOfData.dto.request.RequestClientDto;
import com.GreenCodeSolution.CollectionOfData.dto.response.RespomseClientDto;
import com.GreenCodeSolution.CollectionOfData.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ClientMapper {
    RespomseClientDto toResponseClientDto(Client client);
    Client toClient(RequestClientDto dto);
    List<RespomseClientDto> toResponseClientDtoList(List<Client> list);
}
