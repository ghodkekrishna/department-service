package net.codefusionhub.departmentservice.service.Impl;

import lombok.AllArgsConstructor;
import net.codefusionhub.departmentservice.Dto.DepartmentDto;
import net.codefusionhub.departmentservice.entity.Department;
import net.codefusionhub.departmentservice.mapper.DepartmentMapper;
import net.codefusionhub.departmentservice.repository.DepartmentRepository;
import net.codefusionhub.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
