package com.devcaleb.clients.services;

import com.devcaleb.clients.dto.ClientDTO;
import com.devcaleb.clients.entities.Client;
import com.devcaleb.clients.repositories.ClientRepository;
import com.devcaleb.clients.services.exceptions.DatabaseExceptions;
import com.devcaleb.clients.services.exceptions.ResourceNotFoundExceptions;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Client not found!"));
        return new ClientDTO(client);
    }

    @Transactional
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        copyDTOToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        try{
            Client client = clientRepository.getReferenceById(id);
            copyDTOToEntity(dto, client);
            client = clientRepository.save(client);
            return new ClientDTO(client);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundExceptions("Client not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundExceptions("Resource not found!");
        }
        try {
            clientRepository.deleteById(id);
            throw new ResourceNotFoundExceptions("Good, client deleted!");
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseExceptions("Referential Integrity Failure!");
        }
    }

    private void copyDTOToEntity(ClientDTO dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setChildren(dto.getChildren());
        client.setBirthDate(dto.getBirthDate());
    }

}
