package az.developia.springrom.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MyUtil {

	public String findUser() {
		String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		return loggedInUsername;
	}
	
	
	
}
