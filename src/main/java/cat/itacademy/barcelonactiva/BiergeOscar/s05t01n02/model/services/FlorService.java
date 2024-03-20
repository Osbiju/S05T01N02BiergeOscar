package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.services;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto.FlorDTO;

import java.util.List;

public interface FlorService {

    //add
    FlorDTO add (FlorDTO florDTO);

    //update
    FlorDTO update (Long id, FlorDTO florDTO);

    //delete
    String deleteById (Long id);

    //getOne
    FlorDTO findById (Long id);

    //getAll
    List<FlorDTO> findAll();

}
