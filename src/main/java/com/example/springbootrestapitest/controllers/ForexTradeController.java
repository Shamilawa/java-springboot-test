package com.example.springbootrestapitest.controllers;

import com.example.springbootrestapitest.models.ForexTrade;
import com.example.springbootrestapitest.repository.ForexTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class ForexTradeController {

    @Autowired
    private ForexTradeRepository forexTradeRepository;

    @GetMapping
    public List<ForexTrade> getAllForexTrades() {
        return forexTradeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<ForexTrade> createTrade(@RequestBody ForexTrade forexTrade) {
        ForexTrade savedForexTrade = forexTradeRepository.save(forexTrade);
        return new ResponseEntity<>(savedForexTrade, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ForexTrade getForexTradeById(@PathVariable Long id) {
        return forexTradeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForexTrade> updateForexTradeById(@PathVariable Long id, @RequestBody ForexTrade forexTrade) {
        forexTrade.setTradeId(id);
        ForexTrade updatedForexTrade = forexTradeRepository.save(forexTrade);
        return new ResponseEntity<>(updatedForexTrade, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteForexTradeById(@PathVariable Long id){
        forexTradeRepository.deleteById(id);
    }
}
