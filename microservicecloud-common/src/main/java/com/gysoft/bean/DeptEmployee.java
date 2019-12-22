package com.gysoft.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmployee {

    private Integer id;
    private Integer deptId;
    private Integer employeeId;
}
