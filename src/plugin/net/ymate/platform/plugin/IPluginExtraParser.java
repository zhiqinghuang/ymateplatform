/**
 * <p>文件名:	IPluginExtraParser.java</p>
 * <p>版权:		详见产品版权说明书</p>
 * <p>公司:		YMateSoft Co., Ltd.</p>
 * <p>项目名：	yMatePlatform-Plugin</p>
 * <p>作者：		刘镇(suninformation@163.com)</p>
 */
package net.ymate.platform.plugin;

import org.w3c.dom.Node;

/**
 * <p>
 * IPluginExtraParser
 * </p>
 * <p>
 * 插件主配置文件附加内容分析器；
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
 *          <td>2011-10-17下午09:27:18</td>
 *          </tr>
 *          </table>
 */
public interface IPluginExtraParser {

	/**
	 * @param extraPart 插件附加内容的XML元素对象
	 * @return 执行插件主配置文件中附加内容，并返回附加内容对象
	 */
	public Object doExtarParser(Node extraPart);

}
