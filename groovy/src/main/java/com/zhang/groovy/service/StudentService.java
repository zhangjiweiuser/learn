package com.zhang.groovy.service;

import com.zhang.groovy.exception.BusinessException;
import com.zhang.groovy.vo.StudentVO;

public interface StudentService {
    StudentVO getStudentById(int id);

    void validateStudent(StudentVO student) throws BusinessException;
}
