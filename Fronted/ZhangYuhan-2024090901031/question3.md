#题目3
##解题代码：
```markdown
```html
<!DOCTYPE html>
<html>
    <head>
        <title>菜单</title>
<style>
body {
    background-color: #fff9f5; 
    margin:0;
    padding: 20px;
}

h1{
    font-size: 30px;
    font-family: 'Courier New', Courier, monospace;
    text-align: center;
    margin:20px;
    color: #e67e22; 
    text-shadow: 1px 1px 2px rgba(230, 126, 34, 0.15); 
}

#menu{
    padding:20px;
    margin: 0 auto;
    background-color: #fff; 
    border:2px solid #fde6d8; 
    border-radius:20px;
    box-shadow:0 0 12px 3px rgba(253, 230, 216, 0.3); 
    height:800px;
    width:700px;
    overflow-y: auto;
}

.menu-btn{
    text-align: center;
    background-color: #f8f0e3; 
    color: #d35400; 
    height:40px;
    width:100px;
    margin:65px;
    border:1.5px solid #f5d7b9; 
    border-radius:20px;
    font-family:'Courier New', Courier, monospace;
    cursor: pointer;
    transition: all 0.5s;
}

.menu-btn:hover{
    background-color: #fde6d8; 
    color: #e67e22; 
    border:1.5px solid #e67e22; 
    transform: translateY(-2px);
    box-shadow: 0 0 10px 3px rgba(230, 126, 34, 0.2); 
}

.menu-btn.active{
    background-color: #f9c39e; 
    color: #fff; 
    border:1.5px solid #e67e22; 
    box-shadow: 0 0 10px 5px rgba(230, 126, 34, 0.2);
}

.menu-style{
    font-family:'Courier New', Courier, monospace;
    border:1.5px solid #fde6d8; 
    margin:10px;
    padding:15px;
    border-radius:20px;
    color: #5d4037; 
    background-color: #fffbf8; 
    box-shadow: 0 0 8px 2px rgba(253, 230, 216, 0.2); 
    overflow: hidden;
    transition: all 0.5s;
}

.menu-style img{
    border-radius: 10px;
    object-fit: cover;
    border: 1px solid #fde6d8; 
}

.menu-style li{
    font-size: 18px;
    font-weight: bold;
    color: #e67e22; 
    margin-bottom: 8px;
    list-style: none;
}

.menu-style p{
    line-height: 1.6;
    margin: 0;
    color: #6d4c41; 
}

.menu-style:hover{
    background-color: #fef3e7; 
    color: #fff;
    border:1.5px solid #e67e22;
    transform: translateY(-2px);
    box-shadow: 0 0 10px 3px rgba(230, 126, 34, 0.2);
}

.menu-style:hover p,.menu-style:hover li{
    color: #d35400;
}

.hide{
    display: none;
}

.sale-container{
    text-align:center;
}

.sale{
    background-color: #ffeaa7; 
    border:1.5px solid #ffd740; 
    box-shadow: 0 0 10px 3px rgba(255, 215, 64, 0.2);
    border-radius:20px;
    text-align:center;
    font-family:'Courier New', Courier, monospace;
    padding:4px;
    cursor: pointer; 
}

.sale:hover{
    background-color: #ffdd59; 
    color: #d35400;
    border:1.5px solid #ffb74d;
    transform: translateY(-2px);
    box-shadow: 0 0 10px 3px rgba(255, 183, 77, 0.2);
    transition:all 0.5s;
}
</style>
</style>
    </head>
