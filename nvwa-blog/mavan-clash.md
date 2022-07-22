# 记Maven冲突如何解决

## 什么是Maven冲突
依赖冲突是指项目**依赖的某一个jar包，有多个不同的版本**，因而造成了包版本冲突。
那为什么会有冲突呢？总不会自己把同一个包引入两次把（实际上这样也编译不通过），冲突的根本原因是**传递依赖**导致的冲突。
````
A -> C -> X(1.0)
B -> D -> X(2.0)
````
X是A的**传递依赖**，同时也是B的**传递依赖**，所以如果同时引入了A和B那么就会产生依赖冲突。
## 如何发现依赖冲突
依赖冲突一般会导致**NoClassDefFoundError，ClassNotFoundException，NoSuchMethodError**等异常，原因多是因为依赖冲突导致的。例如Maven采用了A包的1。0版本，在B里面自然找不到在2.0才新增的方法或者类，所以或抛出对应异常。
实际工作中的依赖冲突不会这么明显，我们可以借助工具或者插件。
![https://img-blog.csdnimg.cn/img_convert/62712488522ea963b06563d56abe5ff8.png](https://img-blog.csdnimg.cn/img_convert/62712488522ea963b06563d56abe5ff8.png)
![https://img-blog.csdnimg.cn/img_convert/a71773270e0ee98ec4a5c9965746631d.png](https://img-blog.csdnimg.cn/img_convert/a71773270e0ee98ec4a5c9965746631d.png)
![https://img-blog.csdnimg.cn/img_convert/6636002e2e1776086f64a79d84dd5bda.png](https://img-blog.csdnimg.cn/img_convert/6636002e2e1776086f64a79d84dd5bda.png)
如果是线上或者预发环境无法使用插件，可以使用mvn命令
```shell
mvn dependency:tree -Dverbose
```

## 依赖冲突的默认规则
maven依赖主要有**路径优先**和**第一声明优先**规则，官网的解释如下：
Dependency mediation - this determines what version of an artifact will be chosen when multiple versions are encountered as dependencies. Maven picks the "nearest definition". That is, it uses the version of the closest dependency to your project in the tree of dependencies. You can always guarantee a version by declaring it explicitly in your project's POM. Note that if two dependency versions are at the same depth in the dependency tree, the first declaration wins.
"nearest definition" means that the version used will be the closest one to your project in the tree of dependencies. Consider this tree of dependencies:
````
A
├── B
│   └── C
│       └── D 2.0
└── E
└── D 1.0
````
In text, dependencies for A, B, and C are defined as A -> B -> C -> D 2.0 and A -> E -> D 1.0, then D 1.0 will be used when building A because the path from A to D through E is shorter. You could explicitly add a dependency to D 2.0 in A to force the use of D 2.0, as shown here:
````
A
├── B
│   └── C
│       └── D 2.0
├── E
│   └── D 1.0
│
└── D 2.0      
````
Dependency management - this allows project authors to directly specify the versions of artifacts to be used when they are encountered in transitive dependencies or in dependencies where no version has been specified. In the example in the preceding section a dependency was directly added to A even though it is not directly used by A. Instead, A can include D as a dependency in its dependencyManagement section and directly control which version of D is used when, or if, it is ever referenced.
Dependency scope - this allows you to only include dependencies appropriate for the current stage of the build. This is described in more detail below.
Excluded dependencies - If project X depends on project Y, and project Y depends on project Z, the owner of project X can explicitly exclude project Z as a dependency, using the "exclusion" element.
Optional dependencies - If project Y depends on project Z, the owner of project Y can mark project Z as an optional dependency, using the "optional" element. When project X depends on project Y, X will depend only on Y and not on Y's optional dependency Z. The owner of project X may then explicitly add a dependency on Z, at her option. (It may be helpful to think of optional dependencies as "excluded by default.")

## 如何排除依赖
### 使用exclusion
exclusions可以包含一个或者多exclusion子元素，因此可以排除一个或者多个传递性依赖。
```java
<dependency>
        <groupId>org.apache.poigroupId>
        <artifactId>poi-ooxmlartifactId>
        <version>3.10.1version>
            
        <exclusions>
            <exclusion>
                <artifactId>poiartifactId>
                <groupId>org.apache.poigroupId>
             exclusion>
        exclusions>
<dependency>
```

### 使用dependencyManagement
如果冲突的包比较多，一个一个的exclusion相当费力，于是我们可以使用dependencyManagement
dependencyManagement可以统一管理子包引用的包版本。
```java
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.10</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```