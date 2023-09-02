package com.court.proj.user;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	final DefaultMessageService messageService;

    public UserController() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize("NCS8CNSYI4LRU2ZH", "UCM6DEWY8LADKH6A3WQVBTOJMWQIH77J", "https://api.coolsms.co.kr");
    }
	
	@GetMapping("/join")
	public String join() {
		return "user/userjoin";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/agree")
	public String agree() {
		return "user/agree";
	}
	
	@PostMapping("/send-one")
	public @ResponseBody ResponseEntity<Integer> sendOne(@RequestParam("phone") String phone) {
        //Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        //message.setFrom(phone);
        //message.setTo(phone);
        
        Random random = new Random();
        
        int randomNumber = random.nextInt(900000)+ 100000;
        
        //message.setText("인증번호 : "+ randomNumber);

        //SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        //System.out.println(response);

        return new ResponseEntity<Integer>(randomNumber, HttpStatus.OK);
    }
	
}
