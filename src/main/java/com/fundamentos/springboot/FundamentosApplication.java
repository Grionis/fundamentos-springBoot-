package com.fundamentos.springboot;

import com.fundamentos.springboot.bean.MyBeanWithDependency;
import com.fundamentos.springboot.bean.MyBeanWithProperties;
import com.fundamentos.springboot.bean.Mybean;
import com.fundamentos.springboot.component.ComponentDependency;
import com.fundamentos.springboot.entity.User;
import com.fundamentos.springboot.pojo.UserPojo;
import com.fundamentos.springboot.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication  implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;

	private Mybean mybean;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, Mybean mybean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo,UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.mybean = mybean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//ejemplosAnteriores();
		saveUserInDataBase();

	}


	private void saveUserInDataBase(){
		User user1 = new User("John", "John@gmail.com", LocalDate.of(2022, 01,28));
		User user2 = new User("Daniela", "Daniela@gmail.com", LocalDate.of(2022, 02,28));
		User user3 = new User("Mario", "Mario@gmail.com", LocalDate.of(2022, 03,28));
		User user4 = new User("fabian", "fabian@gmail.com", LocalDate.of(2022, 04,28));
		User user5 = new User("juan", "juan@gmail.com", LocalDate.of(2022, 05,28));
		User user6 = new User("pedro", "pedro@gmail.com", LocalDate.of(2022, 06,28));
		User user7 = new User("diego", "diego@gmail.com", LocalDate.of(2022, 07,28));
		User user8 = new User("cesar", "cesar@gmail.com", LocalDate.of(2022, 8,28));
		User user9 = new User("sebastian", "sebastian@gmail.com", LocalDate.of(2022, 9,28));
		User user10 = new User("mauricio", "mauricio@gmail.com", LocalDate.of(2022, 10,28));

		List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user5, user6, user7, user8, user9, user10);

		try {
			users.forEach(userRepository:: save );
		} catch (Exception e){
			LOGGER.error("Error insertando los usuarios" + e.getMessage());
		}


	}
	public void ejemplosAnteriores(){
		componentDependency.saludar();
		mybean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword() + "-" + userPojo.getAge());

		try {
			//int value = 10/0;
			//LOGGER.debug("Mi valor: " + value);
		} catch (Exception e){
			LOGGER.error("Esto es un error al divir por 0" + e.getStackTrace());
		}
	}
}
