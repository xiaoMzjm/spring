package com.wisely.hightlight_spring4.ch1.javaconfig;

// 不需要@Service
public class UseFunctionService {

	// 不需要@Autowired
	private FunctionService functionService;

	public FunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	public String sayHello(String word) {
		return functionService.sayHello(word);
	}
	
}
