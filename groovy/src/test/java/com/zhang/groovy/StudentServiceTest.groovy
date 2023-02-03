package com.zhang.groovy

import com.zhang.groovy.dao.StudentDao
import com.zhang.groovy.dto.StudentDTO
import com.zhang.groovy.exception.BusinessException
import com.zhang.groovy.service.impl.StudentServiceImpl
import com.zhang.groovy.vo.StudentVO
import spock.lang.Specification
import spock.lang.Unroll

class StudentServiceTest extends Specification {

    def dao = Mock(StudentDao)
    def service = new StudentServiceImpl(studentDao: dao)

    @Unroll
    def "test getStudentById"() {
        given: "设置请求参数"
        def student1 = new StudentDTO(id: 1, name: "张三", province: "北京")
        def student2 = new StudentDTO(id: 2, name: "李四", province: "上海")
        and: "mock studentDao返回值"
        dao.getStudentInfo() >> [student1, student2]
        when: "获取学生信息"
        def response = service.getStudentById(1)

        then: "验证结果"
        with(response) {
            id == 1
            abbreviation == "京"
            postCode == "100000"
        }
    }

    @Unroll
    def "validate student info: #expectedMessage"() {
        when: "校验"
        service.validateStudent(student)

        then: "验证"
        def exception = thrown(expectedException)
        exception.code == expectedCode
        exception.message == expectedMessage

        where: "测试数据"
        student           || expectedException | expectedCode | expectedMessage
        getStudent(10001) || BusinessException | "10001"      | "student is null"
        getStudent(10002) || BusinessException | "10002"      | "student name is null"
        getStudent(10003) || BusinessException | "10003"      | "student age is null"
        getStudent(10004) || BusinessException | "10004"      | "student telephone is null"
        getStudent(10005) || BusinessException | "10005"      | "student sex is null"
    }

    static def getStudent(code) {
        def student = new StudentVO()
        def condition1 = {
            student.name = "张三"
        }
        def condition2 = {
            student.age = 20
        }
        def condition3 = {
            student.telephone = "12345678901"
        }
        def condition4 = {
            student.sex = "男"
        }
        switch (code) {
            case 10001:
                student = null
                break
            case 10002:
                student = new StudentVO()
                break
            case 10003:
                condition1()
                break
            case 10004:
                condition1()
                condition2()
                break
            case 10005:
                condition1()
                condition2()
                condition3()
                break
        }
        return student
    }
}
