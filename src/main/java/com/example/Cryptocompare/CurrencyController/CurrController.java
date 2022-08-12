package com.example.Cryptocompare.CurrencyController;


import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.Cryptocompare.RedisService;
import com.example.Cryptocompare.CurrencyModel.Currxx;
import com.example.Cryptocompare.CurrencyModel.jsontojava;

@Controller
public class CurrController {
    
    RestTemplate template = new RestTemplate();
    //line 15, send http request to API provider to get data, like a POSTMAN

    // @Autowired
    // RedisService service;

    @GetMapping("/")
    public String getHome(@ModelAttribute Currxx currObject){
        
        return "index";
    }

    //submitted form goes to Postmapping
    // use comma to seperate argument like line 26
    // don't put API call in GetMapping because that's landing page, need PostMapping to do API call
    @PostMapping("showcurrency")
    public String getCurr(Model model, @ModelAttribute Currxx currObject){
        
        //? is start of request parameter, get request
        //& is for seperation of different request parameter
        String url = "https://api.apilayer.com/fixer/convert?to="
        +currObject.getTo()+"&from="+currObject.getFrom()+"&amount="+currObject.getAmount();
        

        String apikey= System.getenv("CURRENCY_API_KEY");
        //line45, basically like POSTMAN where you input URL+header, before press send
        RequestEntity<Void> request = RequestEntity.get(url).header("apikey", apikey)
        .accept(MediaType.APPLICATION_JSON).build();
        //line 47 is POSTMAN's send function, get back JSON object, the class we referring to must be your jsontojava file
        ResponseEntity<jsontojava> response = template.exchange(request, jsontojava.class);

        //create new object using filename
        //only get what you need from API JSON to put inside jtj
        jsontojava jtj = response.getBody();
       // service.save(jtj);

        // @ModelAttribute from form
        // each data input need their own model.addAttribute(from server pass in data to exchange website), here you need 5
        // in exchange.html, to gets its result from the model.addAttribute

        //private static final DecimalFormat df = new DecimalFormat("0.00");

        BigDecimal convertDouble = new BigDecimal(jtj.getResult());
        BigDecimal result = convertDouble.setScale(2, RoundingMode.HALF_UP);
        
        model.addAttribute("success",jtj.getSuccess());

        model.addAttribute("query",jtj.getQuery());

        model.addAttribute("info",jtj.getInfo());
        
        model.addAttribute("date",jtj.getDate());

        //model.addAttribute("result",jtj.getResult());
        model.addAttribute("result",result);

        return "exchange";

    }


}
