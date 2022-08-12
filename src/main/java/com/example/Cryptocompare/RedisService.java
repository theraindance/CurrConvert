package com.example.Cryptocompare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.Cryptocompare.CurrencyModel.jsontojava;

@Service
public class RedisService implements RedisRepo {
    @Autowired
    RedisTemplate<String,jsontojava> template;
    //RedisTemplate will convert Json to jave object and go to
    //template go online and save to redis database
    //public return type  to object
    public jsontojava save(jsontojava savejtj){
        template.opsForValue().set("hello", savejtj);
        return null;
    }
    //line 16, pass in the object then redis will save it
    //key = id(can do a randomiser for UUID)
    //line 17, this is just to save object into redis
        


    
}
