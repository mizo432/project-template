package org.venusPj.gfw.common.exception;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

public class ExceptionLogger implements InitializingBean {

    /**
     * Logger suffix of monitoring log.
     */
    private static final String MONITORING_LOG_LOGGER_SUFFIX = ".Monitoring";

    /**
     * Logger for application log output.
     */
    private final Logger applicationLogger;

    /**
     * Logger for monitoring log output.
     */
    private final Logger monitoringLogger;

    /**
     * Logger for each log level.
     */
    private final Map<ExceptionLevel, LogLevelWrappingLogger> exceptionLevelLoggers = new ConcurrentHashMap<ExceptionLevel, LogLevelWrappingLogger>();

    /**
     * Logger that outputs log at INFO log level.
     */
    private final InfoLogger infoLogger;

    /**
     * Logger that outputs log at WARN log level.
     */
    private final WarnLogger warnLogger;

    /**
     * Logger that outputs log at ERROR log level.
     */
    private final ErrorLogger errorLogger;

    /**
     * Object that resolves exception code.
     */
    private ExceptionCodeResolver exceptionCodeResolver = new SimpleMappingExceptionCodeResolver();

    /**
     * Object that resolves exception level.
     */
    private ExceptionLevelResolver exceptionLevelResolver;

    /**
     * placeholder for exception code of log formatter.
     */
    private String PLACEHOLDER_OF_EXCEPTION_CODE = "{0}";

    /**
     * placeholder for exception message of log formatter.
     */
    private String PLACEHOLDER_OF_EXCEPTION_MESSAGE = "{1}";

    /**
     * Message formatter for log output.
     */
    private String logMessageFormat = String.format("[%s] %s",
        PLACEHOLDER_OF_EXCEPTION_CODE, PLACEHOLDER_OF_EXCEPTION_MESSAGE);

    /**
     * Default exception code in case it is not specified.
     */
    private String defaultCode = "UNDEFINED-CODE";

    /**
     * Default exception message in case it is not specified.
     */
    private String defaultMessage = "UNDEFINED-MESSAGE";

    /**
     * Log message trim flag.
     */
    private boolean trimLogMessage = true;

    /**
     * Default constructor.
     * <p>
     * {@link #ExceptionLogger(String)} is called with FQCN of this class as parameter.
     * </p>
     */
    public ExceptionLogger() {
        this(ExceptionLogger.class.getName());
    }

    /**
     * Constructor
     * <p>
     * Based on the name specified in the parameters, logger for application log and <br> logger for
     * monitoring log is fetched.
     * </p>
     * <p>
     * Logger Name<br>
     * <ul>
     * <li>logger for output of application log: {name}</li>
     * <li>logger for output of monitoring log: {name} + ".Monitoring"</li>
     * </ul>
     *
     * @param name name of logger
     */
    public ExceptionLogger(String name) {
        this.applicationLogger = LoggerFactory.getLogger(name);
        this.monitoringLogger = LoggerFactory.getLogger(name
            + MONITORING_LOG_LOGGER_SUFFIX);
        this.infoLogger = new InfoLogger();
        this.warnLogger = new WarnLogger();
        this.errorLogger = new ErrorLogger();
    }

    /**
     * Set the resolver object for exception code.
     * <p>
     * If the exception code resolution object is not set, exception code is not output to the log.
     * </p>
     *
     * @param exceptionCodeResolver exception code resolution object
     */
    public void setExceptionCodeResolver(
        ExceptionCodeResolver exceptionCodeResolver) {
        this.exceptionCodeResolver = exceptionCodeResolver;
    }

    /**
     * set the resolution object for exception level.
     * <p>
     * If the exception level resolution object is not set, exception level is not output to the
     * log.
     * </p>
     *
     * @param exceptionLevelResolver exception level resolution object.
     */
    public void setExceptionLevelResolver(
        ExceptionLevelResolver exceptionLevelResolver) {
        this.exceptionLevelResolver = exceptionLevelResolver;
    }

    /**
     * set the log format.
     * <p>
     * It is possible to specify the output position of the exception message and exception code in
     * log format. <br> The position can specified using "{0}" for exception code and "{1}" for
     * exception message.<br> "{0}" and "{1}" is must be specified. if changed validation rule of
     * logMessageFormat, please override {@link #validateLogMessageFormat(String)} method.
     * </p>
     *
     * @param logMessageFormat log format.
     */
    public void setLogMessageFormat(String logMessageFormat) {
        this.logMessageFormat = logMessageFormat;
    }

    /**
     * Set the trim flag of log message.
     * <p>
     * Default is <code>true</code>
     * </p>
     *
     * @param trimLogMessage set <code>true</code> for trimming
     */
    public void setTrimLogMessage(boolean trimLogMessage) {
        this.trimLogMessage = trimLogMessage;
    }

    /**
     * Set default exception code.
     *
     * @param defaultCode default exception code.
     */
    public void setDefaultCode(String defaultCode) {
        this.defaultCode = defaultCode;
    }

