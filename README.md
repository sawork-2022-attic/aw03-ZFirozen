# WebPOS

通过本次作业对MVC架构的理解：

作业中，网页视图由其视图控制器管理，每一个组件与其数据模型分别对应；用户在页面上的操作经由控制器处理，转化为对数据模型方法的调用，控制器接收调用返回的结果后再更新视图。

这样的架构可以将视图（用户界面）与模型通过统一的控制器进行映射，结构更清晰，也便于代码进行修改，一处改动只要确保其接口（返回的内容）没有变化，而无需对程序的其他部分进行任何变动。

The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web ui (https://github.com/bshbsh404/simple-pos-ui
).

![](screenshot.png)

To run

```shell
mvn clean spring-boot:run
```

Currently, it just lists the products for sale with a cart with one item (just for demonstration). 

Please read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf and make the POS system robust and fully functional. You can also refer to other articles, for instance https://www.baeldung.com/tag/thymeleaf/ .



And please elaborate your understanding in MVC architecture via this homework in your README.md.

