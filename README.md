# Sell
一个学习javaweb的后台商城项目

Idea破解：
------
破解链接:https://blog.csdn.net/SmileLvCha/article/details/78936659<br>

Mysql安装
------
安装Mysql:http://www.runoob.com/mysql/mysql-install.html <br>
配置环境变量：https://www.cnblogs.com/tyhj-zxp/p/6693046.html <br>
安装mysql出现错误2:https://blog.csdn.net/u010340178/article/details/52909365 <br>

Mysql基本操作
------
密码为123 <br>
root<br>
localhost<br>
进入mysql，在mysql的bin目录下打mysql -hlocalhost -uroot -p    <br>
https://jingyan.baidu.com/article/3aed632e19b5e8701080918f.html

Navicat
------
navicat连接出错：https://blog.csdn.net/lihua5419/article/details/80394716 <br>

Redis
------
下载：https://github.com/MicrosoftArchive/redis/releases <br>
安装：http://www.runoob.com/redis/redis-install.html <br>

Redis desktop manager
------
密码默认为空


概念
------
DAO = Data Access Object = 数据存取对象 最低端的，执行具体业务需求（大部分为和数据库打交道）<br>
Service = 服务 中间层，就是一个连接dao和controller的桥梁 <br>
Controller = 控制器 老大，说做什么就做什么<br>

controller----> service ------>  dao <br>

aop:在最外层包一层壳，比如用户验证之后才能进行相应的增加操作。<br>

jpa:将dao层书写xml文件进行查询数据库的方式替换成直接以注解的方式在dao类中执行，用于替换mybatis <br>

ioc:<br>

druid:待学习<br>

webscoket:待学习<br>

apache ab:<br>
//80个请求，100个线程<br>
ab -n 80 -c 100 http://www.baidu.com<br>
//60秒内发100个线程<br>
ab -t 80 -c 100 http://www.baidu.com<br>