    /**
     * Set default exception message.
     *
     * @param defaultMessage default exception message.
     */
    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    @Override
    public void afterPropertiesSet() {

        validateLogMessageFormat(logMessageFormat);

        if (exceptionLevelResolver == null) {
            exceptionLevelResolver = new DefaultExceptionLevelResolver(exceptionCodeResolver);
        }
        registerExceptionLevelLoggers(ExceptionLevel.INFO, infoLogger);
        registerExceptionLevelLoggers(ExceptionLevel.WARN, warnLogger);
        registerExceptionLevelLoggers(ExceptionLevel.ERROR, errorLogger);
    }

    public void log(Exception ex) {
        ExceptionLevel level = exceptionLevelResolver.resolveExceptionLevel(ex);
        LogLevelWrappingLogger logger = null;
        if (level != null) {
            logger = exceptionLevelLoggers.get(level);
        }
        if (logger == null) {
            logger = errorLogger;
        }
        log(ex, logger);
    }

    public void info(Exception ex) {
        log(ex, infoLogger);
    }

    public void warn(Exception ex) {
        log(ex, warnLogger);
    }

    public void error(Exception ex) {
        log(ex, errorLogger);
    }

    protected void validateLogMessageFormat(String logMessageFormat) {
        if (logMessageFormat == null || !logMessageFormat.contains(
            PLACEHOLDER_OF_EXCEPTION_CODE) || !logMessageFormat.contains(
            PLACEHOLDER_OF_EXCEPTION_MESSAGE)) {
            String message = "logMessageFormat must have placeholder({0} and {1})."
                + " {0} is replaced with exception code."
                + " {1} is replaced with exception message. current logMessageFormat is \""
                + logMessageFormat + "\".";
            throw new IllegalArgumentException(message);
        }
    }

    protected String resolveExceptionCode(Exception ex) {
        String exceptionCode = null;
        if (exceptionCodeResolver != null) {
            exceptionCode = exceptionCodeResolver.resolveExceptionCode(ex);
        }
        return exceptionCode;
    }

    protected String makeLogMessage(Exception ex) {
        String exceptionCode = resolveExceptionCode(ex);
        return formatLogMessage(exceptionCode, ex.getMessage());
    }

    protected String formatLogMessage(String exceptionCode,
        String exceptionMessage) {

        String bindingExceptionCode = exceptionCode;
        String bindingExceptionMessage = exceptionMessage;
        if (!StringUtils.hasText(bindingExceptionCode)) {
            bindingExceptionCode = defaultCode;
        }
        if (!StringUtils.hasText(bindingExceptionMessage)) {
            bindingExceptionMessage = defaultMessage;
        }

        String message = MessageFormat.format(logMessageFormat,
            bindingExceptionCode, bindingExceptionMessage);
        if (trimLogMessage) {
            message = message.trim();
        }
        return message;
    }

    protected void registerExceptionLevelLoggers(ExceptionLevel level,
        LogLevelWrappingLogger logger) {
        this.exceptionLevelLoggers.put(level, logger);
    }

    protected Logger getApplicationLogger() {
        return applicationLogger;
    }

    protected Logger getMonitoringLogger() {
        return monitoringLogger;
    }

    private void log(Exception ex, LogLevelWrappingLogger logger) {
        if (!logger.isEnabled()) {
            return;
        }
        String logMessage = makeLogMessage(ex);
        logger.log(logMessage, ex);
    }

    protected interface LogLevelWrappingLogger {

        /**
         * Determines if the logger is valid.
         *
         * @return Returns <code>true</code> if valid.
         */
        boolean isEnabled();

        /**
         * Outputs the log.
         *
         * @param logMessage log message
         * @param ex         Exception
         */
        void log(String logMessage, Exception ex);

    }

    private final class InfoLogger implements LogLevelWrappingLogger {

        @Override
        public boolean isEnabled() {
            return monitoringLogger.isInfoEnabled() || applicationLogger
                .isInfoEnabled();
        }

        @Override
        public void log(String logMessage, Exception ex) {
            if (monitoringLogger.isInfoEnabled()) {
                monitoringLogger.info(logMessage);
            }
            if (applicationLogger.isInfoEnabled()) {
                applicationLogger.info(logMessage, ex);
            }
        }
    }

    private final class WarnLogger implements LogLevelWrappingLogger {

        @Override
        public boolean isEnabled() {
            return monitoringLogger.isWarnEnabled() || applicationLogger
                .isWarnEnabled();
        }

        @Override
        public void log(String logMessage, Exception ex) {
            if (monitoringLogger.isWarnEnabled()) {
                monitoringLogger.warn(logMessage);
            }
            if (applicationLogger.isWarnEnabled()) {
                applicationLogger.warn(logMessage, ex);
            }
        }
    }

    private final class ErrorLogger implements LogLevelWrappingLogger {

        @Override
        public boolean isEnabled() {
            return monitoringLogger.isErrorEnabled() || applicationLogger
                .isErrorEnabled();
        }

        @Override
        public void log(String logMessage, Exception ex) {
            if (monitoringLogger.isErrorEnabled()) {
                monitoringLogger.error(logMessage);
            }
            if (applicationLogger.isErrorEnabled()) {
                applicationLogger.error(logMessage, ex);
            }
        }
    }

}
