### 综合练习题

use empdb;

1. 查询工资在 1000 到 2000 之间有领导的员工信息

   select * from emp where sal between 1000 and 2000 and manager is not null;

2. 查询有领导的员工工资按照降序排序取前三条数据

   select * from emp where manager is not null order by sal desc limit 0,3;

3. 查询 1 号和 3 号部门出现了哪几种不同的工作

   select distinct job from emp where dept_id in(1,3);

4. 查询每个部门的人数

   select dept_id,count(*) from emp group by dept_id;

5. 查询每种工作有领导的员工人数

   select job,count(*) from emp where manager is not null group by job;

6. 查询每个部门的最低工资,最高工资和平均工资

   select dept_id,min(sal) 最低工资, max(sal) 最高工资, avg(sal) 平均工资 from emp group by dept_id;



### having

- where 后面只能写普通字段条件, 不能写聚合函数条件
- having关键字专门用来写聚合函数条件的, 并且需要和分组group by结合使用, 写在分组的后面

1. 查询每个部门的平均工资,要求平均工资大于2000;

   select dept_id,avg(sal) a from emp  group by dept_id having a>2000;

2. 查询每种工作的人数,只查询人数大于 1 的

   select job,count(*) c from emp group by job having c>1;

3. 查询每个部门的工资总和,只查询有领导的员工, 并且要求工资总和大于 5400.

   select dept_id,sum(sal) s from emp 

   where manager is not null group by dept_id having s>5400;

4. 查询每个部门的平均工资, 只查询工资在 1000 到 3000 之间的,并且过滤掉平均工资低于 2000 的

   select dept_id,avg(sal) a from emp where sal between 1000 and 3000 group by dept_id having a>=2000;

### 子查询(嵌套查询)

- 把一条SQL语句嵌套到另外一条SQL语句中,称为子查询

1. 查询工资高于2号部门平均工资的员工信息

select avg(sal) from emp where dept_id=2;

select * from emp where sal>(select avg(sal) from emp where dept_id=2);





