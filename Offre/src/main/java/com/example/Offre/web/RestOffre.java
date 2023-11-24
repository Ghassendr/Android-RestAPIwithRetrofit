package com.example.Offre.web;

import com.example.Offre.dao.OffreRepository;
import com.example.Offre.entity.Offre;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offre")
@RequiredArgsConstructor
public class RestOffre {
    private final OffreRepository offreRepository;
    @GetMapping
    public List<Offre>getAll(){
        return offreRepository.findAll();
    }
    @GetMapping("/{id}")
    public Offre getById(@PathVariable int id){
        return offreRepository.findById(id).get();
    }
    @PostMapping
    public Offre save(@RequestBody Offre offre){
        return offreRepository.save(offre);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        offreRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Offre update(@PathVariable int id,@RequestBody Offre offre){
        offre.setCode(id);
        return offreRepository.save(offre);
    }
}