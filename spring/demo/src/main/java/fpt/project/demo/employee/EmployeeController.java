package fpt.project.demo.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;//tham chieu den inteface
    //viet ham ve cac nhan vien co luong > 3000
    @GetMapping("high-salary")
    public List<Employee> getEmployeesWithHistSalary(){
        return employeeRepository.findAll()
        .stream()
        .filter(nv -> nv.getSalary() > 3000)
        .collect(Collectors.toList());
    }
}
