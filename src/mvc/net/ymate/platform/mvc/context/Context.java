/**
 * <p>文件名:	Context.java</p>
 * <p>版权:		详见产品版权说明书</p>
 * <p>公司:		YMateSoft Co., Ltd.</p>
 * <p>项目名：	yMatePlatform_V2_1</p>
 * <p>作者：		刘镇(suninformation@163.com)</p>
 */
package net.ymate.platform.mvc.context;

import java.util.Map;


/**
 * <p>
 * Context
 * </p>
 * <p>
 * MVC环境上下文对象封装类；
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
 *          <td>2012-12-3下午3:51:42</td>
 *          </tr>
 *          </table>
 */
public class Context {

	protected static ThreadLocal<Context> __THREAD_LOCAL_CONTEXT = new ThreadLocal<Context>();

	private Map<String, Object> __context_map;

	/**
	 * Sets the Context for the current thread.
	 * 
	 * @param context the Context.
	 */
	public static void setContext(Context context) {
		__THREAD_LOCAL_CONTEXT.set(context);
	}

	/**
	 * Returns the Context specific to the current thread.
	 * 
	 * @return the Context for the current thread, is never <tt>null</tt>.
	 */
	public static Context getContext() {
		return __THREAD_LOCAL_CONTEXT.get();
	}

	/**
	 * 构造器
	 * 
	 * @param contextMap
	 */
	public Context(Map<String, Object> contextMap) {
		__context_map = contextMap;
	}

	/**
	 * Returns a value that is stored in the current Context by doing a lookup using the value's key.
	 * 
	 * @param key the key used to find the value.
	 * @return the value that was found using the key or <tt>null</tt> if the key was not found.
	 */
	public Object get(String key) {
		return __context_map.get(key);
	}

	/**
	 * Stores a value in the current Context. The value can be looked up using the key.
	 * 
	 * @param key the key of the value.
	 * @param value the value to be stored.
	 */
	public void put(String key, Object value) {
		__context_map.put(key, value);
	}

	/**
	 * Sets the context map.
	 * 
	 * @param contextMap the context map.
	 */
	public void setContextMap(Map<String, Object> contextMap) {
		__context_map = contextMap;
	}

	/**
	 * Gets the context map.
	 * 
	 * @return the context map.
	 */
	public Map<String, Object> getContextMap() {
		return __context_map;
	}

}
