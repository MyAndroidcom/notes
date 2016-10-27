## Java基础
1.java中try中有return，后面有finally执行顺序问题
return和finally谁先执行,走到Return所在行,就进Finally,然后在回到Rerurn,做返回.
2.在try语句中，在执行return语句时，要返回的结果已经准备好了，就在此时，程序转到finally执行了。
在转去之前，try中先把要返回的结果存放到不同于x的局部变量中去，执行完finally之后，在从中取出返回结果，
因此，即使finally中对变量x进行了改变，但是不会影响返回结果。
它应该使用栈保存返回值。
2.谈谈final,finally,finalize的区别。
- final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为abstract的，又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，不可修改。被声明为final的方法也同样只能使用，不能重载。
- finally—异常处理时提供finally块来执行任何清除操作。如果抛出一个异常，那么相匹配的catch子句就会执行，然后控制就会进入finally块（如果有的话）。
- finalize—方法名。Java技术允许使用finalize()方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的。它是在Object类中定义的，因此所有的类都继承了它。子类覆盖finalize()方法以整理系统资源或者执行其他清理工作。finalize()方法是在垃圾收集器删除对象之前对这个对象调用的。
3.数组中没有length(),有length的属性,String中有length()

