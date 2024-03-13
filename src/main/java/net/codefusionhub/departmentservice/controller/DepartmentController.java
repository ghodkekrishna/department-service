package net.codefusionhub.departmentservice.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.codefusionhub.departmentservice.Dto.DepartmentDto;
import net.codefusionhub.departmentservice.entity.Department;
import net.codefusionhub.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - Department Controller",
        description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation(
            summary = "Save Department REST API",
            description = "Save department REST API is used to save department object in database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    //Save department REST API.
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartments(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Department REST API",
            description = "Get department REST API is used to get department details in database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
       DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(departmentCode);
       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
