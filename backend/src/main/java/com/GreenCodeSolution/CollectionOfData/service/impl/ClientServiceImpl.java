package com.GreenCodeSolution.CollectionOfData.service.impl;
import com.GreenCodeSolution.CollectionOfData.dto.request.RequestClientDto;
import com.GreenCodeSolution.CollectionOfData.dto.response.RespomseClientDto;
import com.GreenCodeSolution.CollectionOfData.dto.response.paginated.PaginatedClientResponseDto;
import com.GreenCodeSolution.CollectionOfData.entity.Client;
import com.GreenCodeSolution.CollectionOfData.repo.ClientRepo;
import com.GreenCodeSolution.CollectionOfData.service.ClientService;
import com.GreenCodeSolution.CollectionOfData.util.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo, ClientMapper clientMapper) {
        this.clientRepo = clientRepo;
        this.clientMapper = clientMapper;
    }

    private final ClientMapper clientMapper;

    @Override
    public void addClient(RequestClientDto requestClientDto) {
        UUID uuid = UUID.randomUUID();
        long clientId = uuid.getMostSignificantBits();


        Client client = new Client(
                clientId,
                requestClientDto.getFullName(),
                requestClientDto.getNic(),
                requestClientDto.getBirthOfDate(),
                requestClientDto.getPhone(),
                requestClientDto.getAddress(),
                requestClientDto.getGender(),
                requestClientDto.getSchool()
        );
        clientRepo.save(client);
    }

    @Override
    public void updateClient(long id, RequestClientDto requestClientDto) {
        Optional<Client>selectedClient=clientRepo.findById(id);
        if (selectedClient.isEmpty()){
            throw new RuntimeException("Client Not Found");
        }
        Client client=selectedClient.get();
        client.setFullName(requestClientDto.getFullName());
        client.setNic(requestClientDto.getNic());
        client.setBirthOfDate(requestClientDto.getBirthOfDate());
        client.setPhone(requestClientDto.getPhone());
        client.setAddress(requestClientDto.getAddress());
        client.setGender(requestClientDto.getGender());
        client.setSchool(requestClientDto.getSchool());
        clientRepo.save(client);
    }


    @Override
    public Object getclient(long id) {
        Optional<Client>selectedClient=clientRepo.findById(id);
        if (selectedClient.isEmpty()){
            throw new RuntimeException("Doctor Not Found !");
        }
       return clientMapper.toResponseClientDto(selectedClient.get());
    }

    @Override
    public PaginatedClientResponseDto getAllClients(String searchText, int page, int size) {
        List<Client>client=clientRepo.searchClient(searchText,PageRequest.of(page,size));
        long clientcount=clientRepo.countClient("%" + searchText + "%");
        List<RespomseClientDto>dtos= clientMapper.toResponseClientDtoList(client);
        return new PaginatedClientResponseDto(
                clientcount,
                dtos
        );
    }


    public void deleteClient(long id){
        Optional<Client>selectedClient=clientRepo.findById(id);
        if (selectedClient.isEmpty()){
            throw new RuntimeException("Client Not Found");
        }
        clientRepo.deleteById(selectedClient.get().getId());
    }

}
