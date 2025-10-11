### 第一次尝试
听信教程使用torchmetric，安装后`import torch`报错，检查发现`torch.__version__`都报错，经过不断检查，发现插件torchmetric版本不兼容，删除重装无果，遂重装环境，放弃此插件。  
![](../assets/question2/error1.png)  
### 第二次尝试  
先构造一个卷积层，使用torch架构。  
```python
import torch
import torch.nn as nn


n,c,h,w = 1,3,8,8   #设置超参数
co,k= 16,3 
s,p=1,1


inp=torch.randn(n,c,h,w)   #构造卷积层
ho=(h-k+2*p)/s+1
wo=(w-k+2*p)/s+1
layer=nn.Conv2d(in_channels=c,out_channels=co,kernel_size=k,stride=s,padding=p)
out=layer(inp)


print(f"输入张量的形状: {inp.shape}")   #输出试验
print(f"输出尺寸: {int(ho)}x{int(wo)}")
print(f"卷积层权重形状: {layer.weight.shape}") 
print(f"张量的形状: {outr.shape}") 
```  
没有输出。  
![](../assets/question2/error2.png)
检查发现参数没有对应。改正后依旧没有输出，重启电脑后回复正常，推测编译器的问题。  
![](../assets/question2/result0.png)
但是没有池化层，只能输入较小的数据