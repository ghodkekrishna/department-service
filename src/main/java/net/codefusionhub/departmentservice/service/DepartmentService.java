package net.codefusionhub.departmentservice.service;

import net.codefusionhub.departmentservice.Dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByDepartmentCode(String code);
}
