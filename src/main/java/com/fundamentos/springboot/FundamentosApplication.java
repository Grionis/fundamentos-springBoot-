package com.fundamentos.springboot;

import com.fundamentos.springboot.bean.MyBeanWithDependency;
import com.fundamentos.springboot.bean.Mybean;
import com.fundamentos.springboot.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication  implements CommandLineRunner {

	private ComponentDependency componentDependency;

	private Mybean mybean;

	private MyBeanWithDependency myBeanWithDependency;
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, Mybean mybean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.mybean = mybean;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		mybean.print();
		myBeanWithDependency.printWithDependency();
	}
}
