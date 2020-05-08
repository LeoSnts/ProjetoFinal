package santos.leonardo.databasemanha.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santos.leonardo.databasemanha.model.MoradorEntity;
import santos.leonardo.databasemanha.repository.MoradorRepository;

import java.util.List;
@RestController
@RequestMapping("/moradores")
public class MoradorControle {

    @Autowired
    private MoradorRepository moradorRepository;



    @GetMapping
    public ResponseEntity<List<MoradorEntity>> findAll (){
        return new ResponseEntity<List<MoradorEntity>>(
                (List<MoradorEntity>) this.moradorRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MoradorEntity> findById(@PathVariable("id") long id) {
        if(this.moradorRepository.findById(id).isPresent()){
            return new ResponseEntity<MoradorEntity>(
                    this.moradorRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<MoradorEntity>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<MoradorEntity> cadastrar (@RequestBody MoradorEntity bandaEntity) {
        return new ResponseEntity<MoradorEntity> (
                this.moradorRepository.save(bandaEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<MoradorEntity> atualizar (@PathVariable("id") long id,
                                                  @RequestBody MoradorEntity moradorEntity) throws Exception {

        if(id == 0 || !this.moradorRepository.existsById(id)){
            throw  new Exception("Código não encontrado!");

        }
        return new ResponseEntity<MoradorEntity>(
                this.moradorRepository.save(moradorEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MoradorEntity> deletar (@PathVariable("id") long id ){
        this.moradorRepository.deleteById(id);
        return new ResponseEntity<MoradorEntity>(new HttpHeaders(), HttpStatus.OK);
    }
}

