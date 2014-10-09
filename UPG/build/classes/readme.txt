一.如果打包为ear包
将reportConfig.xml,runqianLinuxServer.lic(windows版本将runqianWindowServer.lic)复制到web-info
并修改web.xml中
    <init-param>
      <param-name>configFile</param-name>
      <param-value>/WEB-INF/classes/reportConfig.xml</param-value>
    </init-param>
修改为
    <init-param>
      <param-name>configFile</param-name>
      <param-value>/WEB-INF/reportConfig.xml</param-value>
    </init-param>
二.正式上线配置文件配置:
 struts.xml中修改参数为
<constant name="struts.convention.classes.reload" value="false" />
<constant name="struts.devMode" value="false" />
<constant name="webwork.devMode" value="false" />
<constant name="struts.freemarker.templatesCache" value="true" />
log4j中将DEBUG全部改为ERROR
spring-datasource.xml中将jdbc直连方式修改为jndi
freemarker.properties中修改template_update_delay=600000
三.如果为ear包，修改下面参数为
<constant name="struts.convention.exclude.parentClassLoader" value="false" />

  
  