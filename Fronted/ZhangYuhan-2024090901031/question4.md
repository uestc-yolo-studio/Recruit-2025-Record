#题目4
##解题代码：
```markdown
```html
<!DOCTYPE html>
<html>
<head>
    <title>个人作品展示页</title>
    <style>
    .navigate-list{
        margin:0;
        padding:0;
        background-color: #fff5f8;
        overflow:hidden;
        border:#deaad2 2px solid;
        border-radius:20px;
        box-shadow: 0 2px 8px rgba(248, 113, 113, 0.1);
    }
    body{
        width:800px;
        margin:0 auto;
    }
    .main{
        float:left;
        border:none;
        background:none;
        display:block;
        color: #883955; 
        text-align:center;
        padding:12px 20px;
        text-decoration:none;
        font-family:monospace;
        font-size:17px; 
    }
    .main:hover{
        background-color: #fbdbe3; 
        transition: all 0.3s ease;
    }
    .main.active{
        background-color: #f588c0; 
        color:white;
    }
    #home{
        background-color: #fdf1f7;
        height:1000px;
        border-radius:20px;
    }
    .home{
        width:500px;
        height:400px;
        border-radius:20px;
        float:right;
    }
    #home p{
        font-family:monospace;
        color: #6b2142;
        line-height: 1.6;
        margin-left:20px;
        font-size:16px;
    }
    h1{
        text-align:left;
        font-family:monospace;
        font-size:40px;
        color: #883955; 
    }
    .go{
        background-color: #fff9fc;
        border:#fecdd3 2px solid;
        border-radius:20px;
        padding:10px 5px 10px 5px;
        margin-left:90px;
        font-family:monospace;
        font-size:15px;
        color: #883955; 
        width:150px;
    }
    .go:hover{
        background-color: #fff0f4; 
        color: #f472b6;
        transform:translateY(-3px);
        box-shadow:0 0 10px rgba(244, 114, 182, 0.2); 
        transition: all 0.5s ease;
    }
    #works{
        background-image: url('D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\flower2.png'); 
        background-size: cover; 
        background-position: center; 
        background-repeat: no-repeat; 
        border-radius:20px;
        height:1000px;
    }
    h2{
        text-align:center;
        font-family:monospace;
        font-size:28px;
        color: #883955; 
        margin: 30px 0;
        padding: 20px 0;
        }
    h3{
        color:#f472b6;
        font-size:20px;
        margin:20px 40px;
    }
    .header-decoration{
        text-align: center;
        margin: 20px 0;
    }
    .header-decoration img{
        width: 120px;
        height: auto;
        opacity: 0.8;
    }
    .work-display{
        margin:0 auto;
        max-width: 1200px;
    }
    .work-style{
        list-style-type:none;
        font-family:monospace;
        font-size:16px;
        margin:30px auto; 
        background-color: #fff9fc; 
        border-radius:20px;
        padding:20px;
        width:90%;
        height:220px;
        display: flex;
        align-items: flex-start;
        position: relative;
        border: 2px solid #fecdd3;
        box-shadow: 0 0 5px #ebc7e3;
    }
    .work-style:hover{
        background-color: #fff0f4; 
        transform:translateY(-5px);
        box-shadow:0 0 15px rgba(244, 114, 182, 0.2); 
        transition: all 0.5s ease;
    }
    .work-style:hover .content1,.work-style:hover .content2,.work-style:hover .content3{
        display:block;
    }
    .work-img{
        width:300px;
        height:200px;
        display:flex;
        border-radius:100px;
        border: 3px solid #ffe4e9;
    }
    #work1:hover+.content1{
        display:block;
    }
    #work2:hover+.content2{
        display:block;
    }
    #work3:hover+.content3{
        display:block;
    }
    .content1,.content2,.content3{
        display:none;
        position:absolute;
        width:300px;
        height:300px;
        background-color: rgba(255, 249, 252, 0.9);
        border-radius:20px;
        border: 2px solid #ffe4e9;
        color:#6b2142;
        font-family:monospace;
        top:-20px;
        left:-60px;
    }
    .intro{
        color: #6b2142;
        line-height: 1.6;
        margin-left:40px;
    }
    #me{
        height:1000px;
        border-radius:20px;
        margin-top:0;
        background-color: #fdf1f7;
    }
    .self-info-container{
        background-image: url('D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\flower3.png'); 
        background-size: cover; 
        background-position: center; 
        background-repeat: no-repeat; 
        height:600px;
        width:90%;
        margin:0 auto;
        border-radius:20px;
    }
    .me-text{
        font-family:monospace;
        font-size:14px;
        margin-left:20px;
        color: #fe85bc;
    }
    h4{
        font-family:monospace;
        padding:20px 0;
        color: #883955; 
        margin:30px 0;
        text-align:center;
        font-size:28px;
    }
    h5{
        font-family:monospace;
        font-size:16px;
        color: #fe85bc; 
        margin-left:20px;
    }
    .self-info{
        float:left;
        display:block;
        margin:20px 10px 20px 100px;
        width:155px;
        height:160px;
        text-align:center;
        padding:20px 15px 20px 15px;
        border: 2px solid #fecdd3;
        font-family:monospace;
        font-size:16px;
        color: #6b2142;
        border-radius:50%;
        background-color: #fff9fc;
        box-shadow: 0 0 5px #ebc7e3;
    }
    .self-info:hover{
        background-color: #fff0f4; 
        transform:translateY(-5px);
        box-shadow:0 0 15px rgba(244, 114, 182, 0.2); 
        transition: all 0.5s ease;
    }
    h6{
        font-family:monospace;
        font-size:28px;
        color: #883955; 
        text-align:center;
        padding:20px 0;
        margin:30px 0;
    }
    #contact{
        background-color: #fdf1f7;
        height:1000px;
        border-radius:20px;
        margin-top:0;
    }
    #contact p{
        margin:20px;
        font-size:16px;
        color: #fe85bc;
    }
    .contact-container{
        border-radius:20px;
        padding:10px 20px 15px 10px;
        height:150px;
        background-color: #fff9fc; 
        border: 2px solid #fecdd3;
        box-shadow: 0 0 5px #ebc7e3;
    }
    .contact-item{
        list-style-type:none;
        font-family:monospace;
        font-size:16px;
        color: #6b2142;
        margin:20px 20px;
        }
    .contact-item img{
        width:24px;
        height:24px;
        margin-right:15px;
    }
    .contact-item a{
        color: #6b2142;
        text-decoration: none;
    }
    .contact-item a:hover{
        color: #fe85bc;
        text-decoration: underline;
    }
    .hide{
        display:none;
    }
    </style>
