package upp.backend.camundaServices;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class MejlOPrihvatanjuService implements JavaDelegate{
	@Autowired
	public EmailService emailSer;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		User user = (User) execution.getVariable("ulogovanAutor");
		
		String naslov = "Prihvacen rad";
		
		String text = "Vas rad je prihvacen";
		
		emailSer.posaljiMejl(user.getEmail(), naslov, text);

	}

}
