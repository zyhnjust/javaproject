package rpc.proxy.dynamic5ProxyLambda;

import rpc.proxy.HelloIfc;
import rpc.proxy.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: rpc_learn
 * @description:
 * @author: hzhang
 * @create: 2019-08-10 17:00
 *
 * 和4 是一样的只是 intellij 给合并了一下， 代码一样 ，不是lambda 注意。
 **/
public class JDKDynamicMain {

    public static void main(String[]  args){
        HelloIfc proxyInstance = (HelloIfc) Proxy.newProxyInstance(
                HelloIfc.class.getClassLoader(),
                new Class[] { HelloIfc.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] methodArgs) throws Throwable {
                        System.out.println("before");
                        Object result = method.invoke(new HelloImpl(), methodArgs);
                        System.out.println("after");
                        return result;
                    }
                });
        proxyInstance.say("World");
    }
}
