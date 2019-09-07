package in.pune.pradyroy;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApp {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApp.class);

	@RequestMapping("/")
	public String home() {
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		String ret_val = "";

		if (null != inetAddress) {
			String ip_address = "IP Address:- " + inetAddress.getHostAddress();
			String host_name = "Host Name:- " + inetAddress.getHostName();
			ret_val = host_name + " | " + ip_address;
		}
		String OS_NAME = System.getProperty("os.name").toLowerCase();
		ret_val = ret_val + " | " + "OS Name:- " + OS_NAME + " | " + "Message:- Hello from Docker Container 1" + " | " + "Docker Tag:- 2.0";

		return ret_val;
	}
	
	@RequestMapping("/genlogs")
	public String genlogs() {
		genlogsfor10minutes();
		return "Generated random logs for 10 minutes for demoapp";
	}
	
    public void genlogsfor10minutes(){
		int i = 1;
		while(i<=600) {
			if (i%5 == 0)
				LOGGER.info("SUCCESS_MARKER demoapp log statement number " + i );
			else if(i%10 == 0)
				LOGGER.error("ERROR_MARKER demoapp log statement number " + i );
			else
				LOGGER.debug("DEBUG_MARKER demoapp log statement number " + i);
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class, args);
	}

}
