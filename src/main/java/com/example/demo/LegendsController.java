package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class LegendsController {

    @Autowired
    LegendsService legendsService;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(LegendNotFoundException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


    // create

    @PostMapping("/legend")
    public ResponseEntity<Legend> createLegend(@RequestBody Legend legend) {
        Legend newLegend = legendsService.addLegend(legend);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLegend);
    }

    // read

    @GetMapping("/legends")
    public ResponseEntity<List<Legend>> getLegends(@RequestParam(required = false) String lane, @RequestParam(defaultValue = "10") int limit) {


        if (lane != null) {
            return ResponseEntity.status(HttpStatus.OK).body(legendsService.getLegendsByLane(lane, limit));
        }

        return ResponseEntity.status(HttpStatus.OK).body(legendsService.getAllLegends(limit));

    }

    @GetMapping("/legend")
    public ResponseEntity<String> getLegend() {
        return ResponseEntity.status(HttpStatus.OK).body("This is a test");
    }



    // update

    @PutMapping("/legend/{id}")
    public ResponseEntity<Legend> updateLegend(@RequestBody Legend newLegend, @PathVariable long id) {
        Legend updatedLegend = legendsService.updateLegend(newLegend, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedLegend);
    }

    // delete

    @DeleteMapping("/legend/{id}")
    public ResponseEntity<Void> deleteLegendById(@PathVariable long id) {
        legendsService.deleteLegendById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