<body>
    <div id="menu" onmouseleave="next()" onmouseenter="stop()">
    <h1>菜单</h1>
    <button id="mainfood" class="menu-btn active" onclick="food()">主食</button>
    <button id="drink" class="menu-btn" onclick="drink()">饮料</button>
    <button id="snack" class="menu-btn" onclick="snack()">小吃</button>
    <div id="menu-food">
    <ul>
    <div class="menu-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\noodles.png" style="width:100px;height:100px;float:left;margin-right:20px;" alt="宜宾燃面">
    <li>宜宾燃面</li>
    <p style="text-align:left;margin-right:15px;">四川宜宾经典面食，面条劲道弹牙，淋上用芽菜、花生碎、辣椒调制的红油，麻辣鲜香十足；因油重无水、点火可 “燃” 而得名，是当地早餐热门之选。</p>
    <div class="sale-container">
    <button class="sale" onclick="noodles()">加入购物车</button>
    </div>
    </div>
    <div class="menu-style" onclick="dumpling()">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\dumplings.png" style="width:100px;height:100px;float:left;margin-right:20px;" alt="钟水饺">
    <li>钟水饺</li>
    <p style="text-align:left;margin-right:15px;">成都名小吃，与北方水饺风味迥异，主打甜辣口！薄皮包裹纯猪肉馅，煮熟后淋特制红油酱汁，甜中带辣、蒜香浓郁，吃起来清爽不腻。</p>
    <div class="sale-container">
    <button class="sale" onclick="dumpling()">加入购物车</button>
    <br>
    </div>
    </div>
    <div class="menu-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\leaf.png"  style="width:100px;height:100px;float:left;margin-right:20px;" alt="叶儿粑">
    <li>叶儿粑</li>
    <p style="text-align:left;margin-right:15px;">四川泸州、宜宾一带的传统小吃，用糯米粉包裹鲜肉馅（或红糖芝麻甜馅），再以良姜叶包裹蒸熟；叶子的清香渗入糯米团，吃起来软糯绵密，咸甜风味皆具特色。</p>
    <div class="sale-container">
    <button class="sale" onclick="leave()">加入购物车</button>
    </div>
    </div>
    </ul>
    </div>

    <div id="menu-drink" class="hide">
    <ul>
    <div class="menu-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\milk.png" style="width:100px;height:100px;float:left;margin-right:20px;" alt="唯怡豆奶">
    <li>唯怡豆奶</li>
    <p style="text-align:left;margin-right:15px;">四川人吃火锅、串串的灵魂搭档！以花生、大豆为原料，口感醇厚浓郁，带着花生香气；冰镇后喝，解辣效果一绝，是川式辣食的最佳伴侣</p>
    <div class="sale-container">
    <button class="sale" onclick="milk()">加入购物车</button>
    </div>
    </div>
    <div class="menu-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\tea.png" style="width:100px;height:100px;float:left;margin-right:20px;" alt="茉莉花茶">
    <li>茉莉花茶</li>
    <p style="text-align:left;margin-right:15px;">四川犍为是茉莉花重要产地，此地的茉莉花茶尤为有名；茶叶吸收茉莉清香，泡出的茶汤清澈透亮，花香清幽、鲜爽回甘，配小吃或日常饮用都很合适。</p>
    <div class="sale-container">
    <button class="sale" onclick="tea()">加入购物车</button>
    </div>
    </div>
    <div class="menu-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\cola.png" style="width:100px;height:100px;float:left;margin-right:20px;" alt="百事可乐">
    <li>百事可乐</li>
    <p style="text-align:left;margin-right:15px;">冰爽的气泡在口中炸开，味道酸甜可口，能中和四川麻辣小吃的厚重感，带来清爽解腻的体验，也是不少年轻人搭配川味美食的选择。</p>
    <div class="sale-container">
    <button class="sale" onclick="cola()">加入购物车</button>
    </div>
    </div>
    </ul>
    </div>

    <div id="menu-snack" class="hide">
    <ul>
    <div class="menu-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\potato.png" style="width:100px;height:100px;float:left;margin-right:20px;" alt="狼牙土豆">
    <li>狼牙土豆</li>
    <p style="text-align:left;margin-right:15px;">四川街头超火的小吃！土豆切成波浪形块，炸至外酥里嫩，再拌上辣椒面、孜然、折耳根（可选）等调料，香辣过瘾，土豆的绵密与调料的香味融合得恰到好处。</p>
    <div class="sale-container">
    <button class="sale" onclick="potato()">加入购物车</button>
    </div>
    </div>
    <div class="menu-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\cake.png" style="width:100px;height:100px;float:left;margin-right:20px;" alt="蛋烘糕">
    <li>蛋烘糕</li>
    <p style="text-align:left;margin-right:15px;">成都 “万能小吃”！用鸡蛋、面粉调成面糊，在小铜锅里烘成薄饼，可夹奶油、豆沙（甜口）或肉松、榨菜（咸口）等馅料；外皮微脆、内馅丰富，一口下去层次十足。</p>
    <div class="sale-container">
    <button class="sale" onclick="cake()">加入购物车</button>
    </div>
    </div>
    <div class="menu-style">
    <img src="D:\.github\Frontend\ZhangYuhan-2024090901031\assets\question3\ice.png" style="width:100px;height:100px;float:left;margin-right:20px;" alt="冰粉">
    <li>冰粉</li>
    <p style="text-align:left;margin-right:15px;">四川夏日解暑神器！用冰粉籽搓出透明凉粉，浇上红糖水、醪糟，再搭配山楂片、葡萄干、糍粑等配料；冰冰凉凉、酸甜解腻，和辣辣的川菜堪称 “绝配”。</p>
    <div class="sale-container">
    <button class="sale" onclick="ice()">加入购物车</button>
    </div>
    </div>
    </ul>
    </div>

    </div>
    <script>
        function food(){
        document.getElementById('drink').classList.remove('active');   
        document.getElementById('snack').classList.remove('active');   
        document.getElementById('mainfood').classList.add('active');  
        document.getElementById('menu-food').classList.remove('hide'); 
        document.getElementById('menu-snack').classList.add('hide'); 
        document.getElementById('menu-drink').classList.add('hide');
        }
        function drink(){
        document.getElementById('mainfood').classList.remove('active');   
        document.getElementById('snack').classList.remove('active');   
        document.getElementById('drink').classList.add('active');  
        document.getElementById('menu-drink').classList.remove('hide'); 
        document.getElementById('menu-snack').classList.add('hide'); 
        document.getElementById('menu-food').classList.add('hide');
        }
        function snack(){
        document.getElementById('mainfood').classList.remove('active');   
        document.getElementById('drink').classList.remove('active');   
        document.getElementById('snack').classList.add('active');  
        document.getElementById('menu-snack').classList.remove('hide'); 
        document.getElementById('menu-food').classList.add('hide'); 
        document.getElementById('menu-drink').classList.add('hide');        
        }
        function noodles(){
            alert('已加入：宜宾燃面（15r）');
        }
        function dumpling(){
            alert('已加入：钟水饺（12r）');
        }
        function leave(){
            alert('已加入：叶儿粑（10r）');
        }
        function milk(){
            alert('已加入：唯怡豆奶（3r）');
        }
        function tea(){
            alert('已加入：茉莉花茶（4r）');
        }
        function cola(){
            alert('已加入：百事可乐（2.5r）');
        }
        function potato(){
            alert('已加入：狼牙土豆（8r）');
        }
        function cake(){
            alert('已加入：蛋烘糕（5r）');
        }
        function ice(){
            alert('已加入：冰粉（8r）');
        }
        const totalSeconds=5;
        let timer=null;
        function next(){
            stop();
            const food=document.getElementById('mainfood');
            const drink=document.getElementById('drink');
            const snack=document.getElementById('snack');
            let remaining=totalSeconds;
            timer=setInterval(
                function(){
                    remaining--;
                    if(remaining===0){
                        if(food.classList.contains('active')){
                            drink.classList.add('active');   
                            snack.classList.remove('active');   
                            food.classList.remove('active');
                            document.getElementById('menu-drink').classList.remove('hide');
                            document.getElementById('menu-food').classList.add('hide');
                            document.getElementById('menu-snack').classList.add('hide');
                        }
                        else if(drink.classList.contains('active')){
                            snack.classList.add('active');   
                            drink.classList.remove('active');   
                            food.classList.remove('active');
                            document.getElementById('menu-snack').classList.remove('hide');
                            document.getElementById('menu-food').classList.add('hide');
                            document.getElementById('menu-drink').classList.add('hide');
                        }
                        else if(snack.classList.contains('active')){
                            food.classList.add('active');   
                            drink.classList.remove('active');   
                            snack.classList.remove('active');
                            document.getElementById('menu-food').classList.remove('hide');
                            document.getElementById('menu-drink').classList.add('hide');
                            document.getElementById('menu-snack').classList.add('hide');
                        }
                        remaining=totalSeconds;
                    }
                },1000);
        }
        function stop() {
            if (timer) {
                clearInterval(timer); 
                timer = null; 
            }
        }
    </script>
