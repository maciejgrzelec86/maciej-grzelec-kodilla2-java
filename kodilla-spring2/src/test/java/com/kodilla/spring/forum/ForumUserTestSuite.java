package com.kodilla.spring.forum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.kodilla.spring.SpringRunner.class)
public class ForumUserTestSuite {
    @Test
    public void testForumUser() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        //When
        String testForumUser = context.getBean(ForumUser.class).getUsername();
        //Then
        Assert.assertEquals("John Smith", testForumUser);
    }
}
