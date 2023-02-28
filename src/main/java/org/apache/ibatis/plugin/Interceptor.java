/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.util.Properties;

/**
 * 所有的拦截器，都需要实现这个接口
 *
 * @author Clinton Begin
 */
public interface Interceptor {

  /**
   * 用户拦截器执行的业务逻辑代码
   *
   * @param invocation
   * @return
   * @throws Throwable
   */
  Object intercept(Invocation invocation) throws Throwable;

  /**
   * 扫描插件，为拦截方法生成反射对象
   *
   * @param target
   * @return
   */
  Object plugin(Object target);

  /**
   * 可以给拦截器设置一些自定义参数，xml在配置
   */
  void setProperties(Properties properties);

}
