package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(UserMessage message) throws Exception {
		char sym = message.getSymbol();
		if(sym=='*'){
			return new Greeting("The result is "+(message.getNum1()* message.getNum2()));
		}
		else if(sym=='+'){
			return new Greeting("The result is "+(message.getNum1()+message.getNum2()));
		}
		else if(sym=='-'){
			return new Greeting("The result is "+( (message.getNum1()-message.getNum2())));
		}
		else if(sym=='/'){
			if(message.getNum2()!=0){
				return new Greeting("The result is "+ (message.getNum1()/message.getNum2()));
			}
			else{
				return new Greeting("Division by zero not possible you idiot !");
			}
		}
		else if(sym=='%'){
			if(message.getNum2()!=0){
				return new Greeting("The result is "+ (message.getNum1()%message.getNum2()));
			}
			else{
				return new Greeting("Mod by zero not possible you idiot !");
			}
		}
		else{
			return new Greeting("Enter Valid Operator !! ");
		}
	}

}
