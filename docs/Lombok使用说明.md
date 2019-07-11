# Lombok使用说明

Lombok是一款实用工具，借此可以消除许多冗余的代码，提升代码可读性。Lombok基于注解实现，在编译时其注解会变成相应代码，故无需担心性能问题。

## Lombok注解说明

`@Getter` 生成getter代码。

```java
//使用@Getter注解
@Getter
public class Test {
    private String hello;
}
//不使用注解，两者等价
public class Test {
    private String hello;

    public String getHello() {
        return hello;
    }
}
```

`@Setter` 生成setter代码。

```java
//使用@Getter注解
@Setter
public class Test {
    private String hello;
}
//不使用注解，两者等价
public class Test {
    private String hello;

    public void setHello(String hello) {
        this.hello = hello;
    }
}
```

`@Data` 生成getter，setter，toString()，hashCode()，equals()方法和相应参数的构造器，等同于`@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode`的组合注解。

```java
@Data
public class Test {
    private String hello;
}

public class Test {
    private String hello;
    /*Getter and Setter method*/
    /*toString() method*/
    /*equal() and hashCode() method*/
    /*Required arguments are final fields and fields with constraints*/
}
```

`@ToString` 生成toString()方法。

`@EqualsAndHashCode` 生成equal()，hashCode()方法。

`@AllArgsConstructor` 生成全部参数的构造器。

`@NoArgsConstructor` 生成没有参数的构造器。

`@Slf4j` 生成日志对象log，等同于以下代码，其余还有`@Log`，`@Log4j`，`@Log4j2`，`@XSlf4j`，`@JBossLog`，`@Flogger`。

```java
private static final org.slf4j.Logger log =	          org.slf4j.LoggerFactory.getLogger(LogExample.class);
```

## Lombok引入

如果是maven工程，在`pom.xml`下的`dependencies`节点下引入：

```xml
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.18.8</version>
</dependency>
```

## idea正确使用Lombok

在idea使用Lombok时，需要安装插件才能正确使用，否则会报错。点击`Settings` - `Plugins`，搜索Lombok插件安装即可。