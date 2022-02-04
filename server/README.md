# Listen NOW - A backend management system for music website like spolify.

# How to run this project?
1. Open your terminal. `cd` to the location where you want to put the project.
2. Run `git clone https://github.com/YANGZ001/myMusicWebsite.git`
3. Run `cd myMusicWebsite`
4. Run `cd server; ./mvnw spring-boot:run`
5. Run `cd ../manage; npm run dev`
6. Open http://localhost:8080 at your browser.

# Project Structure 项目结构
1. 实体类 Entity，定义数据库表对应的实体类。比如admin，在数据库中有3个column，这个实体就有3个private属性，且自动生成了getter和setter方法。
2. 数据操作层。向数据库发送SQL语句，完成数据库操作。分成Mapper层和DAO层（Mapper接口层）。
   1. DAO层，定义了Mapper接口，定义了操作数据库的函数。
   2. Mapper层，在Mapper目录下，mapper接口映射文件在xml中定义，完成对数据库的访问。
3. Service层。调用Mapper层操作数据库。
4. controller层。对请求和响应进行控制，调用Service层进行业务逻辑处理。