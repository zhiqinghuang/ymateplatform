/**
 * <p>文件名:	IConnectionHolder.java</p>
 * <p>版权:		详见产品版权说明书</p>
 * <p>公司:		YMateSoft Co., Ltd.</p>
 * <p>项目名：	yMatePlatform_V2_1</p>
 * <p>作者：		刘镇(suninformation@163.com)</p>
 */
package net.ymate.platform.persistence.jdbc;

import java.sql.Connection;

import net.ymate.platform.persistence.jdbc.base.dialect.IDialect;

/**
 * <p>
 * IConnectionHolder
 * </p>
 * <p>
 * Connection对象持有者接口，用于记录Connection原始的状态及与数据源对应关系；
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
 *          <td>2012-12-29上午12:30:49</td>
 *          </tr>
 *          </table>
 */
public interface IConnectionHolder {

	/**
	 * @return 获取数据源名称
	 */
	public String getDataSourceName();

	/**
	 * @return 获取数据库连接对象
	 */
	public Connection getConnection();

	/**
	 * 释放连接<br/>
	 * 注意：在通过 ISession 和 ITransaction 接口操作时禁止手动使用此方法
	 */
	public void release();

	/**
	 * @return 获取数据库方言
	 */
	public IDialect getDialect();

}
