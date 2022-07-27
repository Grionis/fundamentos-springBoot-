package com.fundamentos.springboot;

import com.fundamentos.springboot.bean.MyBeanWithDependency;
import com.fundamentos.springboot.bean.MyBeanWithProperties;
import com.fundamentos.springboot.bean.Mybean;
import com.fundamentos.springboot.component.ComponentDependency;
import com.fundamentos.springboot.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication  implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;

	private Mybean mybean;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, Mybean mybean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.mybean = mybean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
