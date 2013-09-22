/**
 * <p>文件名:	IEntityRepository.java</p>
 * <p>版权:		详见产品版权说明书</p>
 * <p>公司:		YMateSoft Co., Ltd.</p>
 * <p>项目名：	ymateplatform</p>
 * <p>作者：		刘镇(suninformation@163.com)</p>
 */
package net.ymate.platform.persistence.jdbc.support;

import java.util.List;

import net.ymate.platform.persistence.jdbc.ConnectionException;
import net.ymate.platform.persistence.jdbc.operator.IResultSetHandler;
import net.ymate.platform.persistence.jdbc.operator.OperatorException;
import net.ymate.platform.persistence.jdbc.query.PageResultSet;

/**
 * <p>
 * IEntityRepository
 * </p>
 * <p>
 * 实体存储器接口定义；
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
 *          <td>2013-7-16下午1:23:13</td>
 *          </tr>
 *          </table>
 */
public interface IEntityRepository {

	/**
	 * @param dsName 数据源名称
	 * @return 设置数据源名称，若不设置则将采用框架默认数据源
	 */
	public void setDataSourceName(String dsName);

	public <T, PK> T load(Class<T> t, PK id, String... fieldFilter) throws OperatorException, ConnectionException;

	public <T> T save(T entity) throws OperatorException, ConnectionException;

	public <T> List<T> saveAll(List<T> entities) throws OperatorException, ConnectionException;

	public <T> T update(T entity, String... fieldFilter) throws OperatorException, ConnectionException;

	public <T> List<T> updateAll(List<T> entities, String... fieldFilter) throws OperatorException, ConnectionException;

	public <T> T delete(T entity) throws OperatorException, ConnectionException;

	public <T, PK> boolean delete(Class<T> t, PK pk) throws OperatorException, ConnectionException;
	
	public <T> List<T> deleteAll(List<T> entities) throws OperatorException, ConnectionException;

	public <T> int[] deleteAll(Class<T> t, Object[] ids) throws OperatorException, ConnectionException;

	public <T> List<T> findAll(Class<T> t, String cond, Object[] params, String... fieldFilter) throws OperatorException, ConnectionException;

	public <T> PageResultSet<T> findAll(Class<T> t, String cond, Object[] params, int pageSize, int currentPage, boolean allowRecordCount, String... fieldFilter) throws OperatorException, ConnectionException;

	public <T> List<T> findAll(String sql, IResultSetHandler<T> handler, Object[] params) throws OperatorException, ConnectionException;

	public <T> PageResultSet<T> findAll(String sql, IResultSetHandler<T> handler, int pageSize, int page, boolean count, Object[] params) throws OperatorException, ConnectionException;

	public int executeForUpdate(String sql, Object[] params) throws OperatorException, ConnectionException;

	public int[] executeForUpdateAll(String sql, List<Object[]> params) throws OperatorException, ConnectionException;

}
