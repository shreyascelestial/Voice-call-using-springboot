package com.example.callapplication;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class CallApplication implements ApplicationRunner{
	
	private final static String SID_ACCOUNT="ACb6ed101b88e2a0f0d39971c7204ac56d";
	private final static String AUTH_ID="a26b52e249f5cdbef68b0349e71fbfe5";
	private final static String FROM_NUMBER="+19126893932";
	private final static String TO_NUMBER="+91 9916227829";
	
	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(CallApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();
		
	}

}
