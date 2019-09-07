package in.pune.pradyroy;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApp {

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
		ret_val = ret_val + " | " + "OS Name:- " + OS_NAME + " | " + "Message:- Hello from Docker Container 1";

		return ret_val;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class, args);
	}

}
