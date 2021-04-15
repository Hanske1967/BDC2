package be.mloz.bdc.cucumber;

import be.mloz.bdc.Bdc2App;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = Bdc2App.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
