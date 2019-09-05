package com.retrofit.imitate;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DyncmicProxy {
    String TAG = "DyncmicProxy";

    List<DyAdapter.Factory> dyFactorys = new ArrayList<>();

    public DyncmicProxy() {
        dyFactorys.add(new DyAdapter.FactoryDestView());
        dyFactorys.add(new DyAdapter.FactoryString());
    }

    public Object create(Class<?> service) {
        return Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Log.d(TAG, method.getName());
                for (int i = 0; i < args.length; i++) {
                    Log.d(TAG, args[i] + "");
                }

                Type returnType = method.getGenericReturnType();
                Annotation[] annotations = method.getAnnotations();

//                适配器工厂列表
                //适配想要的类型
                //根据method返回类型，找到适配器工厂，get方法返回适配器，adapter适配得到具体需求类型。
                DyAdapter dyAdapter = null;
                for (int i = 0; i < dyFactorys.size(); i++) {
                    DyAdapter.Factory factory = dyFactorys.get(i);
                    dyAdapter = factory.get(returnType, annotations);
                    if (dyAdapter != null) {
                        break;
                    }
                }
                //默认返回String
                return dyAdapter.adapt("initValue");
            }
        });

    }

}
