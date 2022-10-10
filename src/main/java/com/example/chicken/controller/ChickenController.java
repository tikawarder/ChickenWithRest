package com.example.chicken.controller;

import com.example.chicken.domain.Chicken;
import com.example.chicken.entity.ChickenEntity;
import com.example.chicken.repository.ChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chicken")
public class ChickenController {

    @Autowired
    private ChickenRepository repository;

    @GetMapping("/chicken")
    public ResponseEntity<String> findChickenCommunication (){
        String variable = "Kot-kot";
        return ResponseEntity.of(Optional.of(variable));
    }

    @GetMapping("/{chickenName}")
    public ResponseEntity<Chicken> getPista (@PathVariable(name="chickenName") String name){
        Chicken chicken = Chicken.builder()
                .id(666)
                .eggNumber(12)
                .name(name)
                                 .build();
        return ResponseEntity.ok(chicken);
    }

    @GetMapping("/chickenname/{chickenName}/eggnumber/{eggNumber}")
    public ResponseEntity<Chicken> getPistaAndEgg (@PathVariable(name="chickenName") String name, @PathVariable(name="eggNumber") int egg){
        Chicken chicken = Chicken.builder()
                                 .id(666)
                                 .eggNumber(egg)
                                 .name(name)
                                 .build();
        return ResponseEntity.ok(chicken);
    }

    @GetMapping("/chickenname")
    public ResponseEntity<Chicken> getPista2 (@RequestParam(name="chickenName") String name){
        Chicken chicken = Chicken.builder()
                                 .id(666)
                                 .eggNumber(12)
                                 .name(name)
                                 .build();
        return ResponseEntity.ok(chicken);
    }

    @PostMapping("/chickenName2")
    public ResponseEntity<Chicken> getPista3 (@RequestBody Chicken chicken){
        Chicken chicken2 = Chicken.builder()
                                 .id(chicken.getId()+1)
                                 .eggNumber(chicken.getEggNumber()+1)
                                 .name(chicken.getName()+"response")
                                 .build();
        return ResponseEntity.ok(chicken2);
    }

    @PostMapping("/createChicken")
    public ResponseEntity<ChickenEntity> createChicken (@RequestBody ChickenEntity chickenEntity){
        ChickenEntity createdChicken = repository.save(chickenEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChicken);
    }

    @GetMapping("/getchickenbyid")
    public ResponseEntity<ChickenEntity> getChickenById(@RequestParam(name="getchickenbyid") int id){
        ChickenEntity getChicken =  repository.findById(id).get();
        return ResponseEntity.ok(getChicken);
    }
}

