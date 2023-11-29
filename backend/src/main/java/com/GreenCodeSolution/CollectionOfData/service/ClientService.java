package com.GreenCodeSolution.CollectionOfData.service;

import com.GreenCodeSolution.CollectionOfData.dto.request.RequestClientDto;
import com.GreenCodeSolution.CollectionOfData.dto.response.paginated.PaginatedClientResponseDto;

public interface ClientService {
    void addClient(RequestClientDto requestClientDto);
    public void updateClient(long id, RequestClientDto requestClientDto);
    Object getclient(long id);
    public void deleteClient(long id);
    public PaginatedClientResponseDto getAllClients(String searchText, int page, int size);
}