</body>
</html>
```
##JavaScript 基础 DOM 操作学习笔记与收获
###核心知识点梳理
1. 获取元素
要操作元素，首先需要定位元素，下面有几种常见的定位元素方式：
  1. 通过 ID 获取：const element = document.getElementById("id名");
  2. 通过类名获取：const elements = document.getElement(s)ByClassName("类名")，如果是多个元素，则需通过索引（如 elements[0]）或遍历来获取单个元素。
  3. 通过 CSS 选择器获取，这种方式更灵活，如果是单个元素，就使用const element = document.querySelector("CSS选择器"); 如果是多个元素，就使用const elements = document.querySelectorAll("CSS选择器"); 
2. 添加事件
事件是用户与页面的交互行为，通过事件监听可在行为触发时执行java代码。常见的事件类型有：click：点击；mouseenter：鼠标移入该区域；mouseleave：鼠标移出该区域；keydown：键盘按下；load：页面加载完成。
3. 控制元素的类名
通过操作元素的class属性，可动态修改元素样式。
通过 classList 操作更灵活，有以下几个常见的操作：1.添加类名：element.classList.add("className")；2.移除类名：element.classList.remove("className")；3.切换类名（存在则移除，不存在则添加）：element.classList.toggle("className")；
4. java的相关变量：
  1. let 声明的变量只在 let 命令所在的代码块 {} 内有效，在 {} 之外不能访问；
  2. 在函数体内使用 var 和 let 关键字声明的变量类似,它们的作用域都是局部的;                                                                                
5. 使用 var 关键字声明的变量在任何地方都可以修改，在相同的作用域或块级作用域中，不能使用 let 关键字来重置 let 关键字声明的变量;但let、const关键字在不同作用域，或不同块级作用域中是可以重新声明赋值的;
6. const 用于声明一个或多个常量，声明时必须进行初始化，且初始化后值不可再修改，使用 const 定义的对象或者数组其实是可变的，但是不能对常量对象重新赋值。
###学习收获与感悟（遇到的问题及解决方式）
1. 对于java的弹窗，一开始其实我是想修改一下弹窗的样式，但是去查了发现如果用alert弹窗是不能修改样式的，就没有再改；
2. 对于定时默认菜单切换和高亮菜单选项，一开始是不知道怎么使用java实现，后来知道可以用class属性来操控元素的样式；
3. 对于计时器，一开始漏掉了那个“，1000”然后运行不了，之后了解到了它的结构是函数+“，1000”。