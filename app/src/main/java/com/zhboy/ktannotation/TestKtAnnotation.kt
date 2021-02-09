package com.zhboy.ktannotation

//-------------------------------定义注解---------------------------------------

@Target(
    //类注释
    AnnotationTarget.CLASS,
    //属性变量注释
    AnnotationTarget.FIELD,
    //函数方法注释
    AnnotationTarget.FUNCTION,
    //方法参数注释
    AnnotationTarget.VALUE_PARAMETER
)

@Retention(AnnotationRetention.RUNTIME)
annotation class RequestParam(val name: String, val value: String)

//-------------------------------使用注解---------------------------------------

@RequestParam(name = "这个类用来干啥", value = "泡茶")
class TeaRequest {

    @RequestParam(name = "茶的年份", value = "2021年")
    private var teaTime: String = "2021年"

    /**
     * 泡茶
     * @param cupColor 水杯颜色
     * @param teaType 茶的类型
     */
    @RequestParam(name = "方法的作用",value = "泡茶")
    private fun makeTea(
        @RequestParam(name = "水杯颜色", value = "红色")
        cupColor: String,
        @RequestParam(name = "茶的类型", value = "红茶")
        teaType: String
    ) {

    }
}
//-------------------------------获取注解的值---------------------------------------

//获取类上面的注解
fun getClassAnnotation() {
    val clazz = TeaRequest::class.java
    val annotation = clazz.getAnnotation(RequestParam::class.java)
    println("类注解的值: ${annotation?.name},${annotation?.value}")
}

//获取属性变量的注解
fun getFieldAnnotation() {
    val clazz = TeaRequest::class.java
    val annotations = clazz.declaredFields
    for (annotation in annotations) {
        val a = annotation.getAnnotation(RequestParam::class.java)
        println("属性变量注解的值: ${a?.name},${a?.value}")
    }
}

//获取函数上面的注解
fun getFunctionAnnotation() {
    val clazz = TeaRequest::class.java
    val annotations = clazz.declaredMethods
    for (annotation in annotations) {
        val a = annotation.getAnnotation(RequestParam::class.java)
        println("函数注解的值: ${a?.name},${a?.value}")
    }
}

//获取方法参数上注解的值
fun getParameterAnnotation() {
    val clazz = TeaRequest::class.java
    val me = clazz.getDeclaredMethod("makeTea", String::class.java, String::class.java)
    val parameterAnnotations = me.parameterAnnotations
    for (parameters in parameterAnnotations) {
        for (param in parameters) {
            if (param is RequestParam) {
                println("参数注解的值：${param.name},${param.value}")
            }
        }
    }
}

fun testAnnotation(){
    getClassAnnotation()
    getFieldAnnotation()
    getFunctionAnnotation()
    getParameterAnnotation()
}