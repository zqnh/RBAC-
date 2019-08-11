# RBAC-
基于最流行的RBAC拓展模型的，分布式的，有界面的，高灵活性，高拓展性的企业级权限管理系统。

#### 1.Java权限管理系统核心技术栈
**权限框架**：Apache Shiro <br/>
**项目框架**：Spring Boot/Spring MVC/Mybatis/Redis <br/>
**基础工具**：Maven/Tomcat/MySQL/JDK1.8 <br/>
**前端技术**：jQuery/Bootstrap/Mustache/zTree/Duallistbox <br/>
**其他技术**：Java高级技术/Guava/Druid/ Jackson <br/>
#### 2.Java权限管理系统功能列表
##### 2.1部门模块
功能：
新增部门
更新部门
删除部门
部门树形结构展示
![部门模块](https://github.com/zqnh/RBAC-/tree/master/img/1.jpg)
##### 2.2用户模块
功能：
新增用户
更新用户
根据部门分页获取用户列表并展示
![用户模块](https://github.com/zqnh/RBAC-/tree/master/img/yonghu.jpg)
##### 2.3权限模块
功能：
新增权限模块
更新权限模块
删除权限模块
权限模块树形结构展示
![权限模块](https://github.com/zqnh/RBAC-/tree/master/img/quanxian.jpg)
##### 2.4权限点模块
功能：
新增权限点
更新权限点
根据权限模块分页获取权限点列表并展示
![权限点模块](https://github.com/zqnh/RBAC-/tree/master/img/quanxiandian.jpg)
##### 2.5角色模块
功能：
新增角色
更新角色
删除角色
获取角色列表并展示
![角色模块](https://github.com/zqnh/RBAC-/tree/master/img/juese.jpg)
##### 2.6权限关系维护
功能：
角色-权限树形结构列表
更新角色-权限关系
![权限关系](https://github.com/zqnh/RBAC-/tree/master/img/quanxianguanxi.jpg)
##### 2.7用户关系维护
功能：
获取指定角色已分配用户列表
获取指定角色未分配用户列表
更新角色-用户关系
![用户关系](https://github.com/zqnh/RBAC-/tree/master/img/yonghuguanxi.jpg)
##### 2.8日志模块
功能：
带查询条件分页展示权限日志
根据权限日志撤销之前的操作
![日志关系](https://github.com/zqnh/RBAC-/tree/master/img/rizhi.jpg)
##### 2.9Redis缓存模块
Redis缓存用户权限
Redis缓存系统权限
已缓存权限清理
##### 2.10其他
在切面判断是否允许当前用户访问某个URL
查询指定用户已分配的权限（树形结构）
查询指定权限被哪些人拥有
