package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LegendsService {

    @Autowired
    private LegendsRepository legendsRepository;

    // create

    public Legend addLegend(Legend legend) {
        // Save the legend to the database
        Legend newLegend = legendsRepository.save(legend);
        return newLegend;
    }

    // read



    public List<Legend> getLegendsByLane(String lane, int limit) {

        List<Legend> legends = legendsRepository.getAllByLane(lane);


        return legends
                .stream()
                .limit(limit)
                .collect(Collectors.toList());

    }

    public List<Legend> getAllLegends(int limit) {

      List<Legend> test = legendsRepository.getAllByName();


        return test
                .stream()
                .limit(limit)
                .collect(Collectors.toList());

    }

    public Legend getLegendById(long id) {
        return legendsRepository.findById(id).orElseThrow(() -> new LegendNotFoundException("Greeting Not Found"));
    }

    public List<Legend> getLegendByName(String name) {
        return legendsRepository.getByName(name);
    }

    // update

    @Modifying
    public Legend updateLegend(Legend newLegend, long id) {
        System.out.println("Updated Legend : " + newLegend);
        System.out.println(id);
        if (!legendsRepository.existsById(id)) {
            throw new LegendNotFoundException("Legend Not Found");
        }

        newLegend.setId(id);

        Legend updatedLegend = legendsRepository.save(newLegend);

        return updatedLegend;
    }

    // delete

    @Transactional
    public void deleteLegendById(long id) {
        if (!legendsRepository.existsById(id)) {
            throw new LegendNotFoundException("Legend Not Found");
        }

        legendsRepository.deleteLegendById(id);
    }
}
