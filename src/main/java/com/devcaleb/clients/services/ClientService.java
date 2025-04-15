package com.devcaleb.clients.services;

import com.devcaleb.clients.dto.ClientDTO;
import com.devcaleb.clients.entities.Client;
import com.devcaleb.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        copyDTOToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    private void copyDTOToEntity(ClientDTO dto, Client client) {
        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setChildren(dto.getChildren());
        client.setBirthDate(dto.getBirthDate());
    }

}
