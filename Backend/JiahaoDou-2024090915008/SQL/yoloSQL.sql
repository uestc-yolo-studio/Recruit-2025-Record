select * from students where name like '张%' or name like '李%';

select * from students where gender='F' and year(birth_date)=2003;

select * from students st left join scores sc on st.student_id=sc.student_id where sc.score between 80 and 90;

select name,email from students limit 5;

select * from students where name like '%三%';

-- 复杂sql语句
select class_id,count(*) as count from students GROUP BY class_id HAVING count>2;

select st.student_id, st.name as student_name,avg(sc.score) as average_score from students st left join scores sc on st.student_id=sc.student_id group by st.student_id,st.name order by average_score desc limit 3;


SELECT 
    c.course_id AS 课程编号,
    c.course_name AS 课程名称,
    COUNT(sc.student_id) AS 选课学生数量
FROM teachers t
JOIN courses c ON t.teacher_id = c.teacher_id
LEFT JOIN scores sc ON c.course_id = sc.course_id
GROUP BY t.teacher_id, t.name, t.title, c.course_id, c.course_name, c.credit
HAVING t.title='教授'
ORDER BY t.teacher_id, 选课学生数量 DESC;


SELECT 
    c.course_id AS 课程编号,
    c.course_name AS 课程名称,
    ROUND(AVG(sc.score), 2) AS 平均分,
    MAX(sc.score) AS 最高分,
    MIN(sc.score) AS 最低分
FROM courses c
JOIN scores sc ON c.course_id = sc.course_id
GROUP BY c.course_id, c.course_name
ORDER BY 平均分 DESC;


SELECT 
    s.student_id AS 学号,
    s.name AS 姓名,
    s.gender AS 性别,
    c.course_name AS 课程名称,
    sc.score AS 成绩
FROM students s
JOIN scores sc ON s.student_id = sc.student_id
JOIN courses c ON sc.course_id = c.course_id
WHERE c.course_name IN ('数据库原理', '数据结构')
  AND sc.score >= 85
ORDER BY c.course_name, sc.score DESC;






