package com.zhang.groovy.service.impl;

import com.zhang.groovy.dao.StudentDao;
import com.zhang.groovy.dto.StudentDTO;
import com.zhang.groovy.exception.BusinessException;
import com.zhang.groovy.service.StudentService;
import com.zhang.groovy.util.PhoneDesensitizedUtil;
import com.zhang.groovy.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/13 14:44
 */
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public StudentVO getStudentById(int id) {
        List<StudentDTO> students = studentDao.getStudentInfo();
        StudentDTO studentDTO = students.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        StudentVO studentVO = new StudentVO();
        if (studentDTO == null) {
            return studentVO;
        }
        studentVO.setId(studentDTO.getId());
        studentVO.setName(studentDTO.getName());
        studentVO.setSex(studentDTO.getSex());
        studentVO.setAge(studentDTO.getAge());
        // 邮编
        if ("上海".equals(studentDTO.getProvince())) {
            studentVO.setAbbreviation("沪");
            studentVO.setPostCode("200000");
        }
        if ("北京".equals(studentDTO.getProvince())) {
            studentVO.setAbbreviation("京");
            studentVO.setPostCode("100000");
        }
        if(StringUtils.hasText(studentDTO.getPhone())){
            studentVO.setTelephone(PhoneDesensitizedUtil.desensitized(studentDTO.getPhone()));
        }
        return studentVO;
    }

    @Override
    public void validateStudent(StudentVO student) throws BusinessException {
        if (student == null) {
            throw new BusinessException("10001", "student is null");
        }
        if (null == student.getName() || "".equals(student.getName())) {
            throw new BusinessException("10002", "student name is null");
        }
        if (student.getAge() == null) {
            throw new BusinessException("10003", "student age is null");
        }
        if (null == student.getTelephone() || "".equals(student.getTelephone())) {
            throw new BusinessException("10004", "student telephone is null");
        }
        if (null == student.getSex()) {
            throw new BusinessException("10005", "student sex is null");
        }
    }
}
