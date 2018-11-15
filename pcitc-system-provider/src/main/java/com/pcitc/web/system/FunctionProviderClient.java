package com.pcitc.web.system;

import org.springframework.web.bind.annotation.RestController;

/**
 * 系统权限业务逻辑
 * @author fb
 *
 */
@RestController
public class FunctionProviderClient 
{
//	@Autowired
//	FunctionService functionService;
//
//	@RequestMapping(value = "/func-provider/func/tree-data", method = RequestMethod.GET)
//	public SysFunction getFunctionTree() throws Exception {
//		logger.info("get user....");
//		return functionService.findFunctionsById("");
//	}
//
//	@RequestMapping(value = "/func-provider/func/get-func/{funcId}", method = RequestMethod.GET)
//	public SysFunction selectFunctionByFuncId(@PathVariable(value = "funcId", required = true) String funcId) throws Exception {
//		logger.info("get user....");
//		return functionService.findFunctionsById(funcId);
//	}
//
//	@RequestMapping(value = "/func-provider/func/update-func", method = RequestMethod.POST)
//	public Serializable updatefunc(@RequestBody SysFunction func) {
//		logger.info("update func....");
//		return functionService.updateSysFunction(func);
//	}
//
//
//	@RequestMapping(value = "/func-provider/func/delete-func/{funcId}", method = RequestMethod.POST)
//	public int deleteFunctionByFuncId(@PathVariable("funcId") String funcId) {
//		logger.info("delete func....");
//		DataOperationStatusEnum status = functionService.delSysFunction(funcId);
//		return status.getStatusCode();
//	}
//
//	@RequestMapping(value = "/func-provider/func/add-func", method = RequestMethod.POST)
//	public Serializable insertFunc(@RequestBody SysFunction func) {
//		logger.info("add user....");
//		return functionService.saveFunction(func);
//	}
//
//	@RequestMapping(value = "/func-provider/func-page")
//	public JSONObject selectFunctionByPage(@RequestParam(value="jsonStr", required=false) String jsonStr) {
//		System.out.println("1selectUserByPage======"+jsonStr);
//		PageInfo<SysFunction> info = functionService.findFunctionsByPage(jsonStr);
//		System.out.println("2selectUserByPage======"+info.toString());
//		return JSONObject.fromObject(info);
//	}
}
