package com.levent.consultantapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.levent.consultantapi.model.Consultant;
import com.levent.consultantapi.service.ConsultantService;
import com.levent.consultantapi.service.InfoService;

@RestController
@RequestMapping("api/v1/")
public class ConsultantController {

	@Autowired
	private ConsultantService consultantService;

	@Autowired
	private InfoService greeter;

	public ConsultantController() {
	}

	@RequestMapping("/test")
	public String test() {
		String new_password = "fgfhgf";
		return greeter.getGreet();
	}

	@RequestMapping(value = "consultants", method = RequestMethod.GET)
	public List<Consultant> consultantList() {
		String password = "fgfhgf";

		ArrayList list1 = null;
		try {
			list1 = new ArrayList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return null;
		}
		return consultantService.getConsultants();
	}

	// crud
	@RequestMapping(value = "consultants", method = RequestMethod.POST)
	public Consultant createConsultant(@RequestBody Consultant consultant) {
		System.out.println("Inside create method... " + consultant);
		return consultantService.createConsultant(consultant);
	}

	@RequestMapping(value = "consultants/{id}", method = RequestMethod.GET)
	public Consultant get(@PathVariable Long id) {
		return consultantService.getConsultantById(id);
	}

	@RequestMapping(value = "consultants/{id}", method = RequestMethod.PUT)
	public Consultant update(@PathVariable Long id, @RequestBody Consultant shipwreck) {
		return consultantService.updateConsultantById(id, shipwreck);
	}

	@RequestMapping(value = "consultants/{id}", method = RequestMethod.DELETE)
	public Consultant nDelete(@PathVariable Long id) {
		return consultantService.deleteConsultantById(id);
	}

	@RequestMapping(value = "consultants/{id}", method = RequestMethod.GET)
	public String testLogin(@RequestParam String username,
	                    @RequestParam String password)
			throws Exception {

		Connection conn = DriverManager.getConnection("connection.url");

        Statement stmt = conn.createStatement();

        String query =
                "SELECT * FROM users WHERE username='"
                        + username
                        + "' AND password='"
                        + password
                        + "'";

        ResultSet rs = stmt.executeQuery(query);

        return rs.next() ? "success" : "fail";
	}

	@RequestMapping(value = "consultants/{id}", method = RequestMethod.GET)
	public String testMethod(@RequestParam String username,
	                    @RequestParam String password)
			throws Exception {

		Connection connection = DriverManager.getConnection("connection.url.new");

        Statement statement = connection.createStatement();

        String query =
                "select * FROM users WHERE username='"
                        + username
                        + "' AND password='"
                        + password
                        + "'";

        ResultSet rs = statement.executeQuery(query);

        return rs.next() ? "success" : "fail";
	}

}
