package com.retrofit.imitate;

import com.retrofit.util.ReflectUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface DyAdapter<T, R> {

    T adapt(R ob);

    abstract class Factory {

        public abstract DyAdapter<?, ?> get(Type returnType, Annotation[] annotations);

    }

    public class FactoryString extends Factory {

        @Override
        public DyAdapter<?, ?> get(Type returnType, Annotation[] annotations) {
            if (ReflectUtil.getRawType(returnType) != String.class) {
                return null;
            }
            return new DyAdapter<String, String>() {
                @Override
                public String adapt(String ob) {
                    return "dyinvoke-linked-" + ob;
                }
            };
        }
    }

    public class FactoryDestView extends Factory {

        @Override
        public DyAdapter<?, ?> get(Type returnType, Annotation[] annotations) {
            if (ReflectUtil.getRawType(returnType) != DestCiew.class) {
                return null;
            }
            return new DyAdapter<DestCiew, String>() {
                @Override
                public DestCiew adapt(String ob) {
                    return new DestCiew(ob);
                }
            };
        }
    }


}
