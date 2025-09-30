# Pet Adoption Management System Project

出题人：@宋雨朋

这个项目是一个现代化的宠物领养管理系统，它将帮助宠物收容所更有效地管理宠物信息和领养流程。我们将使用一些高级技术来实现这个系统。

要完成这个项目，你需要掌握以下技术：

- Maven 项目管理工具：https://maven.org.cn/guides/getting-started/index.html
- Mybatis 持久层框架：https://mybatis.net.cn/
- Lombok：https://www.cnblogs.com/heyonggang/p/8638374.html
- Git 代码版本管理工具：https://blog.csdn.net/sereasuesue/article/details/117080435

### 前置准备

1. 配置好Java环境
2. 配置Maven环境变量
3. 下载并配置MySQL数据库
4. 在数据库中创建一个名为`pet_adoption`的数据库，并创建以下三张表：

#### pet（宠物信息表）

字段 | 类型 | 长度 | 注释
--- | --- | --- | ---
`id` | int | | 不能为空，设置为主键，并设置为自动递增
`name` | varchar | 50 | 不能为空
`species` | varchar | 50 | 不能为空
`age` | int | | 不能为空
`adopt_status` | boolean | | 不能为空，默认为false
`added_date` | datetime | | 不能为空，自动设置为当前时间

#### adopter（领养人信息表）

字段 | 类型 | 长度 | 注释
--- | --- | --- | ---
`id` | int | | 不能为空，设置为主键，并设置为自动递增
`name` | varchar | 50 | 不能为空
`phone` | varchar | 20 | 不能为空
`address` | varchar | 100 | 不能为空
`registration_date` | datetime | | 不能为空，自动设置为当前时间
`password` | varchar | 50 | 不能为空，用于领养人登录

#### adoption_record（领养记录表）

字段 | 类型 | 长度 | 注释
--- | --- | --- | ---
`id` | int | | 不能为空，设置为主键，并设置为自动递增
`pet_id` | int | | 外键，引用pet表中的id，删除和更新时设置为restrict
`adopter_id` | int | | 外键，引用adopter表中的id，删除和更新时设置为restrict
`adoption_date` | datetime | | 不能为空，自动设置为当前时间
`status` | varchar | 20 | 不能为空，记录领养状态（例如："申请中"、"已批准"、"已完成"）

### 触发器设置

1. 在pet表上设置触发器，名称为`del_pet`，触发时机为删除之前，SQL为：
```sql
delete from adoption_record where pet_id = old.id;
```

2. 在adopter表上设置触发器，名称为`del_adopter`，触发时机为删除之前，SQL为：
```sql
delete from adoption_record where adopter_id = old.id;
```

### 项目要求

1. Maven坐标导入部分：
   - 需要自己导入所需的Maven坐标
   - 体验使用Maven管理项目依赖的过程
   - 如果找不到Maven依赖，可以咨询学长学姐

2. 代码实现部分：
   - 完成实体类的Lombok注解配置
   - 实现数据访问层（DAO）
   - 实现业务逻辑层（Service）
   - 实现控制器层（Controller）
   - 添加必要的验证和异常处理
   - 实现基本的CRUD操作
   - 实现领养流程管理

### 功能要求

1. 宠物管理
   - 添加新宠物
   - 查询，更新宠物信息
   - 设置宠物领养状态

2. 领养人管理
   - 登录，注册
   - 管理领养人信息

3. 领养流程管理
   - 提交领养申请
   - 审核领养申请
   - 记录领养过程
   - 跟踪领养状态

### 额外要求

1. 使用Mybatis进行数据库操作
2. 代码中使用Lombok简化实体类
3. 添加必要的日志记录
4. 实现基本的输入验证
5. 添加适当的异常处理

