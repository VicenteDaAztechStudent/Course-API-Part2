package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
	}

}

/*
 * _______PLEASE____READ____________
 * 
 * 
 * * Since we're using port 8080 with Tomcat Server for our 2nd RESTful web service,
 * it's important to make sure no PID's are listening to port 'http://localhost:8080' before running application  
 * Since my OS is Windows, I will list the Windows commands to kill PID's listening to port 8081
 * -------> Linux OS Assistance for Ports: 
 * 				https://til.hashrocket.com/posts/e4c8c665a8-find-and-kill-all-processes-listening-on-a-port



C:\Users\vicente.cruz>netstat -ano | findstr :8080                                          | ----> command to identify what PID is listening to port 'http://localhost:8081'
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       13768				|
  TCP    [::]:8080              [::]:0                 LISTENING       13768				|
																							|
C:\Users\vicente.cruz>taskkill /PID 13768 /F												| -----> kill command for PID from listening to port 'http://localhost:8081'
SUCCESS: The process with PID 13768 has been terminated.									|
																							|
C:\Users\vicente.cruz>netstat -ano | findstr :8080											| -----> verify no other PID is listening before starting CourseApiApp.java class

C:\Users\vicente.cruz>

 * 
 * 
 * This application is design to take a deeper dive to RESTFUl  web services.
 * 
 *  creating CRUD functions via a development tool call Post Man
 * 
 * https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en
 * 
 * If you're new to CRUD functions, here is are education YouTube links that helped me understand
 * these concepts: 
 * 
 * ------>https://www.youtube.com/watch?v=AI2oBJkPK3c&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO&index=19
 * 
 * ------->https://www.youtube.com/watch?v=lpcOSXWPXTk&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO&index=29 
 * ------->https://www.youtube.com/watch?v=bEKt7LLEvb0&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO&index=30
 * ------->https://www.youtube.com/watch?v=_Jnu_jHfQbM&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO&index=31
 * 
 * Also, we will be using JPA to help us use Relational Data Base functionalities via Java.
 * 
 * ----->https://www.youtube.com/watch?v=du99WcQztNU&list=PLmbC-xnvykcghOSOJ1ZF6ja3aOgZAgaMO&index=27
 * 
 * When you first GET http://localhost:8080/topics via PostMan, it will return blank data, you must 
 * use POST functions to edit http://localhost:8080/topics and add a resource using JSON format e.g;
 * 
{
	"id": "angular-dart",
	"name": "Angular Dart Essentials",
	"description": "Become full stack with Angular Dart"
}
 *
 * Please review documentation comments through out the java classes in the application to get 
 * familiarized how each class participate to make the app run.
 * 
 * The YouTube links provided will help a lot in creating in depth POST,GET and so many more commands
 * via PostMan 
 * 
 *
 */

