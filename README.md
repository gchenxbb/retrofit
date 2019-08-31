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