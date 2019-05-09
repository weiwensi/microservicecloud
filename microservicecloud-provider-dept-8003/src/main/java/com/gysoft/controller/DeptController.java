package com.gysoft.controller;

import com.gysoft.bean.Dept;
import com.gysoft.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/8 10:24
 */

@RestController
public class DeptController
{
    @Autowired
    private DeptService service;

    /**
     * 这个实例是用来进行服务发现的，对于注册到
     */
    @Autowired
    private DiscoveryClient client;
    /**
     * 通过这个接口实现对方法访问量的统计，可以在metrics端点里查看统计到的信息。
     */
    @Autowired
    private CounterService counterService;

    @RequestMapping(value="/dept/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list()
    {
        counterService.increment("didispace.dept.list.count");
        return service.list();
    }


    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }


}
