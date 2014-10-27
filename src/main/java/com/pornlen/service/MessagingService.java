package com.pornlen.service;

import com.pornlen.config.Profiles;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile(Profiles.MESSAGING)
@Service
public class MessagingService {

	//WHAT IS THIS FOR
    public void receiveMessage(Object message) {
        System.out.println("Amqp msg received <" + message + ">");
    }
}
