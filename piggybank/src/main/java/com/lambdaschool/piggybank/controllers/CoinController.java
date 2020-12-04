package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CoinController {
    @Autowired
    CoinRepository coinreops;

    private double printMoney(List<Coin> myCoins)
    {
        double total = 0.0;
        for (Coin c : myCoins)
        {
            if(c.getQuantity() > 1)
            {
                System.out.println(c.getQuantity() + " " + c.getNameplural());
                total = total + c.getQuantity() * c.getValue();
            } else if (c.getQuantity() == 1){
                System.out.println("1 " + c.getName());
                total = total + c.getValue();
            }
        }
        return total;
    }

//     http://localhost:2019/total
    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<?> piggybankTotal()
    {
        List<Coin> myCoins = new ArrayList<>();
        coinreops.findAll().iterator().forEachRemaining(myCoins::add);
        double total = printMoney(myCoins);
        System.out.println("The piggy bank holds " + total);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // http://localhost:2019/money/{ammount}
    @GetMapping(value = "/money/{ammount}", produces = "application/json")
    public ResponseEntity<?> removeMoney(@PathVariable double ammount)
    {
        List<Coin> myCoins = new ArrayList<>();
        coinreops.findAll().iterator().forEachRemaining(myCoins::add);
        double reduceMoney = ammount;
        for (Coin c : myCoins)
        {

            while(Math.round((reduceMoney - c.getValue()) * 100.0) / 100.0 >= 0 && c.getQuantity() > 0)
            {
                reduceMoney = Math.round((reduceMoney - c.getValue()) * 100.0) / 100.0;
                c.setQuantity(c.getQuantity() - 1);
            }
        }

        double total = printMoney(myCoins);
        if(reduceMoney > 0.0)
        {
            System.out.println("Money not available");
        } else {
            System.out.println("The piggy bank holds " + total);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
