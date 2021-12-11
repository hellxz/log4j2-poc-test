## 免责声明
本demo仅用于验证Log4j2 JNDI LDAP漏洞，测试修复方案是否生效使用。非经本人授权造成的网络攻击，与本人无关。

## 使用方式
待补充。。。

## 修复方案
### 临时修复方案
1. 对于2.0-2.10版本，应先升级至2.10+，再增加jvm参数 `-Dlog4j2.formatMsgNoLookups=true`
2. 修改配置在应用 classpath 下添加 `log4j2.component.properties`配置文件内容如下：
```properties
log4j2.formatMsgNoLookups=true
```
3. 设置系统环境变量 `FORMAT_MESSAGES_PATTERN_DISABLE_LOOKUPS=true`
### 长久修复方案
1. 升级当前 2.15.0 官方稳定版本
2. 升级JDK 高于 1.8.191