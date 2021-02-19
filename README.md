# Retrofit
Retrofit+okhttp

1,在OkhttpCall中，创建内部okhttp3的Call，创建时机在发起请求时，execute，enqueue。
ServiceMethod的toRequest方法，根据invoke拦截到到接口方法参数args数组。
创建一个ParameterHandler数组，分配一个参数处理handler。
ServiceMethod创建build时，根据Method获取到参数注解数组的数量，构造ParameterHandler数组。
解析参数注解的数组。类型
Url
Path
Query
QueryName
QueryMap
Header
HeaderMap
Field
FieldMap
Part
PartMap
Body
根据这些注解和参数类型Type，类型包括String，HttpUrl等，构建不同的ParameterHandler子类，存放在ParameterHandler数组。

在toRequest方法时，ParameterHandler数组每一项，apply方法，解析对应参数数组元素，参数解析到RequestBuilder中。
举例，Query注解参数，在Query类到apply方法，Query类是ParameterHandler子类，将传入到参数值转换成String类型value，通过Converter转换器。
RequestBuilder建造者到ddQueryParam方法，将参数name和value，name就是从注解Annotation中的value值，即传递的http参数变量。
value就是Method拦截的args参数值。
转换器是从工厂列表中，找到一个可以转换String类型的Converter转换器。工厂列表中未找到，返回兜底转换器ToStringConverter。

通过handler数组，将每一项参数添加到RequestBuilder中。handler的的功能是获取解析参数名和参数值。

addQueryParam方法和addFormField方法，分别将参数添加到RequestBuilder内部的urlBuilder和formBuilder中。
uriBuilder是HttpUrl.Builder，formBuilder是FormBody.Builder。

2,创建okhttp3的Request时，通过Retrofit的RequestBuilder内部，okhttp3的Request.Builder，build()方法
构建okhttp3的Builder构建参数包括，HttpUrl，请求类型method，RequestBody，headers。这些都在Retrofit的RequestBuilder内部。

3,HttpUrl,有一个保存请求key和value的数组，queryNamesAndValues。在最后Retrofit的RequestBuilder，build时，先
build一个HttpUrl，最后在build okhttp3的Request。

4，okhttp3中是否有RequestBody，如果是POST方法注解和Field参数注解，在Field参数处理类中，apply方法，会将参数kv添加到formBuilder，
build Request时，如果有formBuilder，创建RequestBody子类FormBody类型。formBuilder是FormBody的建造者。

5，参数类型会包含RequestBody，有Body参数处理类，此时，build Request时，，内部是已经存在body的。

6，FormBody内部分别包含name和value的列表，对name和value，加入列表前，需要规范化每个字符，



## 原理解析搬到简书

#### ButterKnife优势
1，一个View注入框架，去除了用大量繁重的findViewById查找View对象，总的来说，就是省事。<br />
2，使用注解，如@BindView(R.id.view)，性能基本无损耗，不会影响效率，因为不是在运行时反射，而是在编译时生成新class。<br />
3，可以处理View绑定与事件点击等功能，使代码简洁可读。<br />  

#### 配置
project的build.gradle加入依赖<br />  
`classpath 'com.jakewharton:butterknife-gradle-plugin:8.5.1'`

module的的build.gradle加入插件<br />  
`apply plugin: 'com.jakewharton.butterknife'`

module的的build.gradle加入依赖<br />  
`compile "com.jakewharton:butterknife:8.5.1"
annotationProcessor "com.jakewharton:butterknife-compiler:8.5.1"`

#### 插件
AS安装Android ButterKnife Zelezny插件
重启AS后就能愉快的使用ButterKnife了。

#### 绑定注解示例
绑定视图：@BindView()<br />  
绑定字符串：@BindString()<br />  
绑定array数组：@BindArray()<br />  
绑定color：@BindColor()<br />  
绑定图片资源：@BindBitmap()<br />  

#### 事件注解示例
点击事件：@OnClick<br />  
选中改变事件：@OnCheckedChanged<br />  
Item点击事件：@OnItemClick<br />  
长按事件：@OnLongClick<br />  

#### 加入混淆
-keep class butterknife.** { *; }<br />  
-dontwarn butterknife.internal.**<br />  
-keep class **$$ViewBinder { *; }<br />  
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#### 实现原理，编译时的注解解析
声明的注解的生命周期为CLASS，@Retention(CLASS)。
在编译时，编译器扫描所有带有这些注解的类，处理注解，根据注解，生成一个java类。该类有绑定View对象与事件监听的java代码。
这样，在运行时，就会调用这些java代码。

ButterKnife.bind(this)方法，根据Activity，getWindow和getDecorView获取顶层视图DecorView。
调用createBinding方法，拿到继承Unbinder子类的构造器Constructor，传入Activity与DecorView，创建对象。

#### Unbinder子类的构造器如何得到？
`Class<?> bindingClass = Class.forName(clsName + "_ViewBinding");`<br />  
根据当前Activity类的Name，获取一个Activity_ViewBinding的class。
`bindingCtor = (Constructor<? extends Unbinder>) bindingClass.getConstructor(cls, View.class);`<br />  
获取新类Activity_ViewBinding的构造器。Activity_ViewBinding的构造方法传入Activity与DecorView。
在Activity_ViewBinding构造方法中，使用findViewById绑定View对象，并赋值给传入Activity中定义的View对象。

#### 新类从哪里来？
编译的时候生成代码。注解处理器butterknife-compiler，先扫描所有的Java源文件，解析注解，生成对应java源文件。再生成字节码文件。

#### bind的本质是根据构造器动态创建新类的对象，利用新类findViewById获取View对象以及绑定事件，将对象交给传入的原类Activity。
(新类是在编译时处理，根据注解创建，新类内部View与id绑定。)
这样，原Activity就拥有View对象和事件啦。


编译后，在build/generated/source/apt/debug中可以找到MainActivity_ViewBinding的java文件，实现Unbinder接口。<br />  
运行时，即使没有声明这个MainActivity_ViewBinding类也不会报错，Class.forName一定会找到该类，因为编译成字节码之前会生成它的java文件。
