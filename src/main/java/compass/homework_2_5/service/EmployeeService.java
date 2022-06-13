package compass.homework_2_5.service;

import compass.homework_2_5.exceptions.EmployeeAlreadyAddedExceptions;
import compass.homework_2_5.exceptions.EmployeeNotFindExceptions;
import compass.homework_2_5.exceptions.EmployeeStorageIsFullExceptions;
import compass.homework_2_5.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee){
        return employee.getName()+"|" +employee.getSurname();
    }

    public Employee add(String name, String surname) {
        Employee employee = new Employee(name, surname);
        String key = getKey(employee);
        if (employees.containsKey(key)){
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size()<LIMIT){
            return employees.put(key, employee);
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String name, String surname) {
        String key = getKey(new Employee(name, surname));
        if (!employees.containsKey(key)){
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public Employee find(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.containsKey(getKey(employee))){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getAll(){
        return new ArrayList<>(employees.values());
    }
}

