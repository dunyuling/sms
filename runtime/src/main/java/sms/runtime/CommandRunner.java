package sms.runtime;

import sms.service.StudentService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandRunner {

    private Map<String,Object> services = new HashMap<>();
    private Map<String, Map<String, Method>> methods = new HashMap<>();

    private Map<String,Class<?>> serviceTypes = Map.of("student", StudentService.class);

    public CommandRunner() {
        serviceTypes.forEach( (type,clazz) ->

                {
//                    System.out.println("clazz: " + clazz);

                    ServiceLoader.load(clazz).findFirst().ifPresent(obj -> {
                        services.put(type,obj);

                        methods.put(type, Stream.of(obj.getClass().getDeclaredMethods()).collect(
                                Collectors.toMap(Method::getName, Function.identity())
                        ));
                    });


                }

        );
    }

    public void run(String service, String task, List<String> args) {
//        System.out.println("----run----");

        Object serviceObj = services.get(service);
        Method method = methods.get(service).get(task);
        try {
            //TODO 不能得到结果,但是测试的反射可以得到结果
            Object result = method.invoke(serviceObj,args.toArray());
            System.out.println("result:" + result);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
