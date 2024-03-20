package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.services;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.repository.FlorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorServiceImp implements FlorService {

    @Autowired
    FlorRepository florRepository;


    @Override
    public FlorDTO add(FlorDTO florDTO) {
        Flor flor = FlorDTO.toFlor(florDTO);
        florRepository.save(flor);

        return FlorDTO.toFlorDTO(flor);
    }

    @Override
    public FlorDTO update(Long id, FlorDTO florDTO) {
        Optional<Flor> flor = florRepository.findById(id);

        if (flor.isPresent()) {
            flor.get().setNomFlor(florDTO.getNomFlor()); //update el nom
            flor.get().setPaisFlor(florDTO.getPaisFlor()); //update el pais

            florRepository.save(flor.get());

            return FlorDTO.toFlorDTO(flor.get());
        } else {
            throw new EntityNotFoundException("UPDATE: la flor amb id " + id + ", no s'ha trobat ");
        }
    }

    @Override
    public String deleteById(Long id) {
        Optional<Flor> florOptional = florRepository.findById(id);

        if (florOptional.isPresent()) {
            return "Flor amb id " + id + ", s'ha eliminat correctament";
        } else {
            throw new EntityNotFoundException("DELETE: la flor amb id " + id + ", no s'ha trobat ");
        }
    }

    @Override
    public FlorDTO findById(Long id) {
        Optional<Flor> florOptional = florRepository.findById(id);

        if (florOptional.isEmpty()) {
            throw new EntityNotFoundException("FIND BY ID: la flor amb id " + id + ", no s'ha trobat ");
        } else {
            return FlorDTO.toFlorDTO(florOptional.get());
        }

    }

    @Override
    public List<FlorDTO> findAll() {
        return florRepository.findAll().stream().map(FlorDTO::toFlorDTO).collect(Collectors.toList());
    }
}
