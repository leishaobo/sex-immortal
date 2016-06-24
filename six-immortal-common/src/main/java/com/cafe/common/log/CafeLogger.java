package com.cafe.common.log;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hzleishaobo
 * @version 2016年6月21日
 */
public class CafeLogger {

    private static LogLevel default_level = LogLevel.DEBUG;
    private static LogLevel level = null;

    public static void log(Object object) {
        if (level == null) {
            level = default_level;
        }
        switch (level) {
            case ERROR:
                // 错误处理
                break;
            case WARN:
                // 警告处理
                break;
            case INFO:
                // 信息处理
                break;
            case DEBUG:
                // 调试处理
                error(object);
                break;
            default:
                // 默认处理
                break;
        }
    }

    private static void error(Object object) {
        System.out.println(object);
    }

    private static void warn(Object object) {

    }

    private static void info(Object object) {

    }

    private static void debug(Object object) {

    }

    private enum LogLevel {

        ERROR(0, "error", "错误级别"),
        WARN(1, "warn", "警告级别"),
        INFO(2, "info", "信息级别"),
        DEBUG(3, "debug", "调试级别");
        private static final Map<Integer, LogLevel> value_map = new HashMap<Integer, LogLevel>();
        static {
            for (LogLevel logLevel : LogLevel.values()) {
                value_map.put(logLevel.getLevel(), logLevel);
            }
        }

        private Integer level;
        private String name;
        private String desc;

        LogLevel(Integer level, String name, String desc) {
            this.level = level;
        }

        public static LogLevel getLogLevelByLevel(Integer level) {
            return value_map.get(level);
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

    }
}
