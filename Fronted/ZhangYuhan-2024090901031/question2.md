#题目2
##解题代码：
**由于CSS文件的引入方式为<link id="theme" rel="stylesheet" href="day.css">，所以如果要预览，需要另创.css文件，文件名分别为day.css和night.css，相关代码在下面**
```markdown
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人简历</title>
    <script>
    function myFunction(){
	const css=document.getElementById("theme");
    const herf=css.getAttribute("href");
    if(herf=="day.css"){
        css.setAttribute("href","night.css");
    }else{
        css.setAttribute("href","day.css");
    }
    }
    function skillLevel(skillindex,percentage){
        const skilllevel=document.getElementsByClassName("skill-floor");
        skilllevel[skillindex].style.width=percentage;
    }
</script>
<link id="theme" rel="stylesheet" href="day.css">
</head>
<body>
    <h1 style="text-align: center;font-size:30px;">个人简历</h1>
    <button type="button" class="switch" onclick="myFunction()">切换模式</button>
    <div class="container">
        <fieldset>
            <legend>个人信息区</legend>
            <div class="personal-info">
                <div class="img-container">
                    <a target="_blank" href="">
                        <img src="" alt="请上传头像" width="300" height="200">
                    </a>
                </div>
                <div class="information">
                    <form>
                        <table class="information-table">
                            <tr>
                                <th>姓名</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>性别</th>
                                <td>
                                    <input type="radio" name="gender">
                                    <label for="male">男</label>
                                    <input type="radio" name="gender">
                                    <label for="female">女</label>
                                </td>
                            </tr>
                            <tr>
                                <th>电话</th>
                                <td><input type="text"></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </fieldset>
        <fieldset>
            <legend>教育经历</legend>
            <div class="education">
                <form>
                    <table class="education-table">
                        <tr>
                            <th>信息/阶段</th>
                            <th style="width:30%">院校</th>
                            <th style="width:60%">时间与经历</th>
                        </tr>
                        <tr style="height:60px;">
                            <th>高中</th>
                            <td>
                                <textarea style="margin:5px;height:60px;"></textarea>
                            </td>
                            <td>
                                <textarea style="margin:20px;height:60px;"></textarea>
                            </td>
                        </tr>
                        <tr style="height:60px;">
                            <th>大学</th>
                            <td>
                                <textarea style="margin:5px;height:60px;"></textarea>
                            </td>
                            <td>
                                <textarea style="margin:20px;height:60px;"></textarea>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </fieldset>
    <fieldset>
        <legend>实习/项目经历</legend>
        <form>
            <textarea style="margin:auto 0;height:60px;width:98%;height:200px;"></textarea>
        </form>
    </fieldset>
    <fieldset>
        <legend>技能列表</legend>
        <form  class="skill-form">
            <label>请勾选熟练度：</label><br>
            <label style="margin-right:57px;">1.HTML:</label> <input type="radio" name="html" onclick="skillLevel(0,'100%')">熟练
            <input type="radio" name="html" onclick="skillLevel(0,'66%')">中等
            <input type="radio" name="html" onclick="skillLevel(0,'33%')">了解
            <input type="radio" name="html"onclick="skillLevel(0,'0%')">未涉及<br>
            <div class="skill-level">
                <div class="skill-floor"></div>
            </div>
            <label style="margin-right:68px;">2.CSS:</label> <input type="radio" name="css" onclick="skillLevel(1,'100%')">熟练
            <input type="radio" name="css" onclick="skillLevel(1,'66%')">中等
            <input type="radio" name="css" onclick="skillLevel(1,'33%')">了解
            <input type="radio" name="css" onclick="skillLevel(1,'0%')">未涉及<br>
            <div class="skill-level">
                <div class="skill-floor"></div>
            </div>
            <label style="margin-right:1px;">3.JavaScript:</label> <input type="radio" name="java" onclick="skillLevel(2,'100%')">熟练
            <input type="radio" name="java" onclick="skillLevel(2,'66%')">中等
            <input type="radio" name="java" onclick="skillLevel(2,'33%')">了解
            <input type="radio" name="java" onclick="skillLevel(2,'0%')">未涉及<br>
            <div class="skill-level">
                <div class="skill-floor"></div>
            </div>
            <label style="margin-right:50px;">4.数据库:</label> <input type="radio" name="data" onclick="skillLevel(3,'100%')">熟练
            <input type="radio" name="data" onclick="skillLevel(3,'66%')">中等
            <input type="radio" name="data" onclick="skillLevel(3,'33%')">了解
            <input type="radio" name="data" onclick="skillLevel(3,'0%')">未涉及<br>
            <div class="skill-level">
                <div class="skill-floor"></div>
            </div>
            <label style="margin-right:0px;">5.<input type="text" style="width:87px;" placeholder="其他（请输入）">:</label>
            <input type="radio" name="other" onclick="skillLevel(4,'100%')">熟练
            <input type="radio" name="other" onclick="skillLevel(4,'66%')">中等
            <input type="radio" name="other" onclick="skillLevel(4,'33%')">了解
            <input type="radio" name="other" onclick="skillLevel(4,'0%')">未涉及
            <div class="skill-level">
                <div class="skill-floor"></div>
            </div>
        </form>
    </fieldset>
    <fieldset>
        <legend>求职意向</legend>
        <table class="aim-table">
            <tr>
                <th style="width:20%">目标岗位</th>
                <td><input type="text" style="margin-left:10px;width:90%;"></td>
            </tr>
            <tr>
                <th style="width:20%">工作城市</th>
                <td><input type="text" style="margin-left:10px;width:90%;"></td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>个人优势/自我介绍</legend>
        <textarea style="margin-bottom:15px;height:200px;width:98%"></textarea>
    </fieldset>
</body>
</html>
```
**下面两个是外部文件 day.css和night.css 若要查看效果可能需要新建这两个文件再把代码复制粘贴上去**
```markdown
```css
day.css:    
body{
        font-family: 'Courier New', Courier, monospace;
        border: 1px solid #c6d8f0;
        background-color:#f8fafc;
        width:800px;
        margin: 0 auto;
    }
    .switch{
        margin:20px;
        border-radius:30px;
        border: 2px solid #6387d3;
        background-color:#edf2f9; 
        color:#3a5f99;
        font-family: 'Courier New', Courier, monospace;
        height:40px;
        width:100px;
    }
    .switch:hover{
        transform: translateY(-2px);
        transition: transform 1s;
        box-shadow: 0 0 8px 2px rgba(129, 162, 222, 0.3);
        color:#0d4aad;
        background-color:#dde4f3;
    }
    .container {
        margin:20px;
        display:flex;
        flex-direction: column;
        gap:20px;
    }
    fieldset {
        border: 2px solid #6387d3;
        border-radius:20px;
        padding: 20px;
        margin-bottom: 20px;
        background-color:#ffffff; 
    }
    fieldset:hover{
        transform: translateY(-2px);
        transition: transform 1s;
        box-shadow: 0 0 8px 2px rgba(129, 162, 222, 0.3);
    }
    legend {
        font-size: 20px;
        font-weight: bold;
        padding: 0 10px;
        color:#3a5f99;
    }
    .personal-info {
        display: flex; 
        gap: 20px; 
        align-items: flex-start;
    }
    .img-container {
        flex: 0 0 25%; 
        border: 1px solid #c6d8f0;
        border-radius:50%;
        height: 180px;
        display: flex;
        align-items: center;
        justify-content: center;
        overflow: hidden;
        background-color:#edf2f9;
    }
    .img-container img {
        max-width: 100%;
        max-height: 100%;
        object-fit: cover;
    }
    .information {
        flex: 1; 
        border: 1px solid #c6d8f0;
        border-radius:20px;
        padding: 15px;
        height: 150px; 
        background-color:#edf2f9;
    }
    .information-table {
        width: 100%;
        border-collapse: collapse;
        text-align: center;
    }
    .information-table th, .information-table td {
        padding: 10px;
    }
    .information-table th {
        width: 30%;
        color:#3a5f99;
    }
    .information-table td {
        width: 70%;
    }
    .education-table {
        border-collapse: collapse;
        text-align: center;
        border: 1px solid #c6d8f0;
        background-color:#edf2f9; 
    }
    .education-table th, .education-table td {
        border: 1px solid #c6d8f0;
    }
    .education-table th {
        color:#3a5f99;
    }
    input[type="text"] {
        width: 80%;
        padding: 5px;
    }
    .skill-form{
        background-color:#edf2f9;
        color:#3a5f99;
        border-radius:10px;
        font-family: 'Courier New', Courier, monospace;
    }
    .aim-table, .aim-table th, .aim-table td {
        border: 1px solid #c6d8f0; 
        border-collapse: collapse;
        padding:10px;
        width:99%;
        background-color:#edf2f9; 
    }
    .aim-table th {
        color:#3a5f99; 
    }

    input[type="text"],textarea{
        border-radius:10px;
        border:1px solid #c6d8f0; 
        width: 80%;
        padding: 5px;
        background-color:#ffffff; 
        resize:none;
    }
    input[type="text"]:focus,textarea:focus{
        border: 1px solid #6387d3;
        box-shadow: 0 0 8px 2px rgba(129, 162, 222, 0.3); 
        outline:none;
    }
    h1 {
        text-align: center;font-size:30px;
        color:#3a5f99 !important;
    }
    .skill-level {
        height: 10px;
        background-color: #d1dcec;
        border-radius: 5px;
        margin:10px;
        width:90%;
    }
    .skill-floor {
        height: 100%;
        background-color: #6387d3;
        border-radius: 5px;
        width:0;
        transition: width 0.5s ease-in-out;
    }
    
