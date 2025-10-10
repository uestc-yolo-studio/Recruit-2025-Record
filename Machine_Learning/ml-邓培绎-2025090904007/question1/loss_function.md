## 损失函数
难点：解决局部最优与鞍点的问题，且是对于$f(x_i)$权重$\omega$的函数。  
### 距离损失函数
#### 均方差损失函数MSE
用于度量样本点到回归曲线的距离
$$ 
L(Y|f(x))=\frac{1}{n}\sum_{i=1}^n(Y_i-f(x_i))^2
$$
```python
import numpy as np         
def MSELoss(x:list,y:list):#x:list，代表模型预测的一组数据                      
    assert len(x)==len(y)  #y:list，代表真实样本对应的一组数据
    x=np.array(x)
    y=np.array(y)
    loss=np.sum(np.square(x - y)) / len(x)
    return loss
x=[1,2]                        
y=[0,1]
loss=（（1-0）**2 + （2-1）**2）÷2=（1+1）÷2=1
y_true=torch.tensor(y)
y_pred=torch.tensor(x)
mse_fc = torch.nn.MSELoss(y_true, y_pred)
mse_loss = mse_fc(x,y)
```
### L1曼哈顿距离
残差的绝对值之和
$$
L(Y|f(x))=\sum_{i=1}^n|Y_i-f(x)|
$$
```python
import numpy as np         
def L1Loss(x:list,y:list):
    assert len(x)==len(y)
    x=np.array(x)
    y=np.array(y)
    loss=np.sum(np.abs(x - y)) / len(x)
    return loss
```
### L2欧式距离
标准差，即MSE开算术平方根
### Smooth L1
防止梯度爆炸
$$
L(Y|f(x))= \begin{cases}
\frac{1}{2}(Y_i-f(x_i))^2 & |Y-f(x)|<1 \\\\
|Y-f(x)|-\frac{1}{2} & |Y-f(x)|>=1

\end{cases}
$$
```python
def Smooth_L1(x,y):         
    assert len(x)==len(y)
    loss=0
    for i_x,i_y in zip(x,y):
        tmp = abs(i_y-i_x)
        if tmp<1:
            loss+=0.5*(tmp**2)
        else:
            loss+=tmp-0.5
    return loss
```
### huber
$$
L_{\delta}(y, f(x)) = 
\begin{cases} 
\frac{1}{2}(y - f(x))^2 &  |y - f(x)| \leq \delta \\
\delta |y - f(x)| - \frac{1}{2}\delta^2 & \|y-f(x)|>\delta
\end{cases}
$$
```python
delta=1.0                    #先定义超参数
def huber_loss(x,y):
    assert len(x)==len(y)
    loss=0
    for i_x,i_y in zip(x,y):
        tmp = abs(i_y-i_x)
        if tmp<=delta:
            loss+=0.5*(tmp**2)
        else:
            loss+=tmp*delta-0.5*delta**2
    return loss
```
