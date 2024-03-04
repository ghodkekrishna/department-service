package net.codefusionhub.departmentservice.controller;


import lombok.AllArgsConstructor;
import net.codefusionhub.departmentservice.Dto.DepartmentDto;
import net.codefusionhub.departmentservice.entity.Department;
import net.codefusionhub.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //Save department REST API.
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartments(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
       DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(departmentCode);
       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
