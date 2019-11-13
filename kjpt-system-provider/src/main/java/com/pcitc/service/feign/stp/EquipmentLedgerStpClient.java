package com.pcitc.service.feign.stp;

import com.pcitc.base.stp.equipment.SreEquipmentLedger;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wsl
 * 2019-07-05
 * 1、FeignClient接口中，如果使用到@PathVariable ，必须指定其value
 * 2、FeignClient接口，不能使用@GettingMapping 之类的组合注解 
 * 3、Feign如果想要使用HystrixStream，需要做一些额外操作 
 * 4、如果需要自定义单个Feign配置，Feign的@Configuration注解的类不能与@ComponentScan 的包重叠
 * 默认支持注解：@RequestMapping、@RequestParam、@RequestHeader、@PathVariable
 */
@FeignClient(value = "pcitc-stp-provider")
public interface EquipmentLedgerStpClient {

	/**
	 * 将ERP中的装备台账数据 新增到本地
	 * @param EquipmentLedgerData
	 * @return
	 */
	@RequestMapping(value = "/sre-provider/equipmentLedger/insertEquipmentLedger")
	public Integer insertEquipmentLedger(@RequestBody List<SreEquipmentLedger> EquipmentLedgerData);

}
