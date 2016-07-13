# MyFirstApp
## 针对比较常用的控件和Activity之间传递数据写的一个小demo

打开该app，首先是一个类似开机界面的界面，停留一秒后，自动跳转到主界面。如下图：

![](http://7xslff.com1.z0.glb.clouddn.com/MyFirstApp_Splash.png)

这里界面的自动跳转用到了Handler的postDelayed方法，Activity间传递数据用到了Intent的putExtra方法，并用startActivity实现跳转，最后利用finish将该界面关闭。

进入主界面，有两个按钮，一个TextView，一个按钮是进入买书界面，点击该按钮将会跳转到买书界面，您要买的书后面是一个TextView，在买书界面输入书名后，提交，会把输入的书名返回给该界面，另一个按钮是重置，点击该按钮，您要买的书就会被重置为空。如下图：

![](http://7xslff.com1.z0.glb.clouddn.com/MyFirstApp_Main.png)

由于用mBtnBuyBook打开的界面要返回数据给该界面，所以打开买书界面应该用startActivityForResult方法，并实现onActivityResult方法，当打开的界面由结果返回时，调用该方法，并在这个方法里将返回的结果显示出来。

进入买书界面，有一个EditText用于输入书名，点击提交，将该书名返回给上一个界面，点击取消按钮，直接返回上一个界面。
![](http://7xslff.com1.z0.glb.clouddn.com/MyFirstApp_BuyActivity.png)

由于需要将输入的书名返回给上一个界面，用Intent保存该书名，并利用setResult方法将该Intent返回给上一个界面，这样就达到了返回数据的目的。

点击提交后，可以看到输入的书名返回到了主界面。
![](http://7xslff.com1.z0.glb.clouddn.com/MyFirstApp_ForResult.png)