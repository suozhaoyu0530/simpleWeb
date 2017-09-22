# simpleWeb
此项目用的是spring boot做为spring框架的配置管理工具，maven作为项目管理工具
启动
	导入maven工程
	创建数据库，执行sampledb.sql
	更改application.property中数据库相关的配置信息
	在SimpleApplication.java中run as -> java application
注解相关
	@SpringBeanAfterEven：事后处理事件，可用于所用的springbean的事后事件，当用于的地方为servce层时，此事件与主事件非同一个事务
		service：springbean name
		method：springbean中的方法名
		paramRule：传入参数规则，可以为空，比如arg0,arg1,request.type
			arg0：主方法的入参集合的第一个参数
			request.type：主事件方法入参集合中必须存在HttpServletRequest对象，调用事件时会使用该request对象，并获取request.getParameter("type");
	@SpringBeanAfterTransactionalEven：大体同@SpringBeanAfterEven，只是在service层时，此事件与主事件方法是同一个事务
	@SpringBeanBeforeEven：事前处理事件，其他同@SpringBeanAfterEven
	@SpringBeanBeforeTransactionalEven：事前处理事件，其他同@SpringBeanAfterTransactionalEven
	@SpringBeanExceptionEvent：异常处理事件，其他同@SpringBeanAfterEven，此方法仅仅实现了controller层的处理逻辑
	@SpringBeanFinalEvent：最终处理事件，暂未实现
	
version 0.1.1
已知bug
	注解paramRule属性，当入参为list、map时会出现错误
可能存在的bug
	同一方法上同一注解被使用多次，未测试
	复杂的paramRule入参规则，未测试
以后版本改进
	解决paramRule匹配规则处理
	对paramRule规则处理抽象出来，以增强程序的健壮性
	对于controller层针对返回值的不同处理，用接口抽离出来，以便于不同的项目可以针对自己的需求进行适合自己需求的处理
	现在所有的实现都是使用的默认实现方法处理，后期实现配置化管理，便于不同的项目可以针对自己的需求进行适合自己需求的处理