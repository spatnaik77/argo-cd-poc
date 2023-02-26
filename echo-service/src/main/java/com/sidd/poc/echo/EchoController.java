package com.sidd.poc.echo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {


    public EchoController()
    {

    }
    @GetMapping("/{msg}")
    public String  echo(@PathVariable("msg") String msg) 
    {
        return "hello " + msg;
    }
    
}
