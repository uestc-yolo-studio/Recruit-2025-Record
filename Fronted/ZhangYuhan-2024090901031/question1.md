#题目1
##解题代码
```markdown
```html
<!DOCTYPE html>
<html>
<head>
    <title>社团报名表单</title>
</head>
<body style="width:90%;margin:0 auto;">
    <div>
        <h1 style="text-align:center;">社团报名表单</h1>
        <form action="" method="post">
            <fieldset>
                <legend>个人信息</legend>
                <table style="width:70%;margin:0 auto;">
                    <tr>
                        <th>姓名</th>
                        <th>电话</th>
                        <th>性别</th>
                    </tr>
                    <tr style="text-align:center;">
                        <td>
                            <input type="text" style="width:120px;" placeholder="请输入姓名">
                        </td> 
                        <td>
                            <input type="tel" style="width:120px;" placeholder="请输入电话">
                        </td>
                        <td>
                            <div>
                                <label>
                                    <input type="radio" name="gender"><span>男</span>
                                </label>
                                <label>
                                    <input type="radio" name="gender"><span>女</span>
                                </label>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>班级</th>
                        <th>邮箱</th>
                        <th>出生日期</th>
                    </tr>
                    <tr style="text-align:center;">
                        <td>
                            <input type="text" style="width:120px;" placeholder="请输入班级">
                        </td>
                        <td>
                            <input type="email" style="width:120px;" placeholder="请输入邮箱">
                        </td>
                        <td>
                            <input type="text" style="width:120px;"placeholder="如:2000-01-01">
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>所在院系</legend>
                <div>
                    <label>
                        学院：<input type="text" placeholder="请输入学院">
                    </label><br>
                    <label>
                        专业：<input type="text" placeholder="请输入专业">
                    </label>
                </div>
            </fieldset>
            <fieldset>
                <legend>年级</legend>
                <div>
                    <label><b>年级：</b></label>
                    <select>
                        <option selected>2025级</option>
                        <option>2024级</option>
                        <option>2023级</option>
                        <option>2022级</option>
                    </select>
                </div>
            </fieldset>
            <fieldset>
                <legend>想加入的社团类型</legend>
                <div>
                    <label>
                        <input type="checkbox">
                        <span>科技类</span>
                    </label>
                    <label>
                        <input type="checkbox">
                        <span>文艺类</span>
                    </label>
                    <label>
                        <input type="checkbox">
                        <span>体育类</span>
                    </label>
                    <label>
                        <input type="checkbox">
                        <span>公益类</span>
                    </label>
                    <label>
                        <input type="checkbox">
                        <span>学术类</span>
                    </label>
                </div>
            </fieldset>
            <fieldset>
                <legend>兴趣爱好</legend>
                <div style="text-align:center;">
                    <textarea placeholder="请输入兴趣爱好，不限个数" style="width:100%;height:50px;resize:none;"></textarea>
                </div>
            </fieldset>
            <fieldset>
                <legend>报名须知</legend>
                <div>
                    <input type="checkbox">
                    <label for="agreement">我已阅读并同意报名须知</label>
                </div>
            </fieldset>
            <div style="text-align:center;">
                <input type="submit" value="提交报名" style="margin:20px;">
            </div>
        </form>
    </div>
</body>
</html>
```
##相关知识点总结
###1.若要使用 HTML 表单，需使用 <form> 标签；
###2.<input> 标签通过 type 属性控制输入类型，主要类型包括：
password：密码输入框，输入内容会被隐藏；
radio：单选按钮，若多个 radio 的 name 属性相同，则仅能选择一个；
checkbox：复选框，支持多选；
submit：提交按钮，通过 value 属性设置按钮显示的内容；
button：普通按钮。
###3.下拉菜单由 <select>（作为容器）与 <option>（作为单个选项）配合实现：
<option> 的标签体为选项显示的文字；selected 属性用于设置默认选中项。
###4.多行文本域 <textarea> 支持输入多行文本，通过 resize:none 样式可固定文本域的大小；
placeholder 属性可设置输入提示内容，用户输入信息后该提示会被覆盖；
<legend> 需与 <fieldset> 配合使用（且必须作为 fieldset 的第一个子元素），用于实现表单分组。
##学习中的感悟或心得（遇到的问题及解决方式）
###在学习 HTML 的过程中，我先通过菜鸟教程等网站学习了基础知识，再根据任务要求对各类信息划分区域，初步搭建了一个未加修饰的表单。在完善表单的过程中，遇到了这些困难及解决方式：
###1.照片上传的布局问题：原本想在 “个人信息” 板块插入照片，但因该板块已用表格排版，暂时没找到合适的插入位置，因此暂时放弃；
###2.排版纠结：起初因排版效果不够理想而纠结，后来发现用 legend 分块后排版更美观，便未做过多调整；
提交按钮间距调整：最初 “提交报名” 按钮与上方内容间距过近，学习 CSS 后，通过 margin 属性调整好了间距；
###3.下拉菜单默认项设置：教程中未找到相关说明，后来求助 AI 后，学会了用 selected 属性设置默认选中项。