</head>
<body>
    <div class="navigate">
    <div class="navigate-list">
        <button class="main active" id="main1" onclick="door()">首页</button>
        <button class="main" id="main2" onclick="works()">作品展示</button>
        <button class="main" id="main3" onclick="me()">关于我</button>
        <button class="main" id="main4" onclick="contact()">联系我</button>
    </div>
</div>

    <div id="home">
        <h1>前端学习<br>作品展</h1>
        <br>
        <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\flower1.png" alt="首页图片" class="home">
        <p>通过对前端的学习，我顺利掌握了HTML、CSS、JavaScript等前端开发技术，能够独立完成简单的网页设计任务。</p>
        <br>
        <button class="go" onclick="works()" style="margin-left:75px;"><b>点击查看我的作品</b></button>
    </div>

    <div id="works" class="hide">
    <h2>欢迎来到我的个人作品展示区</h2>
    <div class="work-display">
    <ul>
    <div class="work-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\work1.png" class="work-img" id="work1"style="width:180px;" alt="作品1">
    <div class="content1">具体实现<br>1. 结构层面：<br>
        采用form标签包裹所有表单元素，通过不同的div分组（个人信息、所在院系等板块），使结构清晰。<br>
        输入框使用input标签，text用来输入内容，主要用于输入姓名、班级、电话、邮箱等性别选择用 radio 单选按钮；社团类型用 checkbox 复选框；年级用select下拉选择框；兴趣爱好用textarea文本域；同意须知用 checkbox；提交用button type="submit"。<br>
        2. 样式层面：<br>
        通过 CSS 实现布局美化，使用 flex 布局让表单元素排版整齐，设置边框、圆角、间距等样式提升视觉美感。</div>
    <li><h3>个人信息表单</h3>
    <p class="intro">作品描述：一个简单的个人信息表单，包含姓名、性别、手机号、邮箱、年级、院系等信息录入区域。</p>
    <p class="intro">感悟：通过这个项目，我学习并实践了如何使用HTML创建一个简单的表单，如何用HTML创建各种形式的表单信息录入，以及一些格式和排版的相关内容。</p>
    </li>
    </div>
    <div class="work-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\work2.png" class="work-img" id="work2" style="width:500px;height:200px;" alt="作品2">
    <div class="content2">具体实现<br>1.结构层面：<br>
        页面分为“个人信息区”“教育经历”“实习/项目经历”“技能列表”等板块，通过div、table、input、textarea等标签构建表单结构，每个板块功能明确。<br>
        2. 样式层面：<br>
        采用浅蓝色系作为主色调，营造简洁的简历风格。通过CSS设置边框、圆角、间距、hover动画效果，提升页面视觉层次，并且设置了明暗两种主题。<br>
        3. 交互层面：<br>
        点击“切换模式”按钮可在明暗模式间切换，改变页面背景、文字、边框颜色等。<br>
        选择技能熟练度时，进度条会更新宽度，直观展示技能掌握程度。</div>
    <li>
    <h3>个人简历</h3>
    <p class="intro">作品描述：一个个人简历，包含个人信息、教育经历、实习经历等内容，具有一定风格优化以及动画效果，外加两种模式切换。</p>
    <p class="intro">感悟：通过这个项目，我学习到了如何使用HTML创建个人简历，也学到了如何使用CSS去优化简历的排版和风格，让简历好看，以及增设一些动画效果让简历变得灵动，并且完成多种模式切换。</p>
    </li>
    </div>
    <div class="work-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\work3.png" class="work-img" id="work3"style="width:330px;"alt="作品3">
    <div class="content3">具体实现<br>1. 结构层面：<br>
        页面分为“选项卡导航”和“菜品列表”两大部分。选项卡包含“主食”“饮料”“小吃”三类，菜品列表通过div分组，每个菜品由图片、名称、描述等组成。<br>
        2. 样式层面：<br>
        通过CSS设置布局、颜色、间距等，用float布局等使图片和文字整齐排列；选项卡采用不同背景色区分活跃与非活跃状态，设置hover效果增强交互感。<br>
        3. 交互层面：<br>
        通过JavaScript捕捉点击事件，切换不同分类的菜品内容的显示或隐藏。<br>
        点击按钮可触发函数弹出提示框，显示菜品已购入的提示以及菜品价格。</div>
    <li><h3>菜单</h3>
    <p class="intro">作品描述：一个菜单，包含主食、饮料、小吃三个区域，每个区域分别展示不同的菜品，每个菜品包含菜品介绍、图片等内容。</p>
    <p class="intro">感悟：通过这个项目，我学习到了如何使用HTML创建一个菜单，并利用CSS进行对内容的美化，利用JavaScript完成菜单各个内容的切换、默认显示以及弹窗等动画效果。</p>
    </li>
    </div>
    </ul>
    </div>
    </div>

    <div id="me" class="hide">
        <h4>关于我</h4>
        <h5>-----充满好奇的前端技术学习者</h5>
        <p class="me-text">我是一名对于前端技术充满好奇，十分追求细节和美感的学习者。我热爱探索新的技术，不断提升自己的个人能力。</p>
        <div class="self-info-container">
            <div class="self-info">家乡<p>四川省成都市龙泉驿区</p></div>
            <div class="self-info">母校<p>电子科技大学</p></div>
            <div class="self-info">兴趣爱好<p>看书、音乐、游戏</p></div>
            <div class="self-info">技术栈<p>HTML、CSS、JavaScript</p></div>
    </div>
    </div>

    <div id="contact" class="hide">
        <h6>联系方式</h6>
        <p>-----有什么想法或者交流意向？欢迎联系我，我会尽快回复您。</p>
        <div class="contact-container">
        <ul>
            <li class="contact-item"><img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\email.png"  alt="邮箱图标">邮箱：<a href="mailto:your.email@example.com">3143302559@qq.com</a></li>
            <li class="contact-item"><img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\phone.png" alt="电话图标">电话：<a href="tel:+1234567890">15928751749</a></li>
            <li class="contact-item"><img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question4\qq.png" alt="QQ图标">QQ：<a href="https://weixin.qq.com/">3143302559</a></li>
        </ul>
        </div>
    </div>
    <script>
        function door(){
        document.getElementById('main2').classList.remove('active');   
        document.getElementById('main3').classList.remove('active'); 
        document.getElementById('main4').classList.remove('active');
        document.getElementById('main1').classList.add('active');  
        document.getElementById('home').classList.remove('hide'); 
        document.getElementById('works').classList.add('hide'); 
        document.getElementById('me').classList.add('hide');
        document.getElementById('contact').classList.add('hide');
        }
        function works(){
        document.getElementById('main1').classList.remove('active');   
        document.getElementById('main3').classList.remove('active'); 
        document.getElementById('main4').classList.remove('active');
        document.getElementById('main2').classList.add('active');  
        document.getElementById('works').classList.remove('hide'); 
        document.getElementById('home').classList.add('hide'); 
        document.getElementById('me').classList.add('hide');
        document.getElementById('contact').classList.add('hide');
        }
        function me(){
        document.getElementById('main2').classList.remove('active');   
        document.getElementById('main4').classList.remove('active'); 
        document.getElementById('main1').classList.remove('active');
        document.getElementById('main3').classList.add('active');  
        document.getElementById('me').classList.remove('hide'); 
        document.getElementById('works').classList.add('hide'); 
        document.getElementById('home').classList.add('hide');
        document.getElementById('contact').classList.add('hide');      
        }
        function contact(){
        document.getElementById('main1').classList.remove('active');   
        document.getElementById('main2').classList.remove('active'); 
        document.getElementById('main3').classList.remove('active');
        document.getElementById('main4').classList.add('active');  
        document.getElementById('contact').classList.remove('hide'); 
        document.getElementById('works').classList.add('hide'); 
        document.getElementById('me').classList.add('hide');
        document.getElementById('home').classList.add('hide');
        }
    </script>
</body>
</html>
```
##遇到的一些问题及解决方式：
1. 对于各个板块的切换问题，我用了和上一道题一样的方式，即点击按钮后，通过添加或移除active、hide类来切换显示不同的板块；
2. 对于排版和美观问题，因为确实之前没做有个人作品展示页的经验，然后就在各个地方去搜了一些相关的资源，学到了一些比较美观的排版方式；
3. 其他问题大概不多，很多都是根据前三题的基础去实现的。
