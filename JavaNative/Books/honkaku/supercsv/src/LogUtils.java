import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
    private Logger logger = LoggerFactory.getLogger(LogUtils.class);
    public void error(){
        logger.info("run error");
    }

}
