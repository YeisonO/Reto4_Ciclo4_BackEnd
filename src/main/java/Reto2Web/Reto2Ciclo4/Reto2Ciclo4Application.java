package Reto2Web.Reto2Ciclo4;

import Reto2Web.Reto2Ciclo4.Interfaces.InterfaceOrder;
import Reto2Web.Reto2Ciclo4.Interfaces.InterfacePeripherals;
import Reto2Web.Reto2Ciclo4.Interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Ciclo4Application implements CommandLineRunner{
        @Autowired
        private InterfacePeripherals interfacePeripherals;
        @Autowired
        private InterfaceUser interfaceUser;
        @Autowired
        private InterfaceOrder interfaceOrder;
	public static void main(String[] args) {
		SpringApplication.run(Reto2Ciclo4Application.class, args);
	}
        
        @Override
        public void run(String...args) throws Exception{
            interfacePeripherals.deleteAll();
            interfaceUser.deleteAll();
            interfaceOrder.deleteAll();
        }
}