night.css:    
body{
        font-family: 'Courier New', Courier, monospace;
        border: 1px solid #333842; 
        background-color:#1a1d23; 
        color: #e0e0e0; 
        width:800px;
        margin: 0 auto;
    }
    .switch{
        margin:20px;
        border-radius:30px;
        border: 2px solid  #4a5063;
        background-color:#2d303a; 
        color:#b8c1cf;
        font-family: 'Courier New', Courier, monospace;
        height:40px;
        width:100px;
    }
    .switch:hover{
        transform: translateY(-2px);
        transition: transform 1s;
        box-shadow: 0 0 8px 2px #4a5063;
        color:#ffffff;
        background-color:#383b47;
    }
    .container {
        margin:20px;
        display:flex;
        flex-direction: column;
        gap:20px;
    }
    fieldset {
        border: 2px solid #4a5063;
        border-radius:20px;
        padding: 20px;
        margin-bottom: 20px;
        background-color:#2d303a; 
    }
    fieldset:hover{
        transform: translateY(-2px);
        transition: transform 1s;
        box-shadow: 0 0 8px 2px #4a5063;
    }
    legend {
        font-size: 20px;
        font-weight: bold;
        padding: 0 10px;
        color:#b8c1cf;
        background-color:#2d303a; 
    }
    .personal-info {
        display: flex; 
        gap: 20px; 
        align-items: flex-start;
    }
    .img-container {
        flex: 0 0 25%; 
        border: 1px solid #4a5063; 
        border-radius:50%;
        height: 180px;
        display: flex;
        align-items: center;
        justify-content: center;
        overflow: hidden;
        background-color:#383b47; 
    }
    .img-container img {
        max-width: 100%;
        max-height: 100%;
        object-fit: cover;
    }
    .information {
        flex: 1; 
        border: 1px solid #4a5063;
        border-radius:20px;
        padding: 15px;
        height: 150px; 
        background-color:#383b47; 
    }
    .information-table {
        width: 100%;
        border-collapse: collapse;
        text-align: center;
    }
    .information-table th, .information-table td {
        padding: 10px;
    }
    .information-table th {
        width: 30%;
        color:#b8c1cf;
    }
    .information-table td {
        width: 70%;
    }
    .education-table {
        border-collapse: collapse;
        text-align: center;
        border: 1px solid #4a5063; 
        background-color:#383b47; 
    }
    .education-table th, .education-table td {
        border: 1px solid #4a5063; 
    }
    .education-table th {
        color:#b8c1cf; 
    }
    input[type="text"] {
        width: 80%;
        padding: 5px;
    }
    .skill-form{
        background-color:#2d303a;
        color:#b8c1cf;
        border-radius:10px;
        font-family: 'Courier New', Courier, monospace;
    }
    .aim-table, .aim-table th, .aim-table td {
        border: 1px solid #4a5063; 
        border-collapse: collapse;
        padding:10px;
        width:99%;
        background-color:#383b47; 
    }
    .aim-table th {
        color:#b8c1cf; 
    }
    input[type="text"],textarea{
        border-radius:10px;
        border:1px solid #4a5063; 
        width: 80%;
        padding: 5px;
        background-color:#2d303a; 
        color: #e0e0e0; 
        resize:none;
    }
    input[type="text"]:focus,textarea:focus{
        border: 1px solid #8a94a6; 
        box-shadow: 0 0 8px 2px rgba(138, 148, 166, 0.3); 
        outline:none;
    }
    .skill-level {
        height: 10px;
        background-color:#383b47; 
        border-radius: 5px;
        margin:10px;
    }
    .skill-floor {
        height: 100%;
        background-color:#6c7a93; 
        border-radius: 5px;
        width: 0;
        transition: width 1s ease-in-out;
    }
    input[type="radio"] {
        accent-color: #6c7a93; 
    }
