package compass.homework_2_5.controller;

import compass.homework_2_5.model.Employee;
import compass.homework_2_5.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam("first_name") String firstname,
                        @RequestParam("last_name") String lastname){
        return employeeService.add(firstname,lastname);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("first name") String firstname,
                        @RequestParam("last name") String lastname){
        return employeeService.remove(firstname,lastname);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("first name") String firstname,
                        @RequestParam("last name") String lastname){
        return employeeService.find(firstname,lastname);
    }
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
