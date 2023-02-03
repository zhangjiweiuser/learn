package com.zhang.groovy

import com.zhang.groovy.dao.StudentDao
import com.zhang.groovy.dto.StudentDTO
import com.zhang.groovy.service.impl.StudentServiceImpl
import spock.lang.Specification
import spock.lang.Unroll

class StudentServiceTest2 extends Specification {

    def dao = Mock(StudentDao)
    def service = new StudentServiceImpl(studentDao: dao)

    @Unroll
    def "input 学生id：#id,返回的邮编：#postCodeResult,返回的省份简称:#abbreviationResult"() {
        given: "设置请求参数"
        dao.getStudentInfo() >> students

        when: "获取学生信息"
        def response = service.getStudentById(id);

        then: "验证结果"
        with(response) {
            postCode == postCodeResult
            abbreviation == abbreviationResult
        }
        where: "经典之处：表格方式验证学生信息的分支场景"
        id | students                  || postCodeResult | abbreviationResult
        1  | getStudent(1, "张三", "北京") || "100000"       | "京"
        2  | getStudent(2, "李四", "上海") || "200000"       | "沪"
    }

    static def getStudent(def id, def name, def province) {
        return [new StudentDTO(id: id, name: name, province: province)]
    }
}