```
##CSS 布局核心知识总结与学习感悟
###布局知识要点总结
1. 常见布局方式
  1. Flexbox弹性布局
通过display: flex使用；
通过flex-direction控制主轴方向是横向还是纵向，justify-content用于主轴对齐，align-items与align-self用于交叉轴（与主轴垂直的轴）对齐；
该布局适用于导航栏对齐、卡片垂直居中等一些需要灵活对齐的场景。
  2. Grid网格布局
通过 display: grid使用，可以同时控制行和列；
通过grid-template-columns（grid-template-rows）定义列数（行数），grid-gap定义行列间距，grid-template-areas定义区域命名的布局。
该布局适用于响应式布局、不规则的网格排列等需要同时控制行和列的场景。
  3. Float浮动布局
因为使用这种布局方法可能会导至浮动元素不占父容器的高度，需要通过clear:both等解决，一般使用得比较少。
2. 布局单位
  1. 固定单位：px，可以精确指定字体大小；
  2. 相对单位：%，是相对于父元素的对应属性，该布局单位适用于响应式布局；
  3. 相对字体单位：em、rem，em为相对于当前元素的字体大小，若自身未设置 font-size，则继承父元素；rem为相对于根元素<html>的字体大小；该布局单位适用于响应式布局；
  4. 视口单位：vh、vw，vh为相对于视口高度的百分比，vw为相对于视口宽度的百分比，该布局单位适用于全屏布局以及响应式布局。
3. 布局常见问题与调试方法
  1. 常见问题
浮动高度塌陷：父元素包含浮动子元素时，高度为 0，导致背景、边框等样式失效。
Flex/Grid 对齐异常：justify-content/align-items 不生效，多因 “主轴 / 交叉轴方向设置错误” 或 “项目未正确包裹”。
响应式适配困难：布局在不同屏幕下变形，多因未结合媒体查询（@media）或弹性单位（fr/%/rem）。
  2. 调试方法
查看元素盒模型（确认 width/height/padding/margin 是否正确）。
检查 Flex/Grid 相关属性（如容器的 display、项目的 flex 值）。
模拟不同屏幕尺寸（设备模式），测试响应式效果。
可以逐步删除非核心代码，定位出问题的地方。
4. 进度条与日夜间模式的切换（需要使用java）
  1. 进度条
因为进度条太多并且都是一样的，如果给每一个进度条都配多个java函数会很麻烦，所以可以给函数配置形式参数，并使用getElementsByClassName来获取当前对应的每个进度条的相关信息，这样仅使用一个函数即可；
  2. 日夜间模式切换
首先需要建立两个.css文件,并与html文件建立连接，再设置按钮配置对应函数即可。
5. 鼠标悬停动画的配置
如果要使用鼠标悬停动画，需要在style中的区域名后加：hover 然后录入相关配色等变化，如果想改变使悬停动画的时间，可以使用transition。
###学习过程中的感悟或心得（遇到的问题及解决方式）
1. 对于进度条动画的设置，一开始感觉因为进度条太多并且状态也太多，设置的函数会比较多，但是又因为那些进度条都比较相似，并且各个进度条的状态也比较类似，所以就想办法减少这些函数的数量，求助AI之后发现可以给函数设置形式参数，然后再给每一个进度条和状态设置相应的参数，就能只设置一个函数；
2. 对于日夜间模式的切换，一开始是不知道在<style>里怎么设置两种类型的模式，之后了解到了可以建立两个.css的文件，再建立java函数切换这两个文件即可；
3. 一开始是给每个模块设置了区域内的标题，后面觉得这样设置不够醒目也不够美观，所以就用了第一题学到的<legend>；
4. 一开始不知道如何设置圆形区域，后来了解到是可以使用border-radius:50%。
###印象最深刻的实际应用场景
让我印象最深刻的实际应用场景还是使用Grid布局实现一个响应式的网格布局，例如在一个简单的游戏登录页面，需要在不同屏幕尺寸下都能正常显示，使用Grid布局可以很方便地实现这一点。

