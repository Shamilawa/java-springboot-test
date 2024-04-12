package com.example.springbootrestapitest.controllers;

import com.example.springbootrestapitest.models.ForexTrade;
import com.example.springbootrestapitest.repository.ForexTradeRepository;
import com.example.springbootrestapitest.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class ForexTradeController {
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @Autowired
    private ForexTradeRepository forexTradeRepository;

    @GetMapping
    public List<ForexTrade> getAllForexTrades() {
        return forexTradeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createTrade(@RequestBody ForexTrade forexTrade) {
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
    public void deleteForexTradeById(@PathVariable Long id) {
        forexTradeRepository.deleteById(id);
    }

    //adding entry and exit screenshot
    @PostMapping("/entry-image/{id}")
    public void addEntryScreenshotByForexTradeId(@PathVariable Long id,  @RequestParam("entryScreenshot") MultipartFile entryScreenshot) throws IOException {
        ForexTrade foundForexTrade = forexTradeRepository.findById(id).orElse(null);

        if (foundForexTrade != null) {
            try {
                //need to upload the img and get the url
                String entryScreenshotUrl = firebaseStorageService.uploadFile("trade-entry-" + foundForexTrade.getSymbol() + foundForexTrade.getTradeId(), entryScreenshot);
                foundForexTrade.setEntryScreenshotUrl(entryScreenshotUrl);

                //save the forex trade with the entry url
                ForexTrade savedForexTrade = forexTradeRepository.save(foundForexTrade);

                System.out.println(foundForexTrade.getEntryScreenshotUrl());
                System.out.println(savedForexTrade.getEntryScreenshotUrl());
            } catch (IOException e){
                System.out.println(e);
            }
        } else {
            System.out.println("No Trade found");
        }
    }
}
