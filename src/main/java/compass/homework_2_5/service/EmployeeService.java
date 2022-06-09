package compass.homework_2_5.service;

import compass.homework_2_5.exceptions.EmployeeAlreadyAddedExceptions;
import compass.homework_2_5.exceptions.EmployeeNotFindExceptions;
import compass.homework_2_5.exceptions.EmployeeStorageIsFullExceptions;
import compass.homework_2_5.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;

    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstname, String lastname) {
        Employee employee = new Employee(firstname, lastname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedExceptions();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullExceptions();
    }
        public Employee remove (String firstname, String lastname) {
            Employee employee = new Employee(firstname, lastname);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFindExceptions();
            }
                    employees.remove(employee);
                    return employee;
                }

        public Employee find (String firstname, String lastname){
            Employee employee = new Employee(firstname, lastname);
                if (!employees.contains(employee)) {
                    throw new EmployeeNotFindExceptions();
                }
                    return employee;
                }
        public List<Employee> getAll() {
            return new ArrayList<>(employees);
        }
}


