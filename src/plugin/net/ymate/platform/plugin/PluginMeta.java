/**
 * <p>文件名:	PluginMeta.java</p>
 * <p>版权:		详见产品版权说明书</p>
 * <p>公司:		YMateSoft Co., Ltd.</p>
 * <p>项目名：	yMatePlatform-Plugin</p>
 * <p>作者：		刘镇(suninformation@163.com)</p>
 */
package net.ymate.platform.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import net.ymate.platform.commons.logger.Logs;
import net.ymate.platform.commons.util.FileUtils;
import net.ymate.platform.commons.util.RuntimeUtils;

import org.apache.commons.lang.StringUtils;


/**
 * <p>
 * PluginMeta
 * </p>
 * <p>
 * 插件配置信息元数据描述类；
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
 *          <td>2011-10-17下午04:52:05</td>
 *          </tr>
 *          </table>
 */
public class PluginMeta {

	private IPluginFactory pluginFactory;

	/** 插件唯一ID */
	private String id;

	/** 插件名称 */
	private String name;

	/** 插件别名 */
	private String alias;

	/** 插件初始启动类 */
	private String initClass;

	/** 插件版本 */
	private String version;

	/** 插件文件存放路径 */
	private String path;

	/** 插件作者 */
	private String author;

	/** 作者联系邮箱 */
	private String email;

	/** 当前插件类加载器 */
	private ClassLoader classLoader;

	/** 插件主配置文件附加内容 **/
	private Object extraObj;

	/** 是否加载时自动启动运行 */
	private boolean automatic;

	/** 是否禁用当前插件 */
	private boolean disabled;

	/** 插件描述 **/
	private String description;

	/**
	 * 构造器
	 */
	public PluginMeta() {
	}

	/**
	 * 构造器
	 * @param pluginFactory
	 * @param id
	 * @param name
	 * @param alias
	 * @param initClass
	 * @param version
	 * @param path
	 * @param author
	 * @param email
	 * @param extraObj
	 * @param description
	 */
	public PluginMeta(IPluginFactory pluginFactory, String id, String name, String alias, String initClass, String version, String path, String author, String email, Object extraObj, String description) {
		this.pluginFactory = pluginFactory;
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.initClass = initClass;
		this.version = version;
		this.path = path;
		this.author = author;
		this.email = email;
		this.extraObj = extraObj;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInitClass() {
		return initClass;
	}

	public void setInitClass(String initClass) {
		this.initClass = initClass;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Object getExtraObj() {
		return extraObj;
	}

	public ClassLoader getClassLoader() {
		if (classLoader == null) {
			if (StringUtils.isNotBlank(getPath())) {
				ArrayList<URL> _libList = new ArrayList<URL>();
				try {
					// 设置JAR包路径
                    File _pluginLibDir = new File(FileUtils.fixSeparator(this.getPath()) + "lib");
					if (_pluginLibDir.exists() && _pluginLibDir.isDirectory()) {
                        File[] _libFiles = _pluginLibDir.listFiles();
						for (File _libFile : _libFiles != null ? _libFiles : new File[0]) {
							if (_libFile.isFile() && _libFile.getAbsolutePath().endsWith("jar")) {
								_libList.add(_libFile.toURI().toURL());
							}
						}
					}
					// 设置类文件路径
					_pluginLibDir = new File(FileUtils.fixSeparator(this.getPath()) + "classes");
					if (_pluginLibDir.exists() && _pluginLibDir.isDirectory()) {
						_libList.add(_pluginLibDir.toURI().toURL());
					}
				} catch (MalformedURLException e) {
					Logs.debug("初始化插件 [ Id = " + this.getId() + "] 类加载器时异常", RuntimeUtils.unwrapThrow(e));
				}
				URL[] urls = _libList.toArray(new URL[_libList.size()]);
				classLoader = new PluginClassLoader(urls, pluginFactory.getPluginClassLoader());
			} else {
				classLoader = pluginFactory.getPluginClassLoader();
			}
		}
		return classLoader;
	}

	public boolean isAutomatic() {
		return automatic;
	}

	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getDescription() {
		return description;
	}

}
