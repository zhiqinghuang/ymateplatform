/**
 * <p>文件名:	FileUploadFilter.java</p>
 * <p>版权:		详见产品版权说明书</p>
 * <p>公司:		YMateSoft Co., Ltd.</p>
 * <p>项目名：	yMatePlatform_V2_1</p>
 * <p>作者：		刘镇(suninformation@163.com)</p>
 */
package net.ymate.platform.mvc.web.filter;

import java.util.HashMap;

import net.ymate.platform.commons.beans.annotation.Bean;
import net.ymate.platform.mvc.filter.IFilter;
import net.ymate.platform.mvc.support.RequestMeta;
import net.ymate.platform.mvc.view.IView;
import net.ymate.platform.mvc.web.annotation.FileUpload;
import net.ymate.platform.mvc.web.context.RequestMap;
import net.ymate.platform.mvc.web.context.WebContext;
import net.ymate.platform.mvc.web.support.MultipartRequestWrapper;

/**
 * <p>
 * FileUploadFilter
 * </p>
 * <p>
 * 文件上传拦截器；
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
 *          <td>2012-12-24下午11:01:05</td>
 *          </tr>
 *          </table>
 */
@Bean
public class FileUploadFilter implements IFilter {

	/* (non-Javadoc)
	 * @see net.ymate.platform.mvc.filter.IFilter#doFilter(net.ymate.platform.mvc.support.RequestMeta, java.lang.String)
	 */
	public IView doFilter(RequestMeta meta, String params) throws Exception {
		FileUpload _upload = meta.getMethod().getAnnotation(FileUpload.class);
		if (_upload != null) {
			MultipartRequestWrapper _wrapper = new MultipartRequestWrapper(WebContext.getRequest(), _upload);
			// 重置WebContext内容
			WebContext.setRequest(_wrapper);
			WebContext.getContext().put(WebContext.REQUEST, new RequestMap(_wrapper));
			WebContext.getContext().put(WebContext.PARAMETERS, new HashMap<String, String[]>(_wrapper.getParameterMap()));
		}
		return null;
	}

}
