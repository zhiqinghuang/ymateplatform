/**
 * <p>文件名:	ILogConfig.java</p>
 * <p>版权:		详见产品版权说明书</p>
 * <p>公司:		YMateSoft Co., Ltd.</p>
 * <p>项目名：	yMatePlatform_V2_1</p>
 * <p>作者：		刘镇(suninformation@163.com)</p>
 */
package net.ymate.platform.commons.logger;

import net.ymate.platform.commons.logger.ILogger.LogLevel;

/**
 * <p>
 * ILogConfig
 * </p>
 * <p>
 * 日志记录器框架初始化配置接口；
 * </p>
 * 
 * @author 刘镇(suninformation@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th><th width="100px">动作</th><th
 *          width="100px">修改人</th><th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>刘镇</td>
 *          <td>2012-11-27下午7:01:57</td>
 *          </tr>
 *          </table>
 */
public interface ILogConfig {

	/**
	 * 默认的日志记录器名称
	 */
	public static String DEFAULT_LOGGER_NAME = "default";

	/**
	 * 默认的日志记录级别
	 */
	public static LogLevel DEFAULT_LOG_LEVEL = LogLevel.ALL;

	/**
	 * 打印堆栈数量，超过这个数量会省略输出 
	 */
	public static int PRINT_STACK_COUNT = 5;

	/**
	 * @return 返回日志记录器初始化配置文件路径
	 */
	public String getLogCfgFile();

	/**
	 * @return 返回日志文件输出路径
	 */
	public String getLogOutputDir();

	/**
	 * @return 返回日志记录器初始化名称
	 */
	public String getLoggerName();

	/**
	 * @return 返回ILogger接口实现类对象
	 */
	public ILogger getLoggerClassImpl();

	/**
	 * @return 返回日志记录器级别
	 */
	public LogLevel getLogLevel();

	/**
	 * @return 默认实始化日志记录器时，是否允许控制台输出日志
	 */
	public boolean allowPrintConsole();

}
