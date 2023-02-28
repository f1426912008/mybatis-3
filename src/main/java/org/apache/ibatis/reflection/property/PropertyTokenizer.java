/**
 *    Copyright 2009-2017 the original author or authors.
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
package org.apache.ibatis.reflection.property;

import java.util.Iterator;

/**
 * @author Clinton Begin
 */
public class PropertyTokenizer implements Iterator<PropertyTokenizer> {
  private String name;    // 父属性字段的名字，
  private final String indexedName;   // 当前标记下标的属性字段名字
  private String index;   // 属性下标（如果当前的属性是集合）
  private final String children;    // 子属性字段

  /**
   * 根据入参的属性值，取出入参内部的变量的值
   * 例如：入参 #{student.address}，表示获取学生地址的值
   *
   * @param fullname
   */
  public PropertyTokenizer(String fullname) {
    int delim = fullname.indexOf('.');
    if (delim > -1) {     // 如果入参包含有点，说明需要获取入参内部的某个属性
      name = fullname.substring(0, delim);
      children = fullname.substring(delim + 1);
    } else {    // 不包含点，说明已经是最后一级的字段了，没有子属性字段
      name = fullname;
      children = null;
    }
    indexedName = name;   // 初始下标为第一个父属性名字
    delim = name.indexOf('[');
    if (delim > -1) {
      index = name.substring(delim + 1, name.length() - 1);
      name = name.substring(0, delim);
    }
  }

  public String getName() {
    return name;
  }

  public String getIndex() {
    return index;
  }

  public String getIndexedName() {
    return indexedName;
  }

  public String getChildren() {
    return children;
  }

  @Override
  public boolean hasNext() {
    return children != null;
  }

  @Override
  public PropertyTokenizer next() {
    return new PropertyTokenizer(children);
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Remove is not supported, as it has no meaning in the context of properties.");
  }
}
