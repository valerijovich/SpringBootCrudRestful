package com.valerijovich.springbootcrudrestful;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeDAO {

    private static Map<String, Employee> empMap = new HashMap<>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Employee emp1 = new Employee("E01", "Bob", "Manager");
        Employee emp2 = new Employee("E02", "John", "HR");
        Employee emp3 = new Employee("E03", "Sam", "Programmer");
        Employee emp4 = new Employee("E04", "Adam", "Hostess");
        Employee emp5 = new Employee("E05", "Bill", "Loader");
        Employee emp6 = new Employee("E06", "Jack", "Butler");
        Employee emp7 = new Employee("E07", "Arnold", "Concierge");
        Employee emp8 = new Employee("E08", "Eva", "Owner");
        Employee emp9 = new Employee("E09", "Marry", "PR manager");

        empMap.put(emp1.getEmpNo(), emp1);
        empMap.put(emp2.getEmpNo(), emp2);
        empMap.put(emp3.getEmpNo(), emp3);
        empMap.put(emp4.getEmpNo(), emp4);
        empMap.put(emp5.getEmpNo(), emp5);
        empMap.put(emp6.getEmpNo(), emp6);
        empMap.put(emp7.getEmpNo(), emp7);
        empMap.put(emp8.getEmpNo(), emp8);
        empMap.put(emp9.getEmpNo(), emp9);

        empMap = empMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
    }

    public Employee getEmployee(String empNo) {
        return empMap.get(empNo);
    }

    public Employee addEmployee(Employee emp) {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }

    public Employee updateEmployee(Employee emp) {
        empMap.put(emp.getEmpNo(), emp);
        return emp;
    }

    public void deleteEmployee(String empNo) {
        empMap.remove(empNo);
    }

    public List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<>();
        list.addAll(c);
        return list;
    }
}
