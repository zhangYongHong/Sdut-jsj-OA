package cn.opencil.oa.core.web.basedata.service;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.domain.User;
import cn.opencil.oa.core.query.UserQuery;

/**
 * Project Name:SdutOA
 * File Name:UserService.java
 * Date:2016-4-15下午1:43:46
 * Author : 张树伟
 *
 */
public interface
UserService extends BaseService<User>{

	User validation(String username);

	PageResult<User> getUserPageResult(final UserQuery userQuery);

	User getUserByEmployeenum(String value);
}
