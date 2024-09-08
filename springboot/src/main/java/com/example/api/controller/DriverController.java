package com.example.api.controller;

import com.example.api.annotation.Log;
import com.example.api.model.entity.Driver;
import com.example.api.model.enums.BusincessType;
import com.example.api.service.DriverService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Resource
    private DriverService driverService;

    @Log(moudle = "驾驶员管理",type = BusincessType.INSERT)
    @PostMapping("")
    public Driver save(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @Log(moudle = "驾驶员管理",type = BusincessType.QUERY)
    @GetMapping("")
    public List<Driver> findAll() {
        return driverService.findAll();
    }

    @Log(moudle = "驾驶员管理",type = BusincessType.QUERY)
    @GetMapping("/{id}")
    public Driver findById(@PathVariable String id) {
        return driverService.findById(id);
    }

    @Log(moudle = "驾驶员管理",type = BusincessType.DELETE)
    @DeleteMapping("")
    public void delete(String id) {
        driverService.delete(id);
    }

}
