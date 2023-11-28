package com.GreenCodeSolution.CollectionOfData.api;
import com.GreenCodeSolution.CollectionOfData.dto.request.RequestClientDto;
import com.GreenCodeSolution.CollectionOfData.service.ClientService;
import com.GreenCodeSolution.CollectionOfData.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    public ResponseEntity<StandardResponse> saveMember(@RequestBody RequestClientDto requestClientDto) {
         clientService.addClient(requestClientDto);
         return new ResponseEntity<>(
                 new StandardResponse(201,"saved",requestClientDto.getFullName()),
                 HttpStatus.CREATED
         );
    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateClient(
            @RequestParam Long id,
            @RequestBody RequestClientDto requestClientDto
    ){
        clientService.updateClient(id,requestClientDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Client data Updated !",
                        requestClientDto.getFullName()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findClient(@PathVariable long id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Client data!",
                        clientService.getclient(id)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Client data!",id),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(path = "/list", params = {"searchText","page","size"})

    public ResponseEntity<StandardResponse> findAllClient (

        @RequestParam String searchText,
        @RequestParam int page,
        @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(200,"Client data!",clientService.getAllClients(
                        searchText,page,size)),
                HttpStatus.OK
        );

    }
}
