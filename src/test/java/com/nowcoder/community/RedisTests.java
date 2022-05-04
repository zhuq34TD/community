package com.nowcoder.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStrings(){
        String redisKey = "test:count";

        redisTemplate.opsForValue().set(redisKey, 1);

        System.out.println(redisTemplate.opsForValue().get(redisKey));
        System.out.println(redisTemplate.opsForValue().increment(redisKey));
        System.out.println(redisTemplate.opsForValue().decrement(redisKey));

    }

    @Test
    public void testHash(){
        String redisKey = "test:user";

        redisTemplate.opsForHash().put(redisKey, "id", 1);
        redisTemplate.opsForHash().put(redisKey, "username", "zhangsan");

        System.out.println(redisTemplate.opsForHash().get(redisKey, "id"));
        System.out.println(redisTemplate.opsForHash().get(redisKey, "username"));

    }

    @Test
    public void testList(){
        String redisKey = "test:ids";

//        redisTemplate.opsForList().leftPush(redisKey, 101);
        redisTemplate.opsForList().leftPushAll(redisKey, 101, 102, 103);

        System.out.println(redisTemplate.opsForList().size(redisKey));
        System.out.println(redisTemplate.opsForList().index(redisKey, 0));
        System.out.println(redisTemplate.opsForList().range(redisKey, 0, 3));
        System.out.println(redisTemplate.opsForList().leftPop(redisKey));
        System.out.println(redisTemplate.opsForList().leftPop(redisKey));
    }

    @Test
    public void testSet(){
        String redisKey = "test:teachers";

        redisTemplate.opsForSet().add(redisKey, "aa", "bb", "cc", "dd", "ee");
        System.out.println(redisTemplate.opsForSet().size(redisKey));
        System.out.println(redisTemplate.opsForSet().members(redisKey));
        System.out.println(redisTemplate.opsForSet().pop(redisKey));
        System.out.println(redisTemplate.opsForSet().members(redisKey));
    }

    @Test
    public void testZSet(){
        String redisKey = "test:students";

        redisTemplate.opsForZSet().add(redisKey, "a",10);
        redisTemplate.opsForZSet().add(redisKey, "b",20);
        redisTemplate.opsForZSet().add(redisKey, "c",30);
        redisTemplate.opsForZSet().add(redisKey, "d",40);
        redisTemplate.opsForZSet().add(redisKey, "e",50);

        System.out.println(redisTemplate.opsForZSet().size(redisKey));
        System.out.println(redisTemplate.opsForZSet().zCard(redisKey));
        System.out.println(redisTemplate.opsForZSet().score(redisKey, "c"));
        System.out.println(redisTemplate.opsForZSet().range(redisKey, 0, 4));
    }

    @Test
    public void testKeys(){
        redisTemplate.delete("test:count");

        System.out.println(redisTemplate.hasKey("test:count"));

        redisTemplate.expire("test:students", 10, TimeUnit.SECONDS);

    }
}
