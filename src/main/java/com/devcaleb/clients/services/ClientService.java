package com.devcaleb.clients.services;

import com.devcaleb.clients.dto.ClientDTO;
import com.devcaleb.clients.entities.Client;
import com.devcaleb.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).get();
        return new ClientDTO(client);
    }

}
