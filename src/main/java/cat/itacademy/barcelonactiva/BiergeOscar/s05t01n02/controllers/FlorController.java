package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.controllers;

import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.services.FlorService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    FlorService florService;

    //add
    @GetMapping("/add")
    public ResponseEntity<FlorDTO> addFlor (FlorDTO florDTO){
        FlorDTO florDTO1 = florService.add(florDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(florDTO1);

    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<FlorDTO> updateFlor (@PathVariable Long id, @RequestBody FlorDTO florDTO){
        try {
            FlorDTO florDTO1 = florService.update(id, florDTO);
            return ResponseEntity.ok(florDTO1);
        } catch (EntityNotFoundException enfe) {
            enfe.getMessage();
            return ResponseEntity.notFound().build();
        }
    }

    //deleteById
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlor(@PathVariable Long id){
        try{
            String mensaje = florService.deleteById(id);
            return ResponseEntity.ok(mensaje);
        } catch (EntityNotFoundException enfe) {
            enfe.getMessage();
            return  ResponseEntity.notFound().build();

        }
    }

    //getOne
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO> getOneFlor (@PathVariable Long id){
        try {
            FlorDTO florDTO = florService.findById(id);
            return ResponseEntity.ok(florDTO);
        }catch (EntityNotFoundException enfe){
            enfe.getMessage();
            return ResponseEntity.notFound().build();
        }
    }

    //getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getAllFlors(){
        List<FlorDTO> flores = florService.findAll();

        if (flores.isEmpty()){
            return  ResponseEntity.notFound().build();
        }else {
            return  ResponseEntity.ok(flores);
        }
    }
}